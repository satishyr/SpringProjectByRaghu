package com.app.util;

public class DbConnUtil {

	private static Connection con=null;
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static Connection getConn() {
		return con;
	}
	
	
	
	
}


