package scoring;

public class TestScoring {
	private final double RATIO = 0.6;
	private int studentData;
	private int studentScore;

	public TestScoring(int studentData) {
		this.studentData = studentData;
		this.scoring();
	}
	
	// calculate score
	public int scoring() {
		studentScore = (int) (studentData * RATIO);
		return studentScore;
	}
}
