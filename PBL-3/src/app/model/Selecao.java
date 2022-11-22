package app.model;
 
import java.util.ArrayList;
import java.util.List;
//import java.util.concurrent.atomic.AtomicInteger;

/**
 * 
 * @author Julia Carneiro e Humberto Costa
 *
 */
public class Selecao {
	private String name;
	private Tecnico tecnico;
	//Lista de jogadores da selecao
	private List<Integer> jogadores = new ArrayList<Integer>();

	/**
	 * Construtor da Selecao
	 * @param name
	 */
	public Selecao(String name) {
		super();
		this.name = name;
	}  
	
	public List<Integer> getJogadores() {
		return jogadores; 
	}
	 
	public void setJogadores(List<Integer> jogadores) {
		this.jogadores = jogadores;
	}
	

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	public Tecnico getTecnico() {
		return tecnico;
	}


	public void setTecnico(Tecnico tecnico) {
		this.tecnico = tecnico;
	}
	
	
	@Override
	public String toString() {
		return this.name.toUpperCase();
	}


	


}