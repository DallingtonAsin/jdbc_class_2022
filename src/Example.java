import java.sql.*;
import java.util.*;

public class Example {
	
	private String dbname = "lecturers";
	// select, select using procedure, update, delete, batch execution
	public Connection getConnection() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+this.dbname+"", "Dallington", "Dallington100");
		return con;
	}
	
	public void createDB() throws Exception {
		try {
			
			String query = "CREATE DATABASE IF NOT EXISTS "+this.dbname+"";
			Connection con = this.getConnection();
			Statement stmt = con.createStatement();
			Boolean result = stmt.execute(query);
			System.out.println("Database created successfully");
			
			
		}catch(Exception e) {
			throw e;
		}
	}
	
	
	public void createTable() throws Exception {
		try {
		
			String query = "CREATE TABLE IF NOT EXISTS teachers(id INT(255) NOT NULL PRIMARY KEY AUTO_INCREMENT, name VARCHAR(20), regId VARCHAR(20) UNIQUE, course VARCHAR(20), age INT(100))";
			Connection con = this.getConnection();
			Statement stmt = con.createStatement();
			Boolean result = stmt.execute(query);
			System.out.println("Table created successfully");
			
		}catch(Exception e) {
			throw e;
		}
	}
	
	// Get students using select statement
		public void getStudents() throws Exception {
			 Connection con = this.getConnection();
			 String query = "select * from students";
			 Statement stmt = con.createStatement();
			 ResultSet rs = stmt.executeQuery(query);
			 
			 if (stmt.execute(query)) {
			      ResultSet  rees = stmt.getResultSet();
			    }
			 
			 
			 while(rs.next()) {
				 String name = rs.getString("name");
				 String reg_no = rs.getString("reg_no");
				 int age = rs.getInt("age");
				 System.out.println(name+" whose registration number is "+reg_no+" is "+age+" years old");
			 }
		}
	
	// Get students using stored procedure
	public void getStudentsByStoredProc() throws Exception {
		 Connection con = this.getConnection();
		 String query = "CALL getStudents()";
		 CallableStatement stmt = con.prepareCall(query);
		 ResultSet rs = stmt.executeQuery();
		 while(rs.next()) {
			 String name = rs.getString("name");
			 String reg_no = rs.getString("reg_no");
			 int age = rs.getInt("age");
			 System.out.println(name+" whose registration number is "+reg_no+" is "+age+" years old");
		 }
	}
	
	// Get student details using registration number
	public void getStudentDetails(String regNo) throws Exception {
		 Connection con = this.getConnection();
		 String query = "CALL getStudentDetails(?)";
		 CallableStatement stmt = con.prepareCall(query);
		 stmt.setString("regNo", regNo);
		 ResultSet rs = stmt.executeQuery();
		 while(rs.next()) {
			 String name = rs.getString("name");
			 String reg_no = rs.getString("reg_no");
			 int age = rs.getInt("age");
			 System.out.println(name+" whose registration number is "+reg_no+" is "+age+" years old");
		 }
	}
	
	// update student details using registration number
		public void updateStudentDetails(String regNo, String name) throws Exception {
			 Connection con = this.getConnection();
			 String query = "update students set name=? where reg_no=?";
			 PreparedStatement stmt = con.prepareStatement(query);
			 stmt.setString(1, name);
			 stmt.setString(2, regNo);
			 stmt.executeUpdate();
			 System.out.println("Student details updated successfully");
		}
		
		// Delete student details using registration number
				public void deleteStudentDetails(String regNo) throws Exception {
					 Connection con = this.getConnection();
					 String query = "DELETE FROM students where reg_no=?";
					 PreparedStatement stmt = con.prepareStatement(query);
					 stmt.setString(1, regNo);
					 stmt.executeUpdate();
					 System.out.println("Student details deleted successfully");
				}
				
				public void executeBatchProcessing() throws Exception{
					 Connection con = this.getConnection();
					 Statement stmt = con.createStatement();
					 stmt.addBatch("Insert into students(name, reg_no, student_no, age) VALUES('Mohammed', '19/U/124/PS', '21800383', 22)");
					 stmt.addBatch("Insert into students(name, reg_no, student_no, age) VALUES('Chris', '20/U/125/EVE', '20200113', 19)");
				     stmt.executeBatch();
				     System.out.println("Batch executed successfully");
				}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			
		Scanner input = new Scanner(System.in);
		Example e = new Example();
		
		//e.getStudents(); // fetch students using select statement
		//e.getStudentsByStoredProc(); // fetch using stored procedure
		
		
//		System.out.println("Enter student reg no to get their details");
//		String reg_no = input.nextLine();
//		e.getStudentDetails(reg_no);
	
		
//		System.out.println("Enter student reg no of student whose name is to be updated");
//		String regNo = input.nextLine();
//		System.out.println("Enter student's name");
//		String name = input.nextLine();
//		e.updateStudentDetails(regNo, name);
//		input.close();
		
//		System.out.println("Enter student reg no of student whose details are to be removed from DB");
//		String sRegNo = input.nextLine();
//		e.deleteStudentDetails(sRegNo);
//		input.close();
		
//		e.executeBatchProcessing();
//		e.getStudentsByStoredProc();
		
//		e.createDB();
		e.createTable();
		
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}

