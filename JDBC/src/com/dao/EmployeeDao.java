package com.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.util.DBConnection;

import oracle.net.aso.s;

public class EmployeeDao {
	
	Connection conn;
	Statement stmt;
	
	public void addEmployee()
	{
		conn=DBConnection.getDbConnection();
		
		if(conn!=null)
		{
			String insertSQL="insert into employee values(1,'laxit','a@gmail.com',22)";
			
			try {
				stmt=conn.createStatement();
				int status=stmt.executeUpdate(insertSQL);
				
				if(status>0)
				{
					System.out.println(status+" record inserted");
				}
				else {
					System.out.println("record not inserted");
				}
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally
			{
				try {
					stmt.close();
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	
			
			
		}
	}
	public void addEmp()
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
			
			try
			{
				stmt=conn.createStatement();
				String insertSql="insert into employee(ename,eemail,eage)values('"+eName+"','"+eEmail+"',"+eAge+")";
			
				int res=stmt.executeUpdate(insertSql);
				
				if(res>0)
				{
					System.out.println("employee inserted....");
				}
				else {
					System.out.println("employee not inserteed ");
				}
				stmt.close();
				conn.close();
			}
			catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
	
	public void delEmp()
	{
		conn=DBConnection.getDbConnection();
		
		if(conn!=null)
		{
			Scanner sc=new Scanner(System.in);
			
			System.out.println("pls enter the name to delete a record");
			String eName=sc.next();
			
			try {
				stmt=conn.createStatement();
				
				String deleteSQL="delete from employee where ename ='"+eName+"'";
				int res=stmt.executeUpdate(deleteSQL);
				
				if(res>0)
				{
					System.out.println(res+" records deleted..");
				}
				else {
					System.out.println("no record deleted");
				}
				
				
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
		}
		
	}
	public void updateEmp()
	{
		conn=DBConnection.getDbConnection();
		
		if(conn!=null)
		{
			Scanner sc=new Scanner(System.in);
			System.out.println("please enter name:-");
			String name=sc.next();
			
			System.out.println("please enter email to update:-");
			String eEmail=sc.next();
			
			try {
				stmt=conn.createStatement();
				
				String updateSQL="update employee set eemail='"+eEmail+"' where ename='"+name+"'";
				
				int res=stmt.executeUpdate(updateSQL);
				
				if(res>0)
				{
					System.out.println(res+"-"+"rows updated..");
				}
				else {
					System.out.println("no rows updated...");
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
	public static void main(String[] args) {
			EmployeeDao employeeDao=new EmployeeDao();
//			employeeDao.addEmployee();
//			employeeDao.addEmp();
//			employeeDao.delEmp();	
			employeeDao.updateEmp();
	
	}
	
}
