package nl.frii.iteration.graph;

import java.util.HashMap;



public class Graph<T> {
	private HashMap<T,Vertex> vertices = new HashMap<T,Vertex>();
	
	public Graph () {
		
	}
	
	public Vertex<T> getVertex(T inside) {
		if (!vertices.containsKey(inside)) {
			vertices.put(inside, new Vertex(inside));
		}
		return vertices.get(inside);
	}
	
	public void addEdge(T from, T to, double weight) {
		Vertex<T> vFrom = getVertex(from);
		Vertex<T> vTo = getVertex(to);
		vTo.addLink(vFrom, weight);
		vFrom.addLink(vTo, weight);
	}
	
	public void clear() {
		vertices = new HashMap<T,Vertex>();
	}
	

}
