package com.general;

import java.util.Stack;

/*
 * Push all nodes to stack in reverse order i.e. push right most of every node , and pop it one by one 
 * and connect them by assigning right to stack top element and assign previous pointer i.e. left to null 
 * */
public class TreeToDLLByStack {

	public static void main(String[] args) {
		TreeNode trNode = new TreeNode(1);
		trNode.left = new TreeNode(2);
		trNode.left.left = new TreeNode(4);
		trNode.left.right = new TreeNode(5);
		trNode.right = new TreeNode(3);
		trNode.right.right = new TreeNode(7);
		trNode.right.left = new TreeNode(6);
		Stack<TreeNode> stck = new Stack<>();
		TreeNode temp2 = trNode;
		populateStack(stck, temp2);
		TreeNode root = stck.pop();
		TreeNode temp = root;
		while(!stck.isEmpty()){
			root.right = stck.pop();
			root.left = null;
			root = root.right;
		}
		root.left = null;
		root.right = null;
		System.out.println();
	}
	public static void populateStack(Stack<TreeNode> stck,TreeNode node){
		if(node==null)
			return ;
		populateStack(stck, node.left);
		populateStack(stck, node.right);
		stck.push(node);
	}

}
