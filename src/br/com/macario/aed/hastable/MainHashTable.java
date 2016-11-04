package br.com.macario.aed.hastable;

public class MainHashTable {

	public static void main(String[] args) {
		HashTable hashtable = new HashTable(100);
		hashtable.insert(100);
		hashtable.insert(200);
		hashtable.insert(300);
		hashtable.insert(111);
		
		hashtable.printTable();
		System.out.println();
		Integer delete1 = hashtable.delete(100);
		Integer delete2 = hashtable.delete(101);
		Integer search1 = hashtable.search(200);
		Integer search2 = hashtable.search(400);
		
		System.out.println(delete1 != null ? delete1 : "NÃO EXISTE");
		System.out.println(delete2 != null ? delete2 : "NÃO EXISTE");
		System.out.println(search1 != null ? search1 : "NÃO EXISTE");
		System.out.println(search2 != null ? search2 : "NÃO EXISTE");
		
		System.out.println();
		hashtable.printTable();
	}

}
