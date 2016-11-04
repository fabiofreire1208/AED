package br.com.macario.aed.nodes;

/**
 * Nó padrão de uma árvore
 * @author Francisco Macário
 */
public class Node {
	
	private int key;
	private Node subTreeLeft;
	private Node subTreeRight;
	private Node father;
	
	public Node(){}
	
	public Node(int key){
		this.key = key;
	}
	
	public Node(int key, Node father){
		this.key = key;
		this.father = father;
	}
	
	public Node(int key, Node subTreeLeft, Node subTreeRight){
		this.key = key;
		this.subTreeLeft = subTreeLeft;
		this.subTreeRight = subTreeRight;
	}
	
	public Node(Node subTreeLeft, Node subTreeRight, Node father){
		this.subTreeLeft = subTreeLeft;
		this.subTreeRight = subTreeRight;
		this.father = father;
	}
	
	public Node(int key, Node subTreeLeft, Node subTreeRight, Node father){
		this.key = key;
		this.subTreeLeft = subTreeLeft;
		this.subTreeRight = subTreeRight;
		this.father = father;
	}
	
	public int getKey() {
		return key;
	}
	public void setKey(int key) {
		this.key = key;
	}
	public Node getSubTreeLeft() {
		return subTreeLeft;
	}
	public void setSubTreeLeft(Node subTreeLeft) {
		this.subTreeLeft = subTreeLeft;
	}
	public Node getSubTreeRight() {
		return subTreeRight;
	}
	public void setSubTreeRight(Node subTreeRight) {
		this.subTreeRight = subTreeRight;
	}
	public Node getFather() {
		return father;
	}
	public void setFather(Node father) {
		this.father = father;
	}	
}
