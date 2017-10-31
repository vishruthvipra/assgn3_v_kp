package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class BaseDao {
	final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	final String DB_URL = "jdbc:mysql://127.0.0.1.:3306/hw2_krishnaprasad_vishruth_fall_2017";
	final String USER = "cs5200";
	final String PASS = "cs5200";
    Connection conn = null;
    PreparedStatement pstmt = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
