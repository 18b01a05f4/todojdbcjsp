<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add new task</title>
</head>
<body>
	<form action="addTaskServlet">
		Enter TaskId : <input type="number" name="userTaskId"><br><br>
		Enter Task Description : <input type="text" name="userTask"><br><br>
		<button type="submit">OK</button>
	</form>
</body>
</html>