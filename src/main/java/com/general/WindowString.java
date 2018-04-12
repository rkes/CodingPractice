package com.general;

public class WindowString {

	public static void main(String[] args) {
		System.out.println(minWindow("ADOBECODEBANC", "ABC"));
	}

	public static String minWindow(String A, String B) {
		int strLen = A.length();
		int patLen = B.length();
		if (strLen < patLen)
			return "";
		int[] strMap = new int[256];
		int[] patMap = new int[256];
		for (int i = 0; i < B.length(); i++)
			patMap[B.charAt(i)]++;
		int start = 0,index=0, min_index = -1, minwin_sz = Integer.MAX_VALUE;
		for (int i = 0; i < A.length(); i++) {
			char ch = A.charAt(i);
			strMap[ch]++;
			if(patMap[ch]!=0 && patMap[ch]>=strMap[ch]) start++;
			if(start ==  patLen){
				char chr =A.charAt(index);
				while(strMap[chr]>patMap[chr] || patMap[chr]==0){
					if(strMap[chr]>patMap[chr])
						strMap[chr]--;
					index++;
					chr =A.charAt(index);
				}
				int len_window = i-index+1;
				if(len_window < minwin_sz){
					minwin_sz = len_window;
					min_index = index;
				}
			}
		}
		if(min_index==-1){
			return "";
		}
		return A.substring(min_index,min_index+minwin_sz);
	}
}
