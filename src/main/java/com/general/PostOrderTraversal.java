package com.general;

import java.util.ArrayList;
import java.util.Stack;

public class PostOrderTraversal {

	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);root.right.right = new TreeNode(7);
		root.right.right.left = new TreeNode(8);root.right.right.right = new TreeNode(9);
		System.out.println(preOrderTraversal(root));
	}
	public static ArrayList<Integer> postOrderTraversal(TreeNode a) {  
		ArrayList<Integer> res = new ArrayList<Integer>();
		Stack<TreeNode> stckOne = new Stack<>();
		Stack<TreeNode> stckTwo = new Stack<>();
		TreeNode node = a;
		stckOne.push(node);
		while(!stckOne.isEmpty() ){
			node = stckOne.pop();
			if(node!=null){
				if(node.left!=null)
					stckOne.push(node.left);
				if(node.right!=null)
					stckOne.push(node.right);
				stckTwo.push(node);
			}
			
		}
		while(!stckTwo.isEmpty()){
			res.add(stckTwo.pop().val);
		}
		return res;
	}
	public static ArrayList<Integer> preOrderTraversal(TreeNode a){
		ArrayList<Integer> res = new ArrayList<Integer>();
		Stack<TreeNode> stck = new Stack<>();
		stck.push(a);
		while(!stck.isEmpty()){
			TreeNode temp = stck.pop();
			res.add(temp.val);
			if(temp.right!=null)
				stck.push(temp.right);
			if(temp.left!=null)
				stck.push(temp.left);
		}
		return res;
	}
}
