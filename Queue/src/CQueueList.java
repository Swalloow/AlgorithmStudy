
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

	// ť�� ����ִ��� Ȯ��
	public boolean empty(){
		return (front==null);
	}

	// ť ���Կ���
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

	// ť�� ������ ������ ��ȸ
	public Object peek(){
		if(empty()) throw new ArrayIndexOutOfBoundsException();
		return front.data;
	}

	// ť ��������
	public Object dequeue(){
		Object item = peek();
		front = front.nextNode;

		if(front == null){
			rear = null;
		}
		return item;
	}
}
