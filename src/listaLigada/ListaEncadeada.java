package listaLigada;

public class ListaEncadeada <E> implements Lista<E> {
	private int tamanho;
	private No  inicio;
	private No  fim;
	
	public ListaEncadeada(){
		this.tamanho =0;
		this.inicio=null;
		this.fim=null;
	}
	//adiciona no final
	@Override
	public void add(E info) {
		No nodoAux = new No(info);
		//lista vazia
		if(this.inicio==null) this.inicio = nodoAux;
		else {
			this.fim.prox = nodoAux;
		}
		
		this.fim = nodoAux;
		this.tamanho++;
	}
	//retorna elemento na Pos
	@Override
	public E get(int pos) {
		return this.getNodo(pos).info;
	}
	private No getNodo(int pos) {
		validaPos(pos);
		No aux = this.inicio;
		int cont=0;
		while(aux != null && cont!=pos) {
			cont++;
			aux= aux.prox;
		}
		return aux;
	}
	//remove na posicao
	@Override
	public E remove(int pos){
		//remover no inicio
		E ret;
		if(pos==0) {
			this.validaPos(pos);
			ret = this.inicio.info;
			this.inicio = this.inicio.prox;
			if(this.tamanho==1) {
				this.fim = null;
			}
		}
		//remover no final
		else if(pos==this.tamanho -1) {
			No nodoPenultimo = this.getNodo(this.tamanho-2);
			ret = this.fim.info;
			this.fim = nodoPenultimo;
			nodoPenultimo.prox = null;
		} else {
			//remover no meio
			No nodoAnterior = this.getNodo(pos-1);
			ret = nodoAnterior.prox.info;
			nodoAnterior.prox = nodoAnterior.prox.prox;
		}
		this.tamanho--;
		return ret;
	}
	private void validaPos(int pos) {
		if(pos<0 || pos> this.tamanho-1)
			throw new IllegalArgumentException("Posição da lista inválida!");
	}
	@Override
	public int size() {
		return this.tamanho;
	}
	//classe interna
	private class  No {
		E info;
		No prox;
		
		No(E informacao){
			this.info = informacao;
			this.prox = null;
		}
	}

	@Override
	public String toString() {
		String aux = "";
		for(int i=0;i<this.tamanho;i++){
			aux = aux+this.get(i);
			if(i!=this.tamanho-1) aux+=", ";
		}
		return aux;
	}
}
