package com.linkedList;

public class LinkedListTest {

	public static void main(String[] args) {
		LinkedListImpl linkedListImpl = new LinkedListImpl();
		Node root = linkedListImpl.addNode(null, 1);
		root = linkedListImpl.addNode(root, 2);
		root = linkedListImpl.addNode(root, 3);
		root = linkedListImpl.addNode(root, 4);
		root = linkedListImpl.addNode(root, 5);
		root = linkedListImpl.addNode(root, 5);
		root = linkedListImpl.addNode(root, 4);
		root = linkedListImpl.addNode(root, 3);
		root = linkedListImpl.addNode(root, 2);
		root = linkedListImpl.addNode(root, 1);
		/* root = linkedListImpl.addNode(root, 6); */
		linkedListImpl.traverseNode(root);
		System.out.println();
		System.out.println(linkedListImpl.getKthNodeFromLast(root, 2).data);
		
		// Node revRoot = linkedListImpl.reverseLinkedList(root);
		/*
		 * Node pairRev = linkedListImpl.pairwiseReverse(root); Node revRoot2
		 * =linkedListImpl.reverseKthNode(root, 2); System.out.println();
		 */
		int numOfNodes = countLinkedListSize(root);
		// Node revNodes = reverseLinkedList(root);
		Node midNode = getMid(root);
		// Node revNodes = reverseLinkedList(midNode);
		// System.out.println(revNodes);
		boolean palinDrome = true;

		Node nextHalf = midNode.next;
		midNode.next = null;
		nextHalf = reverseLinkedList(nextHalf);
		while ((numOfNodes % 2 != 0 && root.next != null) || (numOfNodes % 2 == 0 && root != null)) {
			if (nextHalf == null)
				palinDrome = false;
			palinDrome = root.data == nextHalf.data;
			if (!palinDrome)
				break;
			nextHalf = nextHalf.next;
			root = root.next;
		}
		System.out.println(palinDrome);
	}

	public static Node getMid(Node node) {
		Node fast = node, slow = node;
		Node prev = slow;
		while (fast != null && slow != null) {
			fast = fast.next;
			prev = slow;
			slow = slow.next;
			if (fast != null)
				fast = fast.next;
			else
				break;
		}
		return prev;
	}

	public static int countLinkedListSize(Node node) {
		int cnt = 0;
		while (node != null) {
			node = node.next;
			cnt++;
		}
		return cnt;
	}

	public static Node reverseLinkedList(Node node) {
		Node temp = node, q = null, p = null;
		while (temp != null) {
			q = temp.next;
			temp.next = p;
			p = temp;
			temp = q;
		}
		return p;
	}
}
