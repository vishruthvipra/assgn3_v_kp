package dao;

import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Developer;
import model.Role;
import model.Website;

public class WebsiteDao extends BaseDao {

	private static WebsiteDao instance = null; 
	final String CREATE_WEBSITE = "INSERT INTO Website (name, description) VALUES (?, ?)";
	final String CREATE_WEBSITE_DEV = "INSERT INTO Website (name, description, devKey) VALUES (?, ?, ?)";
	final String FIND_ALL_WEBSITES = "SELECT * FROM Website";
	final String FIND_WEBSITE_ID = "SELECT * FROM Website WHERE id=?";
	final String FIND_WEBSITE_DEVID = "SELECT * FROM Website WHERE devKey=?";
	final String UPDATE_WEBSITE = "UPDATE Website SET name=?, description=? WHERE id=?";
	final String DELETE_WEBSITE = "DELETE FROM Website WHERE id=?";
	
	int createWebsiteForDeveloper(int developerId, Website website) {
		int result = -1;
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			statement = connection.prepareStatement(CREATE_WEBSITE_DEV);
			statement.setString(1, website.getName());
			statement.setString(2, website.getDescription());
			statement.setArray(3, (Array) website.getDevKey());
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
	
	public ArrayList<Website> findWebsitesForDeveloper(int developerId) {
		ArrayList<Website> websites = new ArrayList<Website>();
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			statement = connection.prepareStatement(FIND_WEBSITE_ID);
			statement.setInt(1, developerId);
			ResultSet result = statement.executeQuery();
			while(result.next()) {
				int id = result.getInt("id");
				String name = result.getString("name");
				String description = result.getString("description");
				Website website = new Website(id, name, description);
				websites.add(website);
			}
			statement.close();
			connection.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return websites;
	}
	
	public Website findWebsiteById(int websiteId) {
		ArrayList<Website> websites = new ArrayList<Website>();
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			statement = connection.prepareStatement(FIND_WEBSITE_ID);
			statement.setInt(1, websiteId);
			ResultSet result = statement.executeQuery();
			while(result.next()) {
				int id = result.getInt("id");
				String name = result.getString("name");
				String description = result.getString("description");
				Website website = new Website(id, name, description);
				websites.add(website);
			}
			statement.close();
			connection.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return websites.get(0);
	}
	
	public int deleteWebsite(int websiteId) {
		int result = -1;
		
		try {
			Class.forName(JDBC_DRIVER);
			Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
			PreparedStatement statement = connection.prepareStatement(DELETE_WEBSITE);
			statement.setInt(1, websiteId);
			result = statement.executeUpdate();
			statement.close();
			connection.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	public int updateWebsite(int websiteId, Website website) {
		int result = -1;
		
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			statement = connection.prepareStatement(UPDATE_WEBSITE);
			statement.setString(1, website.getName());
			statement.setString(2, website.getDescription());
			statement.setInt(3, websiteId);
			result = statement.executeUpdate();
			statement.close();
			connection.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	public ArrayList<Website> findAllWebsites() {
		ArrayList<Website> websites = new ArrayList<Website>();
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			statement = connection.prepareStatement(FIND_ALL_WEBSITES);
			ResultSet result = statement.executeQuery();
			while(result.next()) {
				int id = result.getInt("id");
				String name = result.getString("name");
				String description = result.getString("description");
				Website website = new Website(id, name, description);
				websites.add(website);
			}
			statement.close();
			connection.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return websites;
	}
	
	public int createWebsite(Website website) {
		int result = -1;
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			statement = connection.prepareStatement(CREATE_WEBSITE);
			statement.setString(1, website.getName());
			statement.setString(2, website.getDescription());
			result = statement.executeUpdate();
			statement.close();
			connection.close();
			return result;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	private WebsiteDao() {}
	
	public static WebsiteDao getInstance() {
		if(instance == null) {
			instance = new WebsiteDao();
		}
		return instance;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebsiteDao wdao = WebsiteDao.getInstance();
		RoleDao rdao = RoleDao.getInstance();
		
		Website fb = new Website("Facebook","an online social media and social networking service", 1234234);
		Role rolefb = new Role("4321rewq", "1", "Owner");
		Role rolefb2 = new Role("5432trew", "1", "Editor");
		Role rolefb3 = new Role("6543ytre", "1", "Admin");
		wdao.createWebsite(fb);
		rdao.assignWebsiteRole(rolefb);
		rdao.assignWebsiteRole(rolefb2);
		rdao.assignWebsiteRole(rolefb3);
		
		Website twitter = new Website("Twitter", "an online news and social networking service", 4321543);
		Role roletw = new Role("4321rewq", "2", "Admin");
		Role roletw2 = new Role("5432trew", "2", "Owner");
		Role roletw3 = new Role("6543ytre", "2", "Editor");
		wdao.createWebsite(twitter);
		rdao.assignWebsiteRole(roletw);
		rdao.assignWebsiteRole(roletw2);
		rdao.assignWebsiteRole(roletw3);
		
		Website wiki = new Website("Wikipedia", "a free online encyclopedia", 3456654);
		Role rolewiki = new Role("4321rewq", "3", "Editor");
		Role rolewiki2 = new Role("5432trew", "3", "Admin");
		Role rolewiki3 = new Role("6543ytre", "3", "Owner");
		wdao.createWebsite(wiki);
		rdao.assignWebsiteRole(rolewiki);
		rdao.assignWebsiteRole(rolewiki2);
		rdao.assignWebsiteRole(rolewiki3);
		
		Website cnn = new Website("CNN", "an American basic cable and satellite television news channel", 6543345);
		Role rolecnn = new Role("4321rewq", "4", "Owner");
		Role rolecnn2 = new Role("5432trew", "4", "Editor");
		Role rolecnn3 = new Role("6543ytre", "4", "Admin");
		wdao.createWebsite(cnn);
		rdao.assignWebsiteRole(rolecnn);
		rdao.assignWebsiteRole(rolecnn2);
		rdao.assignWebsiteRole(rolecnn3);
		
		Website cnet = new Website("CNET", "an American media website that publishes reviews, news, articles, blogs, podcasts and videos on technology and consumer electronics", 5433455);
		Role rolecnet = new Role("4321rewq", "5", "Admin");
		Role rolecnet2 = new Role("5432trew", "5", "Owner");
		Role rolecnet3 = new Role("6543ytre", "5", "Editor");
		wdao.createWebsite(cnet);
		rdao.assignWebsiteRole(rolecnet);
		rdao.assignWebsiteRole(rolecnet2);
		rdao.assignWebsiteRole(rolecnet3);
		
		Website gizmodo = new Website("Gizmodo", "a design, technology, science and science fiction website that also writes articles on politics", 4322345);
		Role rolegiz = new Role("4321rewq", "6", "Editor");
		Role rolegiz2 = new Role("5432trew", "6", "Admin");
		Role rolegiz3 = new Role("6543ytre", "6", "Owner");
		wdao.createWebsite(gizmodo);
		rdao.assignWebsiteRole(rolegiz);
		rdao.assignWebsiteRole(rolegiz2);
		rdao.assignWebsiteRole(rolegiz3);
		
		
		Website newTwitter = new Website("Twitter", "Our source of truthiness");
		wdao.updateWebsite(2, newTwitter);
		ArrayList<Website> websites = wdao.findAllWebsites();
		System.out.println(websites);
	}
}
