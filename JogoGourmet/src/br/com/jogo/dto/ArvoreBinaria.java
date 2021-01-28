package br.com.jogo.dto;

public class ArvoreBinaria {

	public No raiz;
	
	public void insert(No parentNode, String value, boolean choice) {
        raiz = insertNewNode(parentNode, value, choice);
    }

    public void showTree(No no) {
        if (no != null) {
            System.out.println(no.getValor());
            showTree(no.getNoEsquerda());
            showTree(no.getNoDireita());
        }
    }

    public boolean isEmpty() {
        return raiz == null;
    }

    private No insertNewNode(No noPai, String valor, boolean escolha) {
        if (noPai == null) {
            noPai = new No(valor);
            return noPai;
        } else if (escolha) {
            noPai.setNoDireita(insertNewNode(noPai.getNoDireita(), valor, escolha));
        } else {
            noPai.setNoEsquerda(insertNewNode(noPai.getNoEsquerda(), valor, escolha));
        }

        return noPai;
    }
}
