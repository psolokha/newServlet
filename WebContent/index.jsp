<%@ page import="ru.appline.logic.Model" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Title</title>
</head>
<body>
<h1>User workspace</h1>
Type UserID (0 - full list) <br />
Available: <% Model model = Model.getInstance();
			out.print(model.getFromList().size());%>
<form method="get", action="get">
	<lable>ID:
		<input type="text" name="id"><br />	
	</lable>
	<button type="submit">Search</button>
</form>

<a href="addUser.html">Create User</a>
</body>
</html>