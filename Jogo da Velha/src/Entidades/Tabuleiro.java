package Entidades;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class Tabuleiro {
	
	private static Tabuleiro uniqueInstance = new Tabuleiro();
	private static int[][] tabuleiro;
	
	private Tabuleiro() {}
	
	public static Tabuleiro getInstance() {
		return uniqueInstance;
	}
	
	public void jogar(boolean contraAMaquina) {
		int jogador1Pontuacao = 0;
		int jogador2Pontuacao = 0;
		int jogadorCampeaoDaRodada = 0;
		boolean continuaJogando = true;
		while (continuaJogando == true)
		{
			inicializaTabuleiro();
			jogadorCampeaoDaRodada = 0;
			int jogador = -1;
			for(int index = 0; index < 9; index++) {
				if (contraAMaquina && jogador == 1)
				{
					maquinaJoga();
				}
				else
				{
					jogadorJoga(jogador);					
				}
				
				jogador = jogador == -1 ? 1 : -1;
				imprimirTabuleiro();
				jogadorCampeaoDaRodada = buscarVencedor();
				
				if (jogadorCampeaoDaRodada != 0) break;
			}
			
			if (jogadorCampeaoDaRodada != 0)
			{
				if (jogadorCampeaoDaRodada == -1) jogador1Pontuacao = jogador1Pontuacao + 1;
				if (jogadorCampeaoDaRodada == 1) jogador2Pontuacao = jogador2Pontuacao + 1;
			}
			
			Scanner input = new Scanner(System.in);
			System.out.println("");
			System.out.println("Quer jogar mais uma partida?");
			System.out.println("Digite 1 para SIM");
			System.out.println("Digite 2 para NÃO");
			System.out.println("");
			
			int resposta = input.nextInt();
			continuaJogando = resposta == 1 ? true : false;
			imprimirPontuacao(jogador1Pontuacao, jogador2Pontuacao, continuaJogando);
		}
	}
	
	private void inicializaTabuleiro() {
		tabuleiro = new int[3][3];
	}
	
	private void imprimirTabuleiro() {
		System.out.println();
		for(int linha=0 ; linha<3 ; linha++) {
            for(int coluna=0 ; coluna<3 ; coluna++) {
                switch(tabuleiro[linha][coluna]) {
                	case(-1):
                		System.out.print(" X ");
                		break;
                	case(1):
                		System.out.print(" O ");
                		break;
                	default:
                		System.out.print("   ");
                		break;
                }
                
                if(coluna==0 ||coluna==1) {
                    System.out.print("|");
                }
            }    
            
            System.out.println();
		}
	}
	
	private int leiaCoordenadaLinha() {
		Scanner input = new Scanner(System.in);
		System.out.println("Digite sua linha: ");
		int linha = input.nextInt();
		return linha;
	}
	
	private int leiaCoordenadaColuna() {
		Scanner input = new Scanner(System.in);
		System.out.println("Digite sua coluna: ");
		int coluna = input.nextInt();
		return coluna;
	}
	
	private void jogadorJoga(int jogador) {
		boolean valorValido = false;
		while(valorValido == false)
		{
			int linha = leiaCoordenadaLinha();
			int coluna = leiaCoordenadaColuna();
			valorValido = verificarPosicao(linha, coluna);
			
			if (valorValido)
			{
				tabuleiro[linha - 1][coluna - 1] = jogador;
			}
			else
			{
				System.out.println("A posição está inválida. Tente novamente");
			}
		}
	}
	
	/**
	 * Verificar a possibilidade de utilizar o NULL dentro do IF
	 */
	private boolean verificarPosicao(int linha, int coluna) {
		if (linha > 3 || coluna > 3 || linha < 1 || coluna <1)
		{
			return false;
		}
		
		if (tabuleiro[linha - 1][coluna - 1] == 0)
		{
			return true;
		}
		
		return false;
	}

	private int buscarVencedor() {
		int player1 = 0;
		int player2 = 0;
		int jogadorComMaisJogadas = 0;
		
		for (int index = 0; index < 3; index++)
		{
			player1 = player1 + Arrays.stream(tabuleiro[index]).filter(x -> x == -1).toArray().length;
			player2 = player2 + Arrays.stream(tabuleiro[index]).filter(x -> x == 1).toArray().length;
		}
		
		
		if (player1 >= 3 || player2 >= 3)
		{
			jogadorComMaisJogadas = player1 > player2 ? -1 : 1;
			if (
					verificarCombinacaoHorizontal(jogadorComMaisJogadas) || 
					verificarCombinacaoVertical(jogadorComMaisJogadas) || 
					verificarCombinacaoDiagonal(jogadorComMaisJogadas))
			{
				System.out.println("");
				System.out.println("O jogador campeão da rodada é: Jogador " + (jogadorComMaisJogadas == -1 ? "1" : "2"));
				System.out.println("");
				
				return jogadorComMaisJogadas;
			}
			else if (player1 + player2 == 9) 
			{
				System.out.println("O jogo deu velha.");
			}
		}
		
		return 0;
	}
	
	private boolean verificarCombinacaoHorizontal(int jogadorComMaisJogadas) {
		for (int index = 0; index < 3; index++)
		{
			if (tabuleiro[index][0] == jogadorComMaisJogadas && tabuleiro[index][1] == jogadorComMaisJogadas && tabuleiro[index][2] == jogadorComMaisJogadas)
			{
				return true;
			}
		}
		
		return false;
	}
	
	private boolean verificarCombinacaoVertical(int jogador) {
		for (int index = 0; index < 3; index++)
		{
			if (tabuleiro[0][index] == jogador && tabuleiro[1][index] == jogador && tabuleiro[2][index] == jogador)
			{
				return true;
			}
		}
		
		return false;
	}

	private boolean verificarCombinacaoDiagonal(int jogador) {
		if (tabuleiro[0][0] == jogador && tabuleiro[1][1] == jogador && tabuleiro[2][2] == jogador)
		{
			return true;
		}
		
		if (tabuleiro[0][2] == jogador && tabuleiro[1][1] == jogador && tabuleiro[2][0] == jogador)
		{
			return true;
		}
		
		return false;
	}

	private void imprimirPontuacao(int player1, int player2, boolean continuarJogando) {
		System.out.println("O jogador 1 tem " + player1 + " pontos.");
		System.out.println("O jogador 2 tem " + player2 + " pontos.");
		
		String message = continuarJogando ? "até o momento" : "";
		String playerCampeao = player1 > player2 ? "jogador 1" : "jogador 2";
		
		if (player1 == player2 && continuarJogando == false)
		{
			System.out.println("O jogo deu empate.");
			return;
		}
		
		System.out.println("O jogador campeao" + message + " é " + playerCampeao + ".");	
	}

	private void maquinaJoga() {
		Random random = new Random();
		
		boolean verificado = false;
		while (verificado == false)
		{
			int linha = random.nextInt(5);
			int coluna = random.nextInt(5);
			
			System.out.println("linha: " + linha);
			System.out.println("coluna: " + coluna);
			
			
			if (linha == 0) linha = linha + 1;
			if (coluna == 0) coluna = coluna+ 1;
			
			verificado = verificarPosicao(linha, coluna);
			if (verificado)
			{
				tabuleiro[linha - 1][coluna - 1] = 1;
				System.out.println("");
				System.out.println("A maquina fez a jogada, agora é a sua vez");
			}
		}
	}
}
