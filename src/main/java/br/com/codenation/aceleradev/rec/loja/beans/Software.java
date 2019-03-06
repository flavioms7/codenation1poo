package br.com.codenation.aceleradev.rec.loja.beans;

public class Software extends Produto {
	
	private String versao;
	private String requisitosSistema;
	
	public String getVersao() {
		return versao;
	}
	public void setVersao(String versao) {
		this.versao = versao;
	}
	public String getRequisitosSistema() {
		return requisitosSistema;
	}
	public void setRequisitosSistema(String requisitosSistema) {
		this.requisitosSistema = requisitosSistema;
	}
	
}
