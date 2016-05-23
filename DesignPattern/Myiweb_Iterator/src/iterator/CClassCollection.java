package iterator;

import java.util.ArrayList;

public class CClassCollection {

	private ArrayList<CClass> list = new ArrayList<CClass>();

	public ArrayList<CClass> getList() {return list;}
	public void setList(ArrayList<CClass> list) {this.list = list;}

	public IIterator createIterator() {
		ClassIterator iterator = new ClassIterator();
		return iterator;
	}

	private class ClassIterator implements IIterator {
		private int index = 0;

		@Override
		public boolean hasNext() {
			if(this.index < list.size()) {
				return true;
			} else {
				return false;
			}
		}

		@Override
		public Object next() {
			if(this.hasNext()) {
				return list.get(this.index++);
			} else {
				return null;	
			}			
		}
	}
}
