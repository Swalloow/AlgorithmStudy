
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

	// �����ڸ� ���� �����ʱ�ȭ
	public CStackList(){
		this.top = null;
	}

	// ������ ����ִ��� Ȯ��
	public boolean empty(){
		return (top == null);
	}

	// ���Կ���
	public void push(Object item){
		Node newNode = new Node(item);
		newNode.nextNode = top;
		top = newNode;
	}

	// ������ ���� ���� ������ ��ȯ
	public Object peek(){
		if(empty()) throw new ArrayIndexOutOfBoundsException();
		return top.data;
	}

	// ��������
	public Object pop(){
		Object item = peek();
		top = top.nextNode;
		return item;
	}
}
