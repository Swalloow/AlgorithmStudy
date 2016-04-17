import java.util.LinkedList;
import java.util.Queue;

public class CMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(10);
		queue.offer(20);
		queue.offer(30);
		
		while(!queue.isEmpty()) {
			queue.remove();
		}
	}
}
