package br.com.macario.trees;

import br.com.macario.aed.nodes.Node;

public abstract class Tree {

	private Node root;
	
	public abstract void insert(String key);
	public abstract void remove(String key);
	public abstract Node search(Node node, String key);
	
	public void order(Node node){
		if (node != null){
			order(node.getSubTreeLeft());
			System.out.println(node.getKey());
			order(node.getSubTreeRight());
		}
	}
	
	public void preOrder(Node node){
		if (node != null){
			System.out.println(node.getKey());
			preOrder(node.getSubTreeLeft());
			preOrder(node.getSubTreeRight());
		}
	}
	
	public void postOrder(Node node){
		if (node != null){
			postOrder(node.getSubTreeLeft());
			postOrder(node.getSubTreeRight());
			System.out.println(node.getKey());
		}
	}
	
	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}
}