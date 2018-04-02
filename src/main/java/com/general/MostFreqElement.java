package com.general;

public class MostFreqElement {

	public static void main(String[] args) {
		int[] ar = { 1, 2, 3, 3, 4, 2, 3, 3, 3, 3 };
		int elem = getCandidateElement(ar);
		System.out.println(getMostFreqElem(elem, ar));
	}
	public static int getMostFreqElem(int elem , int []ar){
		int cnt =0;
		for(int i=0;i<ar.length;i++){
			if(elem ==ar[i]) cnt++;
		}
		if(cnt>ar.length/2)
			return elem;
		return -1;
	}
	public static int getCandidateElement(int[] ar) {
		int cnt = 1;
		int cand_pos = 0;
		for (int i = 1; i < ar.length; i++) {
			if (ar[cand_pos] == ar[i])
				cnt++;
			else
				cnt--;
			if (cnt == 0) {
				cand_pos = i;
				cnt=1;
			}
		}
		return ar[cand_pos];
	}
}
