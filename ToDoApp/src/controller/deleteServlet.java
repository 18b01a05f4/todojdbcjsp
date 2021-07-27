package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.UserDAO;
import model.UserDTO;

@WebServlet("/deleteServlet")
public class deleteServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		int taskId = Integer.parseInt(request.getParameter("task_id").trim());
		UserDAO userdao = new UserDAO();
		boolean flag = userdao.deleteTask(taskId);
		if(flag) {
			out.println("<h1>Deleted Succesfully!!</h1>");
			RequestDispatcher requestdispatcher = request.getRequestDispatcher("showAllTasks");
			requestdispatcher.include(request, response);
		}
		else out.println("<h1>Record not found...!</h1>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
