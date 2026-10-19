package com.netjstech.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class to represent a Graph
 */
public class Graph {
	private final Map<Integer, List<Edge>> adjListMap;
	private int vertices;

	public Graph(int vertices) {
		this.vertices = vertices;
		this.adjListMap = new HashMap<>();
	}

	static class Edge implements Comparable<Edge> {
		int node, weight;

		Edge(int node, int weight) {
			this.node = node;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}

	public void addEdge(int source, int destination, int weight) {

		adjListMap.computeIfAbsent(source, k -> new ArrayList<>()).add(new Edge(destination, weight));
		// For undirected graph
		adjListMap.computeIfAbsent(destination, k -> new ArrayList<>()).add(new Edge(source, weight));
	}

	void displayGraph() {
		adjListMap.forEach((vertex, edges) -> {
			System.out.print("Vertex " + vertex + " connects to: ");
			edges.forEach(e -> System.out.print("[" + e.node + " with weight " + e.weight + "] "));
			System.out.println();
		});
	}

	public int getVertices() {
		return vertices;
	}

	public Map<Integer, List<Edge>> getAdjListMap() {
		return adjListMap;
	}
}
