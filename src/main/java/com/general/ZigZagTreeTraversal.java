package com.general;

import java.util.ArrayList;
import java.util.List;

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
		trNode.right.left.right = new TreeNode(12);
		trNode.right.left.left = new TreeNode(12);
		// printZigZag(trNode);
		/*
		 * System.out.println("55 : " + checkPathSum(trNode, 55));
		 * System.out.println("28 : " + checkPathSum(trNode, 28));
		 * System.out.println("26 : " + checkPathSum(trNode, 26));
		 * System.out.println("41 : " + checkPathSum(trNode, 41));
		 * System.out.println("50 : " + checkPathSum(trNode, 50));
		 * System.out.println("52 : " + checkPathSum(trNode, 52));
		 * System.out.println("53 : " + checkPathSum(trNode, 53));
		 */
		// System.out.println("0 : " + checkPathSum(null, 0,0) + " " +
		// haspathSum(null, 0));
		printPath(trNode, 50, 0, new ArrayList<>(), new ArrayList<>());
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
				System.out.printf("%d   ", trNode.val);
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

	public static boolean checkPathSum(TreeNode trNode, int sum, int cnt) {
		if (trNode == null) {
			return sum == 0;
		} else {
			if (trNode.left == null && trNode.right == null && sum == cnt) {
				return true;
			}
			return checkPathSum(trNode.left, sum, cnt + trNode.val)
					|| checkPathSum(trNode.right, sum, cnt + trNode.val);
		}
	}
	static List<List<Integer>>pathSum(TreeNode root, int sum){
		 List<List<Integer>> result = new ArrayList<List<Integer>>();
		 printPath(root,sum,0,result,new ArrayList<>());
		 return result;
	}
	static void printPath(TreeNode node, int sum, int cnt, List<List<Integer>> result, List<Integer> path) {
		if (node == null) {
			return;
		}
		if (node.left==null && node.right==null && node.val+cnt == sum) {
			path.add(node.val);
			System.out.println(path);
			path.remove(path.size() - 1);
			return;
		}
		path.add(node.val);
		printPath(node.left, sum, cnt + node.val, result,path);
		printPath(node.right, sum, cnt + node.val, result, path);
		path.remove(path.size() - 1);
	}

	static boolean haspathSum(TreeNode node, int sum) {
		if (node == null)
			return (sum == 0);
		else {
			boolean ans = false;

			/* otherwise check both subtrees */
			int subsum = sum - node.val;
			if (subsum == 0 && node.left == null && node.right == null)
				return true;
			if (node.left != null)
				ans = ans || haspathSum(node.left, subsum);
			if (node.right != null)
				ans = ans || haspathSum(node.right, subsum);
			return ans;
		}
	}
}
