
public class CStackArray {

	private int top;
	private int maxSize;
	private Object[] stackArray;

	// 최대 크기로 배열 생성
	public CStackArray(int maxSize){
		this.maxSize = maxSize;
		this.stackArray = new Object[maxSize];
		this.top = -1;
	}

	// 스택이 비어있는지 체크
	public boolean empty(){
		return (top == -1);
	}

	// 스택이 꽉찼는지 체크
	public boolean full(){
		return (top == maxSize-1);
	}

	// 삽입연산
	public void push(Object item){
		if(full()) throw new ArrayIndexOutOfBoundsException((top+1)+">=" + maxSize);
		stackArray[++top] = item;
	}

	// 스택의 가장 위의 데이터 반환
	public Object peek(){
		if(empty()) throw new ArrayIndexOutOfBoundsException(top);
		return stackArray[top];
	}

	// 삭제연산
	public Object pop(){
		Object item = peek();
		top--;

		return item;
	}
}