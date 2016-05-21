package main;

import decorator.AdditionalPeriod;
import decorator.HighGrade;
import model.CultureMilege;
import model.MajorMilege;
import model.Milege;

public class Main {
	public static void main(String[] args) {
		Milege myCultureMilege = new CultureMilege();
		myCultureMilege = new AdditionalPeriod(myCultureMilege);
		System.out.println(myCultureMilege.getDescription()+" : "+myCultureMilege.myMilege());
		
		Milege myMajorMilege = new MajorMilege();
		myMajorMilege = new HighGrade(myMajorMilege);
		System.out.println(myMajorMilege.getDescription()+" : "+myMajorMilege.myMilege());
	}
}
