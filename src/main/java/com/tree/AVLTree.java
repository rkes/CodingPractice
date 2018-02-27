package com.tree;

public class AVLTree {

	public static void main(String[] args) {
		AVLTreeImplementation avlTreeImplementation  = new AVLTreeImplementation();
		AVLNode root = null;
		root = avlTreeImplementation.insert(root , 1);
		root = avlTreeImplementation.insert(root , 2);
		root = avlTreeImplementation.insert(root , 3);
		root = avlTreeImplementation.insert(root , 4);
		root = avlTreeImplementation.insert(root , 5);
		root = avlTreeImplementation.insert(root , 6);
		root = avlTreeImplementation.insert(root , 7);
		root = avlTreeImplementation.insert(root , 8);
		root = avlTreeImplementation.insert(root , 9);
		root = avlTreeImplementation.insert(root , 10);
		root = avlTreeImplementation.insert(root ,11);
		System.out.println();
	}

}
