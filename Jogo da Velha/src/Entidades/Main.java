package Entidades;

/*************************************************/
/*
 * FIAP
 * TADS - 2o semestre 2021
 * <Professor Fernando Luiz de Almeida>
 * 
 * Checkpoint DDD
 * Arquivo: <Jogo da Velha>
 * 
 * <Danielle Rodrigues Lobo>
 * <Giovanna França>
 * <Guilherme Nunes da Silva>
 * <Matheus Sanches Barreiros>
 * 
 * <Entrega: 19/09/2021>
 *************************************************/
public class Main {

	public static void main(String[] args) {
		Tabuleiro tabuleiro = new Tabuleiro();
		MenuPrincipal menu = new MenuPrincipal();
		int opcaoSelecionada = menu.imprimeMenuPrincipal();
		switch(opcaoSelecionada) {
			case(1):
				tabuleiro.jogar();
				break;
			case(2):
				System.out.println("Em construção");
				break;
			case(3):
				System.out.println("Em construção");
				break;
			
		}
		
	}

}
