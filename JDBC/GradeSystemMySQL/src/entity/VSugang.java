package entity;

import java.util.ArrayList;

public class VSugang {
	//Attributes
	private String sugangID;
	private String sugangName;
	private String grade;
	private ArrayList<String> sugangList;
	
	//Method
	public String getSugangID() {return sugangID;}
	public void setSugangID(String sugangID) {this.sugangID = sugangID;}
	public String getSugangName() {return sugangName;}
	public void setSugangName(String sugangName) {this.sugangName = sugangName;}
	public String getGrade() {return grade;}
	public void setGrade(String grade) {this.grade = grade;}
	public ArrayList<String> getSugangList() {return sugangList;}
	public void setSugangList(ArrayList<String> sugangList) {this.sugangList = sugangList;}
	
}
