package br.com.macario.trees;

import br.com.macario.aed.nodes.Node;
import br.com.macario.aed.nodes.NodeRBT;

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

	public void insertFixUp(Node node){
		while(((NodeRBT) node.getFather()).getColor() == NodeRBT.RED){

			if(node.getFather() == node.getFather().getFather().getSubTreeLeft()){
				NodeRBT y = new NodeRBT();
				y = (NodeRBT) node.getFather().getFather().getSubTreeRight();

				//Caso 1
				if(y.getColor() == NodeRBT.RED){
					((NodeRBT) node.getFather()).setColor(NodeRBT.BLACK);
					y.setColor(NodeRBT.BLACK);
					((NodeRBT) node.getFather().getFather()).setColor(NodeRBT.RED);
					node = node.getFather().getFather();

					//caso 2
				} else if(node == node.getFather().getSubTreeRight()){
					node = node.getFather();
					leftRotate(node);
				}

				//caso 3
				else {
					((NodeRBT) node.getFather()).setColor(NodeRBT.BLACK);
					((NodeRBT) node.getFather().getFather()).setColor(NodeRBT.RED);
					rightRotate(node.getFather().getFather());
				}


			} else {
			
				NodeRBT y = new NodeRBT();
				y = (NodeRBT) node.getFather().getFather().getSubTreeLeft();

				//caso 1
				if (y.getColor() == NodeRBT.RED){
					((NodeRBT) node.getFather()).setColor(NodeRBT.BLACK);
					y.setColor(NodeRBT.BLACK);
					((NodeRBT) node.getFather().getFather()).setColor(NodeRBT.RED);
					node = node.getFather().getFather();
				}

				//caso 2
				else if (node == node.getFather().getSubTreeLeft()){
					node = node.getFather();
					rightRotate(node);
				}
				//caso 3
				else{
					((NodeRBT) node.getFather()).setColor(NodeRBT.BLACK);
					((NodeRBT) node.getFather().getFather()).setColor(NodeRBT.RED);
					leftRotate(node.getFather().getFather());
				}
			}
		}


		((NodeRBT) getRoot()).setColor(NodeRBT.BLACK);

	}
}