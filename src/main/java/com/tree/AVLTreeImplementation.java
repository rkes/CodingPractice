package com.tree;
//Code for ADM , Chapter 3, Q 3-7
public class AVLTreeImplementation {
	public AVLNode insert(AVLNode root, int key) {
		if (root == null) {
			return new AVLNode(key);
		}
		if (root.data > key)
			root.left = insert(root.left, key);
		if (root.data < key)
			root.right = insert(root.right, key);
		else
			return root;
		root.height = Math.max(getHeight(root.left), getHeight(root.right)) + 1;
		int balanceFactor = getBalanceFactor(root);
		//left left case , so rotate right
		if(balanceFactor > 1 && root.left.data > key){
			return rotateRight(root);
		}
		//right right case , so rotateLeft
		if(balanceFactor < -1 && root.right.data < key){
			return  rotateLeft(root);
		}
		// left right case , so rotate right of left subtree
		if(balanceFactor > 1 && root.left.data < key){
			root.left = rotateLeft(root.left);
			return rotateRight(root);
		}
		//right left case , hence rotate left of right subtree
		if(balanceFactor < -1 && root.right.data > key){
			root.right = rotateRight(root.right);
			return rotateLeft(root);
		}
		AVLNode pred = getPredecessor(root,key);
		if(pred!=null && pred.data < root.data ){
			root.setMin(pred.data);
		}
		AVLNode suc = getSucessor(root,key);
		if(suc!=null && suc.data > root.data ){
			root.setMin(suc.data);
		}
		return root;
	}
	public AVLNode findNode(AVLNode root,int key){
		if(root == null){
			return null;
		}
		if(root.data > key)
			return findNode(root.left, key);
		else if(root.data < key)
			return findNode(root.right,key);
		else
			return root;
			
	}
	public AVLNode getPredecessor(AVLNode root,int key){
		AVLNode node =findNode(root,key);
		if(node == null)
			return null;
		AVLNode predNode = getPredecessor(root.left);
		return predNode;
	}
	public AVLNode getSucessor(AVLNode root,int key){
		AVLNode node =findNode(root,key);
		if(node == null)
			return null;
		AVLNode predNode = getSucessor(root.right);
		return predNode;
	}
	public AVLNode getPredecessor(AVLNode root){
		if(root == null)
			return null;
		if(root.right == null)
			return root;
		return getPredecessor(root.right);
	}
	public AVLNode getSucessor(AVLNode root){
		if(root == null)
			return root;
		if(root.left == null)
			return root;
		return getSucessor(root.left);
	}

	public AVLNode rotateLeft(AVLNode node){
		AVLNode x = node.right;
		AVLNode y = x.left;
		
		x.left = node;
		node.right = y;
		node.height = Math.max(getHeight(node.left), getHeight(node.right))+1;
		x.height = Math.max(getHeight(x.left), getHeight(x.right))+1;
		return x;
	}
	public AVLNode rotateRight(AVLNode node){
		AVLNode x = node.left;
		AVLNode y = x.right;
		node.left = y;
		x.right = node;
		node.height = Math.max(getHeight(node.left),getHeight(node.right))+1;
		x.height = Math.max(getHeight(x.left), getHeight(x.right))+1;
		return x;
	}
	public int getBalanceFactor(AVLNode root){
		if(root == null) return 0;
		return getHeight(root.left)-getHeight(root.right);
	}
	public int getHeight(AVLNode root) {
		if (root == null)
			return 0;
		return root.height;
	}
}
