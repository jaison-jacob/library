<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="Librarymanagementadmin.Admindata"%>
<%@page import="Librarymanagementadmin.Bookadd"%>
<%@page import="Librarymanagementadmin.Errors"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
ArrayList<Errors> error = (ArrayList<Errors>)request.getAttribute("error");
if(error != null){
for(Errors errors:error){
	
	if(errors.getcheckerror().equalsIgnoreCase("true")){
		out.println("please enter all detail");
	}else if(errors.getmatchingerror().equalsIgnoreCase("true")){
		out.println("your searched name is not in list");
	}
	
	else{%>
<table border ="1"  width = "500" align ="center" backgroundcolor ="green">
<tr><th>STUDENT NAME</th><th>STUDENT PHONENO</th><th>ADDRESS</th><th>STUDENT EMAIL</th></tr>
<%ArrayList<Admindata> data = (ArrayList<Admindata>)request.getAttribute("data");
if(data != null){
	for(Admindata admindata: data){%>
	<tr>
<td><%=admindata.getname()%></td>	
<td><%=admindata.getphoneno()%></td>
<td><%=admindata.getaddress()%></td>
<td><%=admindata.getemail()%></td>	
<%}} %>
</tr>
</table>

<%}}} %>

<form action = "admin" method = "post">

<button  name="page" value="backadminpage">back adminpage </button><br>


</form>
</body>
</html>