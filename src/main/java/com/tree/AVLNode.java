package com.tree;

public class AVLNode {
	AVLNode left;
	AVLNode right;
	int data;
	int height;
	public AVLNode(int data){
		this.data = data;
		this.height = 1;
	}
}
