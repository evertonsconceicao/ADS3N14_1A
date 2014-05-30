/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

public class Nodo<T> {
	private T chave;
	private Nodo<T> proximo;

	public Nodo() {
		chave = null;
		proximo = null;
	}
	public T getChave() {
		return chave;
	}
	public void setChave(T chave) {
		this.chave = chave;
	}
	public Nodo<T> getProximo() {
		return proximo;
	}
	public void proximo(Nodo<T> proximo) {
		this.proximo = proximo;
	}
}