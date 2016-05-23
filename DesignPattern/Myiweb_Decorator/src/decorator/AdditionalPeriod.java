package decorator;

public class AdditionalPeriod extends ExtraDecorator {

	public AdditionalPeriod(Milege milege) {
		this.milege = milege;
		this.extraPoint = 20;
	}
	
	@Override
	public String getDescription() {
		// add high grade description
		return milege.getDescription() + ", additional period";
	}

	@Override
	public int myMilege() {
		// add high grade milege
		return milege.myMilege() + extraPoint;
	}
}
