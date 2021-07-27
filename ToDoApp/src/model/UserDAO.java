package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
	
	//Establishing Connection...
	
	public Connection getConnection() {
		Connection connection = null;
		String URL = "jdbc:mysql://localhost:3306/practice";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(URL,"root","root");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	
	//Inserting tasks into database...
	
	public int insertTask(UserDTO user) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int result = 0;
		String INSERT = "Insert into todolist values (?,?)";
		connection = getConnection();
		try {
			preparedStatement = connection.prepareStatement(INSERT);
			preparedStatement.setInt(1,user.getTaskId());
			preparedStatement.setString(2,user.getTask());
			
			result = preparedStatement.executeUpdate();
			return result;
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(connection != null) {
					connection.close();
					preparedStatement.close();
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}
	
	//Update User...
	
	public boolean updateTask(UserDTO user) {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = null;
		String UPDATE = "Update todolist set task=? where taskId=?";
		boolean rowsUpdated = false;
		
		try {
			preparedStatement = connection.prepareStatement(UPDATE);
			preparedStatement.setString(1,user.getTask());
			preparedStatement.setInt(2,user.getTaskId());
		
			rowsUpdated = preparedStatement.executeUpdate() > 0;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return rowsUpdated;
	}

	
	
	//Fetching all the task table...
	
	public ArrayList<UserDTO> getAllTasks() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultset = null;
		
		ArrayList<UserDTO> tasklist = new ArrayList<UserDTO>();
		String SELECT = "Select * from todolist";
		connection = getConnection();
		
		try {
			preparedStatement = connection.prepareStatement(SELECT);
			resultset = preparedStatement.executeQuery();
			while(resultset.next()) {
				int id = resultset.getInt(1);
				String task = resultset.getString(2);
				
				tasklist.add(new UserDTO(id,task));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return tasklist;
	}
		
	//Delete task...
	
	public boolean deleteTask(int taskId) {
		boolean rowsDeleted = false;
		Connection connection = getConnection();
		PreparedStatement preparedStatement = null;
		String DELETE = "Delete from todolist where taskId=?";
		try {
			preparedStatement = connection.prepareStatement(DELETE);
			preparedStatement.setInt(1,taskId);
			rowsDeleted = preparedStatement.executeUpdate() > 0;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return rowsDeleted;
	}
	
	
	
}
