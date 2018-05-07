package com.general;

public class QuickSort {

	public static void main(String[] args) {
		int []ar={8,9,1,3,4,50,2};
		int low = 0,high=ar.length-1;
		sort(ar, low, high);
		for(int i=0;i<ar.length;i++)
			System.out.println(ar[i]);
	}
	public static void sort(int []ar,int low,int high){
		if(low<high){
			int pivot = getPivot(ar, low, high);
			sort(ar,low,pivot-1);
			sort(ar,pivot+1,high);
		}
	}
	public static int getPivot(int []ar,int low,int high){
		int small = low-1;
		int pivot = ar[high];
		for(int i=low;i<high;i++){
			if(ar[i]<=pivot ){
				small++;
				int temp = ar[small];
				ar[small] = ar[i];
				ar[i] = temp;
			}
		}
		int temp = ar[small+1];
		ar[small+1] = ar[high];
		ar[high] = temp;
		return small+1;
	}
}
