package com.netjstech.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphDSAdjList {
	private Map<Vertex, List<Vertex>> adjListMap = new HashMap<Vertex, List<Vertex>>();
	
	// add a vertex
	public void addVertex(Vertex v) {
		adjListMap.putIfAbsent(v, new ArrayList<Vertex>());
	}
	
	// remove a vertex
	public void removeVertex(Vertex v) {
		// remove vertex as a key from the map
		adjListMap.remove(v);
		
		// Remove the deleted vertex from all the lists
		
		adjListMap.values().forEach(e -> e.remove(v));
	}
	
	// add edge
	public void addEdge(String source, String destination) {
		Vertex vs = new Vertex(source);
		Vertex vd = new Vertex(destination);
		
		if(!adjListMap.containsKey(vs)) {
			addVertex(vs);
		}
		
		if(!adjListMap.containsKey(vd)) {
			addVertex(vd);
		}
		
		adjListMap.get(vs).add(vd);
		// for undirected graph reverse link (for directed comment it)
		adjListMap.get(vd).add(vs);
		
	}
	
	public void removeEdge(String source, String destination) {
		Vertex vs = new Vertex(source);
		Vertex vd = new Vertex(destination);
		adjListMap.get(vs).remove(vd);
		// for undirected graph reverse link (for directed comment it)
		adjListMap.get(vd).remove(vs);
	}
	
	public void displayGraph() {
		adjListMap.forEach((k, v) -> {
			System.out.print(k.getLabel() + " -> ");
			v.forEach(e -> System.out.print(e.getLabel() + " "));
			System.out.println();
		});
	}
	
	public static void main(String[] args) {

		GraphDSAdjList graph = new GraphDSAdjList();
		graph.addVertex(new Vertex("A"));
		graph.addVertex(new Vertex("B"));
		graph.addEdge("A", "B");
		graph.addEdge("A", "C");
		graph.addEdge("A", "E");
		graph.addEdge("C", "D");
		graph.addEdge("D", "E");
		//graph.adjListMap.values().forEach(e -> System.out.println(e));
		graph.displayGraph();
		
		System.out.println("After removing a vertex");
		graph.removeVertex(new Vertex("A"));
		graph.displayGraph();
		System.out.println("After removing an edge");
		graph.removeEdge("C", "D");
		graph.displayGraph();
	}

}
