package com.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import com.util.DBConnection;
public class BatchProcessEmployee {
	
	Connection conn;
	PreparedStatement pstmt;

	public void addEmployee() {

		conn = DBConnection.getDbConnection();
		if (conn != null) {

			String insertSQL = "insert into employee(ename,eemail,aage,rid,password)values(?,?,?,?,?)";
			Scanner sc = new Scanner(System.in);
			try {
				pstmt = conn.prepareStatement(insertSQL);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			while (true) {

				System.out.println("enter emp name :-");
				String eName = sc.next();

				System.out.println("enter emp email :-");
				String eEmail = sc.next();

				System.out.println("enter emp age :-");
				int eAge = sc.nextInt();

				System.out.println("enter role id");
				int rid = sc.nextInt();
				System.out.println("enetr password");
				String password = sc.next();
				String hashPassword = BcryptDemo.genpasskey(password);
				try {
					
					pstmt.setString(1, eName);
					pstmt.setString(2, eEmail);
					pstmt.setInt(3, eAge);
					pstmt.setInt(4, rid);
					pstmt.setString(5, hashPassword);
					pstmt.addBatch();

					System.out.println("add more record press 1 or any no to exit..");
					int choice = sc.nextInt();

					if (choice != 1) {

						break;
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} // while over..
			try
			{
				pstmt.executeBatch();
			}
			catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) 
	{
		BatchProcessEmployee emp = new BatchProcessEmployee();
		emp.addEmployee();
	}
}
