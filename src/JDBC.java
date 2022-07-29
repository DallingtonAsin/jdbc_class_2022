import java.sql.*;

public class JDBC {
	
	 void establishConnection() throws Exception {
		try {
			
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/school";
		String username = "Dallington";
		String password = "Dallington100";
		Connection con = DriverManager.getConnection(url, username, password);
		System.out.println("Java Database Connection established");
		}
		catch(Exception ex) {
			throw ex;
		}
		
	}
	
	 Connection getConnection() throws Exception {
		try {
			
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/school";
		String username = "Dallington";
		String password = "Dallington100";
		Connection con = DriverManager.getConnection(url, username, password);
		return con;
		}
		catch(Exception ex) {
			throw ex;
		}
	}
	
	 void listStudents() throws Exception{
		try {
			Connection con = this.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * from students");
			while(rs.next()) {
				String name = rs.getString("name");
				String regno = rs.getString("reg_no");
				String studentno = rs.getString("student_no");
				int age = rs.getInt("age");
				System.out.println("Name: "+name+" Reg no "+regno+" Student no "+studentno+" and age "+age+"");
				
			}
			}
			catch(Exception ex) {
				throw ex;
			}
	}
	 
	 void updateStudentRecords() throws Exception{
		 try {
				Connection con = this.getConnection();
				String query = "UPDATE students SET name = ?  WHERE id = ?";
				PreparedStatement ps = con.prepareStatement(query);
				ps.setString(1, "Moses");
				ps.setInt(2, 1);
				ps.executeUpdate();
				con.close();
				this.listStudents();
				}
				catch(Exception ex) {
					throw ex;
				}
	 }
	 
	 void insertStudent() throws Exception{
		 try {
				Connection con = this.getConnection();
				String query = "INSERT INTO students(name, reg_no, student_no, age) VALUES(?, ?, ?, ?)";
				PreparedStatement ps = con.prepareStatement(query);
				ps.setString(1, "David");
				ps.setString(2, "17/U/178");
				ps.setString(3, "217006089");
				ps.setInt(4, 19);
				ps.execute();
				con.close();
				this.listStudents();
		}
				catch(Exception ex) {
					throw ex;
				}
	 }
	 
	 void deleteStudent() throws Exception{
		 try {
				Connection con = this.getConnection();
				String query = "DELETE FROM students WHERE id=?";
				PreparedStatement ps = con.prepareStatement(query);
				ps.setInt(1, 3);
				ps.execute();
				con.close();
				this.listStudents();
		}
				catch(Exception ex) {
					throw ex;
				}
	 }

	public static void main(String[] args) {
		
		JDBC jdbc = new JDBC();
		try {
			jdbc.establishConnection(); // establishes connection
			jdbc.listStudents(); // lists students
			jdbc.updateStudentRecords();
			jdbc.insertStudent(); // inserts student
			jdbc.deleteStudent(); // deletes student
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
