package com.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.util.DBConnectionHeroku;

public class HerokuTableCreation {

		Connection conn;
		PreparedStatement pstmt;
		
		public void  createTable()
		{
			conn=DBConnectionHeroku.getConnection();
			
			if(conn!=null)
			{
				String createTable="create table employee(eid serial primary key,ename varchar(30),eemail varchar(30),epassword varchar(30),eage int)";
				
				try {
					pstmt=conn.prepareStatement(createTable);
					System.out.println(pstmt.execute()); 
				
				
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			
			}
			
			
		}
		public static void main(String[] args) {
			HerokuTableCreation h1=new HerokuTableCreation();
			h1.createTable();
		}
}
