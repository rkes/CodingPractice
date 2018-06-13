package com.general;

import java.util.Stack;

public class NextGreaterElement {
	public static void main(String[] args) {
	
		int []ar = new int[]{11, 13, 21, 3};
		System.out.println(getNextGreater(ar,13));

	}
	public static int getNextGreater(int []ar,int elem){
		Stack<Integer> stck = new Stack<Integer>();
		boolean flag = false;
		for(int i=0;i<ar.length;i++){
			if(ar[i] == elem)
				flag = true;
			if(flag == false)
				continue;
			if(ar[i] > elem && stck.isEmpty())
				stck.push(ar[i]);
			if(ar[i] > elem && !stck.isEmpty()){
					Integer val = stck.peek();
					if (val > ar[i]) {
						stck.push(ar[i]);
					}
					
			}
		}
		return stck.isEmpty() ? -1 :stck.peek();
	}
}
