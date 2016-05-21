package decorator;

import model.Milege;

public class AdditionalPeriod extends ExtraDecorator {

	private Milege milege;
	
	public AdditionalPeriod(Milege milege) {
		this.milege = milege;
	}
	
	@Override
	public String getDescription() {
		// add additional period description
		return milege.getDescription() + ", additional period";
	}

	@Override
	public int myMilege() {
		// add additional period milege
		return milege.myMilege() + 20;
	}
}
