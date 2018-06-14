package com.general;

public class BuildTreeFromSortedArray {

	public static void main(String[] args) {
		
		int arr[] = new int[]{1, 2, 3, 4, 5, 6, 7};
        int n = arr.length;
        TreeNode root = buildTree(arr, 0, n - 1);
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
	public static TreeNode buildTree(int []ar,int start,int end){
		if(start>end)
			return null;
		int mid = (start+end)/2;
		int elem = ar[mid];
		TreeNode node = new TreeNode(elem);
		node.left = buildTree(ar,start,mid-1);
		node.right = buildTree(ar,mid+1,end);
		return node;
	}
}
