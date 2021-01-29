package br.com.jogo.domain;

import java.io.Serializable;

public class ArvoreBinaria implements Serializable{

	private static final long serialVersionUID = 1L;

	private No raiz;
	
	public void adiciona(No parentNode, String value, boolean choice) {
        setRaiz(adicionaNovoNo(parentNode, value, choice));
    }

    public void exibeArvore(No no) {
        if (no != null) {
            exibeArvore(no.getNoEsquerda());
            exibeArvore(no.getNoDireita());
        }
    }


    private No adicionaNovoNo(No noPai, String valor, boolean escolha) {
        if (noPai == null) {
            noPai = new No(valor);
            return noPai;
        } else if (escolha) {
            noPai.setNoDireita(adicionaNovoNo(noPai.getNoDireita(), valor, escolha));
        } else {
            noPai.setNoEsquerda(adicionaNovoNo(noPai.getNoEsquerda(), valor, escolha));
        }

        return noPai;
    }

	public No getRaiz() {
		return raiz;
	}

	public void setRaiz(No raiz) {
		this.raiz = raiz;
	}
}
