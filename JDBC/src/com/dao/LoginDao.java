package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.util.DBConnection;

public class LoginDao {

	Connection conn;
	ResultSet rs;
	Statement stmt;
	
	public void loginEmployee()
	{
		conn=DBConnection.getDbConnection();
		if(conn!=null)
		{
			try {
				stmt=conn.createStatement();
				Scanner sc=new Scanner(System.in);
				
				System.out.println("plz enter email to login:");
				String email=sc.next();
				
				System.out.println("plz enter password:");
				String password=sc.next();
				
				String loginSQL="select * from employee where eemail='"+email+"' and password='"+password+"'";
				rs=stmt.executeQuery(loginSQL);
				
				if(rs.next())
				{
					System.out.println("eid: "+rs.getInt(1));
					System.out.println("ename: "+rs.getString(2));
					System.out.println("eage: "+rs.getInt(4));
					
				}
				else {
					System.out.println("plz check your name and password");
				}
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LoginDao loginDao=new LoginDao();
		loginDao.loginEmployee();
		

	}

}
