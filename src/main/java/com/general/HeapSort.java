package com.general;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.TimeZone;

public class HeapSort {

	public static void main(String[] args) {
		int []ar={8,9,1,3,4,50,2};
		int n = ar.length;
		for(int i=n/2;i>=0;i--){
			heapify(ar,n,i);
		}
		for(int i=n-1;i>=0;i--){
			int temp = ar[0];
			ar[0] = ar[i];
			ar[i] = temp;
			heapify(ar, i,0);
		}
		for(int i=0;i<ar.length;i++)
			System.out.println(ar[i]);
		LocalDateTime dateTime = LocalDateTime.now();
		dateTime.truncatedTo(ChronoUnit.DAYS);
		
		System.out.println("------------------------------------------------------");
		System.out.println(dateTime.atZone(TimeZone.getDefault().toZoneId()).toInstant().toEpochMilli());
		System.out.println(ZonedDateTime.now().truncatedTo(ChronoUnit.DAYS).toInstant().toEpochMilli());
		System.out.println((new Date()).getTime());
	}
	public static int left(int i){
		return 2*i+1;
	}
	public static int right(int i){
		return 2*i+2;
	}
	public static void  heapify(int []ar,int n,int i){
		int left = left(i);
		int right = right(i);
		int small = i;
		if( left < n && ar[left] < ar[small] )
			small=left;
		if( right < n && ar[right] < ar[small] )
			small=right;
		if(small != i){
			int temp = ar[i];
			ar[i] = ar[small];
			ar[small] = temp;
			heapify(ar,n,small);
		}
	}
}
