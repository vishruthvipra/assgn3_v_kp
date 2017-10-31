package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import model.Developer;
import model.Website;

public class DeveloperDao extends BaseDao {
	private static DeveloperDao instance = null; 
	final String CREATE_PERSON = "INSERT INTO Person (username, password, first_name, last_name, email) VALUES (?, ?, ?, ?, ?)";
	final String CREATE_DEVELOPER = "INSERT INTO Developer (username, developerKey) VALUES (?, ?)";
	final String FIND_ALL_DEVELOPERS = "SELECT * FROM Person p, Developer d where p.username = d.username";
	final String FIND_DEVELOPER_ID = "SELECT * FROM Person p, Developer d where p.username = d.username and id.d=?";
	final String FIND_DEVELOPER_USERNAME = "SELECT * FROM  Person p, Developer d where p.username = d.username and d.username=?";
	final String FIND_DEVELOPER_CRED = "SELECT * FROM  Person p, Developer d where p.username = d.username and p.username=? and p.passowrd=?";
	final String UPDATE_DEVELOPER = "UPDATE Person SET username=?, developerKey=? WHERE id=?";
	final String DELETE_DEVELOPER = "DELETE FROM Developer WHERE id=?";
	
	private DeveloperDao() {}
	
	public static DeveloperDao getInstance() {
		if(instance == null) {
			instance = new DeveloperDao();
		}
		return instance;
	}
	
	private int createDeveloper(Developer developer) {
		int result = -1;
		int result2 = -1;
		Connection connection = null;
		PreparedStatement statement = null;
		PreparedStatement statement2 = null;
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			statement = connection.prepareStatement(CREATE_PERSON);
			statement2 = connection.prepareStatement(CREATE_DEVELOPER);
			statement.setString(1, developer.getUsername());
			statement.setString(2, developer.getPassword());
			statement.setString(3, developer.getFirst_name());
			statement.setString(4, developer.getLast_name());
			statement.setString(5, developer.getEmail());
			statement2.setString(1, developer.getUsername());
			statement2.setString(2, developer.getDeveloperKey());
			result = statement.executeUpdate();
			result2 = statement2.executeUpdate();
			statement.close();
			connection.close();
			return result2;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result2;
	}
	
	private ArrayList<Developer> findAllDevelopers() {
		ArrayList<Developer> developers = new ArrayList<Developer>();
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			statement = connection.prepareStatement(FIND_ALL_DEVELOPERS);
			ResultSet result = statement.executeQuery();
			while(result.next()) {
				int id = result.getInt("id");
				String username = result.getString("username");
				String password = result.getString("password");
				String first_name = result.getString("first_name");
				String last_name = result.getString("last_name");
				String email = result.getString("email");
				String developerKey = result.getString("developerKey");
				Developer developer = new Developer(id, username, password, first_name, last_name, email, developerKey);
				developers.add(developer);
			}
			statement.close();
			connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return developers;
		
	}
	
	private Developer findDeveloperById(int developerId) {
		ArrayList<Developer> developers = new ArrayList<Developer>();
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			statement = connection.prepareStatement(FIND_DEVELOPER_ID);
			statement.setInt(1, developerId);
			ResultSet result = statement.executeQuery();
			while(result.next()) {
				String username = result.getString("username");
				String password = result.getString("password");
				String first_name = result.getString("first_name");
				String last_name = result.getString("last_name");
				String email = result.getString("email");
				String developerKey = result.getString("developerKey");
				int id = result.getInt("id");
				Developer developer = new Developer(id, username, password, first_name, last_name, email, developerKey);
				developers.add(developer);
			}
			statement.close();
			connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return developers.get(0);
	}
	
	private Developer findDeveloperByUsername(String username) {
		ArrayList<Developer> developers = new ArrayList<Developer>();
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			statement = connection.prepareStatement(FIND_DEVELOPER_USERNAME);
			statement.setString(1, username);
			ResultSet result = statement.executeQuery();
			while(result.next()) {
				String user_name = result.getString("username");
				String password = result.getString("password");
				String first_name = result.getString("first_name");
				String last_name = result.getString("last_name");
				String email = result.getString("email");
				String developerKey = result.getString("developerKey");
				int id = result.getInt("id");
				Developer developer = new Developer(id, user_name, password, first_name, last_name, email, developerKey);
				developers.add(developer);
			}
			statement.close();
			connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return developers.get(0);
		
	}
	
	private Developer findDeveloperByCredentials(String username, String password) {
		ArrayList<Developer> developers = new ArrayList<Developer>();
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			statement = connection.prepareStatement(FIND_DEVELOPER_CRED);
			statement.setString(1, username);
			statement.setString(2, password);
			ResultSet result = statement.executeQuery();
			while(result.next()) {
				String user_name = result.getString("username");
				String pass_word = result.getString("password");
				String first_name = result.getString("first_name");
				String last_name = result.getString("last_name");
				String email = result.getString("email");
				String developerKey = result.getString("developerKey");
				int id = result.getInt("id");
				Developer developer = new Developer(id, user_name, pass_word, first_name, last_name, email, developerKey);
				developers.add(developer);
			}
			statement.close();
			connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return developers.get(0);
	}
	
	private int updateDeveloper(int developerId, Developer developer) {
		int result = -1;
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			statement = connection.prepareStatement(UPDATE_DEVELOPER);
			statement.setString(1, developer.getUsername());
			statement.setString(2, developer.getDeveloperKey());
			statement.setInt(3, developerId);
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
	
	private int deleteDeveloper(int developerId) {
		int result = -1;
		try {
			Class.forName(JDBC_DRIVER);
			Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
			PreparedStatement statement = connection.prepareStatement(DELETE_DEVELOPER);
			statement.setInt(1, developerId);
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
		DeveloperDao ddao = DeveloperDao.getInstance();
		Developer alice = new Developer("alice", "alice", "Alice", "Wonder", "alice@wonder.com", "4321rewq");
		Developer bob = new Developer("bob", "bob", "Bob", "Marley", "bob@marley.com", "5432trew");
		Developer charlie = new Developer("charlie", "charlie", "Charles", "Garcia", "chuch@garcia.com", "6543ytre");
		Developer dan = new Developer("dan", "dan", "Dan", "Martin", "dan@martin.com", "7654fda");
		Developer ed = new Developer("ed", "ed", "Ed", "Karaz", "ed@kar.com", "5678dfgh");
		ddao.createDeveloper(alice);
		ddao.createDeveloper(bob);
		ddao.createDeveloper(charlie);
		ddao.createDeveloper(dan);
		ddao.createDeveloper(ed);
	}

}
