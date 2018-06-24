package com.general;

public class InvertBinaryTree {

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
		TreeNode temp = trNode, temp1 = trNode;
		inOrder(temp);
		System.out.println("\n--------------------------------------");
		//TreeNode trNodeRev = invert(temp1);
		//inOrder(trNodeRev);
		System.out.println(getMaxHeight(temp));
	}

	public static void inOrder(TreeNode trNode) {
		if (trNode != null) {
			inOrder(trNode.left);
			System.out.printf("%d   ", trNode.val);
			inOrder(trNode.right);
		}
	}
	public static Integer getMaxHeight(TreeNode trNode){
		if(trNode == null) return 0;
		return Math.max(getMaxHeight(trNode.left),getMaxHeight(trNode.right))+1;
	}
	public static TreeNode invert(TreeNode trNode) {
		if (trNode == null)
			return null;
		TreeNode right = invert(trNode.right);
		TreeNode left = invert(trNode.left);
		trNode.right = left;
		trNode.left = right;
		return trNode;
	}
}
