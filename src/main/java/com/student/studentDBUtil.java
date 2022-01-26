package com.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class studentDBUtil {
	private static boolean isSuccess;
	private static Connection con = null;
	private static Statement  stmt = null;
	private static ResultSet rs  = null;

	public static List<Student> validate(String stName, String pass){
	
		ArrayList<Student> st = new ArrayList<>();
		
		//create database connection
				String url = "jdbc:mysql://localhost:3306/studentDatabase";
				String user = "root";
				String password = "123";
				
		//validate
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con 	=  DriverManager.getConnection(url, user, password); 
			Statement stmt  = con.createStatement();
			String sql 		= "select * from student where name = '"+stName+"' and password = '"+pass+"'  ";
			ResultSet rs 	= stmt.executeQuery(sql);
						
			if(rs.next()) {
				
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String age 	= rs.getString(3);
				String phone = rs.getString(4);
				String pw = rs.getString(5);
				
				
				Student s = new Student(id, name, age, phone,pw);
				//Student s = new  Student(id, name, age, phone);
				st.add(s);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return st;			
	}
		
	//insert student
	public static boolean insertStudent(int id, String name, String age, String phone, String pw) {
		//create database connection
		String url = "jdbc:mysql://localhost:3306/studentDatabase";
		String user = "root";
		String password = "123";
		
		boolean isSuccess = false;
			
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con 	=  DriverManager.getConnection(url, user, password); 
			Statement stmt  = con.createStatement();
			String sql = "insert into student values ('"+id+"', '"+name+"','"+age+"', '"+phone+"', '"+pw+"')";
			int rs = stmt.executeUpdate(sql);
			
			if(rs > 0) {
				isSuccess = true;
			}
			else {
				isSuccess = false;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}		
		return isSuccess;		
	}
	
	
	public static boolean updateStudent(String id, String name , String age, String phone, String pw) {
		
		//create database connection
				String url = "jdbc:mysql://localhost:3306/studentDatabase";
				String user = "root";
				String password = "123";
	try {

		Class.forName("com.mysql.jdbc.Driver");
		
		Connection con 	=  DriverManager.getConnection(url, user, password); 
		Statement stmt  = con.createStatement();
		String sql = "update student set name='"+name+"',  age = '"+age+"',  phone = '"+phone+"', password = '"+pw+"' where id='"+id+"'";
		int rs = stmt.executeUpdate(sql);
		
		if(rs >0) {
			isSuccess = true;
		}
		else {
			isSuccess = false;
		}
	}
	catch(Exception e) {
		e.printStackTrace();
	}	
	return isSuccess;
		
}
	
	public static List<Student> getStudentDetails(String Id){
		int convertedID = Integer.parseInt(Id);
		
		ArrayList<Student> st = new ArrayList<>();
		
		//create database connection
				String url = "jdbc:mysql://localhost:3306/studentDatabase";
				String user = "root";
				String password = "123";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con 	=  DriverManager.getConnection(url, user, password); 
			Statement stmt  = con.createStatement();
			String sql = "select * from student where id= '"+convertedID+"' ";
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String age = rs.getString(3);
				String phone = rs.getString(4);
				
				Student s = new Student(id,name, age, phone, password);
				st.add(s);
				
			}
			
		}		
		catch(Exception e) {
			e.printStackTrace();
		}
		return st;
	}
	
	public static List<Student> selectAllStudents(){
		
		List<Student> students = new ArrayList<>();
		//ArrayList<Student> students = new ArrayList<>();
		
		//create database connection
				String url = "jdbc:mysql://localhost:3306/studentDatabase";
				String user = "root";
				String password = "123";
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					
					Connection con 	=  DriverManager.getConnection(url, user, password); 
					Statement stmt  = con.createStatement();
					String sql = "select * from student";
					ResultSet rs = stmt.executeQuery(sql);
					
					while(rs.next()) {
						int id = rs.getInt(1);
						String name = rs.getString(2);
						String age = rs.getString(3);
						String phone = rs.getString(4);					

						Student s = new Student(id,name, age, phone, password);
						students.add(s);
												
					}
				}
				catch(Exception e) {
					e.printStackTrace();
				}
				return students;	
	}
	
	
	
	 public static boolean deleteStudent(String id) {
	    	
	    	int convId = Integer.parseInt(id);
	    	
	    	//create database connection
			String url = "jdbc:mysql://localhost:3306/studentDatabase";
			String user = "root";
			String password = "123";
	    	
	    	try {

	    		Class.forName("com.mysql.jdbc.Driver");
				
				Connection con 	=  DriverManager.getConnection(url, user, password); 
				Statement stmt  = con.createStatement();
	    		String sql = "delete from customer where id='"+convId+"'";
	    		int r = stmt.executeUpdate(sql);
	    		
	    		if (r > 0) {
	    			isSuccess = true;
	    		}
	    		else {
	    			isSuccess = false;
	    		}	    		
	    	}
	    	catch (Exception e) {
	    		e.printStackTrace();
	    	}	    	
	    	return isSuccess;
	    }
}

