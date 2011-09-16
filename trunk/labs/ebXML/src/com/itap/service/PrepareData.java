package com.itap.service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.log4j.Logger;

import com.itap.Constant;
//import com.itap.ebxml.ICustomsBroker;
//import com.itap.ebxml.CustomsBroker;
import com.itap.ebms.MessageProducer;
import com.itap.ebms.req.ConsignmentInformationType;
import com.itap.ebms.req.CustomsTariffQuantityType;
import com.itap.ebms.req.DocumentDetailsTransportType;
import com.itap.ebms.req.DocumentHeaderType;
import com.itap.ebms.req.DocumentReferenceType;
import com.itap.ebms.req.InvoiceInfoType;
import com.itap.ebms.req.LicenseInfoType;
import com.itap.ebms.req.LicensePerInvoice;
import com.itap.ebms.req.QuantityType;
import com.itap.ebms.req.Signature;
import com.itap.ebms.req.DocumentDetailsTransportType.ProductInfo;
import com.itap.ebms.req.DocumentDetailsTransportType.ProductInfo.WeightInfo;

public class PrepareData {
	
	 private static final Logger log = Logger.getLogger(PrepareData.class);

	 final static String driverClass = "oracle.jdbc.driver.OracleDriver";
//	 final static String connectionURL = "jdbc:oracle:thin:@localhost:1521:PTC"; // local
//	 final static String userID = "pctdb"; // local
//	 final static String userPassword = "admin"; // local
	 final static String connectionURL = "jdbc:oracle:thin:@192.168.102.83:1521:orcl";
	 final static String userID = "pctdb";
	 final static String userPassword = "pctdb";
	 MessageProducer mp = null;
	 Connection oraConnection  = null;
	 SimpleDateFormat datePrintFormatPattern = null;
	 SimpleDateFormat dateOracleFormatPattern = null;
	 DecimalFormat decimalFormatPattern = null;
	 
//	 HttpServletRequest request;
//	 HttpServletResponse response;
//	 ICustomsBroker customs;
	 
	 public PrepareData(HttpServletRequest request, HttpServletResponse response) throws JdbcException {
		 
//		 this.customs = new CustomsBroker(request, response);
		 
//		 this.customs = new CustomsBroker();
		 
	     datePrintFormatPattern = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
	     dateOracleFormatPattern = new SimpleDateFormat("MMM dd, yyyy hh:mm:ss a zZ");
	     decimalFormatPattern = new DecimalFormat("#,###.##");

	     try {

	         log.info("  Loading JDBC Driver    -> " + driverClass + "\n");
	         Class.forName(driverClass).newInstance();

	         log.info("  Connecting to          -> " + connectionURL + "\n");
	         this.oraConnection = DriverManager.getConnection(connectionURL, userID, userPassword);
	         log.info("  Connected as           -> " + userID + "\n");	         
	     } catch (ClassNotFoundException e) {
	         e.printStackTrace();
	         throw new JdbcException("ERROR: Class Not Found");
	     } catch (InstantiationException e) {
	         e.printStackTrace();
	         throw new JdbcException("ERROR: Instantiation Error");
	     } catch (IllegalAccessException e) {
	         e.printStackTrace();
	         throw new JdbcException("ERROR: Illegal Access");
	     } catch (SQLException sqlException) {
	    	 sqlException.printStackTrace();
	         handleDatabaseException(sqlException, "Loading JDBC Driver", 1001);
	     } catch (Exception e){
	    	 e.printStackTrace();
	    	 throw new JdbcException("ERROR: Unexpect Exception");
	     }
	 }
	 
	 public PrepareData(HttpServletRequest request, HttpServletResponse response, MessageProducer mp) throws JdbcException {

		 this.mp = mp;

	     datePrintFormatPattern = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
	     dateOracleFormatPattern = new SimpleDateFormat("MMM dd, yyyy hh:mm:ss a zZ");
	     decimalFormatPattern = new DecimalFormat("#,###.##");

	     try {

	         log.info("  Loading JDBC Driver    -> " + driverClass + "\n");
	         Class.forName(driverClass).newInstance();

	         log.info("  Connecting to          -> " + connectionURL + "\n");
	         this.oraConnection = DriverManager.getConnection(connectionURL, userID, userPassword);
	         log.info("  Connected as           -> " + userID + "\n");	         
	     } catch (ClassNotFoundException e) {
	         e.printStackTrace();
	         throw new JdbcException("ERROR: Class Not Found");
	     } catch (InstantiationException e) {
	         e.printStackTrace();
	         throw new JdbcException("ERROR: Instantiation Error");
	     } catch (IllegalAccessException e) {
	         e.printStackTrace();
	         throw new JdbcException("ERROR: Illegal Access");
	     } catch (SQLException sqlException) {
	    	 sqlException.printStackTrace();
	         handleDatabaseException(sqlException, "Loading JDBC Driver", 1001);
	     } catch (Exception e){
	    	 e.printStackTrace();
	    	 throw new JdbcException("ERROR: Unexpect Exception");
	     }
	 }
	 
	 public LicensePerInvoice fakeData() throws DatatypeConfigurationException{

	        DocumentReferenceType documentReference = mp
	                .createDocumentReferenceType("8888", 
	                                                               new BigInteger("8888"),
	                                                               new BigInteger("8888"));
	        LicenseInfoType licenseInfo = null;
//	        LicenseInfoType licenseInfo = mp.createLicenseInfoType("10000",
//	                                                                                                    "Test00", 
//	                                                                                                    "Type00", 
//	                                                                                                    "10000", 
//	                                                                                                    "auth00", 
//	                                                                                                    "20100928",
//	                                                                                                    "20100928",
//	                                                                                                    "66", 
//	                                                                                                    "BhaBha", 
//	                                                                                                    "test",
//	                                                                                                    "description", 
//	                                                                                                    "tax10000");
	        DocumentHeaderType documentHeader = mp.createDocumentHeaderType(
	                documentReference, licenseInfo);

	        List<DocumentDetailsTransportType> documentDetails = new ArrayList<DocumentDetailsTransportType>();
	        InvoiceInfoType invoiceInfo = mp.createInvoiceInfoType("200",
	                                                                                                  new BigInteger("2"), 
	                                                                                                  "Description 2", 
	                                                                                                  new Date());

	        QuantityType quantityInfo = mp.createQuantityType("unit001",
	                                                                                            new BigDecimal(100.00), 
	                                                                                            "sampleUnit001", 
	                                                                                            new BigDecimal(200.0));

	        WeightInfo weightInfo = mp.createWeightInfo("unit003", new BigDecimal(300.0));

	        ProductInfo productInfo = mp.createProductInfo("body001",
	                                                                                      "brand001", 
	                                                                                      "character001", 
	                                                                                      "66", 
	                                                                                      new BigDecimal(500.5),
	                                                                                      "engine001", 
	                                                                                      "model001", 
	                                                                                      quantityInfo, 
	                                                                                      "register001",
	                                                                                      weightInfo, 
	                                                                                      new BigInteger("2010"));

	        CustomsTariffQuantityType tariffInfo = mp.createCustomsTariffQuantityType(
	                                                                new BigInteger("400"),
	                                                                new BigInteger("400"));

	        documentDetails.add(mp.createDocumentDetailsTransportType(
	                                                     new BigInteger("9999"), 
	                                                     "66", 
	                                                     "remark77", 
	                                                     invoiceInfo,
	                                                     productInfo, 
	                                                     tariffInfo));

	        List<Signature> signatures = new ArrayList<Signature>();

	        LicensePerInvoice license = mp.createLicensePerInvoice(
	                                                  documentHeader, 
	                                                  documentDetails, 
	                                                  signatures);
	        return license;
	 }

	 public LicensePerInvoice performQueryMain(String _permitId) throws JdbcException, Exception {
		 PreparedStatement prepare = null;
	     ResultSet rset = null;
	     int rowCount = 0;
	     
	     log.info ("permit id = "+_permitId);
	     
	     Date startDate;
	     long startTimeMillis = 0;
	     long endTimeMillis = 0;
	     BigDecimal permitId = new BigDecimal(_permitId);
	     
	     LicensePerInvoice dto = null;
	     
	     String queryString = Constant.SELECT_MAIN;
	     
	     try {


	         startTimeMillis = System.currentTimeMillis();
	         startDate = new Date(startTimeMillis);
	         log.info("  Start Date / Time      -> " + startDate);
	         prepare = oraConnection.prepareStatement(queryString);
	         prepare.setBigDecimal(1, permitId);
	         
	         String stmt = "SELECT imp_permit_doc.permit_number as permit_number, imp_permit_doc.expire_date as expire_date, "+
	         "imp_permit_doc.permit_date as permit_date, imp_permit_doc.tax_no as tax_no, imp_reconsider_doc.subject as license_name, "+
	         "imp_reconsider_doc.SIGN_NAME||'/'||imp_reconsider_doc.POSITION as authority_name "+
	         "FROM imp_permit_doc, imp_permit_relation, imp_import_letter, imp_reconsider_doc "+
	         "where (imp_import_letter.ID = imp_permit_relation.import_letter_id) AND (imp_reconsider_doc.id = imp_permit_relation.reconsider_doc_id) "+
	         "AND (imp_permit_doc.ID = imp_permit_relation.permit_doc_id) and imp_permit_doc.ID = "+permitId.longValue();

	         rset = prepare.executeQuery();
	         
	         ResultSetMetaData rsMeta = rset.getMetaData();
	         log.info("  # of Columns in Query  -> " + rsMeta.getColumnCount() + "\n");
	         
	         String licenseNo = null; // M
	         String licenseName = null;
             String licenseType = "0"; // M
             String authorityID = null; 
             String authorityName = null;
             String countryCode = null; // O
             Date issueDate = null; // M
             String taxReference = "4030036329"; // M
             String description = null; // O
             Date effectiveDate = null;
             Date expireDate = null; // M
             String inspectionLevel = null;
             String inspectionDesc = null;

             // TODO
	         while (rset.next()) {
	        	 dto = new LicensePerInvoice();
	             int rowNumber = rset.getRow();
	             rowCount++;

//	             if (rowCount == 1) {
	                 log.info("  Printing First Row...");
	                 log.info("  Row Number [" + rowNumber + "]");
	                 log.info("  Row Count  [" + rowCount + "]");
	                 log.info("  ---------------------");
	                 
	                 
	                 licenseName = rset.getString("license_name");
	                 licenseNo = rset.getString("permit_number");
//	                 expireDate = rset.getString("expire_date");
//	                 issueDate = rset.getString("permit_date");
//	                 effectiveDate = rset.getString("permit_date");
	                 expireDate = this.convertString2Date(rset.getString("expire_date"));
	                 issueDate = this.convertString2Date(rset.getString("permit_date"));
	                 taxReference = rset.getString("tax_no");
	                 authorityName = rset.getString("authority_name");
	                 effectiveDate = issueDate;
 
	                 log.info(licenseNo+"|"+expireDate+"|"+issueDate+"|"+taxReference+"|"+effectiveDate);      

	                 LicenseInfoType licenseInfoType = mp.createLicenseInfoType(licenseNo, licenseName, licenseType, issueDate, authorityID, authorityName, countryCode, description, effectiveDate, expireDate, inspectionLevel, inspectionDesc, taxReference);
	                 
//	                 LicenseInfoType licenseInfoType =  mp.createLicenseInfoType(licenseNo, licenseName, licenseType, 
//	                		 authorityID, authorityName, countryCode, description, inspectionLevel, 
//	                		 inspectionDesc, taxReference);

	                 ConsignmentInformationType consignmentInformationType = new ConsignmentInformationType();
	                 consignmentInformationType.setTaxReference(taxReference);
	                 consignmentInformationType.setCountryCode(countryCode);
	            
	                 licenseInfoType.setConsignmentInfo(consignmentInformationType);
	                 
	                 log.info(licenseInfoType.toString());
	                 
//	                 DocumentReferenceType documentReference = new DocumentReferenceType();
	                 /*
	                 String registrationID = "40300363290000011"; // O ?  
	                 BigInteger dischargePort = new BigInteger("1");  
	                 BigInteger loadPort = new BigInteger("1");
	                 */ 
	                 String registrationID = "4030036329"; // O ?  
	                 BigInteger dischargePort = null;  
	                 BigInteger loadPort = null;
//	                 documentReference.setRegistrationID(registrationID);
//	                 documentReference.setDischargePort(dischargePort);
//	                 documentReference.setLoadPort(loadPort);
	                 DocumentReferenceType documentReference = mp.createDocumentReferenceType(registrationID, dischargePort, loadPort);
	                 
	                 DocumentHeaderType documentHeader = mp.createDocumentHeaderType(
	     	                documentReference, licenseInfoType);
	                 
	                 log.info(documentReference);
	                 
	                 // set DocumentHeaderType
	                 dto.setDocumentHeader(documentHeader);

	                 performQueryDetails(permitId, dto);
	             }
//	         }

	         rset.close();
	         prepare.close();
	                                                                              
	         log.info("\n");
	         log.info("  # Rows Processed       -> " + rowCount + "\n");
	         
	         endTimeMillis = System.currentTimeMillis();

	     } catch (SQLException sqlException) {
	    	 sqlException.printStackTrace();
	         handleDatabaseException(sqlException, "Performing Query", 1006);
	     } catch (Exception e){ 
	    	 e.printStackTrace();
	    	 log.error("error ===> "+e.getMessage());
	    	 throw new Exception(e);
	     } finally {
	    	 try {
		    	 if (null != rset)
		    		 rset.close();
		    	 if (null != prepare)
		    		 prepare.close();
	    	 } catch (SQLException se) {
	    		 se.printStackTrace();
	    	 }
	     }
	     return dto;
	 }
	 
	 public void performQueryDetails(BigDecimal permitId, LicensePerInvoice dto) throws Exception {
		 List<DocumentDetailsTransportType> details = new ArrayList<DocumentDetailsTransportType>();
		 String queryString = Constant.SELECT_DETAIL;
		 PreparedStatement prepare = null;
	     ResultSet rset = null;
	     
	     int rowCount = 0;
	     
	     try {
	    	 prepare = oraConnection.prepareStatement(queryString);
	         prepare.setBigDecimal(1, permitId);
	         rset = prepare.executeQuery();
	         
	         ResultSetMetaData rsMeta = rset.getMetaData();
	         log.info("  # of Columns in Query  -> " + rsMeta.getColumnCount() + "\n");
	         
	         while (rset.next()) {
	        	 int rowNumber = rset.getRow();
	             rowCount++;
	             log.info("  ---------------------");
                 log.info("  Row Number [" + rowNumber + "]");
                 log.info("  Row Count  [" + rowCount + "]");
                 log.info("  ---------------------");
	        	 
                 DocumentDetailsTransportType detail = new DocumentDetailsTransportType();
                 
                 String SELECT_DETAIL = "SELECT imp_import_detail.quantity as quantity, imp_import_detail.item_id as item_id, "+
						             	"imp_import_detail.description_eng as description_eng, imp_import_detail.invoice_no as invoice_no, "+
						            	"imp_import_detail.invoice_date as invoice_date, imp_permit_relation.ID as permit_relation_id, "+
						            	"imp_permit_relation.permit_doc_id as permit_doc_id, imp_permit_doc.permit_number as permit_number, "+
						            	"imp_import_letter.tariff_number as tariff_number, imp_import_letter.statics_number as statics_number, "+
						            	"imp_import_detail.load as load, imp_import_detail.MASS as mass, imp_permit_doc.type as per_type "+
						            	"FROM imp_import_letter, "+
						            	"imp_import_detail, "+
						            	"imp_permit_relation, "+
						            	"imp_permit_doc "+
						            	"WHERE ((imp_import_letter.ID = imp_import_detail.import_letter_id) "+
						            	"AND (imp_import_letter.ID = imp_permit_relation.import_letter_id) "+
						            	"AND (imp_permit_doc.ID = imp_permit_relation.permit_doc_id) and imp_permit_doc.ID = ?) ";
                 
                 BigInteger declarationLineNo = null; // O 
                 String countryCode = null; // O ?
                 String remark = null; // O 
                 
                 // Set InvoiceInfoType
                 String invoiceNumber = rset.getString("invoice_no"); // M
                 BigInteger invoiceItem = rset.getBigDecimal("item_id").toBigInteger(); // M
                 String description = rset.getString("description_eng"); // M 
                 Date invoiceDate = this.convertString2Date(rset.getString("invoice_date"));

                 InvoiceInfoType invoiceInfo = mp.createInvoiceInfoType(invoiceNumber, invoiceItem, description, invoiceDate);
                 
                 log.info(invoiceInfo.toString());
                 
                 detail.setInvoiceInfo(invoiceInfo);
                 
                 String iSOUnit = "KG";
                 if (null != rset.getString("per_type")) {
                	 if ("OIL".equals(rset.getString("per_type").toUpperCase()))
                		 iSOUnit = "L";
                 }
                 
                 String quantityUnitCode = iSOUnit;  // TODO Mandatory 
                 BigDecimal quantity = rset.getBigDecimal("quantity");
                 String samplingUnitCode = null;
                 BigDecimal samplingQuantity = null;
                 
                 QuantityType quantityInfo = mp.createQuantityType(quantityUnitCode,
                		 quantity, samplingUnitCode, samplingQuantity);
                 
                 String weightUnitCode = iSOUnit;  // TODO Mandatory
                 BigDecimal weight = rset.getBigDecimal("mass");
                 WeightInfo weightInfo = mp.createWeightInfo(weightUnitCode, weight);

     	         String bodyNo = null; 
                 String brandName = null; 
                 String characteristic = null; 
                 String purchaseCountryCode = null;
                 BigDecimal displacement = null; 
                 String engineNo = null; 
                 String modelCode = null; 
                 String registrationNumber = null; 
                 BigInteger year = null;
                 
                 ProductInfo productInfo = mp.createProductInfo(bodyNo, brandName, characteristic, purchaseCountryCode, 
                		 						displacement, engineNo, modelCode, quantityInfo, registrationNumber, 
     	                                        weightInfo, year);

//                 System.out.println("tariff number = "+rset.getString("tariff_number")+", static number = "+rset.getString("statics_number"));
                 
//                 BigInteger classification = rset.getBigDecimal("tariff_number").toBigInteger();
//                 BigInteger statisticalCode = rset.getBigDecimal("statics_number").toBigInteger();
                 BigInteger classification = null;
                 BigInteger statisticalCode = null;
     	         CustomsTariffQuantityType tariffInfo = mp.createCustomsTariffQuantityType(
     	        		classification, statisticalCode);
                 
                 dto.getDocumentDetails().add(mp.createDocumentDetailsTransportType(declarationLineNo, countryCode, remark, invoiceInfo, productInfo, tariffInfo));
                 
	         }
	     } catch (Exception e){
	    	 e.printStackTrace();
	    	 throw new Exception (e);
	     } finally {
	    	 try {
		    	 if (null != rset)
		    		 rset.close();
		    	 if (null != prepare)
		    		 prepare.close();
	    	 } catch (Exception e){
	    		 e.printStackTrace();
	    	 }
	     }
	 }
	 
	 public void handleDatabaseException(SQLException exception, String strMessage, int intErrorNum) throws JdbcException {

	     log.error("+-------------------------------------------+");
	     log.error("| Printing Exception Trace                  |");
	     log.error("+-------------------------------------------+");
	     exception.printStackTrace();
	
	     log.error("+-------------------------------------------+");
	     log.error("| Database Error Message                    |");
	     log.error("+-------------------------------------------+");
	     // log.error("Message    : " + exception.getMessage());
	     log.error("Error Code : " + exception.getErrorCode());
	     log.error("SQL State  : " + exception.getSQLState());
	
	     log.error("+-------------------------------------------+");
	     log.error("| Throwing Application Exception            |");
	     log.error("+-------------------------------------------+");
	     throw new JdbcException("ERROR: " + strMessage, intErrorNum);

	 }
	 
	 private Date convertString2Date(String stmt){
		 if (null != stmt) {
			 String format = "yyyyMMdd";
			 DateFormat df = new SimpleDateFormat(format);
	
	         try
	         { 
	             Date today = df.parse(stmt);            
	             return today;
	         } 
	         catch (ParseException e)
	         {
	        	 e.printStackTrace();
	         }
		 }
		 return null;
	 }
	 
	 private XMLGregorianCalendar convertDate2XMLGregorianCalendar(Date yourDate) throws DatatypeConfigurationException
	 {
		 if (null != yourDate) {
			 GregorianCalendar c = new GregorianCalendar();
			 c.setTime(yourDate);
			 XMLGregorianCalendar date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
			 return date2;
		 }
		 return null;
	 }
	 
	 
	 
	 
}
