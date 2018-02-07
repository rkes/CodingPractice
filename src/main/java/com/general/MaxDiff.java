package com.general;

public class MaxDiff {

	public static void main(String[] args) {
		int []ar={2, 3, 10, 6, 4, 8, 1};
		int min_num = ar[0];
		int max_diff = ar[1]-ar[0];
		for(int i=1;i<ar.length;i++){
			int diff = Math.abs(ar[i] - min_num);
			if(diff > max_diff){
				max_diff = diff;
			}
			if(ar[i]<min_num)
				min_num = ar[i];
		}
		System.out.println(max_diff +"    "+min_num);
	}

}
