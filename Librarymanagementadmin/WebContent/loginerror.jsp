<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
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

ArrayList<Errors> result = (ArrayList<Errors>)request.getAttribute("check1");
if(result != null){
	
for(Errors errors: result){
if(errors.getphoneno().equalsIgnoreCase("true")){
	out.println("register not sucessfully please enter valid phone number.........");

} 
if(errors.getcheckerror().equalsIgnoreCase("true")){
	out.println("please enter all details............");
}
 if(errors.getusername().equalsIgnoreCase("true")){
	out.println("register is not successful username is already exist...........");
}
 if(errors.getemailerror().equalsIgnoreCase("true")){
	 out.println("register is not successful enter valid emailid ........");
 }
 if(errors.getphoneno().equalsIgnoreCase("false") && errors.getcheckerror().equalsIgnoreCase("false") && errors.getusername().equalsIgnoreCase("false")&&errors.getemailerror().equalsIgnoreCase("false") ){
	out.println("register is successful.........");
}
}
}

ArrayList<Errors> error = (ArrayList<Errors>)request.getAttribute("checkerror");
if(error != null){
for(Errors errors : error){
	
	if(errors.getpassworderror().equalsIgnoreCase("true")){
		out.println("enter valid uername and password...........");
	}
}
}


%>


</body>
</html>