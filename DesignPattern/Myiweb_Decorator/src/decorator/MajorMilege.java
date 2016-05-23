package decorator;

public class MajorMilege implements Milege {

	@Override
	public int myMilege() {
		// major milege
		return 40;
	}

	@Override
	public String getDescription() {
		return "Major Milege";
	}

}
