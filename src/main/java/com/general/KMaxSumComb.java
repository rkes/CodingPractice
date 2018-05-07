package com.general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

import javafx.util.Pair;

public class KMaxSumComb {

	public static void main(String[] args) {
		Integer[] ar = { 36, 27, -35, 43, -15, 36, 42, -1, -29, 12, -23, 40, 9, 13, -24, -10, -24, 22, -14, -39, 18, 17,
				-21, 32, -20, 12, -27, 17, -15, -21, -48, -28, 8, 19, 17, 43, 6, -39, -8, -21, 23, -29, -31, 34, -13,
				48, -26, -35, 20, -37, -24, 41, 30, 6, 23, 12, 20, 46, 31, -45, -25, 34, -23, -14, -45, -4, -21, -37, 7,
				-26, 45, 32, -5, -36, 17, -16, 14, -7, 0, 37, -42, 26, 28 };
		Integer[] br = { 38, 34, -47, 1, 4, 49, -18, 10, 26, 18, -11, -38, -24, 36, 44, -11, 45, 20, -16, 28, 17, -49,
				47, -48, -33, 42, 2, 6, -49, 30, 36, -9, 15, 39, -6, -31, -10, -21, -19, -33, 47, 21, 31, 25, -41, -23,
				17, 6, 47, 3, 36, 15, -44, 33, -31, -26, -22, 21, -18, -21, -47, -31, 20, 18, -42, -35, -10, -1, 46,
				-27, -32, -5, -4, 1, -29, 5, 29, 38, 14, -22, -9, 0, 43 };
		int k = 4;
		List<Integer> res = getKMaxCombSum(Arrays.asList(ar), Arrays.asList(br));

		System.out.println(res);

	}

	public static List<Integer> getKMaxCombSum(List<Integer> a, List<Integer> b) {
		Collections.sort(a);
		Collections.sort(b);
		int k = a.size();
		int m = a.size() - 1;
		int n = b.size() - 1;
		List<Integer> res = new ArrayList<>();
		Pair<Integer, Integer> pair = new Pair<>(m, n);
		int sum = a.get(m) + b.get(n);
		Pair<Integer, Pair<Integer, Integer>> sumPair = new Pair<>(sum, pair);
		PriorityQueue<Pair<Integer, Pair<Integer, Integer>>> qu = new PriorityQueue<>(new PairComparator());
		qu.offer(sumPair);
		Set<Pair<Integer, Integer>> set = new HashSet<>();
		set.add(pair);
		for (int i = 0; i < k; i++) {
			Pair<Integer, Pair<Integer, Integer>> par = qu.poll();
			res.add(par.key);
			m = par.getValue().getKey();
			n = par.getValue().getValue();
			if (n >= 1) {
				sum = a.get(m) + b.get(n - 1);
				Pair<Integer, Integer> pair2 = new Pair<>(m, n - 1);
				if (!set.contains(pair2)) {
					Pair<Integer, Pair<Integer, Integer>> pir2 = new Pair<>(sum, pair2);
					set.add(pair2);
					qu.offer(pir2);
				}
			}
			if (m >= 1) {
				sum = a.get(m - 1) + b.get(n);
				Pair<Integer, Integer>  pair2 = new Pair<>(m - 1, n);
				if (!set.contains(pair2)) {
					Pair<Integer, Pair<Integer, Integer>> pir2 = new Pair<>(sum, pair2);
					set.add(pair2);
					qu.offer(pir2);
				}
			}
		}
		/*
		 * for(Pair<Integer,Integer> p:set){
		 * res.add(a.get(p.getKey())+b.get(p.getValue())); }
		 * Collections.sort(res,Comparator.reverseOrder()); List<Integer> op =
		 * new ArrayList<>(); for(int i=0;i<k;i++){ op.add(res.get(i)); }
		 */
		return res;
	}

	public static class PairComparator implements Comparator<Pair<Integer, Pair<Integer, Integer>>> {
		public int compare(Pair<Integer, Pair<Integer, Integer>> a, Pair<Integer, Pair<Integer, Integer>> b) {
			return a.getKey() - a.getKey();
		}
	}

	public static class Pair<T, V> {
		T key;
		V value;

		Pair(T key, V value) {
			this.key = key;
			this.value = value;
		}

		public T getKey() {
			return this.key;
		}

		public V getValue() {
			return this.value;
		}

		public String toString() {
			return this.key + "  " + this.value;
		}

		public boolean equals(Object obj) {
			Pair<T, V> pair2 = (Pair<T, V>) obj;
			return pair2.key == this.key && pair2.value == this.value;
		}
	}
}
