package com.netjstech.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * Graph DFS traversal (Recursive and Iterative)
 * Adjacency List representation
 */
public class GraphDFSAdjList {
	private Map<String, List<String>> adjListMap;
	// To keep track of already visited vertices
	private Set<String> visited;
	  
	public GraphDFSAdjList(){
		adjListMap = new HashMap<>();
	    visited = new HashSet<String>();
	}
	  
	public void addVertex(String v) {
		adjListMap.putIfAbsent(v, new ArrayList<String>());
	}
	  
	public void addEdge(String source, String destination) {

		if(!adjListMap.containsKey(source)) {
	      addVertex(source);
	    }
	    if(!adjListMap.containsKey(destination)) {
	      addVertex(destination);
	    }
	    adjListMap.get(source).add(destination);
	    // Reverse link also required for undirected graph
	    adjListMap.get(destination).add(source);
	}
	
	// Method to display graph
	public void printGraph() {
		adjListMap.forEach((vertex, neighbors) -> {
	      System.out.print("Vertex " + vertex+ " connects to ");
	      neighbors.forEach(n -> System.out.print(n + " "));
	      System.out.println();
	    });
	}
	
	// DFS Recursive logic start
	public void dfsRecursive(String startVertex) {
		visited.add(startVertex);
		System.out.print(startVertex + " ");
		for(String v: adjListMap.getOrDefault(startVertex, Collections.emptyList())) {
			// if not already visited
			if(!visited.contains(v))
				dfsRecursive(v);
		}
	}
	// DFS Recursive logic end
	
	// DFS Iterative logic start
	public void dfsIterative(String startVertex) {
		Stack<String> stack = new Stack<String>();
		stack.push(startVertex);
		visited.add(startVertex);
		
		while(!stack.isEmpty()) {
			String current = stack.pop();
			System.out.print(current + " ");		
			for(String v: adjListMap.getOrDefault(current, Collections.emptyList())) {
				// if not already visited
				if(!visited.contains(v)) {
					stack.push(v);
					visited.add(v);
				}
			}
		}
	}
	// DFS Iterative logic end
	
	public static void main(String[] args) {
		GraphDFSAdjList graph = new GraphDFSAdjList();

	    	graph.addEdge("A", "B");
	    	graph.addEdge("A", "C");
	    graph.addEdge("A", "D");
	    graph.addEdge("A", "E");
	    graph.addEdge("B", "F");
	    graph.addEdge("F", "I");
	    graph.addEdge("C", "G");
	    graph.addEdge("E", "H");
	    graph.addEdge("H", "J");
	    graph.printGraph();
	    
	    //Recursive call
//	    System.out.println("Graph traversal - DFS Recursive");
//	    graph.dfsRecursive("A");
	    //Iterative call
	    System.out.println("Graph traversal - DFS Iterative");
	    graph.dfsIterative("A");

	}
}
