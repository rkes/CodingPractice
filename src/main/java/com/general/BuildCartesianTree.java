package com.general;

import java.util.ArrayList;

public class BuildCartesianTree {

	public static void main(String[] args) {
		int []ar={9,3,1,7};
		TreeNode node = build(ar,0,ar.length-1);
		inOrderTraversal(node);
		ArrayList<Integer> A = new ArrayList<Integer>();
		System.out.println();
	}

	public static TreeNode build(int[] ar, int low, int high) {
		if (low > high)
			return null;
		int val = Integer.MAX_VALUE;
		int idx = -1;
		for(int i=low;i<=high;i++){
			if(ar[i] < val){
				val = ar[i];
				idx = i;
			}
		}
		TreeNode node = new TreeNode(val);
		node.left = build(ar,low,idx-1);
		node.right = build(ar,idx+1,high);
		return node;
	}
	public static void inOrderTraversal(TreeNode node){
		if(node !=null){
			inOrderTraversal(node.left);
			System.out.printf("%d   ",node.val);
			inOrderTraversal(node.right);
		}
	}
}
