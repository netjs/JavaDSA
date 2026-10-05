package com.netjstech.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class UndirectedGraphCycleDFS {
	private Map<Integer, List<Integer>> adjListMap;
	private int numOfVertices;
	// used to display the vertices that form cycle
	private Stack<Integer> stack;
	
	public UndirectedGraphCycleDFS(int numOfVertices){
	    this.numOfVertices = numOfVertices;
	    this.adjListMap = new HashMap<>();
	    // to keep track of the vertex for the cycle, stack is used
	    // so that vertices which are visited and not part of the cycle
	    // can be easily popped
	    this.stack = new Stack<>();
	}
	
	// adding graph edges	
	public void addEdge(Integer source, Integer destination) {
		adjListMap.computeIfAbsent(source, k->new ArrayList<>()).add(destination);
	    // For undirected graph
	    adjListMap.computeIfAbsent(destination, k->new ArrayList<>()).add(source);
	}
	  
	// Method to display the graph
	public void displayGraph() {
		adjListMap.forEach((k, v) -> {
	      System.out.print("Vertex " + k + " -> ");
	      v.forEach(e -> System.out.print(e + " "));
	      System.out.println();
	    });
	}
	
	// Logic for cycle detection
	public boolean isCycleDetected() {
		boolean[] visited = new boolean[numOfVertices];
		for(int i = 0; i < numOfVertices; i++) {
			if(!visited[i]) {
				if(dfs(i, -1, visited))
					return true;
			}
		}
		return false;
	}
	
	// recursive dfs to check for cycle
	private boolean dfs(int currentVertex, int parent, boolean[] visited) {
		visited[currentVertex] = true;
		stack.push(currentVertex);
		for(int v : adjListMap.getOrDefault(currentVertex, Collections.emptyList())) {
			if(!visited[v]) {
				if(dfs(v, currentVertex, visited))
					return true;
			}
			// if adjacent vertex is already visited but it is not the parent that means cycle
			else if(v != parent) {
				//comment this method call if you don't want to display cycle nodes
				displayCycleVertices(stack, v);
				return true;
			}
		}
		stack.pop();
		return false;
	}
	
	// Method to display vertices that are part of the cycle 
	private void displayCycleVertices(Stack<Integer> stack, int v) {
		List<Integer> cycleList = new ArrayList<Integer>();
		int startIndex = stack.indexOf(v);
		for(int i = startIndex; i < stack.size(); i++) {
			cycleList.add(stack.get(i));
		}
		// Add the starting node to complete the cycle
		cycleList.add(v);
		System.out.println("Detected cycle is: " + cycleList);
	}
	
	public static void main(String[] args) {
	    UndirectedGraphCycleDFS graph = new UndirectedGraphCycleDFS(6);

	    graph.addEdge(0, 1); //A-B
	    //graph.addEdge(1, 2); //A-C
	    graph.addEdge(0, 2); //A-C
	    graph.addEdge(0, 4); //A-E
	    graph.addEdge(2, 3); //C-D
	    graph.addEdge(3, 4); //D-E
	    //graph.addEdge(3, 5);
	    
	    graph.displayGraph(); 
	    
	    if(graph.isCycleDetected()) {
	    		System.out.println("Cycle detected in the graph");
	    }else{
	    		System.out.println("No Cycle detected in the graph");
	    }

	}

}
