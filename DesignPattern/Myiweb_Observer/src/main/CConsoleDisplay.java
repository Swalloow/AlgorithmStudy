package main;

import java.util.Observable;
import java.util.Observer;

public class CConsoleDisplay implements Observer, IDisplayElement {

	private Observable observable;
	private String subjectName;
	private String classNumber;
	private String professor;
	private String studentNumber;
	private String time;
	private String room;
	
	public CConsoleDisplay(Observable observable) {
		// set observer
		this.observable = observable;
		observable.addObserver(this);
	}

	@Override
	public void update(Observable ob, Object arg) {
		if(ob instanceof CClassData) {
			CClassData cClassData = (CClassData) ob;
			this.subjectName = cClassData.getSubjectName();
			this.classNumber = cClassData.getClassNumber();
			this.professor = cClassData.getProfessor();
			this.studentNumber = cClassData.getStudentNumber();
			this.time = cClassData.getTime();
			this.room = cClassData.getRoom();
			
			this.display();
		}
	}

	@Override
	public void display() {
		System.out.println("subjectName: "+subjectName);
		System.out.println("classNumber: "+classNumber);
		System.out.println("professor: "+professor);
		System.out.println("studentNumber: "+studentNumber);
		System.out.println("time: "+time);
		System.out.println("room: "+room);
	}
}
