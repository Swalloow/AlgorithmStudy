package display;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import subject.ClassData;

public class PanelDisplay implements Observer, DisplayElement {

	private Observable observable;
	private String subjectName;
	private String classNumber;
	private String professor;
	private String studentNumber;
	private String time;
	private String room;
	
	public PanelDisplay(Observable observable) {
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
