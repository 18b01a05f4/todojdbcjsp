<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="model.UserDAO,model.UserDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit task</title>
</head>
<body>
	<%
		int taskId = Integer.parseInt(request.getParameter("task_id"));
		
		UserDAO userdao = new UserDAO();
		userdao.getTask(taskId);
		
		UserDTO userdto = new UserDTO();
		
	%>
	
	<form action="editServlet">
		Enter TaskId : <input type="number" name="E_TaskId" value="<%=taskId %>"><br><br>
		Enter Task Description : <textarea type="text" name="editTask"><%=userdao.getTask(taskId).getTask() %></textarea><br><br>
		<button type="submit">OK</button>
	</form>
</body>
</html>