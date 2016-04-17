import java.util.Stack;

public class CMain {

	public static void main(String[] args) {
		Stack<Integer> myStack = new Stack<Integer>();
		myStack.push(10);
		myStack.push(20);
		myStack.push(30);
		
		while(!myStack.isEmpty()) {
			myStack.pop();
		}
	}
}
