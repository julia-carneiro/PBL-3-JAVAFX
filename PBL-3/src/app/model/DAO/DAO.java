package app.model.DAO;

public class DAO {
	private static jogadorDao jogDAO = null;
	private static SelecaoDao selecDAO = null;
	
	public static jogadorDao getJogDao() {
		
		if(jogDAO == null) {
			jogDAO = new jogadorDao();
		}
		return jogDAO;
	}
	
	public static SelecaoDao getSelecDao() {
		if(selecDAO == null) {
			selecDAO = new SelecaoDao();
		}
		return selecDAO;
	}
		
}
