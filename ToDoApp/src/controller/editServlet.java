package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.UserDAO;
import model.UserDTO;

@WebServlet("/editServlet")
public class editServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		int taskId = Integer.parseInt(request.getParameter("E_TaskId"));
		String task = request.getParameter("editTask");
		
		UserDTO userdto = new UserDTO(taskId,task);
		UserDAO userdao = new UserDAO();
		boolean flag = userdao.updateTask(userdto);
		
		if(flag) {
			out.println("<h1>Updated Successfully...!!!</h1>");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
			requestDispatcher.include(request,response);
		}
		else out.println("<h1>Record not found...!</h1>");
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
