package model;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/InquiryAPI")
public class InquiryAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Inquiry inquiryObj = new Inquiry();
       
   
    public InquiryAPI() {
        super();
        
    }
     
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String output = inquiryObj.insertInquiries(request.getParameter("name"),
		 		request.getParameter("email"),
		 		request.getParameter("contactNumber"),
		 		request.getParameter("address"),
		 		request.getParameter("inquiryType"),
		 		request.getParameter("message"));
       response.getWriter().write(output); 
		
	}
	
	// Convert request parameters to a Map
		private static Map getParasMap(HttpServletRequest request)
		{
			Map<String, String> map = new HashMap<String, String>();
		
			try
			{
				Scanner scanner = new Scanner(request.getInputStream(), "UTF-8");
				String queryString = scanner.hasNext() ?
						scanner.useDelimiter("\\A").next() : "";
				scanner.close();
				String[] params = queryString.split("&");
				 
				for (String param : params)
				{ 
					 String[] p = param.split("=");
					 map.put(p[0], p[1]);
				}
			 }
			catch (Exception e)
			{
			}
			return map;
			}

	
	
	

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map paras = getParasMap(request);
		String output = inquiryObj.updateInquiries(paras.get("hidItemIDSave").toString(),
						paras.get("name").toString(),
						paras.get("email").toString(),
						paras.get("contactNumber").toString(),
						paras.get("address").toString(),
						paras.get("inquiryType").toString(),
						paras.get("message").toString());
		response.getWriter().write(output); 
	}

	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map paras = getParasMap(request);
		String output = inquiryObj.deleteInquiries(paras.get("inquiryID").toString());
		response.getWriter().write(output); 
		
	}

}
