package nl.frii.iteration.graph;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Graph<String> g = new Graph<String>();
		DistanceMap shortest = new DistanceMap();
		BreadCrumbMap breadCrumbs = new BreadCrumbMap();
		
		new KarateClub().loadGraph(g);	
		
		Vertex<String> msHi = g.getVertex("17");
		msHi.setDijkstraIterator(shortest, breadCrumbs);
		
		for (Vertex<String> ioVertex : msHi) {
			System.out.println("Reach vertex number " + ioVertex 
					            + " via vertex " + breadCrumbs.get(ioVertex) 
					            + " in " + shortest.get(ioVertex) + " steps.");
		}

	}

}
