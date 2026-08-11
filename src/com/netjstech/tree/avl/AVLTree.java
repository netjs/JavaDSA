package com.netjstech.tree.avl;

import javax.swing.JFrame;

import com.netjstech.tree.bst.TreePanelBinary;

public class AVLTree {
	// root node
	Node root;
	AVLTree(){
		this.root = null;
	}
	
	static class Node{
		Node left;
		Node right;
		int data;
		int height;
		Node(int data){
			this.data = data;
			this.height = 1;
		}
		public void displayData(){
			System.out.print(data + " ");
		}
	}
	
	public void insert(int data) {
		root = insert_recur(root, data);
	}
	
	public Node insert_recur(Node node, int data){
		if(node == null) {
			return new Node(data);
		}
		if(data < node.data) {
			node.left = insert_recur(node.left, data);
		}else if (data > node.data) {
			node.right = insert_recur(node.right, data);
		}else {
			return node;
		}
		
		// rebalance
		node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
		return balanceNode(node);
	}
	
	// getting the node height
	public int getHeight(Node node) {
		return node == null ? 0 : node.height;
	}
	
	public int getBalanceFactor(Node node) {
		return node == null ? 0 : (getHeight(node.left) - getHeight(node.right));
	}
	
	public Node balanceNode(Node node) {
		int balance = getBalanceFactor(node);
		//LL Scenario
		if(balance > 1 && getBalanceFactor(node.left) >= 0) {
			return rightRotate(node);
		}
		// RR Scenario
		if(balance < -1 && getBalanceFactor(node.right) <= 0) {
			return leftRotate(node);
		}
		// LR Scenario
		if(balance > 1 && getBalanceFactor(node.left) < 0) {
			node.left = leftRotate(node.left);
			return rightRotate(node);
		}
		// RL Scenario
		if(balance < -1 && getBalanceFactor(node.right) > 0) {
			node.right = rightRotate(node.right);
			return leftRotate(node);
		}
		return node;
	}
	
	public Node rightRotate(Node node) {
		System.out.println("Right rotate around " + node.data);
		Node temp1 = node.left;
		Node temp2 = temp1.right;
		
		temp1.right = node;
		node.left = temp2;
		
		node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
		temp1.height = 1 + Math.max(getHeight(temp1.left), getHeight(temp1.right));
		return temp1;
	}
	
	public Node leftRotate(Node node) {
		System.out.println("Left rotate around " + node.data);
		Node temp1 = node.right;
		Node temp2 = temp1.left;
		
		temp1.left = node;
		node.right = temp2;
		
		node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
		temp1.height = 1 + Math.max(getHeight(temp1.left), getHeight(temp1.right));
		return temp1;
	}
	
	//In order traversal
	public void inOrder(Node node) {
		if (node != null) {
			inOrder(node.left);
			node.displayData();
			inOrder(node.right);
		}
	}

	// Preorder traversal
	public void preOrder(Node node) {
		if (node != null) {
			node.displayData();
			preOrder(node.left);
			preOrder(node.right);
		}
	}

	// Postorder traversal
	public void postOrder(Node node) {
		if (node != null) {
			postOrder(node.left);
			postOrder(node.right);
			node.displayData();
		}
	}
	
	public Node search(int searchedValue) {
		Node current = root;
		while(current.data != searchedValue) {
			if(searchedValue < current.data) {
				current = current.left;
			}else {
				current = current.right;
			}
			if(current == null) {
				return null;
			}
		}
		return current;
	}
	public static void main(String[] args) {
		AVLTree avlTree = new AVLTree();
		//int[] arr = {30, 20, 25, 10, 5, 35};
		//int[] arr = {20, 30, 40, 45, 25, 15};
		//int[] arr = {30, 10, 20};
		int[] arr = {9, 5, 10, 0, 6, 11, -1, 1, 2, 15, 16};
		//int[] arr = {10, 30, 20};
		for(int n : arr) {
			avlTree.insert(n);
		}
		
		System.out.println("Inorder Traversal");
		
		avlTree.inOrder(avlTree.root);
		System.out.println("");
		
		System.out.println("Preorder Traversal");
		avlTree.preOrder(avlTree.root);
		System.out.println("");
		
		System.out.println("Postorder Traversal");
		avlTree.postOrder(avlTree.root);
		System.out.println("");
		
		Node sn = avlTree.search(2);
		System.out.println(sn == null ? "Node not found" : "Node found with data "+sn.data);
		JFrame frame = new JFrame("AVL Tree Visualization");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.add(new TreePanel(avlTree));
        frame.setVisible(true);

	}

}
