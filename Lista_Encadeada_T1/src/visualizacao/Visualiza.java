/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package visualizacao;

import java.util.Scanner;
import controle.PessoaControle;

public class Visualiza {

	public Scanner leitor = new Scanner(System.in);
	private PessoaControle pControle = new PessoaControle();

	public void imprimeInteiro(Integer valor) {
		System.out.println(valor);
	}

	public void imprimeMenu() {

		int op = 1;

		do {
                    System.out.printf("\nAgenda Contato/\n"
                            + "1 - Cadastra \n" 
                            + "2 - Procura \n"
                            + "3 - Lista \n"
                            + "0 - Sair \n");
			try {
				op = leitor.nextInt();
			} catch (Exception e) {
				System.out.println("Opcao invalida! " + e.getMessage() + "\n");
			}

			switch (op) {
			case 1:
				pControle.cadastraPessoa();
				break;
			case 2:
                                imprimeSubMenuLocalizaPessoa();
				break;
			case 3:
				pControle.listaPessoas();
				break;
                        case 0:
				System.exit(0);
				break;
			}
		} while (op != 0);
	}

	public void imprimeSubMenuLocalizaPessoa() {
		System.out.println("\nLetra Inicial Contato: ");
		Scanner leitor = new Scanner(System.in);
		try {
			String letra = leitor.nextLine();
			pControle.procuraPessoa(letra);
			imprimeSubMenuNavegacao();
		} catch (Exception e) {
			System.out.println("Opcao invalida! " + e.getMessage() + "\n");
		}
	}

	public void imprimeSubMenuNavegacao() {

		int op = 1;

		do {
                    System.out.printf("\nContato \n"
                            + "1 - Proximo \n"
                            + "2 - Anterior \n"
                            + "3 - Excluir \n"
                            + "0 - Retornar \n");
			try {
				op = leitor.nextInt();
			} catch (Exception e) {
				System.out.println("Opcao invalida! " + e.getMessage() + "\n");
			}

			switch (op) {
			case 1:
				pControle.imprimePessoaProxima();
				break;
			case 2:
				pControle.imprimePessoaAnterior();
				break;
			case 3:
				Exclui();
				break;
                        case 0:
				imprimeMenu();
				break;
			}
		} while (op != 0);
	}

	public void Exclui() {

		int op = 1;

		do {
                    System.out.printf("\nExcluir Contato/\n"
                            + "1 - Excluir \n"
                            + "0 - Retornar\n");
			try {
                            op = leitor.nextInt();
			} catch (Exception e) {
				System.out.println("Opcao invalida! " + e.getMessage() + "\n");
			}
			switch (op) {
			case 0:
				imprimeMenu();
				break;
			case 1:
				pControle.excluiPessoa();
				break;
			}
		} while (op != 0);
	}
}