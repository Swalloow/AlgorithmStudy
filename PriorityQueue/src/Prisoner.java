
public class Prisoner implements Comparable<Prisoner> {
	
	private String name;
	private int weight;
	
	public Prisoner(String name, int weight) {
		super();
		this.name = name;
		this.weight = weight;
	}

	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public int getWeight() {return weight;}
	public void setWeight(int weight) {this.weight = weight;}

	@Override
	public int compareTo(Prisoner target) {
		return this.weight >= target.weight ? -1 : 1;
	}
}
