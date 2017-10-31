package dao;

import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Developer;
import model.Page;
import model.Privilege;
import model.Role;
import model.Website;

public class PageDao extends BaseDao{

	private static PageDao instance = null; 
	final String CREATE_PAGE = "INSERT INTO Website (name, description) VALUES (?, ?)";
	final String CREATE_PAGE_DEV = "INSERT INTO Page (title, description, website) VALUES (?, ?, ?)";
	final String FIND_ALL_PAGES = "SELECT * FROM Page";
	final String FIND_PAGE_ID = "SELECT * FROM Page WHERE id=?";
	final String FIND_WEBSITE_DEVID = "SELECT * FROM Website WHERE devKey=?";
	final String UPDATE_PAGE = "UPDATE Page SET title=?, description=? WHERE id=?";
	final String DELETE_PAGE = "DELETE FROM Page WHERE id=?";
	
	public int createPageForWebsite(int websiteId, Page page) {
		int result = -1;
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			statement = connection.prepareStatement(CREATE_PAGE_DEV);
			statement.setString(1, page.getTitle());
			statement.setString(2, page.getDescription());
			statement.setString(3,  String.valueOf(page.getWebsite()));
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
	
	public ArrayList<Page> findPagesForWebsite(int websiteId) {
		ArrayList<Page> pages = new ArrayList<Page>();
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			statement = connection.prepareStatement(FIND_PAGE_ID);
			statement.setInt(1, websiteId);
			ResultSet result = statement.executeQuery();
			while(result.next()) {
				int id = result.getInt("id");
				String title = result.getString("title");
				String description = result.getString("description");
				Page page = new Page(id, title, description);
				pages.add(page);
			}
			statement.close();
			connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pages;
	}
	
	public Page findPageById(int pageId) {
		ArrayList<Page> pages = new ArrayList<Page>();
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			statement = connection.prepareStatement(FIND_PAGE_ID);
			statement.setInt(1, pageId);
			ResultSet result = statement.executeQuery();
			while(result.next()) {
				int id = result.getInt("id");
				String title = result.getString("title");
				String description = result.getString("description");
				Page page = new Page(id, title, description);
				pages.add(page);
			}
			statement.close();
			connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pages.get(0);
	}
	
	public int deletePage(int pageId) {
		int result = -1;		
		try {
			Class.forName(JDBC_DRIVER);
			Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
			PreparedStatement statement = connection.prepareStatement(DELETE_PAGE);
			statement.setInt(1, pageId);
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
	
	public int updatePage(int pageId, Page page) {
		int result = -1;		
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			statement = connection.prepareStatement(UPDATE_PAGE);
			statement.setString(1, page.getTitle());
			statement.setString(2, page.getDescription());
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
	
	public ArrayList<Page> findAllPages() {
		ArrayList<Page> pages = new ArrayList<Page>();
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			statement = connection.prepareStatement(FIND_ALL_PAGES);
			ResultSet result = statement.executeQuery();
			while(result.next()) {
				int id = result.getInt("id");
				String title = result.getString("title");
				String description = result.getString("description");
				Page page = new Page(id, title, description);
				pages.add(page);
			}
			statement.close();
			connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pages;
	}

	private PageDao() {}
	
	public static PageDao getInstance() {
		if(instance == null) {
			instance = new PageDao();
		}
		return instance;
	}
	
	public static void main(String[] args) {
		PageDao pdao = PageDao.getInstance();
		
		PrivilegeDao rdao = PrivilegeDao.getInstance();
		
		Page home = new Page("Home","Landing page", "CNET", 1234234);
		Privilege rolefb = new Privilege("4321rewq", "1", "Editor");
		Privilege rolefb2 = new Privilege("5432trew", "1", "Reviewer");
		Privilege rolefb3 = new Privilege("6543ytre", "1", "Writer");
		pdao.createPageForWebsite(5, home);
		rdao.assignPagePrivilege(rolefb);
		rdao.assignPagePrivilege(rolefb2);
		rdao.assignPagePrivilege(rolefb3);
		
		Page twitter = new Page("About", "Website description", "Gizmodo", 234545);
		Privilege roletw = new Privilege("4321rewq", "2", "Writer");
		Privilege roletw2 = new Privilege("5432trew", "2", "Editor");
		Privilege roletw3 = new Privilege("6543ytre", "2", "Reviewer");
		pdao.createPageForWebsite(5, home);
		rdao.assignPagePrivilege(roletw);
		rdao.assignPagePrivilege(roletw2);
		rdao.assignPagePrivilege(roletw3);
		
		Page wiki = new Page("Contact", "Addresses, phones, and contact info", "Wikipedia", 3456654);
		Privilege rolewiki = new Privilege("4321rewq", "3", "Editor");
		Privilege rolewiki2 = new Privilege("5432trew", "3", "Writer");
		Privilege rolewiki3 = new Privilege("6543ytre", "3", "Owner");
		pdao.createPageForWebsite(5, wiki);
		rdao.assignPagePrivilege(rolewiki);
		rdao.assignPagePrivilege(rolewiki2);
		rdao.assignPagePrivilege(rolewiki3);
		
		Page cnn = new Page("Preferences", "Where users can configure their preferences", "CNN", 6543345);
		Privilege rolecnn = new Privilege("4321rewq", "4", "Owner");
		Privilege rolecnn2 = new Privilege("5432trew", "4", "Editor");
		Privilege rolecnn3 = new Privilege("6543ytre", "4", "Writer");
		pdao.createPageForWebsite(5, cnn);
		rdao.assignPagePrivilege(rolecnn);
		rdao.assignPagePrivilege(rolecnn2);
		rdao.assignPagePrivilege(rolecnn3);
		
		Page cnet = new Page("Profile", "Users can configure their personal information", "CNET", 5433455);
		Privilege rolecnet = new Privilege("4321rewq", "1", "Writer");
		Privilege rolecnet2 = new Privilege("5432trew", "1", "Owner");
		Privilege rolecnet3 = new Privilege("6543ytre", "1", "Editor");
		pdao.createPageForWebsite(5, cnet);
		rdao.assignPagePrivilege(rolecnet);
		rdao.assignPagePrivilege(rolecnet2);
		rdao.assignPagePrivilege(rolecnet3);
	}
}
