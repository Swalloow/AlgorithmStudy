package decorator;

public class Main {
	public static void main(String[] args) {
		
		// CultureMilege, MajorMilege : 40
		// AdditionalPeriod, HighGrade : 20, 10
		
		Milege myCultureMilege = new CultureMilege();
		myCultureMilege = new AdditionalPeriod(myCultureMilege);
		System.out.println(myCultureMilege.getDescription()+" : "+myCultureMilege.myMilege());
		
		Milege myMajorMilege = new MajorMilege();
		myMajorMilege = new HighGrade(myMajorMilege);
		System.out.println(myMajorMilege.getDescription()+" : "+myMajorMilege.myMilege());
	}
}