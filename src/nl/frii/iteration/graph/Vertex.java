package nl.frii.iteration.graph;

import java.util.Iterator;

/*
MIT License
Copyright (c) 2018 Thomas Boose
*/


public class Vertex<T> implements Iterable<Vertex> {
	private T innerObject;
	private Iterator<Vertex> iter;
	private DistanceMap neighbours = new DistanceMap();
	
	public Vertex(T inner) {
		this.innerObject = inner;
	}
	
	public T getInnerObject() {
		return innerObject;
	}
	
	public void addLink(Vertex<?> to, double dist) {
		neighbours.put(to, dist);
	}

	public DistanceMap getNeighbours() {
		return neighbours;
	}
	
	public void setDijkstraIterator(DistanceMap dist, BreadCrumbMap bread) {
		this.iter = new DijkstraIterator(this,dist,bread);
	}
	
	@Override
	public synchronized Iterator<Vertex> iterator() {
		if (this.iter == null) {
			this.iter = new DijkstraIterator(this);
		}
		return iter;
	}
	
	public String toString() {
		return "" + innerObject;
	}

}
