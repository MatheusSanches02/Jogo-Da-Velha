package Entidades;

import java.util.Scanner;

public class MenuPrincipal {
	public int imprimeMenuPrincipal() {
		Scanner input = new Scanner(System.in);
		int opcao;
		System.out.println("1 - Jogador x Jogador");
		System.out.println("2 - Jogador x M�quina(F�cil)");
		System.out.println("3 - Jogador x M�quina(Dif�cil)");
		System.out.println("Selecione sua op��o: ");
		opcao = input.nextInt();
		return opcao;
	}
}
