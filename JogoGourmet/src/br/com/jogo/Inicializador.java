package br.com.jogo;

import br.com.jogo.controllers.JogoController;

public class Inicializador {

	public static void main(String[] args) {
		JogoController controller = new JogoController();
		controller.jogar();
		System.exit(0);
	}
}
