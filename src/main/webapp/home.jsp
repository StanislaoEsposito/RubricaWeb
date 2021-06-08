<%@page import="com.protom.model.entities.Contact"%>
<%@page import="com.protom.model.entities.Email"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="com.protom.dto.User" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%-- 	<jsp:useBean id="user" scope="request" class="it.rdev.rubrica.dto.User"> --%>
<%-- 		<jsp:setProperty name="user" property="*"/> --%>
<%-- 	</jsp:useBean> --%>
	
<%-- 	<%=user.getUsername()  + " " + user.getPassword() %> --%>
	<%  
		List<Contact> users = (List<Contact>) request.getAttribute("users");
		
 	%>
	<table>
	<thead>
		<tr><td>Name</td><td>surname</td></tr>
	</thead>
	<tbody>
	
	
	<%
	for(int i = 0; i<users.size();i++){
		%>
		<tr>
			<td><%= users.get(i).getName()%></td>
			<td><%= users.get(i).getSurname()%></td>
			<%
			if(request.getSession().getAttribute("USER")!=null){
				//request.getSession().setAttribute("listaUtenti", users);
				System.out.println("+++++++++++++++++++++++++++++++++++++++++++"+users.get(i));
				%>
				 <td><a href="/RubricaWeb2/CRUDServlet?action=Elimina&id=<%=users.get(i).getId() %>">Elimina</a></td>
				 <td><a href="/RubricaWeb2/aggiorna.jsp">Aggiorna</a></td>
				<%	
			}
			%>
			
			
		</tr>
	<%
	}
	%>
	
	
	</tbody>
	</table>
	
	<%
		if(request.getSession().getAttribute("USER")==null){
			%>	
			<a href="http://localhost:8080/RubricaWeb2/login.jsp">LogIn</a>
				
			<%
		}
	
	if(request.getSession().getAttribute("USER")!=null){
		%>	
		<a href="/RubricaWeb2/LoginServlet?action=logout">Logout</a>
		
		<a href="/RubricaWeb2/aggiungi.jsp">Aggiungi</a>
		<%
	}
	%>
	


</body>
</html>