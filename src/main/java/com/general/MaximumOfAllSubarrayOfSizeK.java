package com.general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public class MaximumOfAllSubarrayOfSizeK {

	public static void main(String[] args) {
		Integer []ar={1};
		List<Integer> lst = new ArrayList<>(Arrays.asList(ar));
		int [] res = printMax(lst,1);
		for(int i=0;i<res.length;i++){
			System.out.print(res[i]+" , ");
		}
	}
	static int[] printMax(List<Integer> arr,int k){
		 List<Integer> res = new ArrayList<Integer>();
		 for(int i=0;i<arr.size();i=i+1){
			 if(i+k > arr.size())
				 break;
			 List<Integer> subList = getSubList(arr, i, i+k);
			 if( subList.size()==0)
				 continue;
			 
			 res.add(getMax(subList));
		 }
		int []resOutput = new int[res.size()];
		int i=0;
		for(Integer v:res){
			resOutput[i++]=v;
		}
		return resOutput;
	}
	
	public static List<Integer> getSubList(List<Integer> ar,int start,int end){
		List<Integer> subLst = new ArrayList<>();
		for(int i= start;i<end;i++){
			subLst.add(ar.get(i));
		}
		return subLst;
	}
	public static Integer getMax(List<Integer> brr){
		return brr.stream().mapToInt(v->v).max().orElseThrow(NoSuchElementException::new);
	}
}
