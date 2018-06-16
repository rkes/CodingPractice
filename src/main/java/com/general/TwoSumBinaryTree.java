package com.general;

import java.util.HashSet;

public class TwoSumBinaryTree {

	public static void main(String[] args) {
		/*
		 * TreeNode root = new TreeNode(3); root.left = new TreeNode(1);
		 * root.left.right = new TreeNode(2); root.right = new TreeNode(4);
		 */
		int sum = 4;
		int[] ar = { 2, 1, 3 };
		TreeNode root = null;
		for (Integer x : ar) {
			root = buildTree(x, root);
		}
		// inOrderTraversal(root);
		System.out.println(find(root, sum));
		System.out.println();
	}

	public static void inOrderTraversal(TreeNode node) {
		if (node != null) {
			inOrderTraversal(node.left);
			System.out.printf("%d   ", node.val);
			inOrderTraversal(node.right);
		}
	}

	public static TreeNode buildTree(int num, TreeNode node) {
		if (node == null)
			return new TreeNode(num);
		if (node.val > num) {
			node.left = buildTree(num, node.left);
		} else
			node.right = buildTree(num, node.right);
		return node;
	}

	static HashSet<Integer> set	 = new HashSet<Integer>();

	public static boolean find(TreeNode root, int k) {
		if (root == null)
			return false;
		Integer value = k - root.val;
		if (set.contains(value))
			return true;
		set.add(root.val);
		return find(root.left, k) || find(root.right, k);
	}
}
