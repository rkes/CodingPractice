package com.graph;

import java.util.LinkedList;
import java.util.Stack;

public class SortCharacterBasedOnString {

	public static void main(String[] args) {
		String []ar={"baa", "abcd", "abca", "cab", "cad"};
		int n = 4;
		TopGraph grph = new TopGraph(n);
		for(int i=0;i<ar.length-1;i++){
			String a = ar[i];
			String b = ar[i+1];
			for(int j=0;j<Math.min(a.length(), b.length());j++){
				if(a.charAt(j)!=b.charAt(j)){
					grph.addEdge(a.charAt(j)-'a', b.charAt(j)-'a');
					break;
				}
			}
		}
		grph.traverseTopGraph();
	}
	static class TopGraph{
		int len ;
		final LinkedList<Integer> []ajdMat;
		TopGraph(int len){
			this.len =len;
			this.ajdMat = new LinkedList[this.len];
			for(int i=0;i<len;i++){
				this.ajdMat[i] = new LinkedList<Integer>();
			}
		}
		public void addEdge(int start,int end){
			this.ajdMat[start].add(end);
		}
		public void traverseTopGraphUtil(int start,Stack<Integer> stck,boolean [] visited){
			visited[start] = true;
			for(Integer x:ajdMat[start]){
				if(!visited[x])
					traverseTopGraphUtil(x,stck,visited);
			}
			stck.push(start);
		}
		public void traverseTopGraph(){
			Stack<Integer> stck = new Stack<Integer>();
			boolean []visited = new boolean[this.len];
			for(int i=0;i<len;i++){
				if(!visited[i]){
					traverseTopGraphUtil(i, stck, visited);
				}
			}
			while(!stck.isEmpty()){
				System.out.println((char)(stck.pop()+'a'));
			}
		}
	}
}
