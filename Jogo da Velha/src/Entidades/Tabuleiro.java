package Entidades;

import java.util.Scanner;

public class Tabuleiro {

	private int[][] tabuleiro;
	
	public void inicializaTabuleiro(){
		this.tabuleiro = new int[3][3];
	}
	
	public void imprimirTabuleiro() {
		System.out.println();
		for(int linha=0 ; linha<3 ; linha++){
			
            for(int coluna=0 ; coluna<3 ; coluna++){
                switch(this.tabuleiro[linha][coluna]){
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
                if(coluna==0 ||coluna==1){
                    System.out.print("|");
                }
                
                
            }       
            System.out.println();
		}
		
	}
	
	public int leiaCoordenadaLinha(){
		Scanner input = new Scanner(System.in);
		System.out.println("Linha: ");
		int linha = input.nextInt();
		return linha;
	}
	
	public int leiaCoordenadaColuna(){
		Scanner input = new Scanner(System.in);
		System.out.println("Coluna: ");
		int coluna = input.nextInt();
		return coluna;
	}
	
	public void jogar() {
		inicializaTabuleiro();
		int jogador = -1;
		for(int index = 0; index < 9; index ++) {
			int linha = this.leiaCoordenadaLinha();
			int coluna = this.leiaCoordenadaColuna();
			this.tabuleiro[linha - 1][coluna - 1] = jogador;
			jogador = jogador == -1 ? 1:-1;
			imprimirTabuleiro();
		}
	}
}
