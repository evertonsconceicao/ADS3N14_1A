/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

public class ListaEncadeada<T> {

    protected Nodo<T> ponta;
    protected Nodo<T> cauda;

	public ListaEncadeada() {
		ponta = null;
		cauda = null;
	}

	public void insereNovo(Nodo<T> novo) {
		novo.proximo(ponta);
		ponta = novo;
		if (cauda == null)
			cauda = novo;
	}

	public void insereNovo(Nodo<T> novo, Nodo<T> anterior) {
		if (anterior == null) {
			novo.proximo(ponta);
			ponta = novo;
			if (cauda == null)
				cauda = ponta;
		} else {
			novo.proximo(anterior.getProximo());
			anterior.proximo(novo);
			if (anterior == cauda)
				cauda = novo;
		}
	}

	public void anexar(Nodo<T> novo) {
		if (cauda != null) {
			cauda.proximo(novo);
		} else {
			ponta = novo;
		}
		cauda = novo;
	}

	public Nodo<T> getPonta() {
		return ponta;
	}

	public Nodo<T> getCauda() {
		return cauda;
	}
}