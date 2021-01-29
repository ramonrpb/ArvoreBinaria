package br.com.jogo.domain;

import java.io.Serializable;

public class No implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String valor;
	private No noEsquerda;
	private No noDireita;
	
	public No() {
	}
	public No(String valor) {
		super();
		this.valor = valor;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	public No getNoEsquerda() {
		return noEsquerda;
	}
	public void setNoEsquerda(No noEsquerda) {
		this.noEsquerda = noEsquerda;
	}
	public No getNoDireita() {
		return noDireita;
	}
	public void setNoDireita(No noDireita) {
		this.noDireita = noDireita;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((noDireita == null) ? 0 : noDireita.hashCode());
		result = prime * result + ((noEsquerda == null) ? 0 : noEsquerda.hashCode());
		result = prime * result + ((valor == null) ? 0 : valor.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		No other = (No) obj;
		if (noDireita == null) {
			if (other.noDireita != null)
				return false;
		} else if (!noDireita.equals(other.noDireita))
			return false;
		if (noEsquerda == null) {
			if (other.noEsquerda != null)
				return false;
		} else if (!noEsquerda.equals(other.noEsquerda))
			return false;
		if (valor == null) {
			if (other.valor != null)
				return false;
		} else if (!valor.equals(other.valor))
			return false;
		return true;
	}
	
	
}
