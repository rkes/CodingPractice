package com.general;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ValidSudoku {

	public static void main(String[] args) {
		List<String> arLst = Arrays.asList(new String[] { "53..7....", "6..195...", ".98....6.", "8...6...3",
				"4..8.3..1", "7...2...6", ".6....28.", "...419..5", "....8..79" });
		;
		System.out.println(isValidSudoku(arLst));
	}

	public static int isValidSudoku(final List<String> A) {
		Set<Character> chSet = new HashSet<Character>();
		boolean row = true;
		for (String s : A) {
			char[] chAr = s.toCharArray();
			for (char c : chAr) {
				if (chSet.contains(c)) {
					row = false;
					break;
				}
				if (c != '.')
					chSet.add(c);
			}
			if (!row)
				break;
		}
		chSet = new HashSet<Character>();
		boolean col = true;
		int len = A.get(0).length();
		for (int i = 0; i < len; i++) {
			for (String s : A) {
				if (chSet.contains(s.charAt(i))) {
					col = false;
					break;
				}
				if (s.charAt(i) != '.')
					chSet.add(s.charAt(i));
			}
			if (!col)
				break;
		}
		

	}
}
