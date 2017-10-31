package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Role;

public class RoleDao extends BaseDao {

	private static RoleDao instance = null; 
	final String CREATE_WEBSITE_ROLE = "INSERT INTO Role (devKey, websiteId, role) VALUES (?, ?, ?)";
	final String CREATE_PAGE_ROLE = "INSERT INTO Role (devKey, pageId, role) VALUES (?, ?, ?)";
	final String DELETE_WEBSITE_ROLE = "DELETE FROM Role WHERE id=?, devKey=?, websiteId=?";
	final String DELETE_PAGE_ROLE = "DELETE FROM Role WHERE id=?, devKey=?, pageId=?";
	
	int assignWebsiteRole(String developerId, int websiteId, Role role) {
		int result = -1;
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			statement = connection.prepareStatement(CREATE_WEBSITE_ROLE);
			statement.setString(1, role.getDevKey());
			statement.setString(2, role.getWebsiteId());
			statement.setInt(3, role.getId());
			result = statement.executeUpdate();
			statement.close();
			connection.close();
			return result;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	int assignPageRole(int developerId, int pageId, Role role) {
		int result = -1;
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			statement = connection.prepareStatement(CREATE_PAGE_ROLE);
			statement.setString(1, role.getDevKey());
			statement.setString(2, role.getPageId());
			statement.setInt(3, role.getId());
			result = statement.executeUpdate();
			statement.close();
			connection.close();
			return result;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	int deleteWebsiteRole(int developerId, int websiteId, int roleId) {
		int result = -1;		
		try {
			Class.forName(JDBC_DRIVER);
			Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
			PreparedStatement statement = connection.prepareStatement(DELETE_WEBSITE_ROLE);
			statement.setInt(1, roleId);
			statement.setInt(2, developerId);
			statement.setInt(3, websiteId);
			result = statement.executeUpdate();
			statement.close();
			connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	int deletePageRole(int developerId, int pageId, int roleId) {
		int result = -1;		
		try {
			Class.forName(JDBC_DRIVER);
			Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
			PreparedStatement statement = connection.prepareStatement(DELETE_PAGE_ROLE);
			statement.setInt(1, roleId);
			statement.setInt(2, developerId);
			statement.setInt(3, pageId);
			result = statement.executeUpdate();
			statement.close();
			connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	private RoleDao() {}
	
	public static RoleDao getInstance() {
		if(instance == null) {
			instance = new RoleDao();
		}
		return instance;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void assignWebsiteRole(Role role) {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			statement = connection.prepareStatement(CREATE_WEBSITE_ROLE);
			statement.setString(1, role.getDevKey());
			statement.setString(2, role.getWebsiteId());
			statement.setInt(3, role.getId());
			statement.executeUpdate();
			statement.close();
			connection.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
