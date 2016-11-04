package br.com.macario.aed.hastable;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementação de tabela hashing usando array finito
 * Tratamento de colisões: Chaining
 * Hashing: Método da Divisão
 * @author Francisco Macário
 */
public class HashTable {

	private int size;
	private List<List<Integer>> table;
	
	public HashTable(int size) {
		this.size = size;
		this.table = new ArrayList<List<Integer>>();
		for (int i=0;i < this.size; i++){
			this.table.add(i, new ArrayList<Integer>());
		}
	}
	
	public int hashing(int value){
		return (value % size);
	}
	
	public void insert(int value){
		table.get(hashing(value)).add(value);
	}
	
	public Integer search(int value){
		for (Integer v : table.get(hashing(value))){
			if (v == value){
				return v;
			}
		}
		return null;
	}
	
	public Integer delete(int value){
		Integer v = search(value);
		return (table.get(hashing(value)).remove(v) ? v : null);
	}
	
	public void printTable(){
		for (int i=0; i < size; i++){
			System.out.print(i + ": ");
			for (Integer v : table.get(i)){
				System.out.print(v + " ");
			}
			System.out.println();
		}
	}
}
