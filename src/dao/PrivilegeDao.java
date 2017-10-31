package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Privilege;

public class PrivilegeDao extends BaseDao {
	
	private static PrivilegeDao instance = null; 
	
	final String CREATE_WEBSITE_PRIVILEGE = "INSERT INTO Privilege (devKey, websiteId, privilege) VALUES (?, ?, ?)";
	final String CREATE_PAGE_PRIVILEGE = "INSERT INTO Privilege (devKey, pageId, privilege) VALUES (?, ?, ?)";
	final String DELETE_WEBSITE_PRIVILEGE = "DELETE FROM Privilege WHERE id=?, devKey=?, websiteId=?";
	final String DELETE_PAGE_PRIVILEGE = "DELETE FROM Privilege WHERE id=?, devKey=?, pageId=?";
	
	private PrivilegeDao() {}
	
	public static PrivilegeDao getInstance() {
		if(instance == null) {
			instance = new PrivilegeDao();
		}
		return instance;
	}
	int assignWebsitePriviledge(int developerId, int websiteId, Privilege priviledge) {
		int result = -1;
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			statement = connection.prepareStatement(CREATE_WEBSITE_PRIVILEGE);
			statement.setString(1, priviledge.getDevKey());
			statement.setString(2, priviledge.getWebsiteId());
			statement.setInt(3, priviledge.getId());
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
	int assignPagePriviledge(int developerId, int pageId, Privilege priviledge) {
		int result = -1;
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			statement = connection.prepareStatement(CREATE_PAGE_PRIVILEGE);
			statement.setString(1, priviledge.getDevKey());
			statement.setString(2, priviledge.getPageId());
			statement.setInt(3, priviledge.getId());
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
	
	int deleteWebsitePriviledge(int developerId, int websiteId, int priviledgeId) {
		int result = -1;		
		try {
			Class.forName(JDBC_DRIVER);
			Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
			PreparedStatement statement = connection.prepareStatement(DELETE_WEBSITE_PRIVILEGE);
			statement.setInt(1, priviledgeId);
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
	
	int deletePagePriviledge(int developerId, int pageId, int priviledgeId) {
		int result = -1;		
		try {
			Class.forName(JDBC_DRIVER);
			Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
			PreparedStatement statement = connection.prepareStatement(DELETE_PAGE_PRIVILEGE);
			statement.setInt(1, priviledgeId);
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
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void assignPagePrivilege(Privilege priv) {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			statement = connection.prepareStatement(CREATE_PAGE_PRIVILEGE);
			statement.setString(1, priv.getDevKey());
			statement.setString(2, priv.getPageId());
			statement.setInt(3, priv.getId());
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
