import java.util.HashMap;

public class CHashMap {
	static HashMap<Integer, Student> student = new HashMap<Integer, Student>();
	
	public static void main(String[] args) {
		student.put(1111, new Student("김예시", "3학년", "영문과"));
		student.put(2222, new Student("정예시", "1학년", "영문과"));
		student.put(3333, new Student("김예시", "2학년", "컴공과"));
		student.put(4444, new Student("이예시", "4학년", "중문과"));
		student.put(5555, new Student("문예시", "4학년", "의예과"));
		
		printKey();
		printValue();
		printAll();
	}
	
	static public void printKey() {
		System.out.println("this is key----------");
		for(int key : student.keySet()) {
			System.out.println(key);
		}
	}
	
	static public void printValue() {
		System.out.println("this is value----------");
		for(Student student : student.values()) {
			System.out.println(student.getName()+" "+student.getGrade()+" "+student.getMajor());
		}
	}
	
	static public void printAll() {
		System.out.println("this is all----------");
		for(int key : student.keySet()) {
			System.out.println(key+" "+student.get(key).getName()+" "+student.get(key).getGrade()+" "+student.get(key).getMajor());
		}
	}
}
