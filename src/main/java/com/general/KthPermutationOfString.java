package com.general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class KthPermutationOfString {

	public static void main(String[] args) {
		KthPermutationOfString kthPermutationOfString = new KthPermutationOfString();
		Integer []vals = new Integer[]{1,2,3,4};
		List<Integer> values = Arrays.asList(vals);
		System.out.println(kthPermutationOfString.kthPermutationOfString(values, 2));
	}
	public List<Integer> kthPermutationOfString(List<Integer> values,int k){
		List<Integer> permutation = new ArrayList<>();
		List<Integer> factoradi = getFactoradi(values.size(), k);
		boolean []avNums = new boolean[values.size()];
		for(int i=0;i<factoradi.size();i++){
			permutation.add(getUnusedNum(avNums, factoradi.get(i), values));
		}
		return permutation;
	}
	public Integer getUnusedNum(boolean[] avNums, int pos,List<Integer> nums) {
		int i = -1;
		for(int j=0;j<nums.size();j++){
			if(!avNums[j]){
				i++;
				if(i==pos){
					avNums[j] = true;
					return nums.get(j);
				}
			}
		}
		return -1;
	}

	public List<Integer> getFactoradi(int sz, int k) {
		if (sz > 13)
			sz = 13;
		List<Integer> factoradi = new ArrayList<>();
		int i = 1;
		while (k != 0) {
			factoradi.add(k % i);
			k = k / i;
			i++;
		}
		while(i<=sz){
			factoradi.add(0);i++;
		}
		Collections.reverse(factoradi);
		return factoradi;
	}
}
