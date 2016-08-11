
public class DataBox {
	// Shared Data
	private String data;
	
	public synchronized String getData() {
		if(this.data == null) {
			try {
				wait();
			} catch (InterruptedException e) {}
		}
		
		String returnValue = data;
		System.out.println("ConsumerThread read data : " + returnValue);
		data = null;
		
		// ProducerThread to Waiting
		notify();
		
		return returnValue;
	}
	
	public synchronized void setData(String data) {
		if(this.data != null) {
			try {
				wait();
			} catch (InterruptedException e) {}
		}
		
		this.data = data;
		System.out.println("ProducerThread write data : " + data);
		notify();
	}
}
