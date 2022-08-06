import java.sql.*;
import java.util.*;


// Explanation of behind the scenes of Statement Interface

//class Statement {
//	ResultSet result;
//	 
//	 class ResultSet {
//			
//	 }
//	 
//	 ResultSet executeQuery() {
//			this.result = new ResultSet();
//			return this.result;
//    }
//	 
//	 void getDBData() {
//		 Statement stmt = new Statement();
//		 ResultSet rs = stmt.executeQuery();
//	 }
//}



public class Student {
	
	
	Connection establishDBConnection() throws Exception{
		// registering the driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		// open connection
		String url = "jdbc:mysql://127.0.0.1:3306/school";
		String user = "Dallington";
		String password = "Dallington100";
		url = url+"?user="+user+"&password="+password+"";
		
//		Connection con = DriverManager.getConnection(url);
//	    Connection con = DriverManager.getConnection(url, user, password);
	    
		Properties prop = new Properties();
	    prop.setProperty("user", user);
	    prop.setProperty("password", password);
	    Connection con = DriverManager.getConnection(url, prop);
	    
	    return con;
	}
	

	public static void main(String[] args) throws Exception{
	
		try {

//			Student s = new Student();
			Scanner input = new Scanner(System.in);
			
			String url = "jdbc:mysql://127.0.0.1:3306/university";
			Class.forName("com.mysql.cj.jdbc.Driver"); // register the driver
			Connection con = DriverManager.getConnection(url, "Dallington", "Dallington100");
		    System.out.println("Database connection established successfully");
		    
//		    String query = "CREATE DATABASE IF NOT EXISTS university";
//		    Statement stmt = con.createStatement();
//		    stmt.execute(query);
//		    System.out.println("Database created successfully");
		    
//		    String createTblQuery = "CREATE TABLE lecturers(id INT(255) NOT NULL PRIMARY KEY AUTO_INCREMENT, firstName VARCHAR(30) not null, lastName VARCHAR(55) not null, regID VARCHAR(30) not null UNIQUE, courseUnit VARCHAR(50) not null, age INT(255) not null)";
//		    Statement stmt = con.createStatement();
//		    stmt.execute(createTblQuery);
//		    System.out.println("Table created successfully");
		    
		    
//		    String insertRecord = "INSERT INTO lecturers(firstName, lastName, regID, courseUnit, age) VALUES('Peter', 'Ssemakula', '19/U/12553', 'AOOP', 20)";
//		    Statement stmt = con.createStatement();
//		    stmt.execute(insertRecord);
//		    System.out.println("Record inserted successfully");
		    
//		    String insertRecord1 = "INSERT INTO lecturers(firstName, lastName, regID, courseUnit, age) VALUES('Davis', 'Leku', '19/U/1005', 'Calculus', 19)";
//		    String insertRecord2 = "INSERT INTO lecturers(firstName, lastName, regID, courseUnit, age) VALUES('Angella', 'Mulikatete', '19/U/11122', 'Internet Programming', 23)";
//		    String insertRecord3 = "INSERT INTO lecturers(firstName, lastName, regID, courseUnit, age) VALUES('Emmanuel', 'Mulekwa', '19/U/17890', 'Systems programming', 21)";
//		   
//		    Statement stmt = con.createStatement();
//		    stmt.addBatch(insertRecord1);
//		    stmt.addBatch(insertRecord2);
//		    stmt.addBatch(insertRecord3);
//		    stmt.executeBatch();
//		    System.out.println("Records inserted successfully");
		    
//		    System.out.println("Enter the first name of the lecturer");
//		    String firstName = input.nextLine();
//		    System.out.println("Enter the last name of the lecturer");
//		    String lastName = input.nextLine();
//		    System.out.println("Enter the registration id of the lecturer");
//		    String regId = input.nextLine();
//		    System.out.println("Enter the course unit taught by the lecturer");
//		    String courseUnit = input.nextLine();
//		    System.out.println("Enter the age of the lecturer");
//		    int age = input.nextInt();
//		    
//		    String query = "INSERT INTO lecturers(firstName, lastName, regID, courseUnit, age) VALUES(?,?,?,?,?)";
//		    PreparedStatement stmt = con.prepareStatement(query);
//		    stmt.setString(1, firstName);
//		    stmt.setString(2, lastName);
//		    stmt.setString(3, regId);
//		    stmt.setString(4, courseUnit);
//		    stmt.setInt(5, age);
//		    stmt.execute();
//		    System.out.println("Details for lecture "+firstName+" "+lastName+" have been inserted successfully");
//		    
		 
//		    Statement stmt = con.createStatement();
//		    String query = "select * from lecturers";
//		    ResultSet rs = stmt.executeQuery(query);
//		    
//		    while(rs.next()) {
//		    	
//		    	String first_name = rs.getString("firstName");
//		    	String last_name = rs.getString("lastName");
//		    	String reg_id = rs.getString("regID");
//		    	String course_unit = rs.getString("courseUnit");
//		    	int age = rs.getInt("age");
//		    	System.out.println("Lecturer "+first_name+" "+last_name+" whose registration number is "+reg_id+", teaches "+course_unit+" and is "+age+" years old");
//		    
//		    }
		    
		    
//		    Statement stmt = con.createStatement();
//		    String query = "UPDATE lecturers SET firstName='Waswa' WHERE id=1";
//		    stmt.executeUpdate(query);
//		    System.out.println("Peter's records updated successfully");
		    
//		    System.out.println("Enter registration number whose records are to be updated");
//		    String regNo = input.nextLine();
//		    
//		    System.out.println("Enter lecturer's new last name");
//		    String lastname = input.nextLine();
//		    String query  = "UPDATE lecturers SET lastName=? where regID=?";
//	
//		    PreparedStatement ps = con.prepareStatement(query);
//		    ps.setString(1, lastname);
//		    ps.setString(2, regNo);
//		    ps.executeUpdate();
//		    System.out.println("Lectuer's details have been updated successfully");
//		    
		    
//		    Statement stmt = con.createStatement();
//		    String query = "DELETE FROM lecturers WHERE id=6";
//		    stmt.executeUpdate(query);
//		    System.out.println("Record deleted successfully");
		    
//		    String query = "CALL getLecturers()";
//		    CallableStatement stmt = con.prepareCall(query);
//		    ResultSet rs = stmt.executeQuery();
//		    
//		    while(rs.next()) {
//	    	
//	    	String first_name = rs.getString("firstName");
//	    	String last_name = rs.getString("lastName");
//	    	String reg_id = rs.getString("regID");
//	    	String course_unit = rs.getString("courseUnit");
//	    	int age = rs.getInt("age");
//	    	System.out.println(""+first_name+" "+last_name+" whose reg ID is "+reg_id+", teaches "+course_unit+" and is "+age+" years old");
//	    
//	    }
		    
		    System.out.println("Enter registration number of the lecturer whose records are to be retrieved");
		    String regNo = input.nextLine();
		    
		    String query = "CALL getLecturerDetails(?)";
		    CallableStatement stmt = con.prepareCall(query);
		    stmt.setString("registrationId", regNo);
		    ResultSet rs = stmt.executeQuery();
		    
		    while(rs.next()) {
	    	
	    	String first_name = rs.getString("firstName");
	    	String last_name = rs.getString("lastName");
	    	String reg_id = rs.getString("regID");
	    	String course_unit = rs.getString("courseUnit");
	    	int age = rs.getInt("age");
	    	System.out.println(""+first_name+" "+last_name+" whose reg ID is "+reg_id+", teaches "+course_unit+" and is "+age+" years old");
	    
	    }
		    
		}catch(Exception e) {
			e.printStackTrace();
			
		}

	}

}
