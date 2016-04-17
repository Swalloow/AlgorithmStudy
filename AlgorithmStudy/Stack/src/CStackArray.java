
public class CStackArray {

	private int top;
	private int maxSize;
	private Object[] stackArray;

	// �ִ� ũ��� �迭 ����
	public CStackArray(int maxSize){
		this.maxSize = maxSize;
		this.stackArray = new Object[maxSize];
		this.top = -1;
	}

	// ������ ����ִ��� üũ
	public boolean empty(){
		return (top == -1);
	}

	// ������ ��á���� üũ
	public boolean full(){
		return (top == maxSize-1);
	}

	// ���Կ���
	public void push(Object item){
		if(full()) throw new ArrayIndexOutOfBoundsException((top+1)+">=" + maxSize);
		stackArray[++top] = item;
	}

	// ������ ���� ���� ������ ��ȯ
	public Object peek(){
		if(empty()) throw new ArrayIndexOutOfBoundsException(top);
		return stackArray[top];
	}

	// ��������
	public Object pop(){
		Object item = peek();
		top--;

		return item;
	}
}