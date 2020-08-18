<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="Librarymanagementadmin.Errors"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>book adding page</title>
</head>
<body>
<form action = "admin" method = "post">

<button  name="page" value="backadminpage">back adminpage </button><br>


</form>
<%
ArrayList<Errors> errordata = (ArrayList<Errors>)request.getAttribute("bookerror");
if(errordata != null){
	for(Errors error :errordata){
		if(error.getyearerror().equalsIgnoreCase("true")){
			out.println("please enter valid year.......");
		}
		if(error.getbooknameerror().equalsIgnoreCase("true")){
			out.println("book is already added........");
		}
		if(error.getyearerror().equalsIgnoreCase("false") && error.getbooknameerror().equalsIgnoreCase("false") && error.getcheckerror().equalsIgnoreCase("false")){
			out.println("book is added.....");
		}
		if(error.getcheckerror().equalsIgnoreCase("true")){
			out.println("please enter all detail");
		}
	}
}

%>
</body>
</html>