<%@page import="com.protom.model.entities.Phone"%>
<%@page import="com.protom.model.entities.Email"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%=request.getParameter("name") %><br>
<%=request.getParameter("surname") %><br>
NUMERI:
<br>
<%
List<Phone> phones =(List<Phone>) request.getAttribute("phonesList");
for(int i = 0; i<phones.size();i++){
	%>
	<a><%=phones.get(i).getPhone()%></a><br>
	<%
}
%>
<br>
EMAIL:
<br>
<% 

List<Email> emails =(List<Email>) request.getAttribute("emailsList");
for(int i = 0; i<emails.size();i++){
	%>
	<a><%=emails.get(i).getEmail() %></a><br>
	<%
}
%>
</body>
</html>