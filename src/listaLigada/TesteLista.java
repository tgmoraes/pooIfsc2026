package listaLigada;

import java.util.LinkedList;

public class TesteLista {
	public static void main(String[] args) {
		Lista<Integer> lista = new ListaEncadeada<>();
		//ListaEncadeada lista = new ListaEncadeada();
		
		//LinkedList<Integer> lista2 = new LinkedList<>();
		
		lista.add(10);
		lista.add(8);
		lista.add(9);
		lista.add(258);
		lista.add(0);
		lista.add(1000);

		int tam = lista.size();
		
		System.out.println(lista);
		lista.remove(0);
		
		System.out.println(lista);
		
		lista.remove(3);
		
		System.out.println(lista);
		
		lista.remove(1);
		
		System.out.println(lista);
	}
}
