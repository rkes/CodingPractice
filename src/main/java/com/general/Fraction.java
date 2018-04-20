package com.general;

import java.util.HashMap;
import java.util.Map;

public class Fraction {

	public static void main(String[] args) {

		System.out.println(fractionToDecimal(87, 22));
		// System.out.println(87.0/22.0);
	}

	public static String fractionToDecimal(Integer numerator, Integer denominator) {
		long a = numerator;
		long b = denominator;
		StringBuilder sBuilder = new StringBuilder();
		if ((a > 0 && b < 0) || (a < 0 && b > 0))
			sBuilder.append("-");
		sBuilder.append(a/b);
		long r = a%b;
		if(r==0)
			return sBuilder.toString();
		sBuilder.append(".");
		a=r*10;
		Map<Long,Integer> map =new HashMap<>();
		while(!map.containsKey(a)){
			map.put(a, sBuilder.length());
			sBuilder.append(a/b);
			a=(a%b)*10;
			if(a==0) return sBuilder.toString();
		}
		
		return sBuilder.insert(map.get(a), "(").append(")").toString();
	}
}
