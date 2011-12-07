package org.hman.lab;

import java.io.File;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.io.FileUtils;
import org.hman.lab.http.HttpUtil;
import org.hman.lab.xml.XmlValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Sarayut Utsakoo
 * @version 1.0
 * 
 */
public class Launcher implements Serializable {
	
	// Serialize uniqe number
	private static final long serialVersionUID = 7749742495079010893L;
	
	// Logging
	private static final Logger logger = LoggerFactory.getLogger(Launcher.class);
	
	// Component objects
	private Configuration config;
	private String url;
	private List<String> paramLines;
	private ThreadPoolExecutor executor;
	private Integer transaction;
	private Integer concurrency;
	private Integer sample;
	private Integer failed;
	private Long startTime;
	private Long endTime;
	private final SortedSet<Long> timeSpends = new TreeSet<Long>();
	
	private final SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.SSS");
	private final DecimalFormat df = new DecimalFormat("###,###,###,##0.00");
	
	private final XmlValidator xmlValidator = XmlValidator.getInstance();
	
	/**
	 * Main-method
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main( String[] args ) throws Exception {
		Launcher launcher = new Launcher();
		launcher.execute();
	}
	
	/*
	 * Constructor-method
	 */
	public Launcher() {
		try {
			if ( ! new File("conf.properties").isFile() ) 
				throw new RuntimeException("System could not found 'conf.properties' in working directory.");
        
			logger.info(" # #################################### #");
	        logger.info(" #                                      #");
	        logger.info(" #    HTTP POST daemon                  #");
	        logger.info(" #    Java application                  #");
	        logger.info(" #    Revision: 1.0.0 beta              #");
	        logger.info(" #    Last update: 25 Nov 2011          #");
	        logger.info(" #                                      #");
	        logger.info(" # #################################### #");
	        
	        config = new PropertiesConfiguration("conf.properties");
	        
	        logger.info(" # ### conf.properties ################ #");
	        logger.info(" # ws.uri="+config.getString("ws.uri"));
	        logger.info(" # app.threads="+config.getString("app.threads"));
	        logger.info(" # app.tasks="+config.getString("app.tasks"));
	        logger.info(" # xml.file="+config.getString("xml.file"));
	        logger.info(" # param.file="+config.getString("param.file"));
	        logger.info(" # xsd.file="+config.getString("xsd.file"));
	        
	        // URL 
			url = config.getString("ws.uri");
			// No. of sample data to test
			transaction = config.getInt("app.tasks");
			// No. of thread concurrent
			concurrency = config.getInt("app.threads");
			// Load XSD for XML validation
			if ( ! config.getString("xsd.file").isEmpty() ) 
				xmlValidator.init(config.getString("xsd.file"));
			
			// XML request
			File xmlfile = new File(config.getString("xml.file"));
			if ( ! xmlfile.isFile() )
				throw new RuntimeException("System could not found XML request file.");
				
			// Parameter to replace all agreement in each XML before send.
			File paramfile = new File(config.getString("param.file"));
			if ( paramfile.isFile() ) {
				paramLines = FileUtils.readLines(paramfile, "UTF-8");
				if ( paramLines != null && paramLines.size() != transaction ) 
					throw new RuntimeException("Data is missmatch, data is not equals with no. of transaction.");
			} 
			// Thread pool executor
			executor = new ThreadPoolExecutor(concurrency, 
											  concurrency, 
											  0L, 
											  TimeUnit.MILLISECONDS, 
											  new LinkedBlockingQueue<Runnable>());
		} catch ( Exception ex ) {
			logger.error(ex.getMessage(), ex);
			System.exit(0);
		}
	}
	
	/**
	 * Execute load test process
	 */
	public void execute() {
		try {
			
			// Stamp time to start.
			timeSpends.clear();
			sample = 0;
			failed = 0;
			startTime = System.currentTimeMillis();
			
			final String xmlRequest = FileUtils.readFileToString(new File(config.getString("xml.file")), "UTF-8");

			// Start to load task
			for ( int idx=0; idx < transaction; idx++ ) {
				String readyRequest = "";
				// Rebuild XML request with the data replacement.
				if ( paramLines != null && paramLines.size() > 0 ) {
					logger.debug("Entering --> to string replacement process.");
					String line = paramLines.get(idx);
					if ( line.indexOf(",") != -1 ) {
						logger.debug("Entering --> multi regex for replacement {"+line+"}");
						String[] params = line.split(",");
						for ( int i=0; i<params.length; i++ ) {
							readyRequest = xmlRequest.replaceAll( "{"+(i+1)+"}", params[i] );
						}
					} else {
						logger.debug("Entering --> single regex for replacement {"+line+"}");
						readyRequest = xmlRequest.replaceAll( "{1}", line );
					}
				} else {
					readyRequest = xmlRequest;
				}
				
				final String payload = new String(readyRequest);
				// Submit task into thread pool.
				executor.execute(new Runnable() {
					@Override
					public void run() {
						// Stamp time to start
						long start = System.currentTimeMillis();
						String responseBody = "";
						try {	
							// Execute HTTP POST
							responseBody = HttpUtil.getInstance().doPost( url, payload );
						} catch ( Exception ex ) {
							logger.error(ex.getMessage(), ex);
						} finally {
							// Stamp time to finish
							long finish = System.currentTimeMillis() - start;
							// Validate result;
							if ( responseBody.isEmpty() ) {
								finish(finish, false);
							} else {
								if ( config.getString("xsd.file").isEmpty() ) {
									finish(finish, true);
								} else {
									// Validate XML result by XSD
									finish(finish, xmlValidator.valid(responseBody) );									
								}
							}
						}
					}
				});
			}				
		} catch ( Exception ex ) {
			logger.error(ex.getMessage(), ex);
			System.exit(0);
		}
	}
	
	/**
	 * All thread access to register finish task
	 * until all task are finish then proceed data summary.
	 */
	private void finish(Long timeSpend, Boolean good) {
		synchronized(Launcher.class) {
			// Stamp finish task.
			timeSpends.add(timeSpend);
			sample++;
			if ( ! good ) failed++;
			// Report process status currently by logging.
			logger.info("Process = {Transaction: " + transaction + ", Sample: " + sample + ", Failed: " + failed);
			// Execute data summary report when all tasks finish
			if ( sample.intValue() == transaction.intValue() ) {
				reporting();
				System.exit(0);
			}
		}
	}
	
	/**
	 * Summarize data and reporting.
	 */
	private void reporting() {
		try {
			endTime = System.currentTimeMillis();
			Long timeUsage = 0l;
			Long min = timeSpends.first();
			Long max = timeSpends.last();
			Iterator<Long> it = timeSpends.iterator();
			while ( it.hasNext() ) {
				timeUsage = timeUsage.longValue() + ((Long) it.next()).longValue();
			}
			
			Float fSample = sample.floatValue();
			Float fTimeUsage = timeUsage.floatValue();
			Float tps = (fSample*1000)/fTimeUsage;
			
			// Report
			logger.info(" : Start time : " + sdf.format(new Date(startTime)));
			logger.info(" : Finish time : " + sdf.format(new Date(endTime)));
			logger.info(" : No. of sample : " + sample);
			logger.info(" : Time spend : " + df.format(timeUsage) + " ms.");
			logger.info(" : Max. time spend : " + df.format(max) + " ms.");
			logger.info(" : Min. time spend : " + df.format(min) + " ms.");
			logger.info(" : TPS : " + df.format(tps));

		} finally {
			// Purging all tasks
			executor.purge();
		}
	}
	
}
