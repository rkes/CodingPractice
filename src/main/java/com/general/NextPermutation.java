package com.general;

import java.util.ArrayList;
import java.util.Arrays;

public class NextPermutation {

	public static void main(String[] args) {
		Solution solution = new Solution();
		Integer []ars= { 844,251/*, 767, 778, 658, 337, 10, 252, 632, 262, 707, 506, 701, 475, 410, 696, 631, 903, 516, 149, 344, 101, 42, 891, 991*/};
		ArrayList<Integer> ar = new ArrayList<Integer>(Arrays.asList(ars));
		//ar.add(1);
		solution.nextPermutation(ar);
		System.out.println();
	}
	static class Solution {
	    public void nextPermutation(ArrayList<Integer> ar) {
	        
			int n=ar.size();
			int i=n-1;
			if(i==0){
				return ;
			}
			if( i==1){
				
					int temp = ar.get(0);
					ar.set(0, ar.get(1));
					ar.set(1, temp);
				
				return ;
			}
			while(i-1>=0 && ar.get(i)<ar.get(i-1))
				i--;
			if(i<=0){
				i = n-1;
				int j =0;
				while(i>j){
					int temp = ar.get(i);
					ar.set(i,ar.get(j));
					ar.set(j,temp);
					i--;
					j++;
				}
				
			}
			int k =n-1;
			int pivotElem = ar.get(i-1);
			while(k-1>=0 && ar.get(k)<pivotElem){
				k--;
			}
			
			int temp = ar.get(k);
			ar.set(k,ar.get(i-1));
			ar.set(i-1,temp);
			int j = ar.size() - 1;
			while (i < j) {
				temp = ar.get(i);
				ar.set(i, ar.get(j));
				ar.set(j,temp);
				i++;
				j--;
				j--;
			}
			
	    }
	}
}	
