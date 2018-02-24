package com.linkedList;

public class LinkedListTest {

	public static void main(String[] args) {
		LinkedListImpl linkedListImpl = new LinkedListImpl();
		Node root = linkedListImpl.addNode(null, 1);
		 root = linkedListImpl.addNode(root, 2);
		 root = linkedListImpl.addNode(root, 3);
		 root = linkedListImpl.addNode(root, 4);
		 root = linkedListImpl.addNode(root, 5);
		/* root = linkedListImpl.addNode(root, 6);*/
		 linkedListImpl.traverseNode(root);
		 System.out.println();
		// Node revRoot = linkedListImpl.reverseLinkedList(root);
		 Node pairRev = linkedListImpl.pairwiseReverse(root);
		 Node revRoot2 =linkedListImpl.reverseKthNode(root, 2);
		 System.out.println();
		 linkedListImpl.traverseNode(revRoot2);
		 System.out.println();
	}

}
