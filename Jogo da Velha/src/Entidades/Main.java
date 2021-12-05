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
		MenuPrincipal menu = new MenuPrincipal();
		int opcaoSelecionada = menu.imprimeMenuPrincipal();
		Tabuleiro tabuleiro = Tabuleiro.getInstance();
		
		switch(opcaoSelecionada) {
			case(1):
				tabuleiro.jogar(false);
				break;
			case(2):
				tabuleiro.jogar(true);
				break;
			case(3):
				System.out.println("Em construção");
				break;
		}
	}
}
