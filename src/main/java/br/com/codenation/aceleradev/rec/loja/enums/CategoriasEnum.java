package br.com.codenation.aceleradev.rec.loja.enums;

public enum CategoriasEnum {
	SHOWS(0), FILMES(1), SOFTWARES(2);
	
	public int valor;
	CategoriasEnum(int valor){
		this.valor = valor;
	}
	
	public int getValor() {
		return valor;
	}
}
