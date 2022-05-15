package model;

import java.io.IOException;
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

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
