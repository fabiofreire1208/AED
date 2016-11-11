package br.com.macario.aed.nodes;

public class NodeRBT extends Node{
	
	public static final int RED = 0;
	public static final int BLACK = 1;
	
	private int color;
	
	public NodeRBT(){
		super();
	}
	
	public NodeRBT(String key){
		super(key);
	}
	
	public NodeRBT(String key, Node father){
		super(key, father);
	}
	
	public NodeRBT(String key, Node subTreeLeft, Node subTreeRight){
		super(key, subTreeLeft, subTreeRight);
	}
	
	public NodeRBT(Node subTreeLeft, Node subTreeRight, Node father){
		super(subTreeLeft, subTreeRight, father);
	}
	
	public NodeRBT(String key, Node subTreeLeft, Node subTreeRight, Node father){
		super(key, subTreeLeft, subTreeRight, father);
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

}
