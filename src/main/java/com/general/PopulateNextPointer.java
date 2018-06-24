package com.general;

import java.util.ArrayList;
import java.util.List;

public class PopulateNextPointer {

	public static void main(String[] args) {
		TreeLinkNode trNode = new TreeLinkNode(10);
		trNode.left = new TreeLinkNode(7);
		trNode.left.left = new TreeLinkNode(6);
		trNode.left.right = new TreeLinkNode(9);
		trNode.left.left.left = new TreeLinkNode(5);
		trNode.right = new TreeLinkNode(15);
		trNode.right.left = new TreeLinkNode(13);
		trNode.right.right = new TreeLinkNode(16);
		trNode.right.left.right = new TreeLinkNode(14);
		trNode.right.left.left = new TreeLinkNode(12);
		connect(trNode);
	}

	public static void connect(TreeLinkNode root) {
		int height = getHeight(root);
		for (int i = 0; i <= height; i++) {
			List<TreeLinkNode> lstTreeNode = new ArrayList<>();
			levelOrderTraverse(root, i, 0, lstTreeNode);
			connectNodes(lstTreeNode);
			//System.out.println();
		}
		for (int i = 0; i <= height; i++) {
			System.out.println("\n\n");
			levelOrderTraversal(root,i,0);
		}
	}

	public static void connectNodes(List<TreeLinkNode> lstTreeNodes) {
		for (int i = 1; i < lstTreeNodes.size(); i++) {
			TreeLinkNode trNodeOne = lstTreeNodes.get(i - 1);
			TreeLinkNode trNodeNext = lstTreeNodes.get(i);
			trNodeOne.next = trNodeNext;
		}
	}

	public static void levelOrderTraverse(TreeLinkNode root, int height, int hCnt, List<TreeLinkNode> lstTreeNode) {
		if (root == null)
			return;
		if (height == hCnt) {
			lstTreeNode.add(root);
		}
		levelOrderTraverse(root.left, height, hCnt + 1, lstTreeNode);
		levelOrderTraverse(root.right, height, hCnt + 1, lstTreeNode);
	}

	public static void levelOrderTraversal(TreeLinkNode root, int height, int hCnt) {
		if (root == null)
			return;
		if (height == hCnt) {
			TreeLinkNode temp = root;
			while (temp.next != null){
				System.out.printf("%d    ", temp.val);
				temp = temp.next;
			}
		}
		levelOrderTraversal(root.left, height, hCnt + 1);
		levelOrderTraversal(root.right, height, hCnt + 1);
	}

	public static Integer getHeight(TreeLinkNode trLinkNode) {
		if (trLinkNode == null)
			return 0;
		return Math.max(getHeight(trLinkNode.left), getHeight(trLinkNode.right)) + 1;
	}

	static class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;

		TreeLinkNode(int x) {
			val = x;
		}
	}
}
