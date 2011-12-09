package org.hman.lab;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
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

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.hman.lab.http.HttpUtil;
import org.hman.lab.xml.XmlValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Sarayut Utsakoo
 * @version 1.0.0
 *
 */
public class Launcher extends JFrame {
	
	// Serializable
	private static final long serialVersionUID = 6624372084287585828L;
	// Logging
	private static final Logger logger = LoggerFactory.getLogger(Launcher.class);

	// Panel
	private JPanel configurePanel;
	private JPanel resultPanel;
	private JPanel paramsPanel;
	
	// Configuration panel contents
	private JLabel labelURL;
	//private JLabel labelXML;
	private JLabel labelTHREAD;
	private JLabel labelTRX;
	//private JLabel labelDELAY;
	//private JLabel labelMSunit;
	
	private JTextField txtURL;
	private JTextField txtTHREAD;
	private JTextField txtTRX;
	//private JTextField txtDELAY;
	
	private JButton cmdSTART;
	private JButton cmdSTOP;
	private JProgressBar progressBar;
	
	private JTabbedPane tabbedPane;
	
	private JTextArea txtfieldXML;
	private JScrollPane txtFieldScpnXML;
	
	private JTextArea txtfieldXSD;
	private JScrollPane txtFieldScpnXSD;
	
	// Parameters panel contents
	private JLabel labelParams;
	private JLabel labelDelimited;
	private JLabel labelData;
	
	private JTextField txtParams;
	private JTextField txtDelimited;
	private JButton cmdLoadFile;
	private JTable tableData;
	private JScrollPane tableScrollPane;
	
	// Test result panel contents
	private JTable tableResult;
	private JScrollPane tableResultScrollPane;
	
	private final Font normal = new Font("Comic Sans MS", 1, 11);
	private final String[] rsHeader = new String[]{"Parameter","Value"};
	private String[][] rsData = new String[][]{
			{"Start","-"},
			{"Finish","-"},
			{"Sample","-"},
			{"Failed","-"},
			{"Time spend","-"},
			{"TPS","-"},
			{"Max. time spend","-"},
			{"Min. time spend","-"}
	};
	
	private String[] prmHeader;
	private String[][] prmData;
	
	private ThreadPoolExecutor executor;
	private Integer transaction;
	private Integer sample;
	private Integer failed;
	private Long startTime;
	private Long endTime;
	private final SortedSet<Long> timeSpends = new TreeSet<Long>();
	
	private final SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.SSS");
	private final DecimalFormat df = new DecimalFormat("###,###,###,##0.00");
	
	private final XmlValidator xmlValidator = XmlValidator.getInstance();
	
	private final String xsdToolTip = "<?xml version=\"1.0\" encoding=\"utf-8\" ?>\r\n"
		+"<xsd:schema xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" elementFormDefault=\"qualified\">\r\n"
		+"	<xsd:element name=\"request\">\r\n"
		+" 		<xsd:complexType>\r\n"
		+"    		<xsd:sequence>\r\n"
		+"      			<xsd:element name=\"parameters\" maxOccurs=\"1\" minOccurs=\"1\">\r\n"
		+"   					<xsd:complexType>\r\n"
		+"    					<xsd:sequence>\r\n"
		+"    						<xsd:element name=\"p\" maxOccurs=\"1\" minOccurs=\"1\">\r\n"
		+"    							<xsd:complexType>\r\n"
		+"    								<xsd:attribute name=\"k\" type=\"xsd:string\" use=\"required\" fixed=\"promo_code\"/>\r\n"
		+"    								<xsd:attribute name=\"v\" type=\"xsd:string\" use=\"required\" fixed=\"CP003\"/>\r\n"
		+"    							</xsd:complexType>\r\n"
		+"    						</xsd:element>\r\n"
		+"    					</xsd:sequence>\r\n"
		+"    				</xsd:complexType>\r\n"
		+"      			</xsd:element>\r\n"
		+"    		</xsd:sequence>\r\n"
		+"    		<xsd:attribute name=\"command\" type=\"xsd:string\" use=\"required\" fixed=\"doService\"/>\r\n"
		+"  			<xsd:attribute name=\"function_id\" type=\"xsd:string\" use=\"required\" fixed=\"100100992\"/>\r\n"
		+"  			<xsd:attribute name=\"app_user\" type=\"xsd:string\" use=\"required\" fixed=\"load_rbt\"/>\r\n"
		+"  			<xsd:attribute name=\"app_password\" type=\"xsd:string\" use=\"required\" fixed=\"load_rbt132\"/>\r\n"
		+"  			<xsd:attribute name=\"req_transaction_id\" type=\"xsd:string\" use=\"required\" fixed=\"100100007001\"/>\r\n"
		+"  			<xsd:attribute name=\"channel\" type=\"xsd:string\" use=\"required\" fixed=\"SBMTEST\"/>\r\n"
		+"  			<xsd:attribute name=\"service_no\" type=\"xsd:string\" use=\"required\" fixed=\"0890000000\"/>\r\n"
		+"  		</xsd:complexType>\r\n"
		+"	</xsd:element>\r\n"
		+"</xsd:schema>";
	
	/*
	 * Constructor-method
	 */
	public Launcher() {
		try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (UnsupportedLookAndFeelException e) {
            // handle exception
        } catch (ClassNotFoundException e) {
            // handle exception
        } catch (InstantiationException e) {
            // handle exception
        } catch (IllegalAccessException e) {
            // handle exception
        }
	}
	
	/**
	 * Initial UI component
	 */
	public void initial() {
		// Initial
		logger.debug("Application initial components.");
		
		try {
			// Application Exit When Windows close.
			setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
			// Title
			setTitle("Load Test Version 1.0 built 20111122");
			// Windows resize unable
			setResizable(false);
			setFont(normal);
			
			configurePanel = new JPanel(null);
			configurePanel.setBorder(BorderFactory.createTitledBorder("CONFIGURATION"));
			initConfigurationPanel(configurePanel);
			
			resultPanel = new JPanel(null);
			resultPanel.setBorder(BorderFactory.createTitledBorder("RESULT"));
			initResultPanel(resultPanel);
			
			paramsPanel = new JPanel(null);
			paramsPanel.setBorder(BorderFactory.createTitledBorder("PARAMETER"));
			initParamsPanel(paramsPanel);
			
			configurePanel.setBounds(10, 10, 500, 400);
			resultPanel.setBounds(10, 420, 500, 150);
			paramsPanel.setBounds(520, 10, 465, 560);
			
			add(configurePanel);
			add(resultPanel);
			add(paramsPanel);
			
			add(new JPanel());
			
			// Windows
			pack();
			setSize(1000, 600);
			
			// Get the size of the screen
			Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
			 
			// Determine the new location of the window
			int w = getSize().width;
			int h = getSize().height;
			int x = (dim.width-w)/2;
			int y = (dim.height-h)/2;
			 
			// Move the window
			setLocation(x, y);
			// Application appear
			setVisible(true);
		} catch ( Exception ex ) {
			logger.error(ex.getMessage(), ex);
			JOptionPane.showMessageDialog(this, ex.getMessage(), "Exception", ERROR_MESSAGE);
			System.exit(0);
		}
	}
	
	/**
	 * initial all component load into panel
	 * @param configurePanal
	 * 
	 */
	private void initConfigurationPanel(JPanel configurePanel) throws Exception {
		// Add components into content.
		labelURL = new JLabel("URL");
		labelURL.setFont(normal);
		labelTRX = new JLabel("No. of request");
		labelTRX.setFont(normal);
		labelTHREAD = new JLabel("Concurrent");
		labelTHREAD.setFont(normal);
		
		//labelDELAY = new JLabel("Delay");
		//labelDELAY.setFont(normal);
		//labelMSunit = new JLabel("ms.");
		//labelMSunit.setFont(normal);
		//labelXML = new JLabel("XML Request");
		//labelXML.setFont(normal);
		
		txtURL = new JTextField("http://localhost:8080/");
		txtURL.setFont(normal);
		txtTRX = new JTextField("0");
		txtTRX.setFont(normal);
		txtTHREAD = new JTextField("1");
		txtTHREAD.setFont(normal);
		//txtDELAY = new JTextField("0");
		//txtDELAY.setFont(normal);
		
		tabbedPane = new JTabbedPane();
		tabbedPane.setFont(normal);
		
		txtfieldXML = new JTextArea();
		txtfieldXML.setFont(normal);
		txtfieldXML.setTabSize(3);
		txtFieldScpnXML = new JScrollPane(txtfieldXML);
		txtFieldScpnXML.setVerticalScrollBarPolicy(VERTICAL_BAR_NEED);
		txtFieldScpnXML.setHorizontalScrollBarPolicy(HORIZONTAL_BAR_AS_NEED);
		
		txtfieldXSD = new JTextArea();
		txtfieldXSD.setFont(normal);
		txtfieldXSD.setTabSize(3);
		//txtfieldXSD.setToolTipText(xsdToolTip);
		txtFieldScpnXSD = new JScrollPane(txtfieldXSD);
		txtFieldScpnXSD.setVerticalScrollBarPolicy(VERTICAL_BAR_NEED);
		txtFieldScpnXSD.setHorizontalScrollBarPolicy(HORIZONTAL_BAR_AS_NEED);
		
		tabbedPane.addTab("XML request", txtFieldScpnXML);
		tabbedPane.addTab("XSD schema", txtFieldScpnXSD);
		
		cmdSTART = new JButton("Start");
		cmdSTART.setFont(normal);
		cmdSTART.addActionListener(new CmdStartClick());
		cmdSTOP = new JButton("Stop");
		cmdSTOP.setFont(normal);
		cmdSTOP.addActionListener(new CmdStopClick());
		
		progressBar = new JProgressBar();
		//when the task of (initially) unknown length begins:
		//progressBar.setIndeterminate(true);
		progressBar.setVisible(false);
		//do some work; get length of task...
		//progressBar.setMaximum(newLength);
		//progressBar.setValue(newValue);
		progressBar.setIndeterminate(false);
		
		labelURL.setBounds(15, 25, 100, 25);
		labelTHREAD.setBounds(15, 55, 100, 25);
		//labelDELAY.setBounds(245, 55, 35, 25);
		//labelMSunit.setBounds(357, 55, 35, 25);
		labelTRX.setBounds(15, 85, 100, 25);
		//labelXML.setBounds(15, 115, 100, 25);
		
		txtURL.setBounds(120, 25, 366, 25);
		txtTHREAD.setBounds(120, 55, 90, 25);
		//txtDELAY.setBounds(280, 55, 70, 25);
		txtTRX.setBounds(120, 85, 70, 25);
		cmdSTART.setBounds(280, 85, 100, 25);
		cmdSTOP.setBounds(385, 85, 100, 25);
		progressBar.setBounds(120, 115, 366, 25);
		tabbedPane.setBounds(15, 115, 470, 268);
		
		configurePanel.add(labelURL);
		configurePanel.add(labelTHREAD);
		//configurePanel.add(labelDELAY);
		//configurePanel.add(labelMSunit);
		configurePanel.add(labelTRX);
		//configurePanel.add(labelXML);
		configurePanel.add(txtURL);
		configurePanel.add(txtTHREAD);
		//configurePanel.add(txtDELAY);
		configurePanel.add(txtTRX);
		configurePanel.add(tabbedPane);
		configurePanel.add(cmdSTART);
		configurePanel.add(cmdSTOP);
		configurePanel.add(progressBar);
	}
	
	/**
	 * initial all component load into panel
	 * @param resultPanel
	 * 
	 */
	private void initResultPanel(JPanel resultPanel) throws Exception {
		// Add component into content
		intiResult(rsHeader, rsData);
	}
	
	/**
	 * initial all component load into panel
	 * @param paramsPanel
	 * 
	 */
	private void initParamsPanel(JPanel paramsPanel) throws Exception {
		// Add component into content
		labelParams = new JLabel("Parameter(s)");
		labelParams.setFont(normal);
		labelDelimited = new JLabel("Delimited");
		labelDelimited.setFont(normal);
		labelData = new JLabel("Data Loaded");
		labelData.setFont(normal);
		
		txtParams = new JTextField();
		txtParams.setFont(normal);
		txtDelimited = new JTextField();
		txtDelimited.setFont(normal);
		cmdLoadFile = new JButton("Load File");
		cmdLoadFile.setFont(normal);
		cmdLoadFile.addActionListener(new CmdLoadFileClick());
		
		labelParams.setBounds(15, 25, 100, 25);
		labelDelimited.setBounds(15, 55, 100, 25);
		labelData.setBounds(15, 85, 100, 25);
		
		txtParams.setBounds(120, 25, 330, 25);
		txtDelimited.setBounds(120, 55, 50, 25);
		cmdLoadFile.setBounds(200, 55, 100, 25);
		
		paramsPanel.add(labelParams);
		paramsPanel.add(labelDelimited);
		paramsPanel.add(labelData);
		paramsPanel.add(txtParams);
		paramsPanel.add(txtDelimited);
		paramsPanel.add(cmdLoadFile);
		
		initTable(new String[]{""}, new String[][]{{""}});
	}
	
	/**
	 * Build JTable into 'Parameter' Panel by data agreement.
	 * 
	 * @param header
	 * @param data
	 */
	private synchronized void initTable(String[] header, String[][] data) {
		// Destroy old object from UI
		try { paramsPanel.remove(tableScrollPane); } 
		catch (Exception ex) { /* Nothing */ }
		// Re-build object load into UI
		tableData = new JTable( data, header );
		tableData.setFont(normal);
		tableScrollPane = new JScrollPane(tableData);
		tableScrollPane.setVerticalScrollBarPolicy(VERTICAL_BAR_NEED);
		tableScrollPane.setHorizontalScrollBarPolicy(HORIZONTAL_BAR_AS_NEED);
		tableScrollPane.setBounds(15, 115, 430, 425);
		paramsPanel.add(tableScrollPane);
		paramsPanel.updateUI();
	}
	
	/**
	 * Build JTable into 'Result' Panel by data agreement.
	 * 
	 * @param header
	 * @param data
	 */
	private synchronized void intiResult(String[] header, String[][] data) {
		// Destroy old object from UI
		try { resultPanel.remove(tableResultScrollPane); } 
		catch (Exception ex) { /* Nothing */ }
		// Re-build object load into UI
		tableResult = new JTable( data, header);
		tableResult.setFont(normal);
		tableResultScrollPane = new JScrollPane(tableResult);
		tableResultScrollPane.setVerticalScrollBarPolicy(VERTICAL_BAR_NEED);
		tableResultScrollPane.setHorizontalScrollBarPolicy(HORIZONTAL_BAR_AS_NEED);
		tableResultScrollPane.setBounds(15, 25, 472, 112);
		resultPanel.add(tableResultScrollPane);
		resultPanel.updateUI();
	}
	
	
	/**
	 * All thread access to register finish task
	 * until all task are finish then proceed data summary.
	 */
	private void finish(Long timeSpend, boolean good) {
		synchronized(Launcher.class) {
			// Stamp finish task.
			timeSpends.add(timeSpend);
			sample++;
			if ( ! good ) failed++;
			progressBar.setValue(sample);
			progressBar.updateUI();
			
			logger.debug("Look -> Transaction: " + transaction + " <-> Sample: " + sample);

			// Execute data summary report when all tasks finish
			if ( sample.intValue() == transaction.intValue() ) {
				try {
					endTime = System.currentTimeMillis();
					Long timeUsage = 0l;
					Long min = timeSpends.first();
					Long max = timeSpends.last();
					Iterator<Long> it = timeSpends.iterator();
					while ( it.hasNext() ) {
						timeUsage = timeUsage.longValue() + ((Long) it.next()).longValue();
					}
					
					logger.debug("Look -> Start -> " + sdf.format(new Date(startTime)));
					logger.debug("Look -> Finish -> " + sdf.format(new Date(endTime)));
					logger.debug("Look -> Sample -> " + sample);
					logger.debug("Look -> Failed -> " + failed);
					logger.debug("Look -> Time Spend -> " + df.format(timeUsage) + " ms.");
					logger.debug("Look -> Max -> " + df.format(max) +" ms.");
					logger.debug("Look -> Min -> " + df.format(min) + " ms.");
					
					Float fSample = sample.floatValue();
					Float fTimeUsage = timeUsage.floatValue();
					Float tps = (fSample*1000)/fTimeUsage;
					
					rsData = new String[][]{
							{"Start", sdf.format(new Date(startTime))},
							{"Finish", sdf.format(new Date(endTime))},
							{"Sample", sample.toString()},
							{"Failed", failed.toString()},
							{"Time spend", df.format(timeUsage) + " ms."},
							{"TPS", df.format(tps)},
							{"Max. time spend", df.format(max) + " ms."},
							{"Min. time spend", df.format(min) + " ms."}
					};
					
					intiResult(rsHeader, rsData);
				} finally {
					// Resume back to ready state.
					cmdSTART.setEnabled(true);
					progressBar.setMaximum(0);
					progressBar.setMinimum(0);
					progressBar.setVisible(false);
					// Purging all tasks
					executor.purge();
				}
			}
		}
	}
	
	/****************************************************
	 * Main-method
	 * @param args
	 * 
	 */
    public static void main( String[] args ) {
    	// Application object
    	Launcher app = new Launcher();
    	// Application launch
    	app.initial();
    }
    
    /* ******************* Constants ****************** */
    // DIALOG MESSAGE TYPE
    final int PLAIN_MESSAGE = JOptionPane.PLAIN_MESSAGE;
	final int INFO_MESSAGE = JOptionPane.INFORMATION_MESSAGE;
	final int QUESTION_MESSAGE = JOptionPane.QUESTION_MESSAGE;
	final int WARN_MESSAGE = JOptionPane.WARNING_MESSAGE;
	final int ERROR_MESSAGE = JOptionPane.ERROR_MESSAGE;
	// DIALOG BUTTON OPTION
	final int DEFAULT_OPTION = JOptionPane.DEFAULT_OPTION;
	final int OK_OPTION = JOptionPane.OK_OPTION;
	final int YES_NO_OPTION = JOptionPane.YES_NO_OPTION;
	final int YES_NO_CANCEL = JOptionPane.YES_NO_CANCEL_OPTION;
	final int OK_CANCEL = JOptionPane.OK_CANCEL_OPTION;
	// SCROLL BAR OPTION
	final int VERTICAL_BAR_NEED = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
	final int HORIZONTAL_BAR_AS_NEED = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
	
	/**
	 * 
	 * @author sarayut utsakoo
	 * Object class implements action listener when cmdSTART is clicked.
	 * 
	 */
	public class CmdStartClick implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				// URL 
				final String url = txtURL.getText();
				// Validate URL
				if ( url.isEmpty() ) 
					throw new RuntimeException("Please fill URL of services end-point.");
				
				// XML request
				final String xmlRequest = txtfieldXML.getText();
				// Validate XML request
				if ( xmlRequest.isEmpty() )
					throw new RuntimeException("Please fill XML request into XML input.");
				
				// XSD validator
				final String xsdSchema = txtfieldXSD.getText();
				if ( ! StringUtils.isBlank(xsdSchema) ) {
					xmlValidator.init(xsdSchema);
				}
				
				// No. of sample data to test
				transaction = Integer.parseInt(txtTRX.getText());
				logger.debug("Look -> No. of transaction -> " + transaction);
				
				// Validate number of expect sample with data
				if ( prmHeader != null && prmData.length != transaction ) 
					throw new RuntimeException("Data is missmatch, data is not equals with no. of transaction.");
				
				// No. of thread concurrent
				int concurrency = Integer.parseInt(txtTHREAD.getText());
				logger.debug("Look -> No. of currentcy -> " + concurrency);
				
				// Time delay.
				// long delay = Long.parseLong(txtDELAY.getText());
				// Thread pool executor
				executor = new ThreadPoolExecutor(concurrency, 
													concurrency, 
													0L, 
													TimeUnit.MILLISECONDS, 
													new LinkedBlockingQueue<Runnable>());
				// Stamp time to start.
				timeSpends.clear();
				sample = 0;
				failed = 0;
				startTime = System.currentTimeMillis();
				
				// Switch to testing state
				cmdSTART.setEnabled(false);
				progressBar.setMinimum(0);
				progressBar.setMaximum(transaction);
				progressBar.setVisible(true);

				// Start to load task
				for ( int idx=0; idx < transaction; idx++ ) {
					// Rebuild XML request with the data replacement.
					String readyRequest = "";
					// Rebuild XML request with the data replacement.
					if ( prmData != null && prmData.length > 0 ) {
						String[] params = prmData[idx];
						if ( params.length > 1 ) {
							for ( int i=0; i<params.length; i++ ) {
								readyRequest = StringUtils.replace( xmlRequest, prmHeader[i], params[i]);
							}
						} else {
							readyRequest = StringUtils.replace( xmlRequest, prmHeader[0], params[0]);
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
								if ( StringUtils.isBlank(responseBody) ) {
									finish(finish, false);
								} else {
									if ( StringUtils.isBlank(xsdSchema) ) {
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
				JOptionPane.showMessageDialog(Launcher.this, ex.getMessage(), "Exception", ERROR_MESSAGE);
			}
		}
	}
	
	/**
	 * 
	 * @author sarayut utsakoo
	 * Object class implements action listener when cmdSTOP is clicked.
	 *
	 */
	public class CmdStopClick implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				// Shutdown all tasks
				logger.info("Thread -> Shutdown.");
				executor.shutdown();
				logger.info("Thread -> Tasks -> Purge.");
				executor.purge();
			} catch ( Exception ex ) {
				logger.error(ex.getMessage(), ex);
				JOptionPane.showMessageDialog(Launcher.this, ex.getMessage(), "Exception", ERROR_MESSAGE);
			} finally {
				try {
					endTime = System.currentTimeMillis();
					Long timeUsage = 0l;
					Long min = timeSpends.first();
					Long max = timeSpends.last();
					Iterator<Long> it = timeSpends.iterator();
					while ( it.hasNext() ) {
						timeUsage = timeUsage.longValue() + ((Long) it.next()).longValue();
					}
					
					logger.debug("Look -> Start -> " + sdf.format(new Date(startTime)));
					logger.debug("Look -> Finish -> " + sdf.format(new Date(endTime)));
					logger.debug("Look -> Sample -> " + sample);
					logger.debug("Look -> Time Spend -> " + df.format(timeUsage) + " ms.");
					logger.debug("Look -> Max -> " + df.format(max) +" ms.");
					logger.debug("Look -> Min -> " + df.format(min) + " ms.");
					
					Float fSample = sample.floatValue();
					Float fTimeUsage = timeUsage.floatValue();
					Float tps = (fSample*1000)/fTimeUsage;
					
					rsData = new String[][]{
							{"Start", sdf.format(new Date(startTime))},
							{"Finish", sdf.format(new Date(endTime))},
							{"Sample", sample.toString()},
							{"Time spend", df.format(timeUsage) + " ms."},
							{"TPS", df.format(tps)},
							{"Max. time spend", df.format(max) + " ms."},
							{"Min. time spend", df.format(min) + " ms."}
					};
					
					intiResult(rsHeader, rsData);
				} finally {
					// Resume back to ready state.
					cmdSTART.setEnabled(true);
					progressBar.setMaximum(0);
					progressBar.setMinimum(0);
					progressBar.setVisible(false);
					// Purging all tasks
					executor.purge();
				}
			}
		}
	}
	
	/**
	 * 
	 * @author sarayut utsakoo
	 * Object class implements action listener when cmdSTOP is clicked.
	 */
	public class CmdLoadFileClick implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				// Validate the parameter is defined.
				String params = txtParams.getText();
				
				if ( params.isEmpty() ) {
					JOptionPane.showMessageDialog(Launcher.this, "You must define a parameter first.", "Warning", WARN_MESSAGE);
				} else {
					
					// File chooser and filter only text file.
					JFileChooser fileopen = new JFileChooser();
		            FileFilter filter = new FileNameExtensionFilter("text files", "txt");
		            fileopen.addChoosableFileFilter(filter);
		            
		            // Execute file chooser dialog
		            int ret = fileopen.showDialog(paramsPanel, "Open file");
		            
		            // File selected and open
		            if (ret == JFileChooser.APPROVE_OPTION) {
		                // Getting the selected file object
		            	File file = fileopen.getSelectedFile();
		                logger.debug("Look -> File choosen -> " + file.getName());
		                
		                // Read the file content
		                List<String> rawdata = FileUtils.readLines(file, "UTF-8");
		                
		                // Build data for JTable.
		                String delimited = txtDelimited.getText();
		                
		                if ( delimited.isEmpty() ) {
		                	prmHeader = new String[]{ params };
		                	prmData = new String[rawdata.size()][1];
		                } else {
		                	prmHeader = params.split(delimited);
		                	prmData = new String[rawdata.size()][prmHeader.length];
		                }
		                
		                // Fill data in object
		                int idx = 0;
		                for ( String line : rawdata ) {
		                	if ( delimited.isEmpty() ) prmData[idx++][0] = line;
		                	else prmData[idx++] = line.split(delimited);
		                }
		                
		                initTable(prmHeader, prmData);
		            }
				}
			} catch ( Exception ex ) {
				logger.error(ex.getMessage(), ex);
				JOptionPane.showMessageDialog(Launcher.this, ex.getMessage(), "Exception", ERROR_MESSAGE);
			}
		}
	}
}
