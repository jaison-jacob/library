<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="Librarymanagementstudent.studentdetail"%>

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
.buttn {
	position: absolute;
	width: 80%;
	height: 55%;
	margin-left: 10%;
	border: 3px solid #73AD21;
	padding: 3%;
	background-color: LightGray;
}

input {
	margin-top: 2%;
	width: 85%;
	height: 10%;
	margin-left: 5%;
}

#heading {
	margin-top: 0%;
	text-align: center;
}
</style>

	<div class="buttn">
	    <%ArrayList<studentdetail> studentdata = (ArrayList<studentdetail>)request.getAttribute("studentdata");
	    if(studentdata != null){
	    	for(studentdetail data: studentdata){%>
	    		
	    
	    
	    
		<h1 id="heading">hi<%="  "+data.getuserid() %></h1>
		<%}} %>
		<form action="student" method="post">
			<input type="hidden" name="page" value="booksearch" /> <input
				type="submit" name="book add" value="BOOK SEARCH" />
		</form>

		

		<form action="student" method="post">
			<input type="hidden" name="page" value="booklist" /> <input
				type="submit" name="book list" value="BOOK LIST" />
		</form>

		<form action="student" method="post">
			<input type="hidden" name="page" value="viewstatus" /> <input
				type="submit" name="view status" value="VIEW STATUS" />
		</form>
		
		<form action="student" method="post">
			<input type="hidden" name="page" value="bookreturn" /> <input
				type="submit" name="book return " value="BOOK RETURN" />
		</form>

		<form action="student" method="get">
			<input type="hidden" name="page" value="backlogin" /> <input
				type="submit" name="back login" value="BACK LOGIN" />
		</form>
	</div>



</body>
</html>