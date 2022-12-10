package app.model;
 
import java.util.ArrayList;
import java.util.Collection;
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
	
	public List<Selecao> selecoes = new ArrayList<Selecao>();
	/*private Selecao selecao1;
	private Selecao selecao2;
	private Selecao selecao3;
	private Selecao selecao4;*/
	
	
	
	/**
	 * Construtor de Grupos
	 * @param selecoes
	 */
	public Grupos(List<Selecao> selecoes) {
		super();
		/*this.setSelecao1(selecao1);
		this.setSelecao2(selecao2);
		this.setSelecao3(selecao3);
		this.setSelecao4(selecao4);*/
		this.selecoes = selecoes;
		setId(codGrupo.incrementAndGet());
		
		/*Partida partida1 = new Partida(selecao1, selecao2);
		Partida partida2 = new Partida(selecao1, selecao3);
		Partida partida3 = new Partida(selecao1, selecao4);
		Partida partida4 = new Partida(selecao2, selecao3);
		Partida partida5 = new Partida(selecao2, selecao4);
		Partida partida6 = new Partida(selecao3, selecao4);*/
		
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
	
	/**
	public void imprime() {
		for(Selecao item: selecoes) {
			System.out.println(item.toString());
			
		}
	}*/
	
	
	@Override
	public String toString() {
		return "\nId Grupo: " + this.id ;
	}


	/*public Selecao getSelecao1() {
		return selecao1;
	}


	public void setSelecao1(Selecao selecao1) {
		this.selecao1 = selecao1;
	}


	public Selecao getSelecao2() {
		return selecao2;
	}


	public void setSelecao2(Selecao selecao2) {
		this.selecao2 = selecao2;
	}


	public Selecao getSelecao3() {
		return selecao3;
	}


	public void setSelecao3(Selecao selecao3) {
		this.selecao3 = selecao3;
	}


	public Selecao getSelecao4() {
		return selecao4;
	}


	public void setSelecao4(Selecao selecao4) {
		this.selecao4 = selecao4;
	}*/
	
	public Collection<Selecao> retornaCollection(){
		return selecoes;
	}

	public Collection<Selecao> retornaMap(){
		Map<Integer, Selecao> selecoesMap = new HashMap<Integer, Selecao>();
		selecoesMap.put(1, selecoes.get(0));
		selecoesMap.put(2, selecoes.get(1));
		selecoesMap.put(3, selecoes.get(2));
		selecoesMap.put(4, selecoes.get(3));
		
		return selecoesMap.values();
		
	}
	
	
	
}