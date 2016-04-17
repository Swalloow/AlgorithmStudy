
public class CQueueList {
	
	private class Node{
		private Object  data;
		private Node nextNode;

		Node(Object data){
			this.data = data;
			this.nextNode = null;
		}
	}
	private Node front;
	private Node rear;

	public CQueueList(){
		this.front = null;
		this.rear = null;
	}

	// 큐가 비어있는지 확인
	public boolean empty(){
		return (front==null);
	}

	// 큐 삽입연산
	public void enqueue(Object item){
		Node node = new Node(item);
		node.nextNode = null;

		if(empty()){
			rear = node;
			front = node;
		}else{
			rear.nextNode = node;
			rear = node;
		}
	}

	// 큐의 마지막 데이터 조회
	public Object peek(){
		if(empty()) throw new ArrayIndexOutOfBoundsException();
		return front.data;
	}

	// 큐 삭제연산
	public Object dequeue(){
		Object item = peek();
		front = front.nextNode;

		if(front == null){
			rear = null;
		}
		return item;
	}
}
