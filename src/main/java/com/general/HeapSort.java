package com.general;


public class HeapSort {

	public static void main(String[] args) {
		int []ar={8,9,1,3,4,50,2};
		int n = ar.length;
		for(int i=n/2-1;i>=0;i--){
			heapify(ar,i,n);
		}
		for(int i=n-1;i>=0;i--){
			int temp = ar[0];
			ar[0] = ar[i];
			ar[i] = temp;
			heapify(ar, 0, i);
		}
		for(int i=0;i<n;i++)
			System.out.println(ar[i]);
	}

	public static void heapify(int []ar,int start,int size){
		int small= start;
		int left = 2*start+1;
		int right = 2*start+2;
		if(left < size && ar[left] > ar[small])
			small = left;
		if(right < size && ar[right] > ar[small])
			small = right;
		if(small !=start){
			int temp = ar[small];
			ar[small] = ar[start];
			ar[start] = temp;
			heapify(ar,small,size);
		}
	}
}
