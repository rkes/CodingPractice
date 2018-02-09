package com.general;

public class ArraySegregation {

	public static void main(String[] args) {
		int []ar = {0, 1, 0, 1, 0, 0, 1, 1, 1, 0} ;
		int i=0;
		int n=ar.length-1;
		while(i<=n){
			while(ar[i]==0 && i<n)
				i++;
			while(ar[n]==1 && i<n)
				n--;
			if(n<=i)
				break;
			ar[n]=1;
			ar[i]=0;
		}
		for(i=0;i<ar.length;i++)
			System.out.print(ar[i]+"   ");
	}

}
