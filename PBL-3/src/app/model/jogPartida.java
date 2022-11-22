package app.model;
 
/**
 * 
 * @author Julia Carneiro e Humberto Bandeira
 *
 */
public class jogPartida {
	private int gols;
	private int codJog; 
	private int cartoesVermelho;
	private int cartoesAmarelo;
	
	
	/**
	 * Construtor de jogPartida
	 * @param gols
	 * @param cartoesVermelho
	 * @param cartoesAmarelo
	 */
	public jogPartida(int gols,  int cartoesVermelho, int cartoesAmarelo) {
		super();
		this.gols = gols;
		this.cartoesVermelho = cartoesVermelho;
		this.cartoesAmarelo = cartoesAmarelo; 
	}
	
	public void verificaGols() {
		
	}
	
	public int getGols() { 
		return gols;
	}
	public void setGols(int gols) {
		this.gols = gols;
	}
	 
	
	public int getCodJog() {
		return codJog;
	}
	public void setCodJog(int codJog) {
		this.codJog = codJog;
	}
	
	
	public int getCartoesVermelho() {
		return cartoesVermelho;
	}
	public void setCartoesVermelho(int cartoesVermelho) {
		this.cartoesVermelho = cartoesVermelho;
	}
	
	
	public int getCartoesAmarelo() {
		return cartoesAmarelo;
	}
	public void setCartoesAmarelo(int cartoesAmarelo) {
		this.cartoesAmarelo = cartoesAmarelo;
	}
	
}