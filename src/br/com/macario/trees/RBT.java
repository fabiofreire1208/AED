package br.com.macario.trees;

import br.com.macario.aed.nodes.Node;

/**
 * Classe que implementa os m�todos de uma �rvore Rubro Negra
 * @author Francisco Mac�rio
 *
 */
public class RBT extends BST{

	@Override
	public Node search(Node node, String key) {
		// TODO Auto-generated method stub
		return super.search(node, key);
	}

	@Override
	public void insert(String key) {
		// TODO Auto-generated method stub
		super.insert(key);
	}

	@Override
	public void remove(String key) {
		// TODO Auto-generated method stub
		super.remove(key);
	}

	public void leftRotate(Node node){
		Node y = new Node();
		y = node.getSubTreeRight();
		node.setSubTreeRight(y.getSubTreeLeft());

		if(y.getSubTreeLeft() != null){
			y.getSubTreeLeft().setFather(node);
		}

		y.setFather(node.getFather());

		if(node.getFather() == null){
			setRoot(y);
		} else if(node == node.getFather().getSubTreeLeft()){
			node.getFather().setSubTreeLeft(y);
		} else {
			node.getFather().setSubTreeRight(y);
		}

		y.setSubTreeLeft(node);
		node.setFather(y);
	}

	public void rightRotate(Node node){
		Node y = new Node();
		y = node.getSubTreeLeft();
		node.setSubTreeLeft(y.getSubTreeRight());
		
		if(y.getSubTreeRight() != null){
			y.getSubTreeRight().setFather(node);
		}
		
		y.setFather(node.getFather());
		
		if(node.getFather() == null){
			setRoot(y);
		} else if(node == node.getFather().getSubTreeRight()){
			node.getFather().setSubTreeRight(y);
		} else {
			node.getFather().setSubTreeLeft(y);
		}
		
		y.setSubTreeRight(node);
		node.setFather(y);
	}

}