
public class CQueueArray {
	private int front;
	private int rear;
	private int maxSize;
	private Object[] queueArray;

	// ť �迭 ���� �� �ʱ�ȭ
	public CQueueArray(int maxSize){
		this.front = 0;
		this.rear = -1;
		this.maxSize = maxSize;
		this.queueArray = new Object[maxSize];
	}

	// ť�� ����ִ��� Ȯ��
	public boolean empty(){
		return (front == rear+1);
	}

	// ť�� ���ִ��� Ȯ��
	public boolean full(){
		return (rear == maxSize-1);
	}

	// ť ���Կ���
	public void enqueue(Object item){

		if(full()) throw new ArrayIndexOutOfBoundsException();

		queueArray[++rear] = item;
	}

	// ť�� ������ ������ ��ȸ
	public Object peek(){

		if(empty()) throw new ArrayIndexOutOfBoundsException();

		return queueArray[front];
	}

	// ť ��������
	public Object dequeue(){
		Object item = peek();
		front++;
		return item;
	}
}
