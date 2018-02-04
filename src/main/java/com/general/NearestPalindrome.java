package com.general;
/*	Algorithm

	To understand this method, let's start with a simple illustration. Assume that the number given to us is "abcxy". One way to convert this number into a palindrome is to replicate one half of the string to the other half. If we try replicating the second half to the first half, the new palindrome obtained will be "yxcxy" which lies at an absolute of 	|10000(a-y) + 1000(b-x)|10000(a−y)+1000(b−x)| from the original number. But, if we replicate the first half to the second half of the string, we obtain "abcba", which lies at an absolute difference of |10(x-b) + (y-a)|10(x−b)+(y−a)|. Trying to change cc additionaly in either case would incur an additional value of atleast 100 in the absolute difference.

	From the above illustration, we can conclude that if replication is used to generate the palindromic number, we should always replicate the first half to the second half. In this implementation, we've stored such a number in aa at a difference of diff1diff1 from nn.

	But, there exists another case as well, where the digit at the middle index is incremented or decremented. In such cases, it could be profitable to make changes to the central digit only since such changes could lead to a palindrome formation nearer to the original digit. e.g. 10987. Using the above criteria, the palindrome obtained will be 10901 which is at a more difference from 10987 than 11011. A similar situation occurs if a 0 occurs at the middle digit. But, again as discussed previously, we need to consider only the first half digits to obtain the new palindrome. This special effect occurs with 0 or 9 at the middle digit since, only decrementing 0 and incrementing 9 at that digit place can lead to the change in the rest of the digits towards their left. In any other case, the situation boils down to the one discussed in the first paragraph.

	Now, whenever we find a 0 near the middle index, in order to consider the palindromes which are lesser than nn, we subtract a 1 from the first half of the number to obtain a new palindromic half e.g. If the given number nn is 20001, we subtract a 1 from 200 creating a number of the form 199xx. To obtain the new palindrome, we replicate the first half to obtain 19991. Taking another example of 10000, (with a 1 at the MSB), we subtract a 1 from 100 creating 099xx as the new number transforming to a 9999 as the new palindrome. This number is stored in bb having a difference of diff2diff2 from nn

	Similar treatment needs to be done with a 9 at the middle digit, except that this time we need to consider the numbers larger than the current number. For this, we add a 1 to the first half. e.g. Taking the number 10987, we add a 1 to 109 creating a number of the form 110xx(11011 is the new palindrome). This palindrome is stored in cc having a difference of diff3diff3 from nn.

	Out of these three palindromes, we can choose the one with a minimum difference from nn. Further, in case of a tie, we need to return the smallest palindrome obtained. For resolving this tie's conflict, we can observe that a tie is possible only if one number is larger than nn and another is lesser than nn. Further, we know that the number bb is obtained by decreasing nn. Thus, in case of conflict between bb and any other number, we need to choose bb. Similarly, cc is obtained by increasing nn. Thus, in case of a tie between cc and any other number, we need to choose the number other than cc.
 * */

/*
 * https://leetcode.com/problems/find-the-closest-palindrome/description/
 * */

public class NearestPalindrome {
	public static void main(String[] args) {
		System.out.println(getNearestPalindrome("123"));
	}

	public static String getNearestPalindrome(String inp) {
		String defaultCase = getMirrorOfString(inp);
		long diff1 = Math.abs(Long.parseLong(inp) - Long.parseLong(defaultCase));
		if (diff1 == 0) {
			return inp;
		}
		StringBuilder case0 = new StringBuilder(inp);
		int i = (case0.length() - 1) / 2;
		while (i >= 0 && case0.charAt(i) == '0') {
			case0.replace(i, i + 1, "9");
			i--;
		}
		if (i == 0 && case0.charAt(i) == 1) {
			case0.delete(0, 1);
			int mid = case0.length() / 2;
			case0.replace(mid, mid + 1, "9");
		} else {
			case0.replace(i, i + 1, "" + ((char) (case0.charAt(i) - 1)));
		}
		String case0Str = getMirrorOfString(case0.toString());
		StringBuilder case9 = new StringBuilder(inp);
		i = (case9.length() - 1) / 2;
		while (i >= 0 && case9.charAt(i) == '9') {
			case9.replace(i, i + 1, "0");
			i--;
		}
		if (i < 0) {
			case9.insert(0, "1");
		} else {
			case9.replace(i, i + 1, "" + ((char) (case9.charAt(i) + 1)));
		}
		String case9Str = getMirrorOfString(case9.toString());
		long diff2 = Math.abs(Long.valueOf(case0Str) - Long.valueOf(inp));
		long diff3 = Math.abs(Long.valueOf(case9Str) - Long.valueOf(inp));
		if (diff2 > diff1) {
			if (diff1 > diff3)
				return case9Str;
			else if (diff3 > diff1)
				return defaultCase;
		}
		return case0Str;

	}

	public static String getMirrorOfString(String inp) {
		String str = inp.substring(0, (inp.length()) / 2);
		StringBuilder sBuilder = new StringBuilder(str);
		return str + (inp.length() % 2 == 1 ? inp.charAt(inp.length() / 2) : "") + sBuilder.reverse().toString();
	}
}