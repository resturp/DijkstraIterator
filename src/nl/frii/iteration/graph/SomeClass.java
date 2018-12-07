package nl.frii.iteration.graph;

public class SomeClass {
	private String name;
	
	public SomeClass(String name) {
		this.name = name;
	}
	
	public String toString() {
		return "Some " + this.name + "(" + this.hashCode() +")"; 
	};

}
