package app.model;
 
import java.util.ArrayList;
import java.util.HashMap;
//import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 
 * @author Julia Carneiro e Humberto Bandeira
 *
 */
public class Grupos {
	
	private static AtomicInteger codGrupo = new AtomicInteger();
	private int id;
	
	
	private Map <Integer, Partida> partidas = new HashMap<Integer, Partida>();
	private List<Selecao> selecoes = new ArrayList<Selecao>();
	
	/**
	 * Construtor de Grupos
	 * @param selecoes
	 */
	public Grupos(List<Selecao> selecoes) {
		super();
		this.selecoes = selecoes;
		setId(codGrupo.incrementAndGet());
		
		Partida partida1 = new Partida(selecoes.get(0), selecoes.get(1));
		Partida partida2 = new Partida(selecoes.get(0), selecoes.get(2));
		Partida partida3 = new Partida(selecoes.get(0), selecoes.get(3));
		Partida partida4 = new Partida(selecoes.get(1), selecoes.get(2));
		Partida partida5 = new Partida(selecoes.get(1), selecoes.get(3));
		Partida partida6 = new Partida(selecoes.get(2), selecoes.get(3));
		this.partidas.put(partida1.getId(), partida1);
		this.partidas.put(partida2.getId(), partida2);
		this.partidas.put(partida3.getId(), partida3);
		this.partidas.put(partida4.getId(), partida4);
		this.partidas.put(partida5.getId(), partida5);
		this.partidas.put(partida6.getId(), partida6);
		
	}
	
	
	public Map<Integer, Partida> getPartidas() {
		return partidas;
	}



	public void setPartidas(Map<Integer, Partida> partidas) {
		this.partidas = partidas;
	}



	public List<Selecao> getSelecoes() {
		return selecoes;
	}

	public void setSelecoes(List<Selecao> selecoes) {
		this.selecoes = selecoes;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}
	
	
	public void imprime() {
		for(Selecao item: selecoes) {
			System.out.println(item.toString());
			
		}
	}
	
	
	@Override
	public String toString() {
		return "\nId Grupo: " + this.id ;
	}



	
	
	
}