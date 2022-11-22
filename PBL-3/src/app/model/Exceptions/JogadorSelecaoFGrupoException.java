package app.model.Exceptions;

import app.model.Selecao;

/**
 * 
 * @author Julia Carneiro e Humberto Bandeira
 *
 */
public class JogadorSelecaoFGrupoException extends Exception {
	/**
	 * Excecao de selecoes que ainda nao possuem 11 jogadores
	 * @param selec
	 */
	public JogadorSelecaoFGrupoException(Selecao selec) {
		super("Selecao " + selec + " ainda nao atingiu o numero de 11 jogadores");
	}


}   