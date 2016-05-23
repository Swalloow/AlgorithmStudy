package scoring;

public class HomeworkScoring {
	private final double RATIO = 0.3;
	private int studentData;
	private int studentScore;

	public HomeworkScoring(int studentData) {
		this.studentData = studentData;
		this.scoring();
	}
	
	// calculate score
	public int scoring() {
		studentScore = (int) (studentData * RATIO);
		return studentScore;
	}
}
