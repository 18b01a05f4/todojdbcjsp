<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="model.UserDTO,java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Task List</title>
</head>
<body>
	<% List<UserDTO> tasklist = (List<UserDTO>)request.getAttribute("UserTaskList");%>
	<%@ include file="index.jsp"%>
	<table align="center" border="1">
		<tr>
			<th>TaskId</th>
			<th>Task</th>
		</tr>
		<%if(tasklist != null) { %>   
			<%for (int i = 0; i < tasklist.size(); i++) {  %>
				<tr>
					<td><%=tasklist.get(i).getTaskId()%></td>
					<td><%=tasklist.get(i).getTask()%></td>
				</tr>
			<% } %>
		<%} %>  
	</table>
	
	
	
</body>
</html>