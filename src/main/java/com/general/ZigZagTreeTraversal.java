package com.general;

public class ZigZagTreeTraversal {

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
		printZigZag(trNode);
	}

	public static Integer getHeightofTree(TreeNode trNode) {
		if (trNode == null)
			return 0;
		return Math.max(getHeightofTree(trNode.left), getHeightofTree(trNode.right)) + 1;
	}

	public static void printZigZag(TreeNode trNode) {
		int height = getHeightofTree(trNode);
		boolean left = true;
		for (int i = 0; i <= height; i++) {
			System.out.println();
			printZigZagAux(trNode, left, i, 0);
			left = !left;
		}
	}

	public static void printZigZagAux(TreeNode trNode, boolean left, int height, int hcnt) {
		if (trNode != null) {
			if (height == hcnt) {
				System.out.printf("%d   ",trNode.val);
			}
			if (left) {
				printZigZagAux(trNode.left, left, height, hcnt + 1);
				printZigZagAux(trNode.right, left, height, hcnt + 1);

			} else if (!left) {
				printZigZagAux(trNode.right, left, height, hcnt + 1);
				printZigZagAux(trNode.left, left, height, hcnt + 1);
			}
		}

	}
}
