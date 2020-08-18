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
<%
ArrayList<Errors> errordata = (ArrayList<Errors>)request.getAttribute("error");
if(errordata != null){
	for(Errors error : errordata){
		
		if(error.getmatchingerror() == true){
			
			out.println("please enter correct detail");
		}else if(error.getcheckerror() == true){
			
		out.println("please enter all details");
		
		
		}else{
			out.println("book return successfully");
		}
		
	}
}
%>
<br><br><form action="student" method="post">
			<input type="hidden" name="page" value="backpage" /> <input
				type="submit" name="back" value="BACK STUDENT PAGE" />
		</form>
</body>
</html>