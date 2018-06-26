package com.sorting;
/*
 * put all smaller element to the left of pivot and all greater elemet to right of pivot .
 * And do it recursively 
 */
public class QuickSort {
	public static void main(String []args){
		int []ar = {1,9,2,6,12,6,5};
		quickSort(ar, 0, ar.length-1);
		for(int i=0;i<ar.length;i++)
			System.out.println(ar[i]);
	}
	public static void quickSort(int []ar,int low,int high){
		if(low<high){
			int pivot = getPivot(ar,low,high);
			quickSort(ar, low, pivot-1);
			quickSort(ar,  pivot+1,high);
		}
	}
	public static int getPivot(int []ar,int low,int high){
		int pivot = ar[high];
		int i = low-1;
		for(int j = low;j<=high-1;j++){
			if(ar[j]<=pivot){
				i++;
				swap(ar,i,j);
			}
		}
		swap(ar,i+1,high);
		return i+1;
	}
	public static void swap(int []ar,int i , int j){
		int temp = ar[i];
		ar[i] = ar[j];
		ar[j] = temp;
	}
}
