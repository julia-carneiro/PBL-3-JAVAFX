package app.model.Exceptions;

/**
 * 
 * @author Julia Carneiro e Humberto Bandeira
 *
 */
public class SelecaoInsuficienteException extends Exception {
	/**
	 * Excecao para fase de grupo - apenas inicia com 32 selecoes 
	 */
	public SelecaoInsuficienteException() {
		super("\nNumero de selecoes insuficientes para iniciar a fase de grupo\n");
	}
} 