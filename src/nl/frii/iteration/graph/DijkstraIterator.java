package nl.frii.iteration.graph;
/*
MIT License
Copyright (c) 2018 Thomas Boose
*/

import java.util.Iterator;


public class DijkstraIterator implements Iterator<Vertex>  {

	//keep a stack of all vertex TO BE explored. 
	//accompanied by the shortest distance known to reach it.
	private DistanceMap mapStackVertDist = new DistanceMap();
	//keep a stack of all vertex that HAVE BEEN explored. 
	private DistanceMap shortest;
	//keep a stack of all vertex that HAVE BEEN explored. 
	//accompanied by the vertex to use while traveling back.
	private BreadCrumbMap bread;

	public DijkstraIterator(Vertex k, DistanceMap shortest, BreadCrumbMap bread) {
		this.shortest = shortest;
		this.bread = bread;
		mapStackVertDist.put(k, 0.0);
		shortest.put(k, 0.0);
	}

	public DijkstraIterator(Vertex k, BreadCrumbMap bread) {
		this(k, new DistanceMap(), bread);
	}
	public DijkstraIterator(Vertex k, DistanceMap shortest) {
		this(k, shortest, new BreadCrumbMap());
	}
	public DijkstraIterator(Vertex k) {
		this(k, new DistanceMap(), new BreadCrumbMap());
	}
	
	public DistanceMap getStack() {
		return mapStackVertDist;
	}
	public DistanceMap getShortest() {
		return shortest;
	}	
	public BreadCrumbMap getBreadCrumb() {
		return bread;
	}
	
	@Override
	public boolean hasNext() {
		return !mapStackVertDist.isEmpty();
	}

	@Override
	public Vertex next() {
		mapStackVertDist = (DistanceMap) MapUtil.sortByValue(mapStackVertDist);
		//get the first key from stack TO BE explored.
		Vertex keyToRemove = mapStackVertDist.keySet().iterator().next();
		//get the first distance from the stack TO BE explored.
		Double firstDistance = mapStackVertDist.values().iterator().next();

		for (Object keyForNeighbour : keyToRemove.getNeighbours().keySet()) {
			Double newDistance = firstDistance + (Double)keyToRemove.getNeighbours().get(keyForNeighbour);
			if (!shortest.containsKey(keyForNeighbour) || newDistance < shortest.get(keyForNeighbour)) {
				bread.put((Vertex) keyForNeighbour, keyToRemove);
				shortest.put((Vertex) keyForNeighbour, newDistance);
				mapStackVertDist.put((Vertex) keyForNeighbour, newDistance);
			}
		}
		
		mapStackVertDist.remove(keyToRemove);
		return keyToRemove;
	}

}
