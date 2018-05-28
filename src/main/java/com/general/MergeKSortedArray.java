package com.general; 

import java.util.ArrayList;

public class MergeKSortedArray {

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> lsts = new ArrayList<>();
		lsts.add(getArrayList(new Integer[] { 1, 2, 9, 10 }));
		lsts.add(getArrayList(new Integer[] { 7, 8, 12, 15 }));
		lsts.add(getArrayList(new Integer[] { 3, 14, 22, 35 }));
		MergeElement[] mergeElements = new MergeElement[lsts.size()];
		for (int i = 0; i < lsts.size(); i++) {
			MergeElement mergeElement = new MergeElement();
			mergeElement.element = lsts.get(i).get(0);
			mergeElement.i = i;
			mergeElement.j = 1;
			mergeElements[i] = mergeElement;
		}
		createHeap(mergeElements);
		int n = lsts.size();
		int k = 4;
		int []res = new int[n*k];
		for(int i= 0;i<n*k;i++){
			MergeElement root = mergeElements[0];
			res[i] = root.element;
			if(root.j < k){
				root.element = lsts.get(root.i).get(root.j);
				root.j+=1;
			}
			else
				root.element = Integer.MAX_VALUE;
			mergeElements[0] = root;
			heapify(mergeElements, 0);
		}
		for(int i=0;i<res.length;i++)
			System.out.printf("%d\t",res[i]);
	}

	static void createHeap(MergeElement[] mergeElements) {
		int n = (mergeElements.length - 1) / 2;
		while (n >= 0)
			heapify(mergeElements, n--);
	}

	static void heapify(MergeElement[] mergeElements, int i) {
		int start = i;
		int left = 2 * i + 1;
		int right = 2 * i + 2;
		int n = mergeElements.length;
		if(left < n && mergeElements[start].element > mergeElements[left].element)
			start = left;
		if(right < n && mergeElements[start].element > mergeElements[right].element)
			start = right;
		if(start!=i){
			MergeElement temp = mergeElements[start];
			mergeElements[start] = mergeElements[i];
			mergeElements[i] = temp;
			heapify(mergeElements, start);
		}
	}

	static ArrayList<Integer> getArrayList(Integer[] ar) {
		ArrayList<Integer> lst = new ArrayList<>();
		for (Integer x : ar) {
			lst.add(x);
		}
		return lst;
	}

	static class MergeElement {
		int element;
		int i;
		int j;
	}
}
