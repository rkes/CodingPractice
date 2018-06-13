package com.general;

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
		//--------------
		TreeNode root2 = new TreeNode(1);
		root2.left = new TreeNode(2);
		root2.right = new TreeNode(2);
		root2.left.left = new TreeNode(4);
		root2.right.right = new TreeNode(3);
		
		TreeNode root3  = new TreeNode(1);
		root3.left = new TreeNode(2);
		root3.left.left = new TreeNode(3);
		root3.left.right = new TreeNode(4);
		TreeNode root4  = new TreeNode(1);
		root4.right = new TreeNode(2);
		root4.right.right = new TreeNode(3);
		root4.right.left = new TreeNode(4);
		/*root2.left.left = new TreeNode(13);
		root2.left.left.left = new TreeNode(18);
		root2.left.left.left.left = new TreeNode(28);
		root2.right = new TreeNode(7);
		root2.right.right = new TreeNode(5);
		root2.right.left = new TreeNode(8);*/
		System.out.println(isMirror(root3,root4));
		DLL dll = new DLL(1);
		DLL temp = dll;
		//convertBinaryToDLL(root,temp);
	}
	public static boolean solution(TreeNode root1,TreeNode root2){
		if( (root1==null&& root2!=null) || (root2==null && root1!=null ))
			return false;
		if(root1==null && root2==null)
			return true;
		
		return (root1.val==root2.val) && solution(root1.left,root2.left) && solution(root1.right,root2.right);
	}
	static class DLL {
		DLL left;
		int val;
		DLL(int val){
			this.val = val;
		}
		DLL right;
	}
	
	public static void convertBinaryToDLL(TreeNode root,DLL temp){
		if(root!=null){
			convertBinaryToDLL(root.left,temp);
			//System.out.println(root.val);
			if(dllTemp == null)
				dllTemp = new DLL(root.val);
			else{
				dllTemp.left = new DLL(root.val);
				dllTemp= dllTemp.left;
			}
			convertBinaryToDLL(root.right,temp);
		}
		
	}
	public static boolean isSymetrical(TreeNode root1 , TreeNode root2){
		if(root1==null && root2==null)
			return true;
		if(root1==null || root2==null)
			return false;
		return (root1.val == root2.val) && isSymetrical(root1.left, root2.right)&&isSymetrical(root1.right, root2.left);
	}
	public static boolean isMirror(TreeNode root1 , TreeNode root2){
		if(root1==null && root2==null)
			return true;
		if( root1==null || root2==null)
			return false;
		return (root1.val ==root2.val) && isMirror(root1.left, root2.right) && isMirror(root1.right, root2.left);
	}
}
