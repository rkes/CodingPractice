package com.general;

import java.util.Deque;
import java.util.LinkedList;

public class StockBuySellKTransaction {

	public static void main(String[] args) {
		int []ar={2, 5, 7, 1, 4, 3, 1, 3};
		int k = 3;//Transactions 
		int [][]profit = new int[k+1][ar.length];
		int n = ar.length;
		for(int i=0;i<k;i++){
			profit[i][0]=0;
		}
		for(int i=0;i<n;i++){
			profit[0][i] = 0;
		}
		for(int i=1;i<=k;i++){
			int max_diff = Integer.MIN_VALUE;
			for(int j=1;j<n;j++){
				max_diff = Math.max(max_diff, profit[i-1][j-1] - ar[j-1]);
				profit[i][j] = Math.max(profit[i][j-1],max_diff+ar[j] );
			}
		}
		Deque deq = getStockBuySellDetails(ar, profit);
		while(!deq.isEmpty()){
			System.out.print("Buy At "+deq.pollFirst());
			System.out.print("\tSell At "+deq.pollFirst());
			System.out.println();
		}
	}
	public static Deque<Integer> getStockBuySellDetails(int []prices,int [][]profit){
		Deque<Integer>  deq = new LinkedList<Integer>();
		int i=profit.length-1,j=profit[0].length-1;
		while(true){
			if(i==0||j==0)
				break;
			if(profit[i][j] ==  profit[i][j-1])
				j--;
			else{
				int diff = profit[i][j] - prices[j];
				deq.addFirst(j);//Sell
				for(int k=j-1;k>=0;k--){
					if(profit[i-1][k]-prices[k]==diff){
						deq.addFirst(k);//buy
						i--;
						j=k;
						break;
					}
				}
			}
		}
		return deq;
	}

}
