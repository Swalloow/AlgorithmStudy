import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main implements OnResponse {
	
	DataStore ds;
	
	static {
		System.out.println("INIT STATIC");
	}
	
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		test2();
	}
	
	static void test1() {
		MyIterator iterator = new DataStore();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
	
	static void test2() throws NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		try {
			Class clazz = Class.forName("DataStore");
			Object obj = clazz.newInstance();
			Method hasNext = clazz.getMethod("hasNext");
			Method next = clazz.getMethod("next");
			
			while((boolean) hasNext.invoke(obj)) {
				System.out.println(next.invoke(obj));
			}
			
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	static void test3() {
		DataStore dataStore = new DataStore();
		dataStore.requestIterator(new OnResponse() {

			@Override
			public void onResponse(MyIterator iterator) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	public void setIterator(MyIterator iterator) {
		Main main = new Main();
	}

	@Override
	public void onResponse(MyIterator iterator) {
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}		
	}
}
