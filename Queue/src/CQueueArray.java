
public class CQueueArray {
	private int front;
	private int rear;
	private int maxSize;
	private Object[] queueArray;

	// 큐 배열 생성 및 초기화
	public CQueueArray(int maxSize){
		this.front = 0;
		this.rear = -1;
		this.maxSize = maxSize;
		this.queueArray = new Object[maxSize];
	}

	// 큐가 비어있는지 확인
	public boolean empty(){
		return (front == rear+1);
	}

	// 큐가 차있는지 확인
	public boolean full(){
		return (rear == maxSize-1);
	}

	// 큐 삽입연산
	public void enqueue(Object item){

		if(full()) throw new ArrayIndexOutOfBoundsException();

		queueArray[++rear] = item;
	}

	// 큐의 마지막 데이터 조회
	public Object peek(){

		if(empty()) throw new ArrayIndexOutOfBoundsException();

		return queueArray[front];
	}

	// 큐 삭제연산
	public Object dequeue(){
		Object item = peek();
		front++;
		return item;
	}
}
