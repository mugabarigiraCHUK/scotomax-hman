package com.itap.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itap.ebms.MessageProducer;

/**
 * Servlet implementation class LicensePerInvoiceStatusServlet
 */
public class LicensePerInvoiceStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LicensePerInvoiceStatusServlet() {
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
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = getServletContext();
		MessageProducer mp;
		List<String> fnameList = null;
		
		PrintWriter out;
		response.setContentType("text/html");
		out = response.getWriter();
		String error = null;
		try {
			
			String INBOX = ("".equals(context.getInitParameter("INBOX")) ? null
					: context.getInitParameter("INBOX"));
			String OUTBOX = ("".equals(context.getInitParameter("OUTBOX")) ? null
					: context.getInitParameter("OUTBOX"));
			mp = new MessageProducer();
			mp.setDIRECTORY_INBOX(INBOX);
			mp.setDIRECTORY_OUTBOX(OUTBOX);
			
			fnameList = mp.getMessagesInbox();
			createHMTLOutput(out, error, fnameList);	
		} catch (Exception e){
			error = e.getMessage();
			e.printStackTrace();
		}
		out.close();
	}
	
	private void createHMTLOutput(PrintWriter out, String error, List<String> fnameList){
		// Header 
		out.println("<html xmlns=\"http://www.w3.org/1999/xhtml\">");
		out.println("<head>");
		out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=tis-620\" />");
		out.println("<meta http-equiv=\"imagetoolbar\" content=\"false\" />");
		out.println("<meta http-equiv=\"Pragma\" content=\"no-cache\"/>");
		out.println("<link href=\"http://ptc.doeb.go.th/ptc/css/ptc_orange.css\" rel=\"stylesheet\" type=\"text/css\"/>");
		out.println("<title>ระบบสารสนเทศศูนย์กลางการบริการธุรกิจการค้าน้ำมันเชื้อเพลิง</title>");
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
		//Body
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
		boolean showTable = false;
		if (null != error) {
			out.println("Status : "+error+"<br>");
		} else {
			out.println("Status : success<br>");
			out.println("Summary : " + (null != fnameList ? fnameList.size() : 0) + "row(s)<br>");
			if (null != fnameList && fnameList.size() > 0) {
				showTable = true;
			}
		}
		
		if (showTable) {
			out.println("<table class=\"result\">");
			out.println("<tr class=\"oddRow\">");
			out.println("<th>No.</th><th>Name</th></tr>");
			int i = 0;
			for (String name : fnameList) {
				i++;
				if ((i % 2) != 0) {
					out.println("<tr class=\"evenRow\"><td>"+i+"</td><td>"+name+"</td></tr>");
				} else {
					out.println("<tr class=\"oddRow\"><td>"+i+"</td><td>"+name+"</td></tr>");
				}
			}
			out.println("</table>");
		}
		// Tail
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
	}

}
