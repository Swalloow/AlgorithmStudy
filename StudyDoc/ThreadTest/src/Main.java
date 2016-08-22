
public class Main {

	static class TimeThread extends Thread {
		private Runnable runnable;
		
		public TimeThread(Runnable runnable) {
			this.runnable = runnable;
			runnable.run();
		}
		
		public void run() {
			long time = System.currentTimeMillis();
			runnable.run();
			long start = System.currentTimeMillis();
			System.out.println(this.getName() +" : "+ (start-time));
		}		
	}
	
	static public void test() {
		TimeThread t = new TimeThread(new Runnable() {
			@Override
			public void run() {
				long sum = 0;
				for(long i=0; i<10000000; i++) {
					sum += i;
				}
			}
		});
		t.start();
		try {
			t.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		test();
		test();
		test();
		test();
		
		System.out.println("return main");
	}
}
