package com.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import com.util.DBConnection;

public class OutProc {

	Connection conn;
	CallableStatement cstmt;
	
	public void getCount()
	{
		conn=DBConnection.getDbConnection();
		
		if(conn!=null)
		{
			try {
				cstmt=conn.prepareCall("{call gettotal(?,?)}");
				cstmt.setString(1, "jay");
				cstmt.registerOutParameter(2,java.sql.Types.INTEGER);
				cstmt.execute();
				System.out.println("total count name of jay is:- "+cstmt.getInt(2));
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public String getMaxAgeName()
	{
		conn=DBConnection.getDbConnection();
		if(conn!=null)
		{
				String proc="call getmax1(?)";
				
				try {
					cstmt=conn.prepareCall(proc);
					cstmt.registerOutParameter(1,java.sql.Types.VARCHAR);
					cstmt.execute();
					String name=cstmt.getString(1);
					System.out.println(name);
				
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
		}
		return null;
	}
	public static void main(String[] args) {
		OutProc op=new OutProc();
		op.getCount();
		op.getMaxAgeName();
	}
	
}
