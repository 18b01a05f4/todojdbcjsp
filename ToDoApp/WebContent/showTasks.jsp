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
	<% ArrayList<UserDTO> tasklist = (ArrayList<UserDTO>)request.getAttribute("al");%>
	<%@ include file="index.jsp"%>
	<table align="center" border="1">
		<tr>
			<th>TaskId</th>
			<th>Task</th>
		</tr>
		<%if(tasklist != null) { %>
		<%for(UserDTO userdto : tasklist) { %>
			<tr>
				<td><%=userdto.getTaskId() %></td>
				<td><%=userdto.getTask() %></td>
			</tr>
		<%} %>
		<% }%>
	</table>
	
	
</body>
</html>