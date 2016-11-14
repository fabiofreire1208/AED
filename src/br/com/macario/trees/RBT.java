package br.com.macario.trees;

import br.com.macario.aed.nodes.Node;
import br.com.macario.aed.nodes.NodeRBT;

/**
 * Classe que implementa os m�todos de uma �rvore Rubro Negra
 * @author Francisco Mac�rio
 *
 */
public class RBT extends BST{
	
	private NodeRBT nil = new NodeRBT();
	private NodeRBT root = nil;
	
	public RBT(){
		root.setSubTreeLeft(nil);
		root.setSubTreeRight(nil);
		root.setFather(nil);
		super.setRoot(root);
	}

	@Override
	public Node search(Node node, String key) {
		// TODO Auto-generated method stub
		return super.search(node, key);
	}

	@Override
	public void insert(String key) {
		NodeRBT y = nil;
		NodeRBT x = root;
		NodeRBT node = new NodeRBT(key, null, null);
		
		while(!isNil(x)){
			y = x;
			x = (NodeRBT) (compareStringNodes(node, x.getKey()) < 0 ? x.getSubTreeLeft() : x.getSubTreeRight());
		}
		
		node.setFather(y);
		
		if(isNil(y)){
			root = node;
		} else if(compareStringNodes(node, y.getKey()) < 0){
			y.setSubTreeLeft(node);
		} else{
			y.setSubTreeRight(node);
		}
		
		node.setSubTreeLeft(nil);
		node.setSubTreeRight(nil);
		node.setColor(NodeRBT.RED);
		insertFixUp(node);
	}

	@Override
	public void remove(String key) {
		// TODO Auto-generated method stub
		super.remove(key);
	}

	public void leftRotate(NodeRBT node){
		NodeRBT y;
		y = (NodeRBT) node.getSubTreeRight();
		node.setSubTreeRight(y.getSubTreeLeft());

		if(!isNil((NodeRBT) y.getSubTreeLeft())){
			y.getSubTreeLeft().setFather(node);
		}

		y.setFather(node.getFather());

		if(isNil((NodeRBT) node.getFather())){
			root = y;
		} else if(node == node.getFather().getSubTreeLeft()){
			node.getFather().setSubTreeLeft(y);
		} else {
			node.getFather().setSubTreeRight(y);
		}

		y.setSubTreeLeft(node);
		node.setFather(y);
	}

	public void rightRotate(NodeRBT node){
		NodeRBT y;
		y = (NodeRBT) node.getSubTreeLeft();
		node.setSubTreeLeft(y.getSubTreeRight());

		if(!isNil((NodeRBT) y.getSubTreeRight())){
			y.getSubTreeRight().setFather(node);
		}

		y.setFather(node.getFather());

		if(isNil((NodeRBT) node.getFather())){
			root = y;
		} else if(node == node.getFather().getSubTreeRight()){
			node.getFather().setSubTreeRight(y);
		} else {
			node.getFather().setSubTreeLeft(y);
		}

		y.setSubTreeRight(node);
		node.setFather(y);
	}

	public void insertFixUp(NodeRBT node){
		
		NodeRBT y = nil;
		
		
		while( ((NodeRBT) node.getFather()).getColor() == NodeRBT.RED){

			if(node.getFather() == node.getFather().getFather().getSubTreeLeft()){
				y = (NodeRBT) node.getFather().getFather().getSubTreeRight();

				//Caso 1
				if(y.getColor() == NodeRBT.RED){
					((NodeRBT) node.getFather()).setColor(NodeRBT.BLACK);
					y.setColor(NodeRBT.BLACK);
					((NodeRBT) node.getFather().getFather()).setColor(NodeRBT.RED);
					node = (NodeRBT) node.getFather().getFather();

				//caso 2
				} else if(node == node.getFather().getSubTreeRight()){
					node = (NodeRBT) node.getFather();
					leftRotate(node);
				}

				//caso 3
				else {
					((NodeRBT) node.getFather()).setColor(NodeRBT.BLACK);
					((NodeRBT) node.getFather().getFather()).setColor(NodeRBT.RED);
					rightRotate((NodeRBT) node.getFather().getFather());
				}


			} else {

				y = (NodeRBT) node.getFather().getFather().getSubTreeLeft();

				//caso 1
				if (y.getColor() == NodeRBT.RED){
					((NodeRBT) node.getFather()).setColor(NodeRBT.BLACK);
					y.setColor(NodeRBT.BLACK);
					((NodeRBT) node.getFather().getFather()).setColor(NodeRBT.RED);
					node = (NodeRBT) node.getFather().getFather();
				}

				//caso 2
				else if (node == node.getFather().getSubTreeLeft()){
					node = (NodeRBT) node.getFather();
					rightRotate(node);
				}
				//caso 3
				else{
					((NodeRBT) node.getFather()).setColor(NodeRBT.BLACK);
					((NodeRBT) node.getFather().getFather()).setColor(NodeRBT.RED);
					leftRotate((NodeRBT) node.getFather().getFather());
				}
			}
		}


		root.setColor(NodeRBT.BLACK);

	}
	
	private boolean isNil(NodeRBT node){
		
		return node == nil;
	}
	
//	public void setRoot(){
//		super.setRoot(root);
//	}
	
	public NodeRBT getRoot(){
		return root;
	}
	
	
	public void rbPrint(NodeRBT node){
		if (!isNil(node)){
			rbPrint((NodeRBT) node.getSubTreeLeft());
			System.out.println(node.getKey());
			rbPrint((NodeRBT) node.getSubTreeRight());
		}
	}
	
	
	
	
}