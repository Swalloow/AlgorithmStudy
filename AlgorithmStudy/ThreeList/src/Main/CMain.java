package Main;

import java.util.LinkedList;

public class CMain {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Integer> numbers = new LinkedList<>();
		numbers.add(10);
		numbers.add(20);
		numbers.add(30);
		numbers.add(40);
		System.out.println("add : " + numbers);
		
		numbers.add(1, 50);
		System.out.println("addIndex : " + numbers);
		
		numbers.remove(2);
		System.out.println("removeIndex : " + numbers);
		numbers.removeAll(numbers);
		
		System.out.println("getIndex : " + numbers.get(2));
		System.out.println("getSize : " + numbers.size());
		System.out.println("indexOf : " + numbers.indexOf(30));
		
		for(int i = 0; i < numbers.size(); i++) {
			System.out.print(numbers.get(i)+ " ");
		}
		
		for(int value : numbers) {
			System.out.print(value+ " ");
		}
		
		
		int[] value = {10, 20, 30, 40};
		for(int i = 0; i < value.length; i++) {
			numbers.add(value[i]);
		}
		
		for(int number : numbers) {
			System.out.print(number+ " ");
		}
	}
}
