package app.model.Exceptions;

/**
 * 
 * @author Julia Carneiro e Humberto Bandeira
 *
 */
public class JogadorLimiteException extends Exception {
	/**
	 * Excecao para limite de 11 jogadores 
	 * @param jogadores
	 */
	public JogadorLimiteException(int jogadores) {
		super("Limite de " + jogadores + " jogadores batido");
	}

}
   