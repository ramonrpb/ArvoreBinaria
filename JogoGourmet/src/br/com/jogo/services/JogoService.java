package br.com.jogo.services;

import br.com.jogo.domain.ArvoreBinaria;
import br.com.jogo.domain.No;

public class JogoService {

	private ArvoreBinaria arvoreBinaria;
	
    public ArvoreBinaria inicializar() {
    	arvoreBinaria = new ArvoreBinaria();
        arvoreBinaria.adiciona(null, "Massa", true);
        arvoreBinaria.adiciona(arvoreBinaria.getRaiz(), "Lasanha", true);
        arvoreBinaria.adiciona(arvoreBinaria.getRaiz(), "Bolo de chocolate", false);
        return arvoreBinaria;
    }

    public void alterarValorParaNo(No no, String caracteristica, String valor) {
        String chute = no.getValor();
        no.setValor(caracteristica);
        no.setNoEsquerda(new No(chute));
        no.setNoDireita(new No(valor));
    }
    
    public boolean isFolha(No no) {
    	return no.getNoDireita() == null && no.getNoEsquerda() == null;
    }
    
}
