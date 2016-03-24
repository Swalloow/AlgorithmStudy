
public class Student {
	private String name;
	private String grade;
	private String major;
	
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public String getGrade() {return grade;}
	public void setGrade(String grade) {this.grade = grade;}
	public String getMajor() {return major;}
	public void setMajor(String major) {this.major = major;}
	
	public Student(String name, String grade, String major) {
		this.name = name;
		this.grade = grade;
		this.major = major;
	}
}
