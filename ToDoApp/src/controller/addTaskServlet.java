package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.UserDAO;
import model.UserDTO;

@WebServlet("/addTaskServlet")
public class addTaskServlet extends HttpServlet { 
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		int taskId = Integer.parseInt(request.getParameter("userTaskId"));
		String task = request.getParameter("userTask");
		
		HttpSession session = request.getSession();
		session.setAttribute("taskIdOfUser",taskId);
		session.setAttribute("taskOfUser",task);
		
		
		UserDTO userdto = new UserDTO(taskId,task);
		UserDAO userdao = new UserDAO();
		int result = userdao.insertTask(userdto);
		
		if(result > 0) {	
			out.println("<h1>Successfully added!!</h1><br><br>");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
			requestDispatcher.include(request,response);
		}
		else out.println("<h1>Error</h1>");
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
