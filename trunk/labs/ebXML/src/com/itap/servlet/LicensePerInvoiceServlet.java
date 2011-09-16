package com.itap.servlet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.Properties;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.log4j.Logger;

import com.itap.ebms.Acknowledgment;
import com.itap.ebms.MessageProducer;
import com.itap.ebms.req.DocumentDetailsTransportType;
import com.itap.ebms.req.LicensePerInvoice;
import com.itap.service.JdbcException;
import com.itap.service.PrepareData;
import com.itap.utils.PropertiesUtil;

/**
 * Servlet implementation class LicensePerInvoiceServlet
 */
public class LicensePerInvoiceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String dbuser;
	private String dbpass;
	private MessageProducer mp;
	private String userId;

	private static final Logger log = Logger
			.getLogger(LicensePerInvoiceServlet.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LicensePerInvoiceServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		log.info("doProcess");
		
		ServletContext context = getServletContext();
		Properties prop = PropertiesUtil.load(context.getInitParameter("CONFIG_FILE"));
		
		boolean lighthouse_flag = new Boolean(prop.getProperty("LIGHT_HOUSE_FLAG"));
		
		String IP_ADDRESS = prop.getProperty("IP_ADDRESS");
		Integer SERVICES_PORT = Integer.parseInt(prop.getProperty("SERVICES_PORT"));
		String SERVICES_PATH = prop.getProperty("SERVICES_PATH");
		String TRUST_STORE_PATH = prop.getProperty("TRUST_STORE_PATH");
		String TRUST_STORE_PASSWORD = prop.getProperty("TRUST_STORE_PASSWORD");
		String TCDNSW_CPAID = prop.getProperty("TCDNSW_CPAID");
		String TCDNSW_PARTYID = prop.getProperty("TCDNSW_PARTYID");
		String TCDNSW_ROLE = prop.getProperty("TCDNSW_ROLE");
		String DOEB_PARTYID = prop.getProperty("DOEB_PARTYID");
		String DOEB_ROLE = prop.getProperty("DOEB_ROLE");
		String TCDNSW_SERVICES = prop.getProperty("TCDNSW_SERVICES");
		String LICENSE_PERINVOICE_ACTION = prop.getProperty("LICENSE_PERINVOICE_ACTION");
		String LICENSE_RESPONSE_ACTION = prop.getProperty("LICENSE_RESPONSE_ACTION");
		String LICENSE_CANCEL_ACTION = prop.getProperty("LICENSE_CANCEL_ACTION");		
		String INBOX = prop.getProperty("INBOX");
		String OUTBOX = prop.getProperty("OUTBOX");
		userId = prop.getProperty("USER_ID");
		
		String KEYSTORE_PATH = prop.getProperty("KEYSTORE_PATH");
		String KEYSTORE_PASSWORD = prop.getProperty("KEYSTORE_PASSWORD");
		String KEYSTORE_ALIASNAME = prop.getProperty("KEYSTORE_ALIASNAME");
		String DOCUMENT_REF_NAME = prop.getProperty("DOCUMENT_REF_NAME");
		String ALIASNAME_PASSWORD = prop.getProperty("ALIASNAME_PASSWORD");
		
		Boolean sync = true;
		String username = null;
		String password = null;
		LicensePerInvoice pdata = null;
		String permitId = request.getParameter("permitId");
		String error = null;

		String classificationName = "";
		String classificationCode = "";
		log.info("permit_ID = " + permitId);
		log
				.info("sync|username|password|classificationName|classificationCode = "
						+ sync
						+ "|"
						+ username
						+ "|"
						+ password
						+ "|"
						+ classificationName + "|" + classificationCode + "|");
		try {
				mp = new MessageProducer();
				mp.setIP_ADDRESS(IP_ADDRESS);
				mp.setSERVICES_PORT(SERVICES_PORT);
				mp.setSERVICES_PATH(SERVICES_PATH);
				mp.setTRUST_STORE_PATH(TRUST_STORE_PATH);
				mp.setTRUST_STORE_PASSWORD(TRUST_STORE_PASSWORD);
				mp.setDOEB_PARTYID(DOEB_PARTYID);
				mp.setDOEB_ROLE(DOEB_ROLE);
				mp.setTCDNSW_CPAID(TCDNSW_CPAID);
				mp.setTCDNSW_PARTYID(TCDNSW_PARTYID);
				mp.setTCDNSW_ROLE(TCDNSW_ROLE);
				mp.setTCDNSW_SERVICES(TCDNSW_SERVICES);
				mp.setLICENSE_PERINVOICE_ACTION(LICENSE_PERINVOICE_ACTION);
				mp.setLICENSE_RESPONSE_ACTION(LICENSE_RESPONSE_ACTION);
				mp.setLICENSE_CANCEL_ACTION(LICENSE_CANCEL_ACTION);
				
				mp.setDIRECTORY_INBOX(INBOX);
				mp.setDIRECTORY_OUTBOX(OUTBOX);
				mp.setKEYSTORE_ALIASNAME(KEYSTORE_ALIASNAME);
				mp.setKEYSTORE_PASSWORD(KEYSTORE_PASSWORD);
				mp.setKEYSTORE_PATH(KEYSTORE_PATH);
				mp.setDOCUMENT_REF_NAME(DOCUMENT_REF_NAME);
				mp.setALIASNAME_PASSWORD(ALIASNAME_PASSWORD);
			
			PrepareData pd = new PrepareData(request, response, mp);
			pdata = pd.performQueryMain(permitId);
			// proceedLicensePerInvoice(pdata);
			if (!lighthouse_flag)
				error = proceedLicensePerInvoice(pdata, request, response);
		} catch (JdbcException e) {
			log.error(e.getMessage());
			error = e.getMessage();
			// throw new ServletException(e);
		} catch (Exception e) {
			log.error("error ===== > " + e.getMessage());
			e.printStackTrace();

			error = e.getMessage();
			// throw new ServletException(e);
		}

		PrintWriter out;
		response.setContentType("text/html");
		out = response.getWriter();
		
		out.println("<html xmlns=\"http://www.w3.org/1999/xhtml\">");
		out.println("<head>");
		out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=WINDOWS-874\" />");
		out.println("<meta http-equiv=\"imagetoolbar\" content=\"false\" />");
		out.println("<meta http-equiv=\"Pragma\" content=\"no-cache\"/>");
		out.println("<link href=\"http://ptc.doeb.go.th/ptc/css/ptc_orange.css\" rel=\"stylesheet\" type=\"text/css\"/>");
		out.println("<title>"+this.convertToHTML("ระบบสารสนเทศศูนย์กลางการบริการธุรกิจการค้าน้ำมันเชื้อเพลิง")+"</title>");
		out.println("</head>");
		out.println("<body>");
		
		out.println("<table class=\"main\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">");
		out.println("<!-- Banner  -->");
		out.println("<tr><td>");
		out.println("<table class=\"main\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">");
		out.println("<tr>");
		out.println("<td><img src=\"http://ptc.doeb.go.th/ptc/images/head1.gif\" border=\"0\"></td>");
		out.println("<td background=\"http://ptc.doeb.go.th/ptc/images/head.gif\" height=\"80\" width=\"100%\"></td>");
		out.println("<td><img src=\"http://ptc.doeb.go.th/ptc/images/head2.gif\" border=\"0\"></td>");
		out.println("</tr>");
		out.println("</table>");
		
		out.println("<!-- menu -->");
		out.println("<tr>");
		out.println("<td width=\"100%\">");
		out.println("<table class=\"main\" background=\"http://ptc.doeb.go.th/ptc/images/pic_02.gif\" height=\"28px\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">");
		out.println("<tr>");
		out.println("<td align=\"right\">");
		out.println("<img src=\"http://ptc.doeb.go.th/ptc/images/pic_02.gif\" height=\"23\" width=\"100%\">");
		out.println("</td></tr></table></td></tr>");

		out.println("<!-- New Body -->");
		out.println("<tr>"); 
		out.println("<td width=\"100%\" align=\"center\">");
		out.println("<table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"main\">");
		out.println("<tr>");
		out.println("<td width=\"32\"><img src=\"http://ptc.doeb.go.th/ptc/images/pic_03.gif\" border=\"0\"></td>");
		out.println("<td width=\"100%\" valign=\"top\"><img src=\"http://ptc.doeb.go.th/ptc/images/pic_04.gif\" border=\"0\" width=\"100%\" height=\"21\"></td>");
		out.println("<td width=\"32\" ><img src=\"http://ptc.doeb.go.th/ptc/images/pic_05.gif\" border=\"0\"></td>");
		out.println("</tr>");
		out.println("</table>");
		out.println("<table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"body2\">");
		out.println("<tr height=\"130\">");
		out.println("<td background=\"http://ptc.doeb.go.th/ptc/images/pic_08.gif\"></td>");
		out.println("<td width=\"100%\" valign=\"middle\">");
		out.println("<table align=\"center\">");
		out.println("<tr><td width=\"25%\"></td><td align=\"left\" nowrap>");
		if (null != error) {
			out.println("Status : " + error + "<br>");
		} else {
			if (null != pdata)
				out.println("Status : success<br>");
			else 
				out.println("Status : Data not found<br>");
		}
		//
		if (null != pdata) {
			out.println("<table>");
				out.println("<tr><td colspan=\"3\">DocumentReferenceType</td></tr>");
				out.println("<tr><td>&nbsp;</td><td>Registration ID : </td><td>"+ this.convertToHTML(pdata.getDocumentHeader().getDocumentReference().getRegistrationID())+ "</td></tr>");
				out.println("<tr><td>&nbsp;</td><td>DischargePort : </td><td>"+ this.convertToHTML(pdata.getDocumentHeader().getDocumentReference().getDischargePort())+ "</td></tr>");
				out.println("<tr><td>&nbsp;</td><td>Load Port : </td><td>"+ this.convertToHTML(pdata.getDocumentHeader().getDocumentReference().getLoadPort())+ "</td></tr>");
				out.println("<tr><td colspan=\"3\">LicenseInfoType</td></tr>");
				out.println("<tr><td>&nbsp;</td><td>License No : </td><td>"+ this.convertToHTML(pdata.getDocumentHeader().getLicenseInfo().getLicenseNo())+ "</td></tr>");
//				out.println("<tr><td>&nbsp;</td><td>License Name : </td><td>"+ new String(pdata.getDocumentHeader().getLicenseInfo().getLicenseName().getBytes("ISO-8859-1"),"UTF-8" )+ "</td></tr>");
				out.println("<tr><td>&nbsp;</td><td>License Name : </td><td>"+ this.convertToHTML(pdata.getDocumentHeader().getLicenseInfo().getLicenseName())+ "</td></tr>");
				out.println("<tr><td>&nbsp;</td><td>License Type : </td><td>"+ this.convertToHTML(pdata.getDocumentHeader().getLicenseInfo().getLicenseType())+ "</td></tr>");
				out.println("<tr><td>&nbsp;</td><td>Authority ID : </td><td>"+ this.convertToHTML(pdata.getDocumentHeader().getLicenseInfo().getAuthorityID())+ "</td></tr>");
				out.println("<tr><td>&nbsp;</td><td>Authority Name : </td><td>"+ this.convertToHTML(pdata.getDocumentHeader().getLicenseInfo().getAuthorityName())+ "</td></tr>");
				out.println("<tr><td>&nbsp;</td><td>Country Code : </td><td>"+ this.convertToHTML(pdata.getDocumentHeader().getLicenseInfo().getCountryCode())+ "</td></tr>");
				out.println("<tr><td>&nbsp;</td><td>Description : </td><td>"+ this.convertToHTML(pdata.getDocumentHeader().getLicenseInfo().getDescription())+ "</td></tr>");
				out.println("<tr><td>&nbsp;</td><td>Inspection Level : </td><td>"+ this.convertToHTML(pdata.getDocumentHeader().getLicenseInfo().getInspectionLevel())+ "</td></tr>");
				out.println("<tr><td>&nbsp;</td><td>Inspection Desc : </td><td>"+ this.convertToHTML(pdata.getDocumentHeader().getLicenseInfo().getInspectionDesc())+ "</td></tr>");
				out.println("<tr><td>&nbsp;</td><td>TAX Reference : </td><td>"+ this.convertToHTML(pdata.getDocumentHeader().getLicenseInfo().getTaxReference())+ "</td></tr>");
			out.println("</table>");
			
			out.println("<table width=\"100%\" border=\"1\">");
		    out.println("<tr>");
			out.println("<th scope=\"col\" rowspan=\"3\">Declaration Line No.</th>");
			out.println("<th scope=\"col\" rowspan=\"3\">Country Code</th>");
			out.println("<th scope=\"col\" rowspan=\"3\">Remark</th>");
			out.println("<th scope=\"col\" colspan=\"4\">Invoice Info Type</th>");
			out.println("<th scope=\"col\" colspan=\"15\">Product Info Type</th>");
			out.println("<th scope=\"col\" colspan=\"2\">Customs Tariff Quantity Type</th>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td rowspan=\"2\" align=\"center\">Invoice Number</td>");
			out.println("<td rowspan=\"2\" align=\"center\">Invoice Item</td>");
			out.println("<td rowspan=\"2\" align=\"center\">Description</td>");
			out.println("<td rowspan=\"2\" align=\"center\">Invoice Date</td>");
			out.println("<td rowspan=\"2\" align=\"center\">Body No.</td>");
			out.println("<td rowspan=\"2\" align=\"center\">Brand Name</td>");
			out.println("<td rowspan=\"2\" align=\"center\">Characteristic</td>");
			out.println("<td rowspan=\"2\" align=\"center\">Country Code</td>");
			out.println("<td rowspan=\"2\" align=\"center\">Displacement</td>");
			out.println("<td rowspan=\"2\" align=\"center\">Engine No.</td>");
			out.println("<td rowspan=\"2\" align=\"center\">Model Code</td>");
			out.println("<td rowspan=\"2\" align=\"center\">Registration No.</td>");
			out.println("<td rowspan=\"2\" align=\"center\">Year</td>");
			out.println("<td colspan=\"4\" align=\"center\">Quantity Type</td>");
			out.println("<td colspan=\"2\" align=\"center\">Weight Info</td>");
			out.println("<td rowspan=\"2\" align=\"center\">Classification</td>");
			out.println("<td rowspan=\"2\" align=\"center\">Statistical Code</td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td  align=\"center\">Unit Code</td>");
			out.println("<td  align=\"center\">Quantity</td>");
			out.println("<td  align=\"center\">Sampling Unit Code</td>");
			out.println("<td  align=\"center\">Sampling Quantity</td>");
			out.println("<td  align=\"center\">Unit Code</td>");
			out.println("<td  align=\"center\">Weight</td>");
			out.println("</tr>");
			
			
			for (DocumentDetailsTransportType doc : pdata.getDocumentDetails()){
				out.println("<tr>");
				out.println("<td  align=\"center\">"+this.convertToHTML(doc.getDeclarationLineNo())+"</td>");
				out.println("<td  align=\"center\">"+this.convertToHTML(doc.getCountryCode())+"</td>");
				out.println("<td  align=\"center\">"+this.convertToHTML(doc.getRemark())+"</td>");
				if (null != doc.getInvoiceInfo()) {
					out.println("<td  align=\"center\">"+this.convertToHTML(doc.getInvoiceInfo().getInvoiceNumber())+"</td>");
					out.println("<td  align=\"center\">"+this.convertToHTML(doc.getInvoiceInfo().getInvoiceItem())+"</td>");
					out.println("<td  align=\"center\">"+this.convertToHTML(doc.getInvoiceInfo().getDescription())+"</td>");
					out.println("<td  align=\"center\">"+this.convertToHTML(doc.getInvoiceInfo().getInvoiceDate())+"</td>");
				} else {
					out.println("<td  align=\"center\">&nbsp;</td>");
					out.println("<td  align=\"center\">&nbsp;</td>");
					out.println("<td  align=\"center\">&nbsp;</td>");
					out.println("<td  align=\"center\">&nbsp;</td>");
				}
				
				if (null != doc.getProductInfo()) {
					out.println("<td  align=\"center\">"+this.convertToHTML(doc.getProductInfo().getBodyNo())+"</td>");
					out.println("<td  align=\"center\">"+this.convertToHTML(doc.getProductInfo().getBrandName())+"</td>");
					out.println("<td  align=\"center\">"+this.convertToHTML(doc.getProductInfo().getCharacteristic())+"</td>");
					out.println("<td  align=\"center\">"+this.convertToHTML(doc.getProductInfo().getCountryCode())+"</td>");
					out.println("<td  align=\"center\">"+this.convertToHTML(doc.getProductInfo().getDisplacement())+"</td>");
					out.println("<td  align=\"center\">"+this.convertToHTML(doc.getProductInfo().getEngineNo())+"</td>");
					out.println("<td  align=\"center\">"+this.convertToHTML(doc.getProductInfo().getModelCode())+"</td>");
					out.println("<td  align=\"center\">"+this.convertToHTML(doc.getProductInfo().getRegistrationNumber())+"</td>");
					out.println("<td  align=\"center\">"+this.convertToHTML(doc.getProductInfo().getYear())+"</td>");
					
					if (null != doc.getProductInfo().getQuantityInfo()) {
						out.println("<td  align=\"center\">"+this.convertToHTML(doc.getProductInfo().getQuantityInfo().getUnitCode())+"</td>");
						out.println("<td  align=\"center\">"+this.convertToHTML(doc.getProductInfo().getQuantityInfo().getQuantity())+"</td>");
						out.println("<td  align=\"center\">"+this.convertToHTML(doc.getProductInfo().getQuantityInfo().getSamplingUnitCode())+"</td>");
						out.println("<td  align=\"center\">"+this.convertToHTML(doc.getProductInfo().getQuantityInfo().getSamplingQuantity())+"</td>");
					} else {
						out.println("<td  align=\"center\">&nbsp;</td>");
						out.println("<td  align=\"center\">&nbsp;</td>");
						out.println("<td  align=\"center\">&nbsp;</td>");
						out.println("<td  align=\"center\">&nbsp;</td>");
					}
					
					if (null != doc.getProductInfo().getWeightInfo()) {
						out.println("<td  align=\"center\">"+this.convertToHTML(doc.getProductInfo().getWeightInfo().getUnitCode())+"</td>");
						out.println("<td  align=\"center\">"+this.convertToHTML(doc.getProductInfo().getWeightInfo().getWeight())+"</td>");
					} else {
						out.println("<td  align=\"center\">&nbsp;</td>");
						out.println("<td  align=\"center\">&nbsp;</td>");
					}
				} else {
					out.println("<td  align=\"center\">&nbsp;</td>");
					out.println("<td  align=\"center\">&nbsp;</td>");
					out.println("<td  align=\"center\">&nbsp;</td>");
					out.println("<td  align=\"center\">&nbsp;</td>");
					out.println("<td  align=\"center\">&nbsp;</td>");
					out.println("<td  align=\"center\">&nbsp;</td>");
					out.println("<td  align=\"center\">&nbsp;</td>");
					out.println("<td  align=\"center\">&nbsp;</td>");
					out.println("<td  align=\"center\">&nbsp;</td>");
					out.println("<td  align=\"center\">&nbsp;</td>");
					out.println("<td  align=\"center\">&nbsp;</td>");
					out.println("<td  align=\"center\">&nbsp;</td>");
					out.println("<td  align=\"center\">&nbsp;</td>");
					out.println("<td  align=\"center\">&nbsp;</td>");
					out.println("<td  align=\"center\">&nbsp;</td>");
				}
				
				if (null != doc.getTariffInfo()) {
					out.println("<td  align=\"center\">"+this.convertToHTML(doc.getTariffInfo().getClassification())+"</td>");
					out.println("<td  align=\"center\">"+this.convertToHTML(doc.getTariffInfo().getStatisticalCode())+"</td>");
				} else {
					out.println("<td  align=\"center\">&nbsp;</td>");
					out.println("<td  align=\"center\">&nbsp;</td>");
				}
				
				out.println("</tr>");
			}
		
			out.println("</table>");
		
		}
		
		//
		
		
		out.println("</td><td width=\"25%\"></td></tr>");
		out.println("</table>");
		out.println("</td>");
		out.println("<td background=\"http://ptc.doeb.go.th/ptc/images/pic_10.gif\"></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td align=\"left\"><img src=\"http://ptc.doeb.go.th/ptc/images/pic_11.gif\" border=\"0\"></td>");
		out.println("<td></td>");
		out.println("<td align=\"right\"><img src=\"http://ptc.doeb.go.th/ptc/images/pic_12.gif\" border=\"0\"></td>");
		out.println("</tr>");
		out.println("</table>");
		out.println("</td>");
		out.println("</tr>");
		out.println("<!-- New Body -->");
		
		out.println("<!--  line bottom table -->");
		out.println("<tr>");
		out.println("<td width=\"100%\" align=\"center\">");
		out.println("<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" class=\"main\" align=\"center\">");
		out.println("<tr>");
		out.println("<td width=\"2%\" align=\"left\"><img src=\"http://ptc.doeb.go.th/ptc/images/pic_13.gif\" border=\"0\"></td>");
		out.println("<td align=\"left\" width=\"34%\"><img src=\"http://ptc.doeb.go.th/ptc/images/pic_16.gif\" border=\"0\"></td>");
		out.println("<td width=\"100%\" align=\"left\"><img src=\"http://ptc.doeb.go.th/ptc/images/pic_17.gif\" border=\"0\" height=\"21\" width=\"100%\"></td>");
		out.println("<td align=\"right\" width=\"45%\"><img src=\"http://ptc.doeb.go.th/ptc/images/pic_18.gif\" border=\"0\"></td>");
		out.println("<td width=\"2%\" align=\"right\"><img src=\"http://ptc.doeb.go.th/ptc/images/pic_15.gif\" border=\"0\"></td>");
		out.println("</tr>");
		out.println("</table>");
		out.println("</td>");
		out.println("</tr>");
		out.println("<!-- footer -->");
		out.println("<td width=\"100%\">");
		out.println("<table cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"100%\">");
		out.println("<tr>");
		out.println("<td width=\"50%\"><img src=\"http://ptc.doeb.go.th/ptc/images/pic_20.gif\" width=\"100%\" height=\"23\" border=\"0\"></td>");
		out.println("<td width=\"800\"><img src=\"http://ptc.doeb.go.th/ptc/images/pic_19.gif\" border=\"0\" height=\"23\"></td>");
		out.println("<td width=\"50%\"><img src=\"http://ptc.doeb.go.th/ptc/images/pic_20.gif\" width=\"100%\" height=\"23\" border=\"0\"></td>");
		out.println("</tr>");
		out.println("</table>");
		out.println("</td>");
		out.println("</table>");
		out.println("</body></html>");
		out.close();

		log.info("end process");
	}

	private String demo(String ip, Integer port, String path,
			String truststore, String storepass) {
		try {
			StringBuffer ebMSPing = new StringBuffer();
			ebMSPing.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n");
			ebMSPing
					.append("<SOAP:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\r\n");
			ebMSPing
					.append(" xmlns:SOAP=\"http://schemas.xmlsoap.org/soap/envelope/\"\r\n");
			ebMSPing
					.append(" xsi:schemaLocation=\"http://schemas.xmlsoap.org/soap/envelope/\r\n");
			ebMSPing
					.append(" http://www.oasis-open.org/committees/ebxml-msg/schema/envelope.xsd\">\r\n");
			ebMSPing
					.append(" <SOAP:Header xmlns:eb=\"http://www.oasis-open.org/committees/ebxml-msg/schema/msg-header-2_0.xsd\"\r\n");
			ebMSPing
					.append(" xsi:schemaLocation=\"http://www.oasis-open.org/committees/ebxml-msg/schema/msg-header-2_0.xsd\r\n");
			ebMSPing
					.append(" http://www.oasis-open.org/committees/ebxml-msg/schema/msg-header-2_0.xsd\">\r\n");
			ebMSPing
					.append(" <eb:MessageHeader version=\"2.0\" SOAP:mustUnderstand=\"1\"\r\n");
			ebMSPing
					.append(" xmlns=eb:\"http://www.oasis-open.org/committees/ebxml-msg/schema/msg-header-2_0.xsd\"\r\n");
			ebMSPing
					.append(" xsi:schemaLocation=\"http://www.oasis-open.org/committees/ebxml-msg/schema/msg-header-2_0.xsd\r\n");
			ebMSPing
					.append(" http://www.oasis-open.org/committees/ebxml-msg/schema/msg-header-2_0.xsd\">\r\n");
			ebMSPing
					.append(" <eb:From><eb:PartyId>ITAPDemo</eb:PartyId></eb:From>\r\n");
			ebMSPing
					.append(" <eb:To><eb:PartyId>TCDNSWDemo</eb:PartyId></eb:To>\r\n");
			ebMSPing.append(" <eb:CPAId>NSW_DOEB_1_00</eb:CPAId>\r\n");
			ebMSPing
					.append(" <eb:ConversationId>NSW_DOEB_1_00</eb:ConversationId>\r\n");
			ebMSPing.append(" <eb:Service>TCDeLicense</eb:Service>\r\n");
			ebMSPing.append(" <eb:Action>Ping</eb:Action>\r\n");
			ebMSPing.append(" <eb:MessageData>\r\n");
			ebMSPing
					.append(" <eb:MessageId>NSW_DOEB_1_00@itap.com</eb:MessageId>\r\n");
			ebMSPing
					.append(" <eb:Timestamp>2010-08-18T00:00:00</eb:Timestamp>\r\n");
			ebMSPing.append(" </eb:MessageData>\r\n");
			ebMSPing.append(" </eb:MessageHeader>\r\n");
			ebMSPing.append(" </SOAP:Header>\r\n");
			ebMSPing.append(" <SOAP:Body/>\r\n");
			ebMSPing.append("</SOAP:Envelope>\r\n");

			// String urlStr = "http://10.3.20.22:30704/exchange/TCDNSW01";
			// String urlSSL = "https://10.3.20.22:4443/exchange/TCDNSW01";

			System.out.println("URI: https://" + ip + ":" + port + "" + path);

			/*
			 * String ip = "127.0.0.1"; Integer port = 8443; String path =
			 * "/simservlet/services";
			 * 
			 * String trustStore = Class.forName("com.itap.test.ItapebPing")
			 * .getClassLoader() .getResource("cacerts.jks") .getPath();
			 */

			String trustStore = truststore;

			log.info("Trust store: " + trustStore);
			log.info("Trust store password: " + storepass);

			System.setProperty("javax.net.ssl.trustStore", trustStore);
			System.setProperty("javax.net.ssl.trustStorePassword", storepass);

			String ret = null;
			String[] proto = { "SSLv3" }; // SSLv2Hello , SSLv3
			BufferedWriter wr = null;
			SSLSocket socket = null;
			BufferedReader in = null;

			log.info("Initial SSL Socket...");
			SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory
					.getDefault();
			socket = (SSLSocket) factory.createSocket(ip, port);

			socket.setEnabledProtocols(proto);
			socket.setSoTimeout(300 * 1000);

			log.info(" *** Socket start hand shaking...");
			socket.startHandshake();

			// Send header
			log.info(" *** Setting request to https method...");
			wr = new BufferedWriter(new OutputStreamWriter(socket
					.getOutputStream(), "UTF-8"));
			wr.write("POST " + path + " HTTP/1.0\r\n");
			wr
					.write("Content-Length: " + ebMSPing.toString().length()
							+ "\r\n");
			wr
					.write("Content-Type: application/soap+xml; charset=\"utf-8\"\r\n");
			wr.write("SOAPAction: \"ebXML\"\r\n");
			wr.write("\r\n");
			// Send data
			log.info(" *** Sending xml request...");
			wr.write(ebMSPing.toString());
			wr.flush();

			/* start read response */
			log.info(" *** Waiting for xml response...");

			StringBuffer results = new StringBuffer();
			in = new BufferedReader(new InputStreamReader(socket
					.getInputStream()));

			if (null != in) {
				log.info(" *** Start translate stream to string response...");
				String inputLine;

				while ((inputLine = in.readLine()) != null) {
					results.append(inputLine.trim());
				}
				ret = results.toString();
			} else {
				log.info("ERROR: Cannot get stream response");
				throw new NullPointerException("No response from destination server");
			}
			log.info(" *** Display response : " + ret);
			return null;
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			// Connection refused.
			e.printStackTrace();
			return e.getMessage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			// Communicate problem
			e.printStackTrace();
			return e.getMessage();
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			// No response from destination
			e.printStackTrace();
			return e.getMessage();
		}

	}

	private String proceedLicensePerInvoice(LicensePerInvoice data, HttpServletRequest request, HttpServletResponse response)
			throws JdbcException, Exception {
		String messageToDisplay = null;
		try {
			String acknowledge = null;
			String messageId = userId+"_"+data.getDocumentHeader().getLicenseInfo().getLicenseNo();        //Defined by (CPA DOBE User ID)+"_"+(License document reference ID)
			Integer timeToLive = 5;     //It's mean service end-point have to return within 5 minute.
			try {
			    // Proceeding process
				messageToDisplay = mp.produce( messageId, timeToLive, data );
			} catch (Exception e) {
			    // Setting message variable.
			    messageToDisplay = e.getMessage();
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
		return messageToDisplay;
	}
	

	public static String convertToHTML(String s){
		if (s == null) return "&nbsp;";
		
		String result = "";
		byte[] c;
		try {
			c = s.getBytes("TIS620");
			for (byte b : c) {
				if ((b <= -38 && b >= -95) || (b <= -5 && b >= -33))
					result += "&#" + (b+3680) + ";";
				else {
					byte[] t = {b};
					result += new String(t);
				}
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static String convertToHTML(BigInteger s){
		if (s == null) return "&nbsp;";
		
		String result = s.toString();
		return result;
	}

	public static String convertToHTML(BigDecimal s){
		if (s == null) return "&nbsp;";
		
		String result = s.toString();
		return result;
	}

	public static String convertToHTML(XMLGregorianCalendar s){
		if (s == null) return "&nbsp;";
		
		String result = s.toString();
		return result;
	}
}
