package com.general;

import java.util.Stack;

public class BSTIterator {
	Stack<TreeNode> stck = new Stack<TreeNode>();
	public BSTIterator(TreeNode node){
		addALL(node);
	}
	public TreeNode next(){
		TreeNode temp  = stck.pop();
		TreeNode nde = temp;
		if(nde.right!=null){
			nde = nde.right;
			addALL(nde);
		}
		return temp;
	}
	public boolean hasNext(){
		return !stck.isEmpty();
	}
	public void addALL(TreeNode node){
		while(node!=null){
			stck.push(node);
			node = node.left;
		}
	}
	public static void main(String[] args) {
		TreeNode trNode = new TreeNode(10);
		trNode.left = new TreeNode(7);
		trNode.left.left = new TreeNode(6);
		trNode.left.right = new TreeNode(9);
		trNode.left.left.left = new TreeNode(5);
		trNode.right = new TreeNode(15);
		trNode.right.left = new TreeNode(13);
		trNode.right.right = new TreeNode(16);
		trNode.right.left.right = new TreeNode(14);
		trNode.right.left.left = new TreeNode(12);
		BSTIterator bstIterator = new BSTIterator(trNode);
		while(bstIterator.hasNext()){
			System.out.println(bstIterator.next().val);
		}
		//System.out.println();
	}

}
