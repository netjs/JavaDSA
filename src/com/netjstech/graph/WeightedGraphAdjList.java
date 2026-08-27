package com.netjstech.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeightedGraphAdjList {
	private int vertices;
	private Map<String, List<Edge>> adjListMap;
	// Edge class
	static class Edge{
		private String destination;
		private int weight;
		Edge(String destination, int weight){
			this.destination = destination;
			this.weight = weight;
		}
		public String getDestination() {
			return destination;
		}
		public int getWeight() {
			return weight;
		}
		
	}
	
	//Constructor
	public WeightedGraphAdjList(int vertices){
		this.vertices = vertices;
		adjListMap = new HashMap<String, List<Edge>>();
	}
	
	public void addEdge(String source, String destination, int weight) {
		adjListMap.computeIfAbsent(source, k-> new ArrayList<Edge>()).add(new Edge(destination, weight));
		// For undirected graph (For directed graph comment this line)
		//adjListMap.computeIfAbsent(destination, k-> new ArrayList<Edge>()).add(new Edge(source, weight));
	}
	
	public void displayGraph() {
		for(Map.Entry<String, List<Edge>> e : adjListMap.entrySet()) {
			System.out.print(e.getKey() + " -> ");
			for(Edge edge : e.getValue()) {
				System.out.print("[" + edge.getDestination() + ", " + edge.getWeight() + "] ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		WeightedGraphAdjList graph = new WeightedGraphAdjList(5);
		graph.addEdge("A", "B", 5);
		graph.addEdge("A", "C", 10);
		graph.addEdge("A", "E", 7);
		graph.addEdge("C", "D", 15);
		graph.addEdge("D", "E", 8);
		
		graph.displayGraph();
	}

}
