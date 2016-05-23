package iterator;

public class CClass {

	// attribute
	private String subjectName;
	private String classNumber;
	private String studentNumber;
	private String room;

	// getters and setters
	public String getSubjectName() {return subjectName;}
	public String getClassNumber() {return classNumber;}
	public String getStudentNumber() {return studentNumber;}
	public String getRoom() {return room;}
	public void setSubjectName(String subjectName) {this.subjectName = subjectName;}
	public void setClassNumber(String classNumber) {this.classNumber = classNumber;}
	public void setStudentNumber(String studentNumber) {this.studentNumber = studentNumber;}
	public void setRoom(String room) {this.room = room;}
	
	// constructor
	public CClass(String subjectName, String classNumber, String studentNumber, String room) {
		this.subjectName = subjectName;
		this.classNumber = classNumber;
		this.studentNumber = studentNumber;
		this.room = room;
	}	
}
