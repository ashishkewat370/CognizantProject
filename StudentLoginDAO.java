package StudentManagementSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentLoginDAO {
Connection con ;
	
	public StudentLoginDAO(Connection con){
		this.con=con;
	}
    public boolean validateUser(int studentId, String password) {
        boolean isStudentValid = false;
        String query = "SELECT * FROM studentlogin WHERE studentId = ? AND Password = ?";

        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, studentId);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            isStudentValid = rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isStudentValid;
    }
}
