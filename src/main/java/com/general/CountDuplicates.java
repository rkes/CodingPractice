package com.general;

public class CountDuplicates {

	public static void main(String[] args) {
		int[] ar = { 1, 2, 3, 3, 3, 3, 3, 3, 3, 4, 5, 6, 6, 6, 6, 6, 7, 8, 9 };
		int min = getMinCount(ar, 4);
		int max = getMaxCount(ar, 4);
		System.out.println("count: =  " + (max - min + 1));
	}

	public static int getMinCount(int[] ar, int key) {
		int left = 0;
		int right = ar.length - 1;
		int mid = (left + right) / 2;
		while (left <= right) {
			if (ar[mid] == key && ar[mid] > ar[mid - 1])
				return mid;
			else if (ar[mid] < key)
				left = mid + 1;
			else
				right = mid - 1;
			mid = (left + right) / 2;
		}
		return -1;
	}

	public static int getMaxCount(int[] ar, int key) {
		int left = 0, right = ar.length - 1;
		int mid = (left + right) / 2;
		while (left <= right) {
			if (ar[mid] == key && ar[mid] < ar[mid + 1]) {
				return mid;
			} else if (ar[mid] > key)
				right = mid - 1;
			else
				left = mid + 1;
			mid = (left + right) / 2;
		}
		return -1;
	}
}
