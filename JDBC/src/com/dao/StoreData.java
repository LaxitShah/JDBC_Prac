package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;


import com.util.DBConnection;

public class StoreData {
	
	Connection conn;
	PreparedStatement pstmt;
	
	public void add()
	{
		conn=DBConnection.getDbConnection();
		Date date=new Date(0);
		System.out.println(date);
		
		SimpleDateFormat formate=new SimpleDateFormat("yyyy-MM-dd");
		String d=formate.format(date);
		
		
		try {
			pstmt=conn.prepareStatement("insert into reg(regdate) values(?)");
			pstmt.setString(1,d);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
			
		StoreData d=new StoreData();
		d.add();
	}
	
}
