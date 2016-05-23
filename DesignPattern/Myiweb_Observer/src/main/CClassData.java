package main;

import java.util.Observable;

public class CClassData extends Observable {

	// attribute
	private String subjectName;
	private String classNumber;
	private String professor;
	private String studentNumber;
	private String time;
	private String room;
	
	// getters
	public String getSubjectName() {return subjectName;}
	public String getClassNumber() {return classNumber;}
	public String getProfessor() {return professor;}
	public String getStudentNumber() {return studentNumber;}
	public String getTime() {return time;}
	public String getRoom() {return room;}
	
	// constructors
	public CClassData(){}
	public CClassData(String subjectName, String classNumber, String professor, String studentNumber, String time, String room) {
		this.subjectName = subjectName;
		this.classNumber = classNumber;
		this.professor = professor;
		this.studentNumber = studentNumber;
		this.time = time;
		this.room = room;
	}
	
	// observer
	public void dataChanged() {
		setChanged();
		notifyObservers();
	}
	
	public void setData(String subjectName, String classNumber, String professor, String studentNumber, String time, String room) {
		this.subjectName = subjectName;
		this.classNumber = classNumber;
		this.professor = professor;
		this.studentNumber = studentNumber;
		this.time = time;
		this.room = room;
		
		dataChanged();
	}
}
