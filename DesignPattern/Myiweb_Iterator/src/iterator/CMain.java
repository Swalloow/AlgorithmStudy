package iterator;

public class CMain {

	public static void main(String[] args) {
		CClassCollection classCollection = new CClassCollection();
		IIterator iterator = classCollection.createIterator();
		
		classCollection.getList().add(new CClass("database", "05", "30", "5420"));
		classCollection.getList().add(new CClass("architecture", "04", "35", "5120"));
		classCollection.getList().add(new CClass("network", "03", "40", "5121"));
		
		while(iterator.hasNext()) {
			CClass mClass = (CClass) iterator.next();
			System.out.println("SubjectName : "+mClass.getSubjectName());
		}
	}
}