package br.com.jogo.controllers;

import javax.swing.JOptionPane;

import br.com.jogo.domain.ArvoreBinaria;
import br.com.jogo.domain.No;
import br.com.jogo.services.JogoService;
import br.com.jogo.utilitarios.Utilitario;

public class JogoController {

	private JogoService service = new JogoService();
	private boolean loop = true;
	
	public int jogar() {
		ArvoreBinaria arvoreBinaria = service.inicializar();
		return iniciarJogoGourmet(arvoreBinaria);
	}
	
	private int iniciarJogoGourmet(ArvoreBinaria arvoreBinaria) {
		
        int dialogInicial = dialogInicial();
        if (dialogInicial == JOptionPane.CLOSED_OPTION) {
            loop = false;
        }

        while (loop) {
            informarPrato(arvoreBinaria.getRaiz(), arvoreBinaria);
        }
        return dialogInicial;
    }
	
	private int dialogInicial() {
        Object[] options = {"Ok"};
        return JOptionPane.showOptionDialog(null, Utilitario.getMessage("pense.prato", null) , Utilitario.messages.getString("titulo.jogo"),
        		JOptionPane.PLAIN_MESSAGE, JOptionPane.DEFAULT_OPTION, null, options, options[0]);
    }
	
	private void informarPrato(No no, ArvoreBinaria arvoreBinaria) {
    	Object [] param = {no.getValor()};
    	String pergunta = Utilitario.getMessage("pergunta.prato", param);
        Object[] options = { Utilitario.messages.getString("label.sim"), Utilitario.messages.getObject("label.nao") };
        int resposta = JOptionPane.showOptionDialog(null, pergunta, Utilitario.messages.getString("titulo.confirme"),
        		JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        if (resposta == JOptionPane.OK_OPTION) {
            boolean isFolha = service.isFolha(no);
        	if (isFolha) {
        		JOptionPane.showInternalMessageDialog(null, Utilitario.messages.getString("msg.acertei"), Utilitario.messages.getString("titulo.jogo"),
        				JOptionPane.INFORMATION_MESSAGE);
                iniciarJogoGourmet(arvoreBinaria);
            } else {
                informarPrato(no.getNoDireita(), arvoreBinaria);
            }
        } else {
            if (no.getNoDireita() == null) {
                obterInformacaoNovoPrato(no);
                iniciarJogoGourmet(arvoreBinaria);
            } else {
                informarPrato(no.getNoEsquerda(), arvoreBinaria);
            }
        }
	}
	
	private void obterInformacaoNovoPrato(No no) {
        String novoPrato = JOptionPane.showInputDialog(Utilitario.getMessage("qual.prato", null));
        Object[] param = {novoPrato, no.getValor()};
        String caracteristica = JOptionPane.showInputDialog(Utilitario.getMessage("novo.prato", param));

        service.alterarValorParaNo(no, caracteristica, novoPrato);
    }
}
