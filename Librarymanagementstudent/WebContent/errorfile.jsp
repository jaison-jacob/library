<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="Librarymanagementstudent.Errors"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action = "student" method = "get">

<input type="hidden" name="page" value="backstudentlogin"/><br>
<input type="submit" name="login student" id = "btn" value="BACK LOGIN" /><br>

</form>

<%
ArrayList<Errors> error = (ArrayList<Errors>)request.getAttribute("errors");
if(error != null){
	
	for(Errors errors : error ){
		
		if(errors.getphoneno() == true){
			out.println("please enter valid phone no");
		}
		if(errors.geytemailerror() == true){
			out.println("email id is already exist");
		}
		if(errors.getcheckerror() == true){
			out.println("please enter all data");
		}
		if(errors.getmatchingerror() == true){
			out.println("please enter valid userid and password");
		}
		
		if(errors.getphoneno() == false && errors.geytemailerror() == false && errors.getcheckerror() == false && errors.getmatchingerror() == false ){
			out.println("register is successful....... "+
		"your userid is :"+errors.getuserid());
		}
	}
}
%>


</body>
</html>