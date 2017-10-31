package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.HeadingWidget;
import model.HtmlWidget;
import model.ImageWidget;
import model.Page;
import model.Role;
import model.Website;
import model.Widget;
import model.YouTubeWidget;

public class WidgetDao extends BaseDao {

	private static WidgetDao instance = null; 
	final String CREATE_WIDGET = "INSERT INTO Widget (name, type, text, order, width, height, url) VALUES (?, ?, ?, ?, ?, ?, ?)";
	final String CREATE_WIDGET_PAGE = "INSERT INTO Page (title, description, website) VALUES (?, ?, ?)";
	final String FIND_ALL_WIDGETS = "SELECT * FROM Widget";
	final String FIND_WIDGET_ID = "SELECT * FROM Widget WHERE id=?";
	final String FIND_WIDGET_PAGEID = "SELECT * FROM Widget WHERE page=?";
	final String UPDATE_WIDGET = "UPDATE Widget SET name=?, type=?, text=?, order=?, width=?, height=?, url=? WHERE id=?";
	final String DELETE_WIDGET = "DELETE FROM Widget WHERE id=?";
	
	public int createWidgetForPage(int pageId, Widget widget) {
		int result = -1;
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			statement = connection.prepareStatement(CREATE_WIDGET_PAGE);
			statement.setString(1, widget.getName());
			statement.setString(2, widget.getType());
			statement.setString(3, widget.getText());
			statement.setInt(4, widget.getOrder());
			statement.setInt(5, widget.getWidth());
			statement.setInt(6, widget.getHeight());
			statement.setString(7, widget.getUrl());
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
	
	public ArrayList<Widget> findWidgetsForPage(int pageId) {
		ArrayList<Widget> widgets = new ArrayList<Widget>();
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			statement = connection.prepareStatement(FIND_WIDGET_PAGEID);
			statement.setInt(1, pageId);
			ResultSet result = statement.executeQuery();
			while(result.next()) {
				int id = result.getInt("id");
				String name = result.getString("name");
				String type = result.getString("type");
				String text = result.getString("text");
				int order = result.getInt("order");
				int width = result.getInt("width");
				int height = result.getInt("height");
				String cssClass = result.getString("cssClass");
				String cssStyle = result.getString("cssStyle");
				String url = result.getString("url");
				Widget widget = new Widget(id, name, width, height, cssClass, cssStyle, text, order, type);
				widgets.add(widget);
			}
			statement.close();
			connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return widgets;
	}
	
	public Widget findWidgetById(int widgetId) {
		ArrayList<Widget> widgets = new ArrayList<Widget>();
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			statement = connection.prepareStatement(FIND_WIDGET_ID);
			statement.setInt(1, widgetId);
			ResultSet result = statement.executeQuery();
			while(result.next()) {
				int id = result.getInt("id");
				String name = result.getString("name");
				String type = result.getString("type");
				String text = result.getString("text");
				int order = result.getInt("order");
				int width = result.getInt("width");
				int height = result.getInt("height");
				String cssClass = result.getString("cssClass");
				String cssStyle = result.getString("cssStyle");
				String url = result.getString("url");
				Widget widget = new Widget(id, name, width, height, cssClass, cssStyle, text, order, type);
				widgets.add(widget);
			}
			statement.close();
			connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return widgets.get(0);
	}
	
	
	
	public int deleteWidget(int widgetId) {
		int result = -1;		
		try {
			Class.forName(JDBC_DRIVER);
			Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
			PreparedStatement statement = connection.prepareStatement(DELETE_WIDGET);
			statement.setInt(1, widgetId);
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
	
	public int updateWidget(int widgetId, Widget widget) {
		int result = -1;		
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			statement = connection.prepareStatement(UPDATE_WIDGET);
			statement.setString(1, widget.getName());
			statement.setString(2, widget.getType());
			statement.setString(3, widget.getText());
			statement.setInt(4, widget.getOrder());
			statement.setInt(5, widget.getWidth());
			statement.setInt(6, widget.getHeight());
			statement.setString(7, widget.getCssClass());
			statement.setString(8, widget.getCssStyle());
			statement.setInt(9, widgetId);
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
	
	public ArrayList<Widget> findAllWidgets() {
		ArrayList<Widget> widgets = new ArrayList<Widget>();
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			statement = connection.prepareStatement(FIND_ALL_WIDGETS);
			ResultSet result = statement.executeQuery();
			while(result.next()) {
				int id = result.getInt("id");
				String name = result.getString("name");
				String text = result.getString("text");
				String type = result.getString("type");
				int order = result.getInt("order");
				int width = result.getInt("width");
				int height = result.getInt("height");
				String url = result.getString("url");
				Widget widget = new Widget(name, type, text, order, width, height, url);
				widgets.add(widget);
			}
			statement.close();
			connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return widgets;
	}

	private WidgetDao() {}
	
	public static WidgetDao getInstance() {
		if(instance == null) {
			instance = new WidgetDao();
		}
		return instance;
	}
	
	public static void main(String[] args) {
		WidgetDao wdao = WidgetDao.getInstance();
		
		HeadingWidget fb = new HeadingWidget("head123","Welcome", 0, -1, -1, "", "Home");
		wdao.createWidgetForPage(5, fb);
		
		HtmlWidget fb2 = new HtmlWidget("post234","<p>Lorem</p>", 0, -1, -1, "", "About");
		wdao.createWidgetForPage(5, fb2);
		
		HeadingWidget fb3 = new HeadingWidget("head345","Hi", 1, -1, -1, "", "Contact");
		wdao.createWidgetForPage(5, fb3);
		
		HtmlWidget fb4 = new HtmlWidget("intro456","<h1>Hi</h1>", 2, -1, -1, "", "Contact");
		wdao.createWidgetForPage(5, fb4);
		
		ImageWidget fb5 = new ImageWidget("image345",null, 3, 50, 100, "/img/567.png", "Contact");
		wdao.createWidgetForPage(5, fb5);
		
		YouTubeWidget fb6 = new YouTubeWidget("video456",null, 0, 400, 300, "https://youtu.be/h67VX51QXiQ", "Preferences");
		wdao.createWidgetForPage(5, fb6);
	}

}
