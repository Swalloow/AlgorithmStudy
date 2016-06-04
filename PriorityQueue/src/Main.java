import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) {
		Prisoner prisoner1 = new Prisoner("Smith", 3);
		Prisoner prisoner2 = new Prisoner("James", 5);
		Prisoner prisoner3 = new Prisoner("Nicole", 1);
		Prisoner prisoner4 = new Prisoner("Mickey", 7);
		Prisoner prisoner5 = new Prisoner("Michel", 10);
		
		PriorityQueue<Prisoner> priorityQueue = new PriorityQueue<Prisoner>();
		
		priorityQueue.offer(prisoner1);
		priorityQueue.offer(prisoner2);
		priorityQueue.offer(prisoner3);
		priorityQueue.offer(prisoner4);
		priorityQueue.offer(prisoner5);
		
		
		while(!priorityQueue.isEmpty()) {
			Prisoner prisoner = priorityQueue.poll();
			System.out.println(prisoner.getName());
		}
	}
}
