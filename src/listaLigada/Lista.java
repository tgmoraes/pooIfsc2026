package listaLigada;

public interface Lista<E> {

	//adiciona no final
	void add(E info);

	//retorna elemento na Pos
	E get(int pos);

	//remove na posicao
	E remove(int pos);

	int size();

}