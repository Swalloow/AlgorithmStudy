package display;

import java.util.Observable;
import java.util.Observer;

import subject.ClassData;

public class ConsoleDisplay implements Observer, DisplayElement {

	private Observable observable;
	private String subjectName;
	private String classNumber;
	private String professor;
	private String studentNumber;
	private String time;
	private String room;
	
	public ConsoleDisplay(Observable observable) {
		this.observable = observable;
		observable.addObserver(this);
	}

	@Override
	public void update(Observable ob, Object arg) {
		if(ob instanceof ClassData) {
			ClassData classData = (ClassData) ob;
			this.subjectName = classData.getSubjectName();
			this.classNumber = classData.getClassNumber();
			this.professor = classData.getProfessor();
			this.studentNumber = classData.getStudentNumber();
			this.time = classData.getTime();
			this.room = classData.getRoom();
			
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
