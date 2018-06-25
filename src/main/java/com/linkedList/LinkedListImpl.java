package com.linkedList;

public class LinkedListImpl {
	public Node addNode(Node root ,int data){
		if(root == null){
			return new Node(data);
		}
		root.next = addNode(root.next,data);
		return root;
	}
	public void traverseNode(Node node){
		if(node == null)
			return;
		else{
			System.out.printf("%d ",node.data);
			traverseNode(node.next);
		}
	}
	public Node reverseLinkedList(Node root){
		if(root == null){
			return null;
		}
		if(root.next == null){
			return root;
		}
		Node temp = root.next;
		root.next =null;
		Node rev = reverseLinkedList(temp);
		temp.next = root;
		return rev;
	}
	public Node reverseKthNode(Node root,int k){
		Node temp=root,q=null,t;
		int cnt =0;
		while( temp !=null && cnt<k){
			t = temp.next;
			temp.next =q;
			q = temp;
			temp = t;
			cnt++;
		}
		if(temp!=null){
			root.next = reverseKthNode(temp, k);
		}
		return q;  
	}
	public Node pairwiseReverse(Node root){
		Node temp = root,p=root,q=null;
		root = p.next;
		while(true){
			q = p.next;
			temp = q.next;
			q.next =p;
			if(temp == null){
				p.next =null;break;
			}
			if(temp.next == null){
				p.next = temp; break;
			}
			p.next=temp.next;
			p=temp;
		} 
		return root;
	}
	public Node getKthNodeFromLast(Node root , int k){
		Node temp = root,slow = root;int cnt =0;
		while(temp!=null){
			if(cnt < k){
				temp = temp.next;
				cnt++;
				continue;
			}
			slow= slow.next;
			temp = temp.next;
		}
		return slow;
	}
}
