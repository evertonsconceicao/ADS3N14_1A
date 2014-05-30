/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controle;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import modelo.ListaOrdenada;
import modelo.Nodo;
import modelo.Pessoa;

public class PessoaControle<T> {

	private ListaOrdenada<Pessoa> listaOrdenadaPessoa = null;
	private Nodo<Pessoa> pessoaEncontrada;

	public void cadastraPessoa() {

		Scanner leitor = new Scanner(System.in);
		Pessoa pessoacadastro = new Pessoa();

		try {
                        System.out.println("\nContato");
			System.out.println("\n -> Nome:");
			String nome = leitor.nextLine();
			pessoacadastro.setNome(nome);

			System.out.println(" -> Numero:");
			String telefone = leitor.nextLine();
			pessoacadastro.setTelefone(telefone);
			File arq = new File("C:\\Users\\Everton\\Documents\\NetBeansProjects\\ListaEncadeada.txt");
			try (

			FileWriter filewriter = new FileWriter(arq, true)) {
				filewriter.write(pessoacadastro.getNome());
				filewriter.write("-");
				filewriter.write(pessoacadastro.getTelefone());
				filewriter.write("\n");
				filewriter.flush();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		} catch (Exception ex) {
			System.out.println("**** Erro!  ****");
		}
	}

	public void listaPessoas() {

		File arquivo = new File("C:\\Users\\Everton\\Documents\\NetBeansProjects\\ListaEncadeada.txt");

		try {
			criaListaOrdenada(arquivo);
			imprimeContatos();
		} catch (FileNotFoundException e) {
			System.out.println("Falha ao Encontrar o arquivo!");
		} catch (IOException e) {
			System.out
					.println("Falha de Leitura do Arquivo! " + e.getMessage());
		}
	}

	private void imprimeContatos() {

		Nodo<Pessoa> listaPessoa = listaOrdenadaPessoa.getPonta();
		if (listaPessoa != null) {

			do {
				if (listaPessoa.getChave() != null) {
					System.out.println(listaPessoa.getChave().getNome() + " "
                                                + listaPessoa.getChave().getTelefone());
                                        listaPessoa = listaPessoa.getProximo();
				}

			} while (listaPessoa != null);
		} else {
			System.out.println("**** Agenda Vazia! ****");
		}
	}

	private void criaListaOrdenada(File arquivo)

	throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(arquivo));
		String linha;
		listaOrdenadaPessoa = new ListaOrdenada<>();
		while ((linha = reader.readLine()) != null) {

			Pessoa pessoa = retornaPessoa(linha);
			Nodo<Pessoa> nodo = new Nodo<>();
			nodo.setChave(pessoa);
			listaOrdenadaPessoa.anexar(nodo);
		}
	}

	private Pessoa retornaPessoa(String texto) {

		Pessoa pessoa = new Pessoa();
		String[] arrayPessoa = texto.split("-");
		pessoa.setNome(arrayPessoa[0]);
		pessoa.setTelefone(arrayPessoa[1]);

		return pessoa;
	}

	public void procuraPessoa(String letra) {

		Nodo<Pessoa> listaPessoa = listaOrdenadaPessoa.getPonta();
		do {
			if (listaPessoa.getChave() != null) {
				if (listaPessoa.getChave().getNome().startsWith(letra)) {
					pessoaEncontrada = listaPessoa;
					System.out.println(pessoaEncontrada.getChave().getNome()
							+ " " + pessoaEncontrada.getChave().getTelefone());
					break;
				} else {
					listaPessoa = listaPessoa.getProximo();
				}
			}
		} while (listaPessoa != null);
	}

	public void excluiPessoa() {

		String contatoAExcluir = null;
		FileReader lerArquivo = null;
		FileWriter escreverArquivo = null;
		BufferedReader leitor;

		String nomeDoArquivo = "C:\\Users\\Everton\\Documents\\NetBeansProjects\\ListaEncadeada.txt";
		String arquivoConferir = "C:\\Users\\Everton\\Documents\\NetBeansProjects\\ListaEncadeada.txt";
		String line = "";

		try {
			lerArquivo = new FileReader(new File(nomeDoArquivo));
			escreverArquivo = new FileWriter(new File(arquivoConferir));
			leitor = new BufferedReader(lerArquivo);
			line = "";
			while ((line = leitor.readLine()) != null) {
				if (!line.trim().equals(contatoAExcluir.trim())) {
                                    escreverArquivo.write(pessoaEncontrada + "\r\n");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				escreverArquivo.close();
				lerArquivo.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void imprimePessoaAnterior() {
		Nodo<Pessoa> listaPessoa = listaOrdenadaPessoa.getPonta();
		do {
			if (listaPessoa != null) {
				if (listaPessoa.equals(pessoaEncontrada)) {
					System.out.println("Não existe Anterior");
				}

				if (listaPessoa.getProximo() != null) {
					if (listaPessoa.getProximo().equals(pessoaEncontrada)) {
						System.out.println(listaPessoa.getChave().getNome()
								+ " " + listaPessoa.getChave().getTelefone());
						break;
					}
				}
				listaPessoa = listaPessoa.getProximo();
			}
		} while (listaPessoa != null);
	}

	public void imprimePessoaProxima() {

		pessoaEncontrada = pessoaEncontrada.getProximo();
		System.out.println(pessoaEncontrada.getChave().getNome() + " "
				+ pessoaEncontrada.getChave().getTelefone());
	}
}
