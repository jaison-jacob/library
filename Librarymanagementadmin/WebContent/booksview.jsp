<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="Librarymanagementadmin.Bookadd"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action = "admin" method = "post">

<button  name="page" value="backadminpage">back adminpage </button><br>


</form>

<table border ="1"  width = "500" align ="center">
<tr><th>booksname</th><th>language</th><th>catogory</th><th>publish year</th><th>status</th><th>bookid</th></tr>
<%ArrayList<Bookadd> list = (ArrayList<Bookadd>)request.getAttribute("booklist");
if(list != null){
	for(Bookadd books:list){%>
<tr>
<td><%=books.getbookname()%></td>	
<td><%=books.getlanguage()%></td>
<td><%=books.getcatogory()%></td>
<td><%=books.getpublishdate()%></td>
<td><%=books.getstatus() %>	</td>
<td><%=books.getbookid() %></td>	
</tr>	

<%}} %>
</table>

<% %>
</body>
</html>