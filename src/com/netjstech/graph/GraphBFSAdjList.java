package com.netjstech.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Graph BFS traversal Adjacency List representation
 */
public class GraphBFSAdjList {
	private Map<String, List<String>> adjList;
	// To keep track of already visited vertices
	private Set<String> visited;
	  
	GraphBFSAdjList(){
	    adjList = new HashMap<>();
	    visited = new HashSet<String>();
	}
	  
	public void addVertex(String v) {
	    adjList.putIfAbsent(v, new ArrayList<String>());
	}
	  
	public void addEdge(String source, String destination) {

	    if(!adjList.containsKey(source)) {
	      addVertex(source);
	    }
	    if(!adjList.containsKey(destination)) {
	      addVertex(destination);
	    }
	    adjList.get(source).add(destination);
	    // Reverse link also required for undirected graph
	    adjList.get(destination).add(source);
	}
	  
	// Method to display graph
	public void displayGraph() {
	    adjList.forEach((k, v) -> {
	      System.out.print("Vertex " + k + " connects to ");
	      v.forEach(e -> System.out.print(e + " "));
	      System.out.println();
	    });
	}
	
	public void bfsTraversal(String startVertex) {
		Queue<String> queue = new LinkedList<String>();
		queue.add(startVertex);
		visited.add(startVertex);
		while(!queue.isEmpty()) {
			String currentVertex = queue.poll();
			System.out.print(currentVertex + " ");
			for(String v : adjList.getOrDefault(currentVertex, Collections.emptyList())) {
				if(!visited.contains(v)) {
					queue.add(v);
					visited.add(v);
				}

			}
		}
	}
	
	  
	public static void main(String[] args) {
		GraphBFSAdjList graph = new GraphBFSAdjList();

    		graph.addEdge("A", "B");
	    graph.addEdge("A", "C");
	    graph.addEdge("A", "D");
	    graph.addEdge("A", "E");
	    graph.addEdge("B", "F");
	    graph.addEdge("F", "I");
	    graph.addEdge("C", "G");
	    graph.addEdge("E", "H");
	    graph.addEdge("H", "J");
	    
	    graph.displayGraph();
	    System.out.println("Graph Traversal - BFS");
	    graph.bfsTraversal("A");

	}

}
