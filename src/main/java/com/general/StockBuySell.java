package com.general;

import java.util.ArrayList;

public class StockBuySell {

	public static void main(String[] args) {
		int[] ar = { 100, 180, 260, 310, 40, 535, 695 };
		int n = ar.length;
		int i = 0;
		int count = 0;
		ArrayList<Interval> sols = new ArrayList<Interval>();
		while (i < n - 1) {
			while (i < n - 1 && ar[i] > ar[i + 1])
				i++;
			if (i == n - 1) {
				break;
			}
			Interval interval = new Interval();
			interval.buy = i++;
			while (i < n && ar[i] >= ar[i - 1])
				i++;
			interval.sell = i - 1;
			sols.add(interval);
			count++;
		}
		if (count == 0)
			System.out.println(" No Interval Found");
		else {
			for (i = 0; i < count; i++) {
				System.out.println("Stock Buy At " + sols.get(i).buy + "  Stock Sell At :" + sols.get(i).sell);
			}
		}
	}

	static class Interval {
		int buy;
		int sell;
	}
}
