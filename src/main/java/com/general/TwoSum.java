package com.general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TwoSum {

	public static void main(String[] args) {
		Integer []ar = {4, 7, -4, 2, 2, 2, 3, -5, -3, 9, -4, 9, -7, 7, -1, 9, 9, 4, 1, -4, -2, 3, -3, -5, 4, -7, 7, 9, -4, 4, -8};
		List<Integer> lst = Arrays.asList(ar);
		printpairs(ar,-3);
		//List<Integer> res = twoSum(lst, -3);
		//System.out.println(res);

	}
	private static final int MAX = 100000; // Max size of Hashmap
	 
    static void printpairs(Integer numbers[],int sum)
    {
    	   if(numbers.length < 2){
               return;
           }        
           Set set = new HashSet(numbers.length);
           
           for(int value : numbers){
               int target = sum - value;
               
               // if target number is not in set then add
               if(!set.contains(target)){
                   set.add(value);
               }else {
                   System.out.printf("(%d, %d) %n", value, target);
               }
           }
    }
	public static ArrayList<Integer> twoSum(final List<Integer> A, int B) {
		HashMap<Integer,Data> mp = new HashMap<>();
		ArrayList<Integer> res = new ArrayList<>();
		for(int i=0;i<A.size();i++){
			Integer negNum = B-A.get(i);
			Data data = mp.get(A.get(i));
			if(data == null){
				data = new Data();
				data.start = i;
				mp.put(negNum, data);
			}
			else 
				if(data !=null && data.start!=null && data.end==null ){
					data.end = i;	
					mp.put(A.get(i), data);
				}
			
		}
		Iterator<Map.Entry<Integer, Data>> iter = mp.entrySet().iterator();
		Integer minEnd = Integer.MAX_VALUE,minStart =Integer.MAX_VALUE;
		Data dataRes = null;
		while(iter.hasNext()){
			Map.Entry<Integer,Data> entry = iter.next();
			Data data = entry.getValue();
			if(data==null || data.end==null)
				continue;
			if(minEnd > entry.getValue().end){
				minEnd = entry.getValue().end;
				dataRes = new Data();
				if(dataRes.start == null && dataRes.end == null){
					dataRes.start = entry.getValue().start;
					dataRes.end = minEnd;
				}
			}
			else{
				if(minEnd == entry.getValue().end){
					if(entry.getValue().start > dataRes.start){
						dataRes.start = entry.getValue().start;
					}
				}
			}
		}
		if(dataRes !=null){
			res.add(dataRes.start);
			res.add(dataRes.end);
		}
		return res;
    }
	static class Data{
		Integer start;
		Integer end;
	}
}
