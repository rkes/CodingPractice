package com.general;

import java.util.ArrayList;

public class MergeKSortedInterviewBit {
	static class ListNode {
		public int val;
		public ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public static void main(String[] args) {
		int []ar=new int[]{10,9,
							8,20,38,44,55,65,66,79,87,
							2,68,72,5,5,55,61,73,89,
							2,30,73,4,28,73,84,96,3,
							54,82,83,5,15,33,38,94,100,
							1,4,5,22,32,42,64,86,2,
							11,78
							};
		ArrayList<ListNode> lstNode = new ArrayList<>();
		int start =2;
		for(int i=0;i<ar[0];i++){
			ListNode ltNode = new ListNode(ar[start]);
			ListNode temp =ltNode;
			for(int j=start+1;j<=ar[1]+1;j++){
				ListNode node = new ListNode(ar[j]); 
				temp.next = node;
				temp=temp.next;
			}
			start = start+ar[1];
			lstNode.add(ltNode);
		}
		System.out.println();
	}
	
	static void createHeap(){
		
	}
}
