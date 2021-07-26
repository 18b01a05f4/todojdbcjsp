package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDAO {
	
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
	
	
	
	
	
}