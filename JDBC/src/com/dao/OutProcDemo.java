package com.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import com.util.DBConnection;

public class OutProcDemo {

	Connection conn;
	CallableStatement cstmt;
	
		public void demo()
		{
			conn=DBConnection.getDbConnection();
			
			if(conn!=null)
			{
				String sql="{call gecb(?,?)}";
					
				try {
					cstmt=conn.prepareCall(sql);
					cstmt.setString(1,"jay");
					cstmt.registerOutParameter(2,java.sql.Types.INTEGER);
					cstmt.execute();
					
					System.out.println(cstmt.getInt(2));
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}		
			}
		}
		public static void main(String[] args) {
		
			OutProcDemo obj=new OutProcDemo();
			obj.demo();
			
		}
}
