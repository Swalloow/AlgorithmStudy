package scoring;


public class ScoringFacade {

	private AttandenceScoring attandenceScoring;
	private HomeworkScoring homeworkScoring;
	private TestScoring testScoring;
	
	public ScoringFacade(int studentData) {
		attandenceScoring = new AttandenceScoring(studentData);
		homeworkScoring = new HomeworkScoring(studentData);
		testScoring = new TestScoring(studentData);
	}

	public void scoring() {
		System.out.println("your attandence score is "+this.attandenceScoring.scoring());
		System.out.println("your homework score is "+this.homeworkScoring.scoring());
		System.out.println("your test score is "+this.testScoring.scoring());
	}
}