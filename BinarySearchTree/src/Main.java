
public class Main {
	public static void main(String[] args) {
		BinarySearchTree b = new BinarySearchTree();
		//트리에 노드를 삽입
		b.insert(3);b.insert(8);
		b.insert(1);b.insert(4);b.insert(6);b.insert(2);b.insert(10);b.insert(9);
		b.insert(20);b.insert(25);b.insert(15);b.insert(16);
		
		System.out.println("트리삽입 결과 : ");
		b.display(b.root);
		System.out.println("");
		System.out.println("이진트리에서 4를 탐색 : " + b.find(4));
		System.out.println("이진트리에서 2를 삭제 : " + b.delete(2));		
		b.display(b.root);
		System.out.println("\n이진트리에서 4를 삭제 : " + b.delete(4));		
		b.display(b.root);
		System.out.println("\n이진트리에서 10을 삭제 : " + b.delete(10));		
		b.display(b.root);
	}
}