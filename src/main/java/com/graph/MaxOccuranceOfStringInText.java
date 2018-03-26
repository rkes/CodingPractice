package com.graph;

import java.util.LinkedList;

public class MaxOccuranceOfStringInText {

	public static void main(String[] args) {

	}

	static class SuffixTrieNode {
		int MAX_CHAR = 256;
		SuffixTrieNode [] children = new SuffixTrieNode[MAX_CHAR];
		LinkedList<Integer> indices ;
		int indexMinHeap ;
		int frequency;
		SuffixTrieNode(){
			indices = new LinkedList<Integer>();
			for(SuffixTrieNode child:children){
				child = null;
			}
		}
		public void insert(String str,Integer index){
			indices.add(index);
			if(children[index] == null){
				children[index] = new SuffixTrieNode();
			}
			children[index].insert(str.substring(1), index+1);
		}
		public LinkedList<Integer> search(String s){
			if(s.length()==0){
				return this.indices;
			}
			if(children[s.charAt(0)]!=null)
				return children[s.charAt(0)].search(s.substring(1));
			else
				return null;
		}
	}
}
