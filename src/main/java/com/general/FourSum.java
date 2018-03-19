package com.general;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class FourSum {

	public static void main(String[] args) {
		Integer []ar={ 9, -8, -10, -7, 7, -8, 2, -7, 4, 7, 0, -3, -4, -5, -1, -4, 5, 8, 1, 9, -2, 5, 10, -5, -7, -1, -6, 4, 1, -5, 3, 8, -4, -10, -9, -3, 10, 0, 7, 9, -8, 10, -9, 7, 8, 0, 6, -6, -7, 6, -4, 2, 0, 10, 1, -2, 5, -2 };
		ArrayList<Integer> inp = new ArrayList<>();
		for(Integer x:ar){
			inp.add(x);
		}
		ArrayList<ArrayList<Integer>>  op = fourSum(inp,0);
		System.out.println();
	}
	private static boolean unCommon(PairSum pairSum, PairSum pairSum2) {
		if(pairSum.start==pairSum2.start||pairSum.end==pairSum2.start||pairSum.end==pairSum2.end||pairSum.start==pairSum2.end)
			return false;
		return true;
	}
	private static class PairSum{
		int sum;
		int start;
		int end;
	}
	public static ArrayList<ArrayList<Integer>> fourSum(ArrayList<Integer> A, int B) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		ArrayList<Integer> op = new ArrayList<Integer>();
		Set<ArrayList<Integer>> opSet = new HashSet<>();
		Collections.sort(A);
		for(int i=0;i<A.size()-1;i++){
			for(int j=i+1;j<A.size();j++){
				int l = j+1;
				int m=A.size()-1;
				while(l<m){
					if(A.get(i)+A.get(j)+A.get(l)+A.get(m)==B){
						op = new ArrayList<>();
						op.add(A.get(i));op.add(A.get(j));op.add(A.get(l));op.add(A.get(m));
						if(!opSet.contains(op)){
							opSet.add(op);
							res.add(op);
						}
						l++;
						m--;
					}
					else
						if(A.get(i)+A.get(j)+A.get(l)+A.get(m)<B)
							l++;
						else
							m--;
				}
			}
		}
		return res;
	}
	public static ArrayList<ArrayList<Integer>> fourSum1(ArrayList<Integer> A, int B) {
		int x= B;
		int n = A.size();
		ArrayList<PairSum> sums = new ArrayList<>();
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		for(int i=0;i<n-1;i++){
			for(int j=i+1;j<n;j++){
				PairSum pairSum = new PairSum();
				pairSum.sum=A.get(i)+A.get(j);
				pairSum.start=i;
				pairSum.end=j;
				sums.add(pairSum);
			}
		}
		Collections.sort(sums,new Comparator<PairSum>() {
			public int compare(PairSum sum1,PairSum sum2){
				return sum1.sum-sum2.sum;
			}
		});
		int i=0,j=sums.size()-1;
		while(i<j){
			if(sums.get(i).sum+sums.get(j).sum==x ){
				ArrayList<Integer> op = new ArrayList<>();
				op.add(A.get(sums.get(i).start));
				op.add(A.get(sums.get(i).end));
				op.add(A.get(sums.get(j).end));
				op.add(A.get(sums.get(j).start));
				Collections.sort(op);
				if(!res.contains(op))
				res.add(op);
				i++;
				j--;
			}
			else
				if(sums.get(i).sum+sums.get(j).sum<x)
				i++;
			else
				j--;
		}
		 return res;
    }
}
