package com.general;

import java.util.ArrayList;
import java.util.Stack;

public class InOrderTraversal {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);root.right.right = new TreeNode(7);
		root.right.right.left = new TreeNode(8);root.right.right.right = new TreeNode(9);
		System.out.println(inorderTraversal(root));
	}
	 public static ArrayList<Integer> inorderTraversal(TreeNode a) {  
		 ArrayList<Integer> lst  = new ArrayList<Integer>();
		 Stack<TreeNode> stck = new Stack<>();
		 TreeNode node = a;
		 while(!stck.isEmpty() || node!=null){
			if(node!=null){
				stck.push(node);
				node = node.left;
			}
			else{
				if(stck.isEmpty()) break;
				node = stck.pop();
				if(node == null)
					continue;
				lst.add(node.val);
				node = node.right;
			}
		 }
		 return lst;
	 }
}
