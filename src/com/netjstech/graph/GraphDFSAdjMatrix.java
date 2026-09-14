package com.netjstech.graph;

import java.util.Stack;

/**
 * Graph DFS traversal (Recursive and Iterative)
 * Adjacency matrix representation
 */
public class GraphDFSAdjMatrix {
	private int numOfVertices;
	private int[][] adjMatrix;
	private boolean[] visited;
	
	// If using separate vertex class then use this array to store Vertex objects
	private Vertex[] vertices;
	int col;
	
	public GraphDFSAdjMatrix(int numOfVertices){
		this.numOfVertices = numOfVertices;
		this.adjMatrix = new int[numOfVertices][numOfVertices];
		this.visited = new boolean[numOfVertices];
		this.vertices = new Vertex[numOfVertices];
	}
	
	public void addVertex(String label) {
		vertices[col++] = new Vertex(label);
	}
	
	public void addEdge(int source, int destination) {
	    if((source < 0 || source > numOfVertices) || (destination < 0 || destination > numOfVertices)) {
	      System.out.println("Invalid edge addition");
	      return;
	    }
	    adjMatrix[source][destination] = 1;
	    // For undirected graph reverse setting also required
	    adjMatrix[destination][source] = 1;
	}
	
	public void displayGraph() {
		for(int i = 0; i < adjMatrix.length; i++) {
	      for(int j = 0; j < adjMatrix[0].length; j++) {
	        System.out.print(adjMatrix[i][j] + " ");
	      }
	      System.out.println();
	    }
	}
	
	// DFS recursive start
	// Recursive Graph traversal
	public void dfsRecursive(int startVertex) {
		vertices[startVertex].visited = true;
		System.out.print(vertices[startVertex].getLabel() + " ");
		for(int i = 0; i < numOfVertices; i++) {
			if(adjMatrix[startVertex][i] == 1 && !vertices[i].visited) {
				dfsRecursive(i);
			}
		}		
	}
	// DFS recursive end
	
	// DFS iterative start
	public void dfsIterative(int startVertex) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(startVertex);
		vertices[startVertex].visited = true;
		
		while(!stack.isEmpty()) {
			int current = stack.pop();
			System.out.print(vertices[current].getLabel() + " ");
			for(int i = 0; i < numOfVertices; i++) {
				if(adjMatrix[current][i] == 1 && !vertices[i].visited) {
					stack.push(i);
					vertices[i].visited = true;
				}
			}
		}
		
	}
	// DFS iterative end
	
	public static void main(String[] args) {
		GraphDFSAdjMatrix graph = new GraphDFSAdjMatrix(10);
		
	    graph.addVertex("A");
	    graph.addVertex("B");
	    graph.addVertex("C");
	    graph.addVertex("D");
	    graph.addVertex("E");
	    graph.addVertex("F");
	    graph.addVertex("G");
	    graph.addVertex("H");
	    graph.addVertex("I");
	    graph.addVertex("J");
	    
	    graph.addEdge(0, 1); //A-B
	    graph.addEdge(0, 2); //A-C
	    graph.addEdge(0, 3); //A-D
	    graph.addEdge(0, 4); //A-E
	    graph.addEdge(1, 5); //B-F
	    graph.addEdge(5, 8); //F-I
	    graph.addEdge(2, 6); //C-G
	    graph.addEdge(4, 7); //E-H
	    graph.addEdge(7, 9); //H-J

	    graph.displayGraph();
	    
//	    System.out.println("DFS Traversal - Recursive ");
//	    graph.dfsRecursive(0);
	    
	    System.out.println("DFS Traversal - Iterative ");
	    graph.dfsIterative(0);
	}

}
