package app.model.Exceptions;
/**
 * 
 * @author Julia Carneiro e Humberto Bandeira
 *
 */
public class TecnicoLimiteException extends Exception {
	/**
	 * Apenas um tecnico pode ser adicionado a uma selecao 
	 * @param tecnico
	 */
	public TecnicoLimiteException(int tecnico) {
		super("Limite de " + tecnico + " tecnico atingido");
	}
	
}
