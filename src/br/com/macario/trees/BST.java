package br.com.macario.trees;

import br.com.macario.aed.nodes.Node;

/**
 * Classe que implementa os métodos de uma Árvore Binária de Busca
 * @author Francisco Macário
 */
public class BST extends Tree{
	
	public BST(){
		super();
	}
	
	@Override
	public Node search(Node node, String key) {
		if (node != null && compareStringNodes(node, key) == 0){
			return node;
		} else if (node != null && (compareStringNodes(node, key) > 0)){
			return search(node.getSubTreeLeft(),key);
		} else if (node != null && compareStringNodes(node, key) < 0) {
			return search(node.getSubTreeRight(),key);
		}
		return node;
	}
	
	public int compareStringNodes(Node node, String key){
		return node.getKey().compareTo(key);
	}
	
	public Node minimum(Node node){
		while (node != null && node.getSubTreeLeft() != null){
			node = node.getSubTreeLeft();
		}
		return node;
	}
	
	public Node maximum(Node node){
		while (node != null && node.getSubTreeRight() != null){
			node = node.getSubTreeRight();
		}
		return node;
	}
	
	public Node predeccessor(Node node){
		if (node != null){
			return node.getSubTreeRight();
		}
		return node;
	}
	
	public Node successor(Node node){
		if (node != null && node.getSubTreeRight() != null){
			return minimum((node.getSubTreeRight()));
		} else {
			Node father = node.getFather(); 
			while (father != null && node == father.getSubTreeRight()){
				node = father;
				father = father.getFather();
			}
			return father;
		}
	}
	
	@Override
	public void insert(String key){
		Node fatherNode = null;
		Node node = getRoot();
		Node newNode = new Node(key,null, null);
		while (node != null){
			fatherNode = node;
			if (compareStringNodes(newNode, node.getKey()) > 0){
				node = node.getSubTreeRight();
			} else {
				node = node.getSubTreeLeft();
			}
		}
		newNode.setFather(fatherNode);
		if (fatherNode == null) {
			setRoot(newNode);
		} else if (compareStringNodes(newNode, fatherNode.getKey()) > 0){
			fatherNode.setSubTreeRight(newNode);
		} else {
			fatherNode.setSubTreeLeft(newNode);
		}
	}
	
	private void transplant(Node node, Node son){
		if (node.getFather() == null){
			setRoot(son);
		} else if (node == node.getFather().getSubTreeLeft()){
			node.getFather().setSubTreeLeft(son);
		} else {
			node.getFather().setSubTreeRight(son);
		}
		if (son != null){
			son.setFather(node.getFather());
		}
	}
	
	@Override
	public void remove(String key){
		if (getRoot() != null) {
			Node node = search(getRoot(), key);
			if (node != null) {
				if (node.getSubTreeLeft() == null){
					transplant(node, node.getSubTreeRight());
				} else if (node.getSubTreeRight() == null){
					transplant(node, node.getSubTreeLeft());
				} else {
					Node nodeAux = minimum(node.getSubTreeRight());
					if (nodeAux.getFather() != node){
						transplant(nodeAux, nodeAux.getSubTreeRight());
						nodeAux.setSubTreeRight(node.getSubTreeRight());
						nodeAux.getSubTreeRight().setFather(nodeAux);
					}
					transplant(node, nodeAux);
					nodeAux.setSubTreeLeft(node.getSubTreeLeft());
					nodeAux.getSubTreeLeft().setFather(nodeAux);
				}
			}
		}
	}

	
}