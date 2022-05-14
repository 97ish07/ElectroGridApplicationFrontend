<%@page import="model.Inquiry" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="Components/jquery-3.6.0.min.js"></script>
<script src="Components/main.js"></script>

</head>
<body>





<div class="container">
<h1>Inquiry Management</h1>
<form id="formNotice" name="formNotice" method="post" action="inquiry.jsp">
Name:<input id="phone" name="phone" type="text" class="form-control"><br>
E-mail:<input id="address" name="address" type="text" class="form-control"><br>
Contact Number:<input id="note" name="note" type="text" class="form-control"><br>
Address:<input id="zipcode" name="zipcode" type="text" class="form-control"><br>
Inquiry Type:<input id="zipcode" name="zipcode" type="text" class="form-control"><br>
Message:<input id="zipcode" name="zipcode" type="text" class="form-control"><br>
<input id="btnSave" name="btnSave" type="button" value="Save" class="btn btn-primary">
<input type="hidden" id="hidItemIDSave" name="hidItemIDSave" value="">
</form>
<br>
<div id="alertSuccess" class="alert alert-success"></div>
<div id="alertError" class="alert alert-danger"></div>
<br>


<div id="divItemsGrid">
	<%
 		Inquiry inquiryObj = new Inquiry();
 		out.print(inquiryObj.readInquiries());
	%>
	</div>

</div>



</body>
</html>