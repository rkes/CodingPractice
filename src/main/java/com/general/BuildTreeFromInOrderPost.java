package com.general;

public class BuildTreeFromInOrderPost {
	static Integer index = 0;
	public static void main(String[] args) {
		int []inOderar={1};
		int []postOderar={1} ;
		index = 0;;
	    
        int in[] = new int[]{ 1, 2, 3};
        int pre[] = new int[]{2, 1, 3  };
        int len = in.length;
		TreeNode node = buildInOrderPre(in, pre, 0, len-1);//build(inOderar,postOderar,0,inOderar.length-1);
		printPreOrder(node);
		System.out.println();
		printPostOrder(node);
	}
	public static void printPreOrder(TreeNode node){
		if(node != null){
			System.out.printf("%d   ",node.val);
			printPreOrder(node.left);
			printPreOrder(node.right);
		}
	}
	public static void printPostOrder(TreeNode node){
		if(node != null){
		
			printPostOrder(node.left);
			printPostOrder(node.right);
			System.out.printf("%d   ",node.val);
		}
	}
/*	public static TreeNode build(int []inOrderAr,int []postOrderAr,int start,int end){
		if(start > end) return null;
		int elem = postOrderAr[index--];
		int idx = search(inOrderAr,start,end,elem);	
		TreeNode trNode = new TreeNode(elem);
		trNode.right = build(inOrderAr, postOrderAr, idx+1,end);
		trNode.left = build(inOrderAr, postOrderAr, start, idx-1);
		return trNode;
	}*/
	public static TreeNode buildInOrderPre(int []inOrderAr,int []preOrderAr,int start,int end){
		if(start > end) return null;
		TreeNode trNode = new TreeNode(preOrderAr[index++]);
		if(start == end)
			return trNode;
		int idx = search(inOrderAr,start,end,trNode.val);	
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
