package StudentManagementSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SubjectDAO {
	Connection con;

	public SubjectDAO(Connection con) {
		this.con = con;
	}
	
	public void addSubject(Subject subject) {
	    String sql = "INSERT INTO subject (subjectId, subjectName, classLevel) VALUES (?, ?, ?)";
	    try (PreparedStatement pstmt = con.prepareStatement(sql)) {
	        pstmt.setInt(1, subject.getSubjectId());
	        pstmt.setString(2, subject.getSubjectName());
	        pstmt.setInt(3, subject.getClassLevel());
	        pstmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	public List<Subject> getSubjectsByClassLevel(int classLevel) {
        List<Subject> subjects = new ArrayList<>();
        String query = "SELECT subjectId, subjectName FROM subject WHERE classLevel = ?";

        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, classLevel);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int subjectId = rs.getInt("subjectId");
                String subjectName = rs.getString("subjectName");
                subjects.add(new Subject(subjectId, subjectName));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return subjects;
    }
}
