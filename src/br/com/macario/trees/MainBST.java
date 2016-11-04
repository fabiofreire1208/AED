package br.com.macario.trees;

public class MainBST {

	public static void main(String[] args) {
		Tree bst = new BST();
		bst.insert(15);
		bst.insert(18);
		bst.insert(17);
		bst.insert(20);
		bst.insert(6);
		bst.insert(7);
		bst.insert(13);
		bst.insert(9);
		bst.insert(3);
		bst.insert(2);
		bst.insert(4);
		
		bst.order(bst.getRoot());
		
		bst.remove(18);
		bst.remove(3);
		
		bst.order(bst.getRoot());
	}
}
