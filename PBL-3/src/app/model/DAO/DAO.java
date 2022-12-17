package app.model.DAO;

import app.model.Exceptions.JogadorSelecaoFGrupoException;
import app.model.Exceptions.SelecaoInsuficienteException;



// Classe DAO usada para acessar todos os DAOs do programa.

public class DAO {
	private static jogadorDao jogDAO = null;
	private static SelecaoDao selecDAO = null;
	private static TecnicoDao tecDAO = null;
	private static ArbitroDao arbDAO = null;
	

	public static jogadorDao getJogDao() {

		if (jogDAO == null) {
			jogDAO = new jogadorDao();
		}
		return jogDAO;
	}

	public static SelecaoDao getSelecDao() {
		if (selecDAO == null) {
			selecDAO = new SelecaoDao();
		}
		return selecDAO;
	}

	public static TecnicoDao getTecnicoDao() {
		if (tecDAO == null) {
			tecDAO = new TecnicoDao();
		}
		return tecDAO;
	}

	public static ArbitroDao getArbitroDao() {
		if (arbDAO  == null) {
			arbDAO = new ArbitroDao();
		}
		return arbDAO;
	}
	

}
