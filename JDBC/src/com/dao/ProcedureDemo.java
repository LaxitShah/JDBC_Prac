package com.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.util.DBConnection;

public class ProcedureDemo {

	Connection conn;
	CallableStatement cstmt;
	
	public void addEmployee()
	{
		conn=DBConnection.getDbConnection();
		if(conn!=null)
		{
			try {
				cstmt=conn.prepareCall("{call insertemp(?,?,?,?,?)}");
				cstmt.setString(1,"jay");
				cstmt.setString(2,"jay@gmail.com");
				cstmt.setInt(3, 20);
				cstmt.setInt(4, 1);
				cstmt.setString(5, "jay123");
				
				int res=cstmt.executeUpdate();
				System.out.println(res);
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	public void getAllEmpls()
	{
		conn=DBConnection.getDbConnection();
		if(conn!=null)
		{
			
			try {
				cstmt=conn.prepareCall("{call getallEmps()}");
				
				ResultSet rs=cstmt.executeQuery();
				
				while(rs.next())
				{
					System.out.println(rs.getString("ename"));
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
	
		ProcedureDemo p1=new ProcedureDemo();
		//p1.addEmployee();
		p1.getAllEmpls();
		
	}
}
