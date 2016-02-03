
public class CStackList {
	
	private Node top;
	private class Node{
		private Object data;
		private Node nextNode;

		Node(Object data){
			this.data = data;
			this.nextNode = null;
		}
	}

	// 생성자를 통한 스택초기화
	public CStackList(){
		this.top = null;
	}

	// 스택이 비어있는지 확인
	public boolean empty(){
		return (top == null);
	}

	// 삽입연산
	public void push(Object item){
		Node newNode = new Node(item);
		newNode.nextNode = top;
		top = newNode;
	}

	// 스택의 가장 위의 데이터 반환
	public Object peek(){
		if(empty()) throw new ArrayIndexOutOfBoundsException();
		return top.data;
	}

	// 삭제연산
	public Object pop(){
		Object item = peek();
		top = top.nextNode;
		return item;
	}
}
