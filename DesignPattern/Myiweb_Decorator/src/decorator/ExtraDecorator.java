package decorator;

public abstract class ExtraDecorator implements Milege {
	
	protected Milege milege;
	protected int extraPoint;
	
	public int myMilege() {
		return milege.myMilege() + extraPoint;
	}
	public String getDescription() {
		return milege.getDescription();
	}
}