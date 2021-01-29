package br.com.jogo.utilitarios;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class Utilitario {

	public static Locale currentLocale = new Locale("pt","BR");
	public static ResourceBundle messages = ResourceBundle.getBundle("messages", currentLocale);
	
	public static String getMessage(String chave, Object[] parametro) {
		return MessageFormat.format(messages.getString(chave), parametro);
    }
	
}
