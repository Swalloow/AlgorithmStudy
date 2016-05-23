package decorator;

public class HighGrade extends ExtraDecorator {
	
	public HighGrade(Milege milege) {
		this.milege = milege;
		this.extraPoint = 10;
	}
	
	@Override
	public String getDescription() {
		// add high grade description
		return milege.getDescription() + ", high grade";
	}

	@Override
	public int myMilege() {
		// add high grade milege
		return milege.myMilege() + extraPoint;
	}
}
