<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="/RubricaWeb2/CRUDServlet?action=Aggiorna2">
		<p>
			Nome: <input type="text" name="name">
		</p>
		<p>
			Cognome: <input type="text" name="surname">
		</p>
		<button type="submit">Aggiorna</button>
		<button type="reset">reset</button>
	</form>
</body>
</html>