package scoring;

public class AttandenceScoring {
	private final double RATIO = 0.1;
	private int studentData;
	private int studentScore;

	public AttandenceScoring(int studentData) {
		this.studentData = studentData;
	}
	
	// calculate score
	public int scoring() {
		this.studentScore = (int) (this.studentData * RATIO);
		return studentScore;
	}
}