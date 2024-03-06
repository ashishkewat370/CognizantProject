package StudentManagementSystem;

public class StudentLogin {
      private int studentId;
      private String Password;
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public StudentLogin(int studentId, String password) {
		super();
		this.studentId = studentId;
		Password = password;
	}
      public StudentLogin() {
    	  
      }
}
