package com.netjstech.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class UndirectedGraphCycleBFS {
	// For adjacency list representation
	private Map<Integer, List<Integer>> adjList;
	private int numOfVertices;

	UndirectedGraphCycleBFS(int numOfVertices){
	    this.numOfVertices = numOfVertices;
	    adjList = new HashMap<>();
	}
	  
	// Creating adjacency list 
	public void addEdge(Integer source, Integer destination) {
		adjList.computeIfAbsent(source, k->new ArrayList<>()).add(destination);
		// For undirected graph
		adjList.computeIfAbsent(destination, k->new ArrayList<>()).add(source);
	}
	  
	public void displayGraph() {
	    adjList.forEach((k, v) -> {
	      System.out.print("Vertex " + k + " -> ");
	      v.forEach(e -> System.out.print(e + " "));
	      System.out.println();
	    });
	}
	
	// Logic for cycle detection starts
	public boolean isCycleDetected() {
		boolean[] visited = new boolean[numOfVertices];
		for(int i = 0; i < numOfVertices; i++) {
			if(!visited[i]) {
				if(bfs(i, visited))
					return true;
			}
		}
		return false;
	}
	
	// BFS traversal to check for cycle
	private boolean bfs(int currentVertex, boolean[] visited) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] {currentVertex, -1});
		visited[currentVertex] = true;
		int[] parentMap = new int[numOfVertices];
		Arrays.fill(parentMap, -1);
		while(!queue.isEmpty()) {
			int[] v = queue.poll();
			int vertex = v[0];
			int parent = v[1];
			for(int neighbour: adjList.getOrDefault(vertex, Collections.emptyList())) {
				if(!visited[neighbour]) {
					visited[neighbour] = true;
					queue.add(new int[] {neighbour, vertex});
					parentMap[neighbour] = vertex;
				}
				// if visited neighbour is not the parent
				else if(neighbour != parent) { // cycle detected
					//comment this method call if you don't want to display cycle nodes
					displayCycle(vertex, neighbour, parentMap);
					return true;
				}
				
			}
		}
		return false;
	}
	
	// Method to display the vertices that form the cycle
	private void displayCycle(int u, int v, int[] parentMap) {
		List<Integer> pathU = new ArrayList<Integer>();
		List<Integer> pathV = new ArrayList<Integer>();
		List<Integer> cycleNodes = new ArrayList<Integer>();
		
		int current = u;
		while(current != -1) {
			pathU.add(current);
			current = parentMap[current];
		}
		
		current = v;
		while(current != -1) {
			pathV.add(current);
			current = parentMap[current];
		}
		
		
		System.out.println("pathU " + pathU);
		System.out.println("pathV " + pathV);
		
		int i = pathU.size() - 1;
		int j = pathV.size() - 1;
		System.out.println("i before loop " + i);
		System.out.println("j before loop " + j);
		
		// Find the lowest common ancestor
		while( i >= 0 && j >=0 && pathU.get(i).equals(pathV.get(j))) {
			i--;
			j--;
		}
		System.out.println("i after loop " + i);
		System.out.println("j after loop " + j);
		
		int startIndex = i + 1;
		
		for(int k = startIndex; k >=0; k--) {
			cycleNodes.add(pathU.get(k));
		}
		
		for(int k = 0; k <= j; k++) {
			cycleNodes.add(pathV.get(k));
		}
		cycleNodes.add(pathU.get(startIndex));
		System.out.println("Cycle Nodes " + cycleNodes);
		
	}
	
	public static void main(String[] args) {
		 UndirectedGraphCycleBFS graph = new UndirectedGraphCycleBFS(10);
//		 graph.addEdge(0, 1); 		
//		 graph.addEdge(0, 2); 
//		 graph.addEdge(0, 4); 
//		 graph.addEdge(2, 3);
//		 graph.addEdge(3, 4);// Creates a cycle [0, 2, 3, 4, 0]
		 
		 // Another Graph
//		  graph.addEdge(0, 1);
//		  graph.addEdge(0, 2);
//		  graph.addEdge(0, 3);
//		  graph.addEdge(0, 7); 
//		  graph.addEdge(1, 4);
//		  graph.addEdge(4, 5);
//		  graph.addEdge(2, 5);
//		  graph.addEdge(3, 6);// Creates a cycle 0-1-4-5-2-0
		  
		 // Another Graph
		  graph.addEdge(0, 1);
		  graph.addEdge(1, 2);
		  graph.addEdge(2, 3);
		  graph.addEdge(2, 4);
		  graph.addEdge(3, 4);
	        
		 graph.displayGraph(); 
		 
		 if(graph.isCycleDetected()) {
			 System.out.println("There is a cycle in the graph");
		 }else {
			 System.out.println("There is no cycle in the graph");
		 }		 		 
	}

}
