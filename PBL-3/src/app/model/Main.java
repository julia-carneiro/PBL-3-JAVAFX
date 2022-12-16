package app.model;

import app.model.DAO.DAO;
import app.model.Exceptions.JogadorSelecaoFGrupoException;
import app.model.Exceptions.SelecaoInsuficienteException;

public class Main {
	private static FaseDeGrupo fasedegrupo = null;
	private static jogPartida jogPart = null; 

	public static FaseDeGrupo getFaseDeGrupo() {
		if (fasedegrupo == null) {
			int qtdSelecoes = DAO.getSelecDao().retornaListaSelecoes().size();
			if (qtdSelecoes == 4) {
				try {

					fasedegrupo = new FaseDeGrupo(DAO.getSelecDao().retornaListaSelecoes(), DAO.getSelecDao());
				} catch (JogadorSelecaoFGrupoException | SelecaoInsuficienteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return fasedegrupo;

	}
	
	public static jogPartida getjogPart() {
		if(jogPart == null) {
			jogPart = new jogPartida(0, 0, 0);
		}
		return jogPart;
	}
}
