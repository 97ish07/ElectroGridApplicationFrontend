package model;

import java.sql.*;

public class Inquiry
{ 
	//A common method to connect to the DB
	private Connection connect()
	 {
		 Connection con = null;
		 
		 try
		 {
		 Class.forName("com.mysql.jdbc.Driver");
		
		 //Provide the correct details: DBServer/DBName, username, password
		 con = DriverManager.getConnection("jdbc:mysql://localhost/inquirydb", "root", "");
		 }
		 catch (Exception e)
		 {
			 e.printStackTrace();
		 }
		 
		 return con;
	 }
	
	//Insert
	public String insertInquiries(String name, String email, String contactNumber, String address, String inquiryType, String message)
	 {
		 String output = "";
		 
		 try
		 {
			 Connection con = connect();
			 
			 if (con == null)
			 {return "Error while connecting to the database for inserting.";}
			 
			 // create a prepared statement
			 String query = " insert into inquiries (`inquiryID`,`name`,`email`,`contactNumber`,`address`,`inquiryType`,`message`)" + " values (?, ?, ?, ?, ?, ?, ?)";
			 
			 PreparedStatement preparedStmt = con.prepareStatement(query);
			 
			 // binding values
			 preparedStmt.setInt(1, 0);
			 preparedStmt.setString(2, name);
			 preparedStmt.setString(3, email);
			 preparedStmt.setString(4, contactNumber);
			 preparedStmt.setString(5, address);
			 preparedStmt.setString(6, inquiryType);
			 preparedStmt.setString(7, message);
			 
			 
			 // execute the statement
			 preparedStmt.execute();
			 con.close();
			 
			 String NewInquirys = readInquiries();
			 output = "{\"status\":\"success\", \"data\": \"" + 
					 NewInquirys + "\"}"; 
			 
		 }
		 catch (Exception e)
		 {
	
			 output = "{\"status\":\"error\", \"data\": \"Error while inserting the inquiry.\"}"; 
			 System.err.println(e.getMessage());
		 }
		 return output;
	}
	
	// view
	
	public String readInquiries()
	{
		 String output = "";
		 
		 try
		 {
			 Connection con = connect();
			 
			 if (con == null)
			 {return "Error while connecting to the database for reading."; }
			 
			 // Prepare the html table to be displayed
			 output = "<table border='1' class='table table-striped'><tr>"
					 + "<th>Name</th>"
					 + "<th>E-mail</th>"
					 + "<th>Contact Number</th>"
					 + "<th>Address</th>"
					 + "<th>Inquiry Type</th>"
					 + "<th>Message</th>"
					 + "<th>Update</th><th>Delete</th></tr>";
					 
			
			 String query = "select * from inquiries";
			 Statement stmt = con.createStatement();
			 ResultSet rs = stmt.executeQuery(query);
			 
			 // iterate through the rows in the result set
			 while (rs.next())
			 {
				 String inquiryID = Integer.toString(rs.getInt("inquiryID"));
				 String name = rs.getString("name");
				 String email = rs.getString("email");
				 String contactNumber = rs.getString("contactNumber");
				 String address = rs.getString("address");
				 String inquiryType = rs.getString("inquiryType");
				 String message = rs.getString("message");
				 
				 
				 // Add into the html table
				 output += "<tr><td><input id=\'hidItemIDUpdate\' name=\'hidItemIDUpdate\' type=\'hidden\' value=\'"
							+ inquiryID + "'>" +  name + "</td>";
				 output += "<td>" + email + "</td>";
				 output += "<td>" + contactNumber + "</td>";
				 output += "<td>" + address + "</td>";
				 output += "<td>" + inquiryType + "</td>";
				 output += "<td>" + message + "</td>";
				 
				 
				 // buttons
				 
				 output += "<td><input name='btnUpdate' type='button' value='Update' class='btnUpdate btn btn-success' data-inquiryid='" + inquiryID+"'></td>"
						 + "<td><input name='btnRemove' type='button' value='Remove' class='btnRemove btn btn-danger' data-inquiryid='" + inquiryID + "'></td></tr>";
			 }
			 
			 con.close();
			 // Complete the html tables
			 output += "</table>";
		 }
		 catch (Exception e)
		 {
			 output = "Error while reading the inquiries.";
			 System.err.println(e.getMessage());
		 }
		 return output;
	}
	
	//update
	public String updateInquiries(String inquiryID, String name, String email, String contactNumber, String address, String inquiryType, String message)
	{
		 String output = "";
		 
		 try
		 {
			 Connection con = connect();
			 
			 if (con == null)
			 {return "Error while connecting to the database for updating."; }
			 
			 // create a prepared statement
			 String query = "UPDATE inquiries SET name=?,email=?,contactNumber=?,address=?,inquiryType=?,message=? WHERE inquiryID=?";
			 
			PreparedStatement preparedStmt = con.prepareStatement(query);
			 
			 // binding values
			 preparedStmt.setString(1, name);
			 preparedStmt.setString(2, email);
			 preparedStmt.setString(3, contactNumber);
			 preparedStmt.setString(4, address);
			 preparedStmt.setString(5, inquiryType);
			 preparedStmt.setString(6, message);
			 preparedStmt.setInt(7, Integer.parseInt(inquiryID));
			 
			 
			 // execute the statement
			 preparedStmt.execute();
			 con.close();
			 
			 String NewInquirys = readInquiries();
			 output = "{\"status\":\"success\", \"data\": \"" + 
					 NewInquirys + "\"}";
			 
			 
		 }
		 catch (Exception e)
		 {
			 output = "{\"status\":\"error\", \"data\":\"Error while updating the inquiry.\"}";
			 System.err.println(e.getMessage());
		 }
		 
		 return output;
		 
	}
	
	// delete
	public String deleteInquiries(String inquiryID)
	{
	 String output = "";
	 try
	  {
	  Connection con = connect();
	  if (con == null)
	  {
	  return "Error while connecting to the database for deleting.";
	  }
	  
	  // Create a prepared statement
	  String query = "delete from inquiries where inquiryID=?";
	  PreparedStatement preparedStmt = con.prepareStatement(query);
	  
	  // Binding values
	  preparedStmt.setInt(1, Integer.parseInt(inquiryID));

	  // Execute the statement
	  preparedStmt.execute();
	  con.close();
	  
	  String NewInquirys = readInquiries();
	  output = "{\"status\":\"success\", \"data\": \"" + NewInquirys + "\"}"; 
	 
	  }
	 catch (Exception e)
	  {
	  
	  output = "{\"status\":\"error\", \"data\": \"Error while deleting the Inquiry.\"}";
	  System.err.println(e.getMessage());
	  }
	 return output; 
	}
}

	