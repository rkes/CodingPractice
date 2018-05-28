package com.general;

public class NumberOfHeaps {
	static long MOD = 100000007;
	static long choose(int n, int k, long[][] nck) {
		if (k > n)
			return 0;
		if (n <= 1)
			return 1;
		if (k == 0)
			return 1;
		if (nck[n][k] != -1)
			return nck[n][k];
		long ans = choose(n - 1, k, nck) + choose(n - 1, k - 1, nck);// n C r = n-1 C r-1 + n-1 C r;
		nck[n][k] = ans%MOD;
		return ans;
	}
	public static int solve(int n){
		long [][]nck = new long[n+1][n+1];
		long []dp = new long[n+1];
		for(int i=1;i<=n;i++)
			dp[i] = -1;
		for(int i=1;i<=n;i++)
			for(int j=0;j<=n;j++)
				nck[i][j] = -1;
		return (int)getNumberOfHeap(n, nck, dp);
	}
	public static long getNumberOfHeap(int n,long [][]nck,long []dp){
		if(n==0)
			return 1;
		if(dp[n]!=-1)
			return dp[n];
		int left = getLeft(n);
		long heapVal = (((choose(n-1,left,nck)%MOD) * getNumberOfHeap(left, nck, dp))%MOD) * getNumberOfHeap(n-left-1, nck, dp);
		dp[n] = heapVal % MOD;
		return heapVal;
	}
	static int getLeft(int n) {
		if (n == 1)
			return 0;
		int h = log2(n);
		int numOfNodesOnHeightH = 1 << h; // Number of elements at Height H is 2^h
		int numOfNodesInHeap = numOfNodesOnHeightH - 1; //Number of Elements in a Heap is 2^h-1
		int actualNumberOfElementsOnHeightH = n - numOfNodesInHeap; // Number of element at last level is (Total Number of nodes -number of element in heap) 
		if( actualNumberOfElementsOnHeightH>= numOfNodesOnHeightH/2)
			return numOfNodesInHeap;
		else
			return numOfNodesInHeap - (numOfNodesOnHeightH/2-actualNumberOfElementsOnHeightH);
	}
	static int log2(int n){
		int k=-1;
		while(n>0){
			n=n/2;
			k++;
		}
		return k;
	}
	public static void main(String[] args) {

		int n = 5;
		int k = 2;
		//System.out.println(getLeft(9));
		System.out.println(solve(10));
		//System.out.println(getLeft(11));
		//System.out.println(getLeft(12));
	}

}
