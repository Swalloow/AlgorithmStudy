import java.util.HashSet;
import java.util.Set;

public class HashSetTest {
	public static void main(String[] args) {
		String[] strArr = {"a", "a", "b", "c", "d", "e"};
		Set<String> set =  new HashSet<String>();
		
		for(int i = 0; i < strArr.length; i++) {
			set.add(strArr[i]);
		}
		for(String str: strArr) {
			set.add(str);
		}
		
		System.out.println(set);
		
		set.remove("b");
		set.removeAll(set);
		set.clear();
	}
}
