package com.general;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ShortestPrefixHashMap {

	public static void main(String[] args) {
		String[] str = { "zebra", "dog", "duck", "dove" };
		System.out.println(search(str));
	}
	public static ArrayList<String> search(String[] A){
		TrieNode root = new TrieNode();
		for(String s:A){
			insert(root,s);
		}
		ArrayList<String> prefixes = new ArrayList<>();
		for(String x:A){
			prefixes.add(findPrefix(x, root));
		}
		return prefixes;
	}
	public static void insert(TrieNode root,String str){
		int len = str.length();
		for(int i=0;i<len;i++){
			char c = str.charAt(i);
			root = root.map.computeIfAbsent(c, x->new TrieNode());
			root.cnt++;
		}
		
	}
	public static String findPrefix(String str,TrieNode root){
		int len = str.length();
		char []chArray = str.toCharArray();
		int i=0;
		StringBuilder sBuilder = new StringBuilder();
		while(true){
			char ch = chArray[i++];
			sBuilder.append(ch);
			root = root.map.get(ch);
			if(root.cnt == 1)
				return sBuilder.toString();
		}
	}
	static class TrieNode {
		int cnt = 0;
		Map<Character, TrieNode> map = new HashMap<>();
	}
}
