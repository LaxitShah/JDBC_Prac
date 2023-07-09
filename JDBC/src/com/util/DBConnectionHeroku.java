package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionHeroku {

	private static String userName="xpunifwznkuddw";
	private static String password="46caf2213dcbf5ed2fa362e7c170c7fb3675a57e1e4aaac0363d9fa13d466dd6";
	private static String DriverClass="org.postgresql.Driver";
	private static String connectionURL="jdbc:postgresql://ec2-52-20-160-44.compute-1.amazonaws.com:5432/d2i2a5g2u00823?sslmode=require";

	
	public static Connection getConnection()
	{
		Connection  conn=null;
		
			try {
				Class.forName(DriverClass);
				
				conn=DriverManager.getConnection(connectionURL,userName,password);
				
				if(conn!=null)
				{
					System.out.println("connected to database");
				}
				else {
					System.out.println("Try Again");
				}
				
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		return conn;
	}
	
	public static void main(String[] args) {
		
		getConnection();
		
	}
	
}
