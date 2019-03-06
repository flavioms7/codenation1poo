package br.com.codenation.aceleradev.rec.loja.beans;

public class Filme extends Produto{
	
	private String diretor;
	private String anoLancamento;
	
	public String getDiretor() {
		return diretor;
	}
	public void setDiretor(String diretor) {
		this.diretor = diretor;
	}
	public String getAnoLancamento() {
		return anoLancamento;
	}
	public void setAnoLancamento(String anoLancamento) {
		this.anoLancamento = anoLancamento;
	}
	
}
