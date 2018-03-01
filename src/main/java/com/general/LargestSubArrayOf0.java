package com.general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LargestSubArrayOf0 {

	public static void main(String[] args) {
		Integer[] ar ={1, 2, -2, 4, -4};//{-1, 1, 1, -1, -1, 1, 1, -1 };
		System.out.println(maxLen(Arrays.asList(ar)));
	}

	static ArrayList<Integer> maxLen(List<Integer>  ar) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		ArrayList<Integer> max_lenArray = new ArrayList<>();
		int sum = 0, max_len = 0,i,max=0,start=0;
		Integer prev=null;
		for (i = 0; i < ar.size(); i++) {
			sum = sum + ar.get(i);
			if (ar.get(i) == 0 && max_len == 0) {
				max=max_len = 1;
			}
			if (sum == 0) {
				max_len = i + 1;
				if(max<max_len){
					max = max_len;
					if(prev!=null)
					start = prev+1;
				}
			}
			prev = map.get(sum);
			if (prev != null) {
				if(i-prev > max_len){
					start = prev;
					max_len = i-prev;
				}
			} else
				map.put(sum, i);

		}
		 max_lenArray = new ArrayList();
		 for (int j = 0; j < max_len; j++) {
				max_lenArray.add(ar.get(start+j));
		 }
		
		return max_lenArray;
	}

}
