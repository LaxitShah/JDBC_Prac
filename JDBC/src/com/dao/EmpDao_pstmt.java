package com.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

//import com.mysql.jdbc.PreparedStatement;
import com.util.DBConnection;

public class EmpDao_pstmt {
	
	java.sql.PreparedStatement pstmt;
	Connection conn;
	
	public void addEmployee()
	{
		conn=DBConnection.getDbConnection();
		
		if(conn!=null)
		{
		
			
			Scanner sc=new Scanner(System.in);
			
			System.out.println("enter employee name:-");
			String eName=sc.next();
			
			System.out.println("enter employee email:-");
			String eEmail=sc.next();
			
			System.out.println("enter employee age:-");
			int eAge=sc.nextInt();
			
			System.out.println("enter employee password:-");
			String ePassword=sc.next();
			
			System.out.println("enter employee role:-");
			String role=sc.next();
			
			int rId=0;
			
			if(role.equalsIgnoreCase("Developer"))
			{
				rId=1;
			}
			else if(role.equalsIgnoreCase("Manager"))
			{
				rId=2;
			}
			else if(role.equalsIgnoreCase("HR"))
			{
				rId=3;
			}
			else if(role.equalsIgnoreCase("accountent"))
			{
				rId=4;
			}
			else 
			{
				System.out.println("no role found plz find a new job!!");
				return;
			}
				String insertSQL="insert into employee(ename,eemail,aage,rid,password)values(?,?,?,?,?)";
				
				try {
					pstmt=conn.prepareStatement(insertSQL);
					pstmt.setString(1,eName);
					pstmt.setString(2,eEmail);
					pstmt.setInt(3,eAge);
					pstmt.setInt(4,rId);
					pstmt.setString(5,ePassword);
					
					int res=pstmt.executeUpdate();
					
					if(res>0)
					{
						System.out.println("inserted");
					}
					else {
						System.out.println("not inserted");
					}
					
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
		}
	}
	public void addEmployee_batch()
	{
		conn=DBConnection.getDbConnection();
		if(conn!=null)
		{
			
			try {
				String insertSQL="insert into employee(ename,eemail,aage,rid,password)values(?,?,?,?,?)";
				pstmt=conn.prepareStatement(insertSQL);
				
				for(int i=1;i<=200;i++)
				{
					pstmt.setString(1,"raj"+i);
					pstmt.setString(2,"raj@gmail.com");
					pstmt.setInt(3,20);
					pstmt.setInt(4, 1);
					pstmt.setString(5,"raj@1121");
					pstmt.addBatch();
				}
				pstmt.executeBatch();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
	}
	public void updateEmployee()
	{
		conn=DBConnection.getDbConnection();
		if(conn!=null)
		{
			String updateSQl="update employee set ename=?,aage=?,password=? where eemail=?";
			
			try {
				pstmt=conn.prepareStatement(updateSQl);
				
				pstmt.setString(1, "warangets");
				pstmt.setInt(2, 55);
				pstmt.setString(3, "microamazone");
				pstmt.setString(4, "raj@gmail.com");
				pstmt.addBatch();
				pstmt.setString(1, "poojanshah");
				pstmt.setInt(2,44);
				pstmt.setString(3, "pooooja");
				pstmt.setString(4, "poojan@gmail.com");
				pstmt.addBatch();
				
				pstmt.executeBatch();
				System.out.println("*");
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
			
		}
	}
	
	
	
	public static void main(String[] args) {
		
		EmpDao_pstmt eDao=new EmpDao_pstmt();
//		eDao.addEmployee();
//		eDao.addEmployee_batch();
		eDao.updateEmployee();
		
	}
	
	
}
