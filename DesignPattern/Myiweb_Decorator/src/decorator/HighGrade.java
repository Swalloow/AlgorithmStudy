package decorator;

import model.Milege;

public class HighGrade extends ExtraDecorator {

	private Milege milege;
	
	public HighGrade(Milege milege) {
		this.milege = milege;
	}
	
	@Override
	public String getDescription() {
		// add high grade description
		return milege.getDescription() + ", high grade";
	}

	@Override
	public int myMilege() {
		// add high grade milege
		return milege.myMilege() + 10;
	}

}
