
public class DataStore implements MyIterator {
	
	static {
		System.out.println("DATASTORE");
	}
	
	private static String[] array = {"a", "b", "c", "d"};
	int index;

	public void requestIterator(OnResponse on) {
		on.onResponse(this);
	}

	@Override
	public boolean hasNext() {
		if(array.length-index==0)
			return false;
		return true;
	}

	@Override
	public Object next() {
		return array[index++];
	}
}
