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
<style>

#table{

rowspan:"2";
}

</style>
<%
ArrayList<Errors> error = (ArrayList<Errors>)request.getAttribute("checkerror");
if(error != null){
	for(Errors errors: error){
		if(errors.getcheckerror().equalsIgnoreCase("true")){
			out.println("please enter all values");
		}else if(errors.getcheckerror().equalsIgnoreCase("false")){%>

<table border ="1"  width = "500" align ="center" backgroundcolor ="green">
<tr><th>booksname</th><th>language</th><th>catogory</th><th>book publishyear</th><th>student name</th><th>buydate</th><th>returndate</th></tr>
<%ArrayList<Bookadd> Bookdetail = (ArrayList<Bookadd>)request.getAttribute("booklist");
if(Bookdetail != null){
	for(Bookadd books:Bookdetail){%>
<tr>
<td><%=books.getbookname()%></td>	
<td><%=books.getlanguage()%></td>
<td><%=books.getcatogory()%></td>
<td><%=books.getpublishdate()%></td>
<td><%=books.getname() %></td>
<td><%=books.getbuydate() %></td>
<td><%=books.getreturndate() %></td>



</tr>
<%}}%>
</table>


<%}}} %>

<form action = "admin" method = "post">

<button  name="page" value="backadminpage">back adminpage </button><br>


</form>

</body>
</html>