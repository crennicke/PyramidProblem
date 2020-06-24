<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="com.rennicke.Servlet" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Pyramid Problem</title>
</head>
<body>
		<form action="Servlet" method="POST"> 
 		Please enter pyramid word:
 		<input type="text" name="text1" id="text1">
 		<br>
 		<input type="submit" value="Submit">
		</form> 
		
		<c:if test="${not empty message}">
   		 <h1>${message}</h1>
</c:if>
</body>
</html>