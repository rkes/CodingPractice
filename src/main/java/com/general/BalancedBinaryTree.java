package com.general;

public class BalancedBinaryTree {

	public static void main(String[] args) {
		TreeNode node = new TreeNode(3);
		//node.left = new TreeNode(9);
		node.right = new TreeNode(20);
		//node.right.left = new TreeNode(15);
		node.right.right = new TreeNode(7);
		System.out.println(isBalanced(node));
		//System.out.println(getHeightofTree(node.right));
	}
	public static boolean isBalanced(TreeNode node){
		if( node == null)
			return true;
		int left = getHeightofTree(node.left);
		int right = getHeightofTree(node.right);
		if( Math.abs(left - right) >= 2)
			return false;
		return isBalanced(node.left) && isBalanced(node.right);
	}
	public static int getHeightofTree(TreeNode node){
		if( node == null) return 0;
		return Math.max(getHeightofTree(node.left),getHeightofTree(node.right))+1;
	}
}
