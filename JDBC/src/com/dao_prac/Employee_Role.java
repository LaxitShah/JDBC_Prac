package com.dao_prac;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.util.DBConnection_prac;

public class Employee_Role {

	Connection conn;
	Statement stmt;
	
	public void addEmp()
	{
		conn=DBConnection_prac.getDbConnection();
		
		if(conn!=null)
		{
			Scanner sc=new Scanner(System.in);
			
			System.out.println("enter email:");
			String email=sc.next();
			
			System.out.println("enter role:");
			String role=sc.next();
			
			int rId=0;
			int eId1=0;
			
			if(role.equalsIgnoreCase("Devloper"))
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
			else if(role.equalsIgnoreCase("Accountant"))
			{
				rId=4;
			}
			else if(email.equalsIgnoreCase("a@"))
			{
				eId1=1;
			}
			else if(email.equalsIgnoreCase("b@"))
			{
				eId1=2;
			}
			else if(email.equalsIgnoreCase("c@"))
			{
				eId1=3;
			}
			else if(email.equalsIgnoreCase("d@"))
			{
				eId1=4;
			}
			else {
				System.out.println("Invalid");
				return;
			}
			
			try {
				stmt=conn.createStatement();
				
				String insertSQL="insert into employee_role(eremail,errole,rid,eid)values('"+email+"','"+role+"',"+rId+","+eId1+")";
				
				int res=stmt.executeUpdate(insertSQL);
				
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
	public static void main(String[] args) {
		Employee_Role er=new Employee_Role();
		er.addEmp();
	}
}

