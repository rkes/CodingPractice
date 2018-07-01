package com.general;import javax.swing.event.AncestorEvent;

public class BinaryToDLL {
	public static DLL dllTemp;

	public static void main(String[] args) {

		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(7);
		root.right = new TreeNode(12);
		root.left.left = new TreeNode(5);
		root.left.right = new TreeNode(8);
		root.right.left = new TreeNode(11);
		root.right.right = new TreeNode(13);
		root.right.right.right = new TreeNode(18);
		TreeNode ansc = getLCA2(5, 8, root);
		System.out.println(ansc.val);
		TreeNode anscIter = getLCAIterative(5,8,root);
		System.out.println(anscIter.val);
		// --------------
		TreeNode root2 = new TreeNode(1);
		root2.left = new TreeNode(2);
		root2.right = new TreeNode(2);
		root2.left.left = new TreeNode(4);
		root2.right.right = new TreeNode(3);

		TreeNode root3 = new TreeNode(1);
		root3.left = new TreeNode(2);
		root3.left.left = new TreeNode(3);
		root3.left.right = new TreeNode(4);
		TreeNode root4 = new TreeNode(1);
		root4.left = new TreeNode(2);
		root4.left.left = new TreeNode(3);
		root4.left.right = new TreeNode(4);
		root4.right = new TreeNode(5);
		inOrderTraversal(root4);
		TreeNode root5 = new TreeNode(1);
		root5.left = new TreeNode(2);
		root5.left.left = new TreeNode(6);
		root5.right = new TreeNode(3);
		root5.right.right = new TreeNode(4);
		root5.right.right.right = new TreeNode(5);
		System.out.println(getMinHeight(root5));
		/*
		 * root2.left.left = new TreeNode(13); root2.left.left.left = new
		 * TreeNode(18); root2.left.left.left.left = new TreeNode(28);
		 * root2.right = new TreeNode(7); root2.right.right = new TreeNode(5);
		 * root2.right.left = new TreeNode(8);
		 */
		/*
		 * System.out.println(isMirror(root3,root4)); DLL dll = new DLL(1); DLL
		 * temp = dll;
		 */
		// convertBinaryToDLL(root,temp);
	}

	static TreeNode prev = null;
	static TreeNode root = null;

	public static void inOrderTraversal(TreeNode trNode) {
		if (trNode != null) {
			inOrderTraversal(trNode.left);
			if (prev == null) {
				root = trNode;
			} else
				prev.right = trNode;
			trNode.left = prev;
			prev = trNode;
			inOrderTraversal(trNode.right);
		}
	}

	public static boolean solution(TreeNode root1, TreeNode root2) {
		if ((root1 == null && root2 != null) || (root2 == null && root1 != null))
			return false;
		if (root1 == null && root2 == null)
			return true;

		return (root1.val == root2.val) && solution(root1.left, root2.left) && solution(root1.right, root2.right);
	}

	static class DLL {
		DLL left;
		int val;

		DLL(int val) {
			this.val = val;
		}

		DLL right;
	}

	public static void convertBinaryToDLL(TreeNode root, DLL temp) {
		if (root != null) {
			convertBinaryToDLL(root.left, temp);
			// System.out.println(root.val);
			if (dllTemp == null)
				dllTemp = new DLL(root.val);
			else {
				dllTemp.left = new DLL(root.val);
				dllTemp = dllTemp.left;
			}
			convertBinaryToDLL(root.right, temp);
		}

	}

	public static boolean isSymetrical(TreeNode root1, TreeNode root2) {
		if (root1 == null && root2 == null)
			return true;
		if (root1 == null || root2 == null)
			return false;
		return (root1.val == root2.val) && isSymetrical(root1.left, root2.right)
				&& isSymetrical(root1.right, root2.left);
	}

	public static boolean isMirror(TreeNode root1, TreeNode root2) {
		if (root1 == null && root2 == null)
			return true;
		if (root1 == null || root2 == null)
			return false;
		return (root1.val == root2.val) && isMirror(root1.left, root2.right) && isMirror(root1.right, root2.left);
	}

	public static Integer getMinHeight(TreeNode trNode) {
		if (trNode == null)
			return 0;
		if (trNode.left == null && trNode.right == null)
			return 1;
		Integer left = getMinHeight(trNode.left);
		Integer right = getMinHeight(trNode.right);
		if (left > right)
			return right + 1;
		return left + 1;
	}

	public static TreeNode getLCA(int data1, int data2, TreeNode node) {
		if (node == null)
			return null;
		else {
			if (node.val == data1 || node.val == data2)
				return node;
			else {
				TreeNode leftRoot = getLCA(data1, data2, node.left);
				TreeNode rightRoot = getLCA(data1, data2, node.right);
				if (leftRoot != null && rightRoot != null)
					return root;
				else {
					if (leftRoot == null)
						return rightRoot;
					return leftRoot;
				}
			}
		}
	}
	public static TreeNode getLCA2(int leftData,int rightData , TreeNode root){
		if(root == null)
			return null;
		if(root.val > leftData && root.val>rightData)
			return getLCA2(leftData,rightData,root.left);
		if(root.val < leftData && root.val<rightData)
			return getLCA2(leftData,rightData,root.right);
		return root;
	}
	public static TreeNode getLCAIterative(int leftData,int rightData , TreeNode root){
		while(root!=null){
			if(root.val > leftData && root.val > rightData)
				root = root.left;
			else if(root.val < leftData && root.val<rightData)
				root = root.right;
			else
				break;
		}
		return root;
	}
	
}
