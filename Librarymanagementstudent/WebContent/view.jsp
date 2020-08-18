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
<%ArrayList<bookdetail> Bookdetail = (ArrayList<bookdetail>)request.getAttribute("view");
if(Bookdetail != null){
	for(bookdetail books:Bookdetail){%>
<table border ="1"  width = "500" align ="center" backgroundcolor ="green">
<tr><th>booksname</th><th>language</th><th>BUY DATE</th></tr>

<tr>
<td><%=books.getbookname()%></td>	
<td><%=books.getlanguage()%></td>
<td><%=books.getbuydate()%></td>


		
</tr>
     <%}%>

</table>
<%}else{
out.println("you dont have any books");
}%>	
<br><br><form action="student" method="post">
			<input type="hidden" name="page" value="backpage" /> <input
				type="submit" name="back" value="BACK STUDENT PAGE" />
		</form>

</body>
</html>