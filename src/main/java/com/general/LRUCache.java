package com.general;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {

	
}
class Solution {
    int capacity ;
    Map<Integer,Integer> map ; 
    public Solution(int capacity) {
        this.capacity = capacity;
        map = new LinkedHashMap<>(capacity);
    }
    
    public int get(int key) {
        Integer val = map.get(key);
        if(val == null) return -1;
        map.remove(Integer.valueOf(key));
        map.put(key, val);
        return val;
    }
    
    public void set(int key, int value) {
        Integer val = map.get(key);
        if( val != null){
        	this.map.remove(Integer.valueOf(key));
        }
        if(this.capacity == map.size()){
        	Integer ke = this.map.keySet().iterator().next();
        	this.map.remove(ke);
        }
        
        this.map.put(Integer.valueOf(key), value);
    }
}

