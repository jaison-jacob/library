<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="Librarymanagementstudent.bookdetail"%>
<%@page import="Librarymanagementstudent.bookstatus"%>

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
	#btn{
	width :100%;
	background-color :green;
	}
	
	</style>

<table border ="1"  width = "500" align ="center" backgroundcolor ="green">
<tr><th>booksname</th><th>language</th><th>catogory</th><th>publishyear</th><th>book status</th><th>switch</th></tr>
<%ArrayList<bookdetail> Bookdetail = (ArrayList<bookdetail>)request.getAttribute("bookdetail");
if(Bookdetail != null){
	for(bookdetail books:Bookdetail){%>
<tr>
<td><%=books.getbookname()%></td>	
<td><%=books.getlanguage()%></td>
<td><%=books.getcatogory()%></td>
<td><%=books.getpublishyear() %>
<td><%=books.getstatus()%></td>
<%if(books.getstatus().equalsIgnoreCase("available")){ %>
<td><form action = "student" method = "post">

<button  name="page" value="buy"  id="btn">BUY</button><br>
<input type = "hidden" name ="bookid" value = "<%=books.getbookid()%>" />

</form>
</td>
<%} %>		
</tr>
<%}} %>	
</table>
<br><br><form action="student" method="post">
			<input type="hidden" name="page" value="backpage" /> <input
				type="submit" name="back" value="BACK STUDENT PAGE" />
		</form>
</body>
</html>