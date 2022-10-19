package com.flight;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {

	private static String url = "jdbc:mysql://localhost:3306/cinnamon_air";
	private static String user = "root";
	private static String pass = "qwerty";
	private static Connection con;
	
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(url,user,pass);
		}catch(Exception e){
			System.out.print("Connection failed");
		}
		
		return con;
	}
	
	
}
