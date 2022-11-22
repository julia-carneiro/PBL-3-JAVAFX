package app.model.Exceptions;

import app.model.Selecao;
/**
 * 
 * @author Julia Carneiro e Humberto Bandeira
 *
 */
public class SelecaoLimiteException extends Exception {
	/**
	 * Excecao de limite de 32 selecoes
	 * @param selecao
	 * @param size
	 */
	public SelecaoLimiteException(Selecao selecao, int size) {
		super("A selecao " + selecao.getName() + " não pode ser adicionada! Limite de " + size + " selecoes atingido!");
	}
}