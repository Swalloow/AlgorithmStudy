package model;

public abstract class Milege {
	
	// description is about option
	protected String description = "none";
	
	// calculate my milege
	public abstract int myMilege();
	public String getDescription() {
		return description;
	}
}
