package com.general;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VerticalOrderTraversalBinary {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);root.right.right = new TreeNode(7);
		root.right.right.left = new TreeNode(8);root.right.right.right = new TreeNode(9);
		System.out.println(solution(root));
	}
	public static Map<Integer,List<Integer>> map = new HashMap<>();
	static int min =Integer.MAX_VALUE;
	static int max =Integer.MIN_VALUE;
	public static List<List<Integer>> solution(TreeNode A){
		List<List<Integer>> lsts = new ArrayList<>();
		populateMap(A,0);
		for(int i=min ;i<=max+1;i++){
			List<Integer> lts = map.get(i);
			if(lts != null)
				lsts.add(lts);
		}
		return lsts;
	}
	public static void populateMap(TreeNode A, int index){
		if(A == null) return ;
		List<Integer> vals = map.get(index);
		if( vals == null)
			vals = new ArrayList<Integer>();
		vals.add(A.val);
		map.put(index, vals);
		if(min > index)
			 min = index;
		if(max < index)
			max = index;
		populateMap(A.left, index-1);
		populateMap(A.right, index+1);
	}

}
class TreeNode{
	int val;
	TreeNode left;TreeNode right;
	TreeNode(int val){
		this.val = val;
	}
}
