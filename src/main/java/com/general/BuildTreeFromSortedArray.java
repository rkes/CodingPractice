package com.general;

import java.util.ArrayList;

public class BuildTreeFromSortedArray {

	public static void main(String[] args) {
		
		int arr[] = new int[]{1, 2, 3, 4, 5, 6, 7};
        int n = arr.length;
        ArrayList<Integer> lst = new ArrayList<Integer>();
        for(int i=0;i<n;i++)
        	lst.add(arr[i]);
        TreeNode root = buildTree(lst, 0, lst.size()-1);
        System.out.println();
        inorderTravsersal(root);
        System.out.println();
        postorderTravsersal(root);
        System.out.println();
	}
	public static void inorderTravsersal(TreeNode node){
		if(node!=null){
			inorderTravsersal(node.left);
			System.out.printf("%d\t",node.val);
			inorderTravsersal(node.right);
		}
	}
	public static void postorderTravsersal(TreeNode node){
		if(node!=null){
			inorderTravsersal(node.left);
			inorderTravsersal(node.right);
			System.out.printf("%d\t",node.val);
		}
	}
	public static TreeNode buildTree(ArrayList<Integer> lst,int start,int end){
		if(start>end)
			return null;
		int mid = (start+end)/2;
		int elem = lst.get(mid);
		TreeNode node = new TreeNode(elem);
		node.left = buildTree(lst,start,mid-1);
		node.right = buildTree(lst,mid+1,end);
		return node;
	}
}
