package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.UserDAO;
import model.UserDTO;

@WebServlet("/showAllTasks")
public class showAllTasks extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		UserDAO userdao = new UserDAO();
		ArrayList<UserDTO> al = userdao.getAllTasks();
//		out.println(al.size());
		if(al != null) {
			request.setAttribute("al",al);
			RequestDispatcher requestdispatcher = request.getRequestDispatcher("showTasks.jsp");
			requestdispatcher.include(request, response);
//			out.println(al.get(0).getTask());
		}
		else out.println("<h1>Record not found...!</h1>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
