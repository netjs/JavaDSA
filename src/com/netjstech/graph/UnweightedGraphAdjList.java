package com.netjstech.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UnweightedGraphAdjList {
	private int vertices;
	private Map<String, List<String>> adjListMap;
	
	public UnweightedGraphAdjList(int vertices){
		this.vertices = vertices;
		adjListMap = new HashMap<String, List<String>>();
	}
	
	public void addEdge(String source, String destination) {
		adjListMap.computeIfAbsent(source, k -> new ArrayList<String>()).add(destination);
		// For undirected graph (For directed graph Comment it)
		//adjListMap.computeIfAbsent(destination, k -> new ArrayList<String>()).add(source);
	}
	
	public void displayGraph() {
		for(Map.Entry<String, List<String>> e : adjListMap.entrySet()) {
			System.out.print(e.getKey() + "-> ");
			for(String s : e.getValue()) {
				System.out.print("[" + s + "] ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		UnweightedGraphAdjList obj = new UnweightedGraphAdjList(5);
		obj.addEdge("A", "B");
		obj.addEdge("A", "C");
		obj.addEdge("A", "E");
		obj.addEdge("C", "D");
		obj.addEdge("D", "E");
	
		obj.displayGraph();
	}

}
