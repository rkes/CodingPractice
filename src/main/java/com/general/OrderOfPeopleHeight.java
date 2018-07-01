package com.general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class OrderOfPeopleHeight {

	public static void main(String[] args) {
		List<PeopleHeight> heights = new ArrayList<PeopleHeight>();
		int []heits = new int[]{5 ,3 ,2, 6, 1, 4};
		int []inFronts = new int[]{0 ,1, 2, 0, 3, 2};
		for(int i=0;i<heits.length;i++){
			PeopleHeight peopleHeight = new PeopleHeight(heits[i], inFronts[i]);
			heights.add(peopleHeight);
		}
		Collections.sort(heights);
		
		int []ar=new int[heits.length];
		Integer [] op = new Integer[heits.length];
		for(PeopleHeight peopleHeight :heights){
			int pos = getPos(ar,peopleHeight.inFront);
			if(pos>=0){
				op[pos]= peopleHeight.height;
			}
		}
		ArrayList<Integer> res = new ArrayList<Integer>(Arrays.asList(op));
		System.out.println(res);
	}
	public static Integer getPos(int []ar,int cnt){
		int tempCnt =-1;
		for(int i=0;i<ar.length;i++){
			if(ar[i]==0){
				tempCnt++;
				if(tempCnt == cnt){
					ar[i] =-1;
					return i;
				}
			}
		}
		return -1;
	}
	static class PeopleHeight implements Comparable<PeopleHeight>{
		int height;
		int inFront;
		public PeopleHeight(int height,int inFront){
			this.height = height;
			this.inFront = inFront;
		}
		public int compareTo(PeopleHeight peopleHeight){
			return -peopleHeight.height+this.height;
		}
		public String toString(){
			return height+"   "+inFront;
		}
	}
}
