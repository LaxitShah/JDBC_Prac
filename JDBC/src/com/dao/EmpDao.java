package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

//import javax.management.relation.RoleStatus;

import com.util.DBConnection;

public class EmpDao {

		Connection conn;
		Statement stmt;
		ResultSet rs;
	
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
				
				System.out.println("enter employee password:-");
				String ePassword=sc.next();
				
				System.out.println("enter employee role:-");
				String role=sc.next();
				
				int rId=0;
				
				if(role.equalsIgnoreCase("Developer"))
				{
					rId=1;
				}
				else if (role.equalsIgnoreCase("Manager")) 
				{
					rId=2;
				}
				else if (role.equalsIgnoreCase("HR"))
				{
					
					rId=3;	
				}
				else if(role.equalsIgnoreCase("accountant"))
				{
					rId=4;
				}
				else {
					System.out.println("no role found pls find a new job ");
					return ;
					
				}
				
				try {
					stmt=conn.createStatement();
					
					String insertSql="insert into employee(ename,eemail,aage,rid,password)values('"+eName+"','"+eEmail+"',"+eAge+","+rId+",'"+ePassword+"')";
					int res=stmt.executeUpdate(insertSql);
					
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
		public void getEmployees()
		{
			conn=DBConnection.getDbConnection();
			
			if(conn!=null)
			{
				try {
					stmt=conn.createStatement();
					String selectedSQL="select * from employee";
					
					rs=stmt.executeQuery(selectedSQL);
					System.out.println("EID\t\t ENAME\t\t EEMAIL\t\t EAGE\t\t");
					while(rs.next())
					{
						System.out.println();
						System.out.print(rs.getInt("eid"));
						System.out.print("\t\t"+rs.getString("ename"));
						System.out.print("\t\t"+rs.getString("eemail"));
						System.out.print("\t\t"+rs.getString("aage"));
					}
					
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
		
		public static void main(String[] args) {
			EmpDao em=new EmpDao();
			em.addEmp();
			em.getEmployees();
		}
	
}
