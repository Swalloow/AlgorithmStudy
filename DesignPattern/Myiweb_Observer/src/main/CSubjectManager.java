package main;

import java.util.*;

public class CSubjectManager {

	Vector vector = new Vector();
	
	public void addSubject(String data) {
		String number;
		String name;
		int grade;
		
		number = data.split(" ")[0];
		name = data.split(" ")[1];
		grade = Integer.parseInt(data.split(" ")[2]);

		CSubjectData subject = new CSubjectData();
		subject.setSubjectNumber(number);
		subject.setName(name);
		subject.setGrade(grade);
		
		vector.add(subject);
	}
	
	public void showsubjectList() {
		for(int i=0; i<vector.size(); i++) {
			System.out.println(((CSubjectData)vector.get(i)).getSubjectNumber()+" "+((CSubjectData)vector.get(i)).getName()+" "+((CSubjectData)vector.get(i)).getGrade());
		}
	}
	
	public CSubjectData getsubject(String subjectNumber) {
		for(int i=0; i<vector.size(); i++) {
			if(((CSubjectData)vector.get(i)).getSubjectNumber().equals(subjectNumber)) {
				return (CSubjectData)vector.get(i);
			}
		}
		return null;
	}
}
