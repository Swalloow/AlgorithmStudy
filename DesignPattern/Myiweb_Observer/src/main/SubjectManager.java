package main;

import java.util.*;

import subject.SubjectData;

public class SubjectManager {

	Vector vector = new Vector();
	
	public void addSubject(String data) {
		String number;
		String name;
		int grade;
		
		number = data.split(" ")[0];
		name = data.split(" ")[1];
		grade = Integer.parseInt(data.split(" ")[2]);

		SubjectData subject = new SubjectData();
		subject.setSubjectNumber(number);
		subject.setName(name);
		subject.setGrade(grade);
		
		vector.add(subject);
	}
	
	public void showsubjectList() {
		for(int i=0; i<vector.size(); i++) {
			System.out.println(((SubjectData)vector.get(i)).getSubjectNumber()+" "+((SubjectData)vector.get(i)).getName()+" "+((SubjectData)vector.get(i)).getGrade());
		}
	}
	
	public SubjectData getsubject(String subjectNumber) {
		for(int i=0; i<vector.size(); i++) {
			if(((SubjectData)vector.get(i)).getSubjectNumber().equals(subjectNumber)) {
				return (SubjectData)vector.get(i);
			}
		}
		return null;
	}
}
