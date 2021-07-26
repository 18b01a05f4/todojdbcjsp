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
	
	
	//Fetching all the task table...
	
	public List<UserDTO> getAllTasks() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultset = null;
		
		List<UserDTO> tasklist = new ArrayList<>();
		String SELECT = "Select * from todolist";
		connection = getConnection();
		
		try {
			preparedStatement = connection.prepareStatement(SELECT);
			resultset = preparedStatement.executeQuery();
			while(resultset.next()) {
				UserDTO userdto = new UserDTO();
				userdto.setTaskId(resultset.getInt(1));
				userdto.setTask(resultset.getString(2));
				
				tasklist.add(userdto);
			}
			return tasklist;
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(connection != null) {
					connection.close();
					preparedStatement.close();
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}	
		return null;
	}
		
	
}
