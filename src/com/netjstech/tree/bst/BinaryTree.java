package com.netjstech.tree.bst;

import java.util.List;

import javax.swing.JFrame;

public class BinaryTree {
	  // first node
	  Node root;
	  BinaryTree(){
	    root = null;
	  }
	  // Class representing tree nodes
	  static class Node{
	    int value;
	    Node left;
	    Node right;
	    Node(int value){
	      this.value = value;
	      left = null;
	      right = null;        
	    }
	    public void displayData(){
	      System.out.print(value + " ");
	    }
	  }
	    
	  public void insert(int i){
	    root = insert(root, i);
	  }
	    
	  //Inserting node - recursive method
	  public Node insert(Node node, int value){
	    if(node == null){
	      return new Node(value);
	    }
	    // Move to the left if passed value is 
	    // less than the current node
	    if(value < node.value){
	      node.left = insert(node.left, value);
	    }
	    // Move to the right if passed value is 
	    // greater than the current node
	    else if(value > node.value){
	      node.right = insert(node.right, value);
	    }
	    return node;
	  }
	  
	  public static void main(String[] args) {

		    BinaryTree bst = new BinaryTree();
		    //int[] data = {30, 20, 25, 10, 35, 5};
		    //int[] data = {30, 10, 20};
		    //int[] data = {10, 30, 20};
		    //int[] data = {20, 30, 15, 25, 40, 45};
		    int[] data = {9, 5, 10, 0, 6, 11, -1, 1, 2};
		    for(int d : data) {
		    		bst.insert(d);
			}

		    // for showing the tree
			JFrame frame = new JFrame("Binary Search Tree Visualization");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setSize(800, 600);
	        frame.add(new TreePanelBinary(bst));
	        frame.setVisible(true);
		   
	  }
}

