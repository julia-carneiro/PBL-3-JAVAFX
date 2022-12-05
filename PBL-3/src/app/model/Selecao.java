package app.model;
 
import java.util.ArrayList;
import java.util.List;
//import java.util.concurrent.atomic.AtomicInteger;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * 
 * @author Julia Carneiro e Humberto Costa
 *
 */
public class Selecao {
	private String name;
	private Integer pontuacao;
	private Tecnico tecnico;
	
	//Lista de jogadores da selecao
	private List<Jogador> jogadores = new ArrayList<Jogador>();

	/**
	 * Construtor da Selecao
	 * @param name
	 */
	public Selecao(String name) {
		super();
		this.name = name;
	}  
	

	
	public ObservableList<Jogador> getJogadores() {
		return FXCollections.observableArrayList(jogadores);
		//return jogadores; 
	}
	 
	public void setJogadores(List<Jogador> jogadores) {
		this.jogadores = jogadores;
	}
	

	public Integer getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(Integer pontuacao) {
		this.pontuacao = pontuacao;
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