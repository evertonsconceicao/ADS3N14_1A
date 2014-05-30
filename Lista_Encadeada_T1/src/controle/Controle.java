/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controle;

import modelo.ListaOrdenada;
import visualizacao.Visualiza;
import modelo.Nodo;

public class Controle {

	private ListaOrdenada<Integer> lista = new ListaOrdenada<Integer>();
	private Visualiza view = new Visualiza();

	public void iniciaLista() {
		for (int i = 0; i < 20; ++i) {
			Nodo<Integer> pessoa = new Nodo<Integer>();
			pessoa.setChave(null);
			lista.insereNovo(pessoa);
		}
	}

	public void imprimeLista() {
		Nodo<Integer> nodo = lista.getPonta();
		while (nodo != null) {
			view.imprimeInteiro(nodo.getChave());
			nodo = nodo.getProximo();
		}
	}
}