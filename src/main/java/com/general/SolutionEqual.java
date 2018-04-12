package com.general;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SolutionEqual {

	public static void main(String[] args) {
		int[] ar = {1, 5, 2, 4, 2, 0, 2, 5, 1, 0, 5, 0 };
		ArrayList<Integer> Ar = new ArrayList<>();
		for (int i = 0; i < ar.length; i++) {
			Ar.add(ar[i]);
		}
		/*Ar.stream().map(x -> {
			System.out.println(x);
			x++;
			return printData(x);
		}).collect(Collectors.toList());*/
		System.out.println(equal(Ar));

	}

	public static Integer printData(Integer x) {
		System.out.println(x);
		return x + 1;
	}
		public static ArrayList<Integer> equal(ArrayList<Integer> A) {
	        ArrayList<Integer> res = new ArrayList<Integer>();
	        Map<Integer,Indices> sumSet = new HashMap<Integer,Indices>();
	        for(int i=0;i<A.size()-1;i++){
	            for(int j=i+1;j<A.size();j++){
	                int sum = A.get(i)+A.get(j);
	                Indices temp = sumSet.get(sum);
	                if(temp == null){
	                    Indices indices = new Indices(i,j);
	                    sumSet.put(sum,indices);
	                }
	                else{
	                    if(res.size()==0 ){
	                    	if(!(temp.i==i || temp.j==j  || temp.j==i)){
	                        res.add(temp.i);
	                        res.add(temp.j);
	                        res.add(i);
	                        res.add(j);
	                    	}
	                    }
	                    else{
	                        int A1 = res.get(0);
	                        int B1 = res.get(1);
	                        int C1 = res.get(2);
	                        int D1 = res.get(3);
	                        int C2 = i;
	                        int D2 = j;
	                        int A2 = temp.i;
	                        int B2 = temp.j;
	                        if(!( (A1<A2) || 
	                            (A1 == A2 && B1<B2 ) || 
	                            (A1==A2 && B1==B2 && C1<C2) || 
	                            (A1==A2 && B1==B2 && C1==C2 && D1<D2)
	                         )){
	                        	if(!(A2==C2 || A2==D2 || A2==B2|| B2==C2 || B2==D2||C2==D2)){
	                             res = new ArrayList<Integer>();
	                             res.add(A2);res.add(B2); res.add(C2);res.add(D2);
	                        	}
	                         }
	                         
	                    }
	                    
	                }
	            }
	        }
	        return res;
	    }
    static class Indices{
        public int i; public int j;
        Indices(int i , int j ){
            this.i = i;this.j=j;
        }
    }
	public static ArrayList<Integer> equal2(ArrayList<Integer> A) {
		ArrayList<Integer> lst = new ArrayList<Integer>();
		Map<Integer, Pair> map = new TreeMap<>();

		for (int i = 0; i < A.size() - 1; i++) {
			for (int j = i + 1; j < A.size(); j++) {
				int sum = A.get(i) + A.get(j);
				if (map.get(sum) == null)
					map.put(sum, new Pair(i, j));
			}
		}
		List<Pairs> pairs = new ArrayList<>();
		for (int i = 0; i < A.size(); i++) {
			for (int j = i + 1; j < A.size(); j++) {
				int sum = A.get(i) + A.get(j);
				Pair pair = map.get(sum);
				Pair pair2 = new Pair(i, j);
				if (!pair.equals(pair2) && map.containsKey(sum)) {
					lst = new ArrayList<>();
					lst.add(pair.x);
					lst.add(pair.y);
					lst.add(pair2.x);
					lst.add(pair2.y);
					pairs.add(new Pairs(pair, pair2));
				}
			}
		}
		Collections.sort(pairs);
		return lst;
	}

	public static class Pair {
		int x;
		int y;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public boolean equals(Object obj) {
			Pair a = (Pair) obj;
			return a.x == this.x && a.y == this.y;
		}

	}

	public static class Pairs implements Comparable<Pairs> {
		Pair pairOne;
		Pair pairTwo;

		Pairs(Pair pairOne, Pair pairTwo) {
			this.pairOne = pairOne;
			this.pairTwo = pairTwo;
		}

		@Override
		public int compareTo(Pairs obj) {
			if (obj.pairOne.x - this.pairOne.x >= 0 && obj.pairOne.y >= this.pairOne.y
					&& obj.pairTwo.y >= this.pairTwo.y) {
				return 1;
			}
			if (obj.pairOne.equals(this.pairOne) && obj.pairTwo.equals(this.pairTwo))
				return 0;
			return -1;
		}

	}
}
