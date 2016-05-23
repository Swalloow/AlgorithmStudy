package decorator;

public class CultureMilege implements Milege {
	
	@Override
	public int myMilege() {
		// culture milege
		return 30;
	}

	@Override
	public String getDescription() {
		return "Culture Milege";
	}
}
