package app.model.DAO;

public class DAO {
	private static jogadorDao jogDAO = null;
	
	public static jogadorDao getJogDao() {
		
		if(jogDAO == null) {
			jogDAO = new jogadorDao();
		}
		return jogDAO;
	}
		
}
