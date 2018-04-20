package com.general;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MaximumPointsOnSameLine {

	public static void main(String[] args) {
		// int[][] arr ={{2,1},{ 2 , 4}};// { { -1, 1 }, { 0, 0 }, { 1, 1 }, {
		// 2, 2 }, { 3, 3 }, { 3, 4 } };
		String[] inp = "0 0 1 1 -1 -1".split(" ");

		ArrayList<Integer> x = new ArrayList<Integer>();
		ArrayList<Integer> y = new ArrayList<Integer>();
		for (int i = 0; i < inp.length / 2; i++) {
			x.add(Integer.valueOf(inp[i]));
			y.add(Integer.valueOf(inp[inp.length / 2 + i]));
		}
		/*
		 * "barfoothefoobarman"
["foo","bar"]*/
		//System.out.println(max-Points(x, y));
		// System.out.println(maxPointOnSameLine(arr));
		System.out.println(maxPoints("barfoothefoobarman", new String[]{"foo","bar"}));

	}

	public static List<Integer> maxPoints(String text, String[] words) {
		List<Integer> indices = new ArrayList<Integer>();
		
		if(text.length()==0 )
			return indices;
		int np = words.length;
		if(np==0)
			return indices;
		int n = words[0].length();
		Map<String, Integer> mapCnt = new HashMap<>();
		for (String s : words)
			mapCnt.put(s, mapCnt.getOrDefault(s, 0) + 1);
	
		
		for (int i = 0; i < text.length()-(words.length*n)+1; i++) {
			Map<String, Integer> seen = new HashMap<>();
			int j = 0;
			while (j < words.length) {
				String subString = text.substring(i + j * n, i + (j + 1) * n);
				if (mapCnt.containsKey(subString)) {
					seen.put(subString, seen.getOrDefault(subString, 0) + 1);
					if (seen.get(subString) > mapCnt.get(subString))
						break;
				}
				else{
					break;
				}
				j++;
			}
			if(j==words.length)
				indices.add(i);
		}
		return indices;
	}

	public static int maxPoints(ArrayList<Integer> a1, ArrayList<Integer> b1) {
		List<Pair<Integer, Integer>> pairs = new ArrayList<>();
		for (int i = 0; i < a1.size(); i++) {
			Pair<Integer, Integer> pair = new Pair(a1.get(i), b1.get(i));
			pairs.add(pair);
		}
		Set<Pair<Integer, Integer>> mapSet = new HashSet<>();
		Map<Pair<Integer, Integer>, Integer> map = new HashMap<>();
		int max = 0;
		for (int i = 0; i < pairs.size(); i++) {
			int localMax = 0, vertical = 0, overlapping = 0;
			for (int j = 0; j < pairs.size(); j++) {
				if (i == j)
					continue;
				Pair<Integer, Integer> a = pairs.get(i);
				Pair<Integer, Integer> b = pairs.get(j);
				if (a.equals(b))
					overlapping++;
				else if (a.getKey().equals(b.getKey()))
					vertical++;
				else {
					int diffX = Math.abs(a.getKey() - b.getKey());
					int diffY = Math.abs(a.getValue() - b.getValue());
					int gcd = gcd(diffX, diffY);
					if (gcd == 0)
						gcd = 1;
					diffX = diffX / gcd;
					diffY = diffY / gcd;
					Pair p = new Pair(diffX, diffY);
					Integer cnt = map.get(p);
					if (cnt == null)
						cnt = 0;
					map.put(p, cnt++);
					mapSet.add(a);
					mapSet.add(b);
					localMax = Math.max(localMax, mapSet.size());

				}
				localMax = Math.max(localMax, vertical);
			}
			max = Math.max(max, localMax + overlapping + 1);
			map.clear();
		}
		return max;
	}

	public static class Pair<T, V> {
		T key;
		V value;

		public Pair(T key, V value) {
			this.key = key;
			this.value = value;
		}

		public T getKey() {
			return this.key;
		}

		public V getValue() {
			return this.value;
		}
	}

	public static int maxPointOnSameLine(int[][] arr) {
		Map<Pair<Integer, Integer>, Integer> map = new HashMap<>();
		List<Pair<Integer, Integer>> pairs = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			Pair<Integer, Integer> pair = new Pair(arr[i][0], arr[i][1]);
			pairs.add(pair);
		}
		int max = 0;
		for (int i = 0; i < pairs.size() - 1; i++) {
			int localMax = 0;
			int overlapping = 0, verticalPoints = 0;
			for (int j = i + 1; j < pairs.size(); j++) {
				Pair<Integer, Integer> a = pairs.get(i);
				Pair<Integer, Integer> b = pairs.get(j);
				if (a.equals(b))
					overlapping++;
				else if (a.getKey().equals(b.getKey()))
					verticalPoints++;

				else {
					int diffY = Math.abs(b.getValue() - a.getValue());
					int diffX = Math.abs(b.getKey() - b.getKey());
					int gcd = gcd(diffY, diffX);
					if (gcd == 0)
						gcd = 1;
					diffY = diffY / gcd;
					diffX = diffX / gcd;
					Pair<Integer, Integer> pair = new Pair(diffX, diffY);
					Integer cnt = map.get(pair);
					if (cnt == null)
						cnt = 0;
					if (cnt == 0) {
						map.put(pair, 1);
					} else
						map.put(pair, cnt + 1);
					localMax = Math.max(localMax, cnt);
				}
				localMax = Math.max(localMax, verticalPoints);
			}
			max = Math.max(max, localMax + overlapping + 1);
			map.clear();
		}
		return max;
	}

	public static int gcd(int a, int b) {
		if (a == 0 || b == 0)
			return a + b;
		if (a > b)
			return gcd(b, a % b);
		else
			return gcd(a, b % a);

	}

}
