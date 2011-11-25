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
	private String xmlRequest;
	private List<String> paramLines;
	private ThreadPoolExecutor executor;
	private Integer transaction;
	private Integer concurrency;
	private Integer sample;
	private Long startTime;
	private Long endTime;
	private final SortedSet<Long> timeSpends = new TreeSet<Long>();
	
	private final SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.SSS");
	private final DecimalFormat df = new DecimalFormat("###,###,###,##0.00");
	
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
	        
	        // URL 
			url = config.getString("ws.uri");
			// No. of sample data to test
			transaction = config.getInt("app.tasks");
			// No. of thread concurrent
			concurrency = config.getInt("app.threads");
			
			// XML request
			File xmlfile = new File(config.getString("xml.file"));
			xmlRequest = FileUtils.readFileToString(xmlfile);
			
			// Parameter to replace all agreement in each XML before send.
			File paramfile = new File(config.getString("param.file"));
			if ( paramfile.isFile() ) {
				paramLines = FileUtils.readLines(paramfile);
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
			startTime = System.currentTimeMillis();

			// Start to load task
			for ( int idx=0; idx < transaction; idx++ ) {
				// Rebuild XML request with the data replacement.
				if ( paramLines != null && paramLines.size() > 0 ) {
					for (String line : paramLines) {
						if ( line.indexOf(",") != -1 ) {
							String[] params = line.split(",");
							for ( int i=0; i<params.length; i++ ) {
								xmlRequest.replaceAll( "${"+(i+1)+"}", params[i] );
							}
							
						} else {
							xmlRequest.replaceAll( "${1}", line );
						}
					}
				}
				// Submit task into thread pool.
				executor.execute(new Runnable() {
					@Override
					public void run() {
						try {
							// Stamp time to start
							long start = System.currentTimeMillis();
							// Execute HTTP POST
							String responseBody = HttpUtil.getInstance().doPost( url, xmlRequest );
							logger.debug(" >>>>>>>>>>>>>>>>>>>> HTTP response <<<<<<<<<<<<<<<<<<<< ");
							logger.debug(responseBody);
							// Stamp time to finish
							long finish = System.currentTimeMillis() - start;
							finish(finish);
						} catch ( Exception ex ) {
							logger.error(ex.getMessage(), ex);
						}
					}
				});
			}				
		} catch ( Exception ex ) {
			logger.error(ex.getMessage(), ex);
		}
	}
	
	/**
	 * All thread access to register finish task
	 * until all task are finish then proceed data summary.
	 */
	private void finish(Long timeSpend) {
		synchronized(Launcher.class) {
			// Stamp finish task.
			timeSpends.add(timeSpend);
			sample++;
			
			logger.debug("Look -> Transaction: " + transaction + " <-> Sample: " + sample);

			// Execute data summary report when all tasks finish
			if ( sample.intValue() == transaction.intValue() ) {
				reporting();
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
