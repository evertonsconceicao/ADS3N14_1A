/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

public class ListaOrdenada<T extends Comparable<T>> extends ListaEncadeada<T>
{	
	public Nodo<T> procuraNodo(Nodo<T> needle)
	{
		Nodo<T> atual = getPonta();
		Nodo<T> anterior = null;
		T chaveNeedle = needle.getChave();

		while (atual != null) {
			T chaveAtual = atual.getChave();
			int cmp = chaveNeedle.compareTo(chaveAtual);
			if (cmp == 0)
				return atual; 
			if (cmp < 0)
				return anterior;
			anterior = atual;
			atual = atual.getProximo();
		}
		return anterior;
	}

	public void anexar(Nodo<T> novo)
	{
		insereNovo(novo);
	}

	public void insereNovo(Nodo<T> novo, Nodo<T> anterior)
	{
		insereNovo(novo);
	}

	public void insereNovo(Nodo<T> novo)
	{
		Nodo<T> anterior = procuraNodo(novo);

		if (anterior == null) {
			novo.proximo(ponta);
			ponta = novo;
			if (cauda == null)
				cauda = novo;
		} else {
			novo.proximo(anterior.getProximo());
			anterior.proximo(novo);
			if (cauda == anterior)
				cauda = novo;
		}		
	}
}