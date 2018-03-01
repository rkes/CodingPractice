package com.tree;

public class AVLNode {
	AVLNode left;
	AVLNode right;
	int data;
	int height;
	int max = Integer.MIN_VALUE;
	int min = Integer.MAX_VALUE;;
	public AVLNode(int data){
		this.data = data;
		this.height = 1;
	}
	public void setMax(int max){
		this.max = max;
	}
	public void setMin(int min){
		this.min = min;
	}
}
