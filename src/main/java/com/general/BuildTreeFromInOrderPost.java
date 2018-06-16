package com.general;

public class BuildTreeFromInOrderPost {
	static Integer index = 0;
	public static void main(String[] args) {
		int []inOderar={1};
		int []postOderar={1} ;
		index = 0;;
	    
        int in[] = new int[]{9, 8, 4, 2, 10, 5, 10, 1, 6, 3, 13, 12, 7};
        int pre[] = new int[]{1, 2, 4, 8, 9, 5, 10, 10, 3, 6, 7, 12, 13};
        int len = in.length;
		TreeNode node = buildInOrderPre(in, pre, 0, len-1);//build(inOderar,postOderar,0,inOderar.length-1);
		printInOrder(node);
	}
	public static void printInOrder(TreeNode node){
		if(node != null){
			printInOrder(node.left);
			System.out.printf("%d   ",node.val);
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
	public static TreeNode buildInOrderPre(int []inOrderAr,int []preOrderAr,int start,int end){
		if(start > end) return null;
		int elem = preOrderAr[index++];
		int idx = search(inOrderAr,start,end,elem);	
		TreeNode trNode = new TreeNode(elem);
		if(start == end)
			return trNode;
		trNode.left = buildInOrderPre(inOrderAr, preOrderAr, start,idx-1);
		trNode.right = buildInOrderPre(inOrderAr, preOrderAr, idx+1,end);
		return trNode;
	}
	public static Integer search(int []inOrderAr,int start,int end,int key){
		int i;
		for(i=start;i<end;i++){
			if(inOrderAr[i] == key)
				return i;
		}
		return i;
	}

}