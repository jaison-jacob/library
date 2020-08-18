<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="Librarymanagementstudent.bookdetail"%>
<%@page import="Librarymanagementstudent.bookstatus"%>
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



<%

					out.println("book buy successfully.it shouldbe return within 10 days");

%>
<br><br><form action="student" method="post">
						<input type="hidden" name="page" value="backpage" /> <input
							type="submit" name="back" value="BACK STUDENT PAGE" />
					</form>
</body>
</html>