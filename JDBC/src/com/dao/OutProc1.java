package com.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import com.util.DBConnection;

public class OutProc1 {
	
	Connection conn;
	CallableStatement cstmt;
	
	public void get()
	{
		conn=DBConnection.getDbConnection();
		if(conn!=null)
		{
			try {
				cstmt=conn.prepareCall("{call disp_gen1(?,?)}");
				cstmt.registerOutParameter(1,java.sql.Types.INTEGER);
				cstmt.setString(2,"female");
				cstmt.execute();
				
				System.out.println(cstmt.getInt(1));
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
	}	
	public static void main(String[] args) {
		
		OutProc1 o1=new OutProc1();
		o1.get();
	
	}
}
