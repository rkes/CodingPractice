package com.general;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class DistinctNumberInWindow {

	public static void main(String[] args) {
		int[] ar = { 1, 2, 2, 3, 4, 5, 5, 6, 7, 8, 8 };//{1, 2, 1, 3, 4, 2, 3};
		int m = 4;
		for(int i=0;i<ar.length-m+1;i++){ 
			int cnt = 0;
			for(int j=i;j<m+i;j++){
				int k = i;
				for(;k<j;k++){
					if(ar[j] == ar[k]) break; 	
				}
				if(j==k) cnt++;
			}
			System.out.println(cnt);
		}
		System.out.println("------------------------------------");
		countDistinctElementInQueue(ar,4);
	}
	private static int countDistinctElementInQueue(int[] ar,int k){
		Map<Integer,Integer> map = new HashMap<>();
		int distinct_cnt=0;
		for(int i=0;i<k;i++){
			Integer val = map.get(ar[i]);
			if(Objects.isNull(val)){
				distinct_cnt++;
				val = 0;
			}
			map.put(ar[i], ++val);
		}
		System.out.println(distinct_cnt);
		for(int i=k;i<ar.length;i++){
			Integer val = map.get(ar[i-k]);
			if(!Objects.isNull(val) && val==1){
				map.remove(map.get(ar[i-k]));
				distinct_cnt--;
			}
			else{
				map.put(ar[i-k], val-1);
			}
			if(map.get(ar[i]) == null){
				distinct_cnt++;
				map.put(ar[i], 1);
			}
			else
				map.put(ar[i], map.get(ar[i])+1);
			System.out.println(distinct_cnt);
		}
		return 1;
	}

}
