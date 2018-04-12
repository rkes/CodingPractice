package com.general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class TwoSum {

	public static void main(String[] args) {
		Integer[] ar = { 77, 28, 19, 21, 67, 15, 53, 25, 82, 52, 8, 94, 50, 30, 37, 39, 9, 43, 35, 48, 82, 53, 16, 20,
				13, 95, 18, 67, 77, 12, 93, 0 };
		List<Integer> lst = Arrays.asList(ar);
		//System.out.println(diffPossible(lst, 53));
		System.out.println(anagrams(Arrays.asList(new String[]{"cat", "dog"})));
		// List<Integer> res = twoSum(lst, -3);
		// System.out.println(res);

	}

	private static final int MAX = 100000; // Max size of Hashmap

	static void printpairs(Integer numbers[], int sum) {
		if (numbers.length < 2) {
			return;
		}
		Set set = new HashSet(numbers.length);

		for (int value : numbers) {
			int target = sum - value;

			// if target number is not in set then add
			if (!set.contains(target)) {
				set.add(value);
			} else {
				System.out.printf("(%d, %d) %n", value, target);
			}
		}
	}

	public static ArrayList<Integer> twoSum(final List<Integer> A, int B) {
		HashMap<Integer, Data> mp = new HashMap<>();
		ArrayList<Integer> res = new ArrayList<>();
		for (int i = 0; i < A.size(); i++) {
			Integer negNum = B - A.get(i);
			Data data = mp.get(A.get(i));
			if (data == null) {
				data = new Data();
				data.start = i;
				mp.put(negNum, data);
			} else if (data != null && data.start != null && data.end == null) {
				data.end = i;
				mp.put(A.get(i), data);
			}

		}
		Iterator<Map.Entry<Integer, Data>> iter = mp.entrySet().iterator();
		Integer minEnd = Integer.MAX_VALUE, minStart = Integer.MAX_VALUE;
		Data dataRes = null;
		while (iter.hasNext()) {
			Map.Entry<Integer, Data> entry = iter.next();
			Data data = entry.getValue();
			if (data == null || data.end == null)
				continue;
			if (minEnd > entry.getValue().end) {
				minEnd = entry.getValue().end;
				dataRes = new Data();
				if (dataRes.start == null && dataRes.end == null) {
					dataRes.start = entry.getValue().start;
					dataRes.end = minEnd;
				}
			} else {
				if (minEnd == entry.getValue().end) {
					if (entry.getValue().start > dataRes.start) {
						dataRes.start = entry.getValue().start;
					}
				}
			}
		}
		if (dataRes != null) {
			res.add(dataRes.start);
			res.add(dataRes.end);
		}
		return res;
	}

	public static int diffPossible(final List<Integer> A, int B) {
		Collections.sort(A);
		Set mp = new HashSet<>();
		for (int i = 0; i < A.size(); i++) {
			int elem = A.get(i);
			if (mp.contains(elem)) {
				return 1;
			} else
				mp.add(elem + B);
		}
		return 0;
	}
	 public static ArrayList<ArrayList<Integer>> anagrams(final List<String> A) {
		 ArrayList<ArrayList<Integer>> lst = new ArrayList<>();
		 Map<String,List<Integer>> set = new HashMap<>();
		 for(int i=0;i<A.size();i++){
			 char[] chrs= A.get(i).toCharArray();
			 Arrays.sort(chrs);
			 String key =new String(chrs);
			 if(set.containsKey(key)){
				 List elems = set.get(key);
				 elems.add(i+1);
			 }
			 else{
				 List<Integer> index = new ArrayList<>();
				 index.add(i+1);
				 set.put(key, index);
			 }
		 }
		 for(List<Integer> strs :set.values()){
			 lst.add((ArrayList<Integer>) strs);
		 }
		 return lst;
	 }
	public static Integer getKey(char[] chrs){
		int s=0;
		for(char c:chrs){
			s=s+(c-'a');
		}
		return s;
	}
	static class Data {
		Integer start;
		Integer end;
	}
}
