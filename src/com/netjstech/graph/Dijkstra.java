package com.netjstech.graph;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class Dijkstra {
	
	public void dijkstra(int source, Graph graph) {
		int numOfVertices = graph.getVertices();
		boolean[] visited = new boolean[numOfVertices];
		
		int[] distance = new int[numOfVertices];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[source] = 0;
		
		PriorityQueue<Graph.Edge> pq = new PriorityQueue<Graph.Edge>();
		pq.add(new Graph.Edge(source, 0));
		
		while(!pq.isEmpty()) {
			Graph.Edge current = pq.poll();
			int n = current.node;
			if(visited[n])
				continue;
			visited[n] = true;
			
			for(Graph.Edge next: graph.getAdjListMap().getOrDefault(n, Collections.emptyList())) {
				int v = next.node;
				int weight = next.weight;
				if(!visited[v] && distance[n] + weight < distance[v] ) {
					distance[v] = distance[n] + weight;
					pq.add(new Graph.Edge(v, distance[v]));
				}
			}
		}
		
		printPaths(source, distance);
	}
	
	// To display the shortest paths from a source
	private void printPaths(int source, int[] distance) {
		System.out.println("Shortest path from source " + source);
		for(int i = 0; i < distance.length; i++) {
			System.out.println(" To Vertex "+ i + " -> " + distance[i]);
		}
	}

	public static void main(String[] args) {
	    // change as per num of vertices
	    Graph graph = new Graph(6);
//	    graph.addEdge(0, 1, 10);
//	    graph.addEdge(0, 4, 5);
//	    graph.addEdge(1, 2, 30);
//	    graph.addEdge(1, 3, 40);
//	    graph.addEdge(3, 4, 50);
	    
	    //Another graph
	    graph.addEdge(0, 1, 2);
	    graph.addEdge(0, 3, 5);
	    graph.addEdge(1, 2, 3);
	    graph.addEdge(1, 3, 2);
	    graph.addEdge(2, 5, 4);
	    graph.addEdge(3, 4, 3);
	    graph.addEdge(4, 5, 1);
	    
	    graph.displayGraph();
	    
	    Dijkstra obj = new Dijkstra();
	    obj.dijkstra(0, graph);

	}

}
