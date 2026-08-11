package com.netjstech.tree.bst;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

import com.netjstech.tree.bst.BinaryTree.Node;

public class TreePanelBinary extends JPanel {
	    private BinaryTree bst;


	    
	    public TreePanelBinary(BinaryTree bst) {
	        this.bst = bst;
	    }
	    @Override
	    protected void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        if (bst.root != null) {
	            drawNode(g, bst.root, getWidth() / 2, 30, getWidth() / 6);
	        }
	    }

	    private void drawNode(Graphics g, Node node, int x, int y, int xOffset) {
	        if (node == null) {
	            return;
	        }
	        Font boldFont = new Font("SansSerif", Font.BOLD, 16);
	        // Draw node (circle and data)
	        g.setColor(Color.BLUE);
	        g.setFont(boldFont);
	        g.fillOval(x - 12, y - 15, 30, 30);
	        g.setColor(Color.WHITE);
	        g.drawString(String.valueOf(node.value), x - 5, y + 5);

	        // Draw left child and line
	        if (node.left != null) {
	            g.setColor(Color.BLACK);
	            g.drawLine(x, y + 15, x - xOffset, y + 65); // Line from parent to child
	            drawNode(g, node.left, x - xOffset, y + 80, xOffset / 2); // Recurse for left child
	        }

	        // Draw right child and line
	        if (node.right != null) {
	            g.setColor(Color.BLACK);
	            g.drawLine(x, y + 15, x + xOffset, y + 65); // Line from parent to child
	            drawNode(g, node.right, x + xOffset, y + 80, xOffset / 2); // Recurse for right child
	        }
	    }
}