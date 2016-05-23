package scoring;

public class Professor {
	// Professor scoring students
	private ScoringFacade scoringFacade;
	private int studentData;
	
	public Professor(int studentData) {
		this.studentData = studentData;
	}

	public void scoring() {
		scoringFacade = new ScoringFacade(studentData);
		scoringFacade.scoring();
	}
}