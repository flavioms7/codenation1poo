package br.com.codenation.aceleradev.rec.loja.exceptions;

public class EstoqueInsuficienteException extends Exception {
	public EstoqueInsuficienteException() {
		super();
	}
	
	public EstoqueInsuficienteException(String message) {
		super(message);
	}
}
