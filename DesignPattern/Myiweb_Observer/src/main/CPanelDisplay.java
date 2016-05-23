package main;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class CPanelDisplay implements Observer, IDisplayElement {

	private Observable observable;
	private String subjectName;
	private String classNumber;
	private String professor;
	private String studentNumber;
	private String time;
	private String room;
	
	public CPanelDisplay(Observable observable) {
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
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JMenuBar menubar = new JMenuBar();
		JTextArea textArea = new JTextArea();
		
		frame.setSize(400, 600);
		frame.setTitle("MyoungJi Myiweb System");
		frame.setVisible(true);
		frame.setJMenuBar(menubar);
		frame.add(panel);
		panel.add(textArea);
		
		textArea.append("subjectName : "+subjectName+"\n");
		textArea.append("classNumber : "+classNumber+"\n");
		textArea.append("professor : "+professor+"\n");
		textArea.append("studentNumber : "+studentNumber+"\n");
		textArea.append("time : "+time+"\n");
		textArea.append("room : "+room+"\n");
	}
}
