package com.linkedList;

public class Node {
	int data;
	Node next;
	public Node(int data){
		this.data = data;
	}
	public String toString(){
		Node temp = this;
		StringBuilder stringBuilder = new StringBuilder(temp.data);
		while(temp!=null){
			stringBuilder.append(temp.data+"     ");
			temp = temp.next;
		}
		return stringBuilder.toString();
	}
}
