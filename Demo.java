package com.que1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Demo {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Roll Number of Course");
		int roll=sc.nextInt();
		
//		Scanner sc1=new Scanner(System.in);
//		System.out.println("Enter Course");
//		String cname=sc1.next();
//		
		
		
		
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String url="jdbc:mysql://localhost:3306/question1bd";
		
		try(Connection conn= DriverManager.getConnection(url, "root", "root");) {
			
			
			PreparedStatement ps= conn.prepareStatement("select s.roll,s.name,c.cname from Student s INNER JOIN Course c INNER JOIN Student_Course sc ON s.roll=sc.roll AND c.cid=sc.cid AND s.roll=?");
			ps.setInt(1, roll);
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				int s=rs.getInt("roll");
				String m=rs.getString("name");
				String c=rs.getString("cname");
				
				System.out.println("Roll "+s);
				System.out.println("Name "+m);
				System.out.println("Course Name "+c);
			}
			
			
//			PreparedStatement ps1= conn.prepareStatement("select s.roll,s.name,c.cname from Student s INNER JOIN Course c INNER JOIN Student_Course sc ON s.roll=sc.roll AND c.cid=sc.cid AND c.name=?");
//			ps1.setString(2, cname);
//			
//			ResultSet rs1=ps1.executeQuery();
//			
//			while(rs1.next()) {
//				
//				String m=rs1.getString("cname");
//				int s=rs1.getInt("roll");
//				String c=rs1.getString("name");
//				
//				
//				System.out.println("Course Name "+m);
//				System.out.println("Roll "+s);
//				System.out.println("Name "+c);
//			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
			
		

	}

}
