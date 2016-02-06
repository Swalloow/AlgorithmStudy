import java.util.TreeSet;

public class TreeSetTest {
	public static void main(String[] args) {
		TreeSet<String> set = new TreeSet<String>();
		
		set.add("apple");
		set.add("airplane");
		set.add("alien");
		set.add("disc");
		set.add("dance");
		
		System.out.println(set.headSet("b"));
		System.out.println(set.subSet("a", "al"));
		System.out.println(set.tailSet("c"));
		
	}
}
