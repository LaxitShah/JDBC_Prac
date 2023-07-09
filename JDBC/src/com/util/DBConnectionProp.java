package com.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnectionProp {
		public static void main(String[] args) {
				
			try {
				
				FileInputStream fis=new FileInputStream("connection.prop");
				Properties props=new Properties();
				
				props.load(fis);
				
				String driverClass=(String)props.get("driverClass");
				String connectionUrl=(String) props.get("URL");
				String userName=(String)props.get("user");
				String password=props.getProperty("password");
				
				Class.forName(driverClass);
				
				Connection conn=DriverManager.getConnection(connectionUrl,userName,password);
				
				if(conn!=null)
				{
					System.out.println(conn+" connected...");
				}
			} catch (IOException | ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		}
}
