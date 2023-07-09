package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * Connection class with MYSQL database..
 * 
 * */

public class DBConnection {

	private static String userName = "root";
	private static String password = "root";
	// ip address of your database...
	// AWS --> cloud
	// 3306 is port num of mysql service
	// 1521 oracle
	// 5432
	// 27017 mongodb
	private static String connectionURL = "jdbc:mysql://localhost:3306/7pm";
	private static String driverClass = "com.mysql.jdbc.Driver";

	public static Connection getDbConnection() {

		Connection conn = null;
		// loading driver....
		// forname jvm force compile time --> new
		try {
			Class.forName(driverClass); // loaded..
			// getting connection...

			conn = DriverManager.getConnection(connectionURL, userName, password); //
			// conn --
			if (conn != null) {

				System.out.println("Connected with database...");
			} else {

				System.out.println("not connected with database..");
			}

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return conn;
	}

}
