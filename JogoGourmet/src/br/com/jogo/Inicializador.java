package br.com.jogo;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import br.com.jogo.dto.ArvoreBinaria;
import br.com.jogo.dto.No;

public class Inicializador {

	static ArvoreBinaria arvoreBinaria;
	static boolean loop = true;
	
	static Locale currentLocale = new Locale("pt","BR");
	static ResourceBundle messages = ResourceBundle.getBundle("messages", currentLocale);
	
	public static void main(String[] args) {
		arvoreBinaria = new ArvoreBinaria();
		iniciarJogoGourmet();
	}

    private static void inicializar() {
        arvoreBinaria.insert(null, "Massa", true);
        arvoreBinaria.insert(arvoreBinaria.raiz, "Lasanha", true);
        arvoreBinaria.insert(arvoreBinaria.raiz, "Bolo de chocolate", false);
    }

    public static void iniciarJogoGourmet() {
        if (arvoreBinaria.isEmpty()) {
            inicializar();
        }

        int dialogInicial = dialogInicial();
        if (dialogInicial == JOptionPane.CLOSED_OPTION) {
            loop = false;
        }

        while (loop) {
            informarPrato(arvoreBinaria.raiz);
        }
        System.exit(0);
    }

    public static void informarPrato(No no) {
    	Object [] param = {no.getValor()};
    	String pergunta = getMessage("pergunta.prato", param);
        Object[] options = { messages.getString("label.sim"), messages.getObject("label.nao") };
        int resposta = JOptionPane.showOptionDialog(null, pergunta, messages.getString("titulo.confirme"), JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        if (resposta == JOptionPane.OK_OPTION) {
            boolean isFolha = no.getNoDireita() == null && no.getNoEsquerda() == null;
        	if (isFolha) {
        		JOptionPane.showInternalMessageDialog(null, messages.getString("msg.acertei"), messages.getString("titulo.jogo"), JOptionPane.INFORMATION_MESSAGE);
                iniciarJogoGourmet();
            } else {
                informarPrato(no.getNoDireita());
            }
        } else {
            if (no.getNoDireita() == null) {
                obterInformacaoNovoPrato(no);
                iniciarJogoGourmet();
            } else {
                informarPrato(no.getNoEsquerda());
            }
        }
    }

    private static int dialogInicial() {
        Object[] options = {"Ok"};
        return JOptionPane.showOptionDialog(null, getMessage("pense.prato", null) , messages.getString("titulo.jogo"), JOptionPane.PLAIN_MESSAGE, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
    }


    private static void obterInformacaoNovoPrato(No no) {
        String novoPrato = JOptionPane.showInputDialog(getMessage("qual.prato", null));
        Object[] param = {novoPrato, no.getValor()};
        String caracteristica = JOptionPane.showInputDialog(getMessage("novo.prato", param));

        alterarValorParaNo(no, caracteristica, novoPrato);
    }

    private static void alterarValorParaNo(No no, String caracteristica, String valor) {
        String chute = no.getValor();
        no.setValor(caracteristica);
        no.setNoEsquerda(new No(chute));
        no.setNoDireita(new No(valor));
    }
    
    private static String getMessage(String chave, Object[] parametro) {
		return MessageFormat.format(messages.getString(chave), parametro);
    }
}
