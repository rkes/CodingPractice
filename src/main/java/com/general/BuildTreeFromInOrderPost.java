package com.general;

public class BuildTreeFromInOrderPost {
	static Integer index = 0;
	public static void main(String[] args) {
		int []inOderar={1};
		int []postOderar={1} ;
		index = postOderar.length-1;
		TreeNode node = build(inOderar,postOderar,0,inOderar.length-1);
		printInOrder(node);
	}
	public static void printInOrder(TreeNode node){
		if(node != null){
			printInOrder(node.left);
			System.out.println(node.val);
			printInOrder(node.right);
		}
	}
	public static TreeNode build(int []inOrderAr,int []postOrderAr,int start,int end){
		if(start > end) return null;
		int elem = postOrderAr[index--];
		int idx = search(inOrderAr,start,end,elem);	
		TreeNode trNode = new TreeNode(elem);
		trNode.right = build(inOrderAr, postOrderAr, idx+1,end);
		trNode.left = build(inOrderAr, postOrderAr, start, idx-1);
		return trNode;
	}
	public static Integer search(int []inOrderAr,int start,int end,int key){
		for(int i=start;i<end;i++){
			if(inOrderAr[i] == key)
				return i;
		}
		return start;
	}

}
