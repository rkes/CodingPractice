package com.general;

import java.util.Stack;

public class KthMinimumInTree {

	public static void main(String[] args) {
		/*TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.left.right.right = new TreeNode(7);
		root.left.left.left = new TreeNode(1);
		root.right = new TreeNode(15);
		root.right.left = new TreeNode(12);
		root.right.left.left = new TreeNode(11);
		root.right.right = new TreeNode(16);*/
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(1);
		root.left.right = new TreeNode(2);
		root.right = new TreeNode(4);	
		// inOrderTraversal(root);
		TreeNode elem = getKthSmallest(root, 1);
		if(elem!=null)
			System.out.println(elem.val);
	}

	public static void inOrderTraversal(TreeNode node) {
		if (node != null) {
			inOrderTraversal(node.left);
			System.out.printf("%d \t", node.val);
			inOrderTraversal(node.right);
		}
	}

	public static TreeNode getKthSmallest(TreeNode node, int k) {
		TreeNode temp = node;
		Stack<TreeNode> stck = new Stack<>();
		while (temp != null) {
			stck.push(temp);
			temp = temp.left;
		}
		int cnt = 1;
		while (!stck.isEmpty() && cnt < k) {
			TreeNode nde = stck.pop();
			if (nde.right != null) {
				nde = nde.right;
				while(nde!=null){
					stck.push(nde);
					nde = nde.left;
				}
			}
			cnt++;
		}
		return stck.peek();
	}
}
