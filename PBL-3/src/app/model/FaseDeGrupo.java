package app.model;
 
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import app.model.DAO.SelecaoDao;
import app.model.Exceptions.JogadorSelecaoFGrupoException;
import app.model.Exceptions.SelecaoInsuficienteException;

/**
 * 
 * @author Julia Carneiro e Humberto Bandeira
 *
 */
public class FaseDeGrupo {
	
	private Map<Integer, Grupos> grupos = new HashMap<Integer, Grupos>();
	
	private List<Selecao> selecoes = new ArrayList<Selecao>();
	
	
	/**
	 * Construtor fase de grupos - cria 8 grupos com 4 selecoes
	 * @param selecoes
	 * @throws JogadorSelecaoFGrupoException
	 * @throws SelecaoInsuficienteException
	 */
	public FaseDeGrupo(List<Selecao> selecoes, SelecaoDao selec) throws JogadorSelecaoFGrupoException, SelecaoInsuficienteException {
		super();
		//verificaselecao(selec);
		
		for(int i = 0; i < selecoes.size(); i++) {
			//verificajogselecao(selecoes.get(i));
		}
	
		this.selecoes = selecoes;

		Grupos grupo1 = new Grupos(selecoes.get(0), selecoes.get(1), selecoes.get(2), selecoes.get(3));
		Grupos grupo2 = new Grupos(selecoes.get(4), selecoes.get(5), selecoes.get(6), selecoes.get(7));
		/*Grupos grupo3 = new Grupos(selecoes.subList(8, 12));
		Grupos grupo4 = new Grupos(selecoes.subList(12, 16));
		Grupos grupo5 = new Grupos(selecoes.subList(16, 20));
		Grupos grupo6 = new Grupos(selecoes.subList(20, 24));
		Grupos grupo7 = new Grupos(selecoes.subList(24, 28));
		Grupos grupo8 = new Grupos(selecoes.subList(28, 32));*/
	
		this.grupos.put(1, grupo1);
		this.grupos.put(2, grupo2);
		/*this.grupos.put(3, grupo3);
		this.grupos.put(4, grupo4);
		this.grupos.put(5, grupo5);
		this.grupos.put(6, grupo6);
		this.grupos.put(7, grupo7);
		this.grupos.put(8, grupo8);*/

	}
	
	/**
	 * Lanca a excecao de selecoes insuficientes
	 * @throws SelecaoInsuficienteException
	 */
	public void verificaselecao(SelecaoDao selec) throws SelecaoInsuficienteException{
		if(selec.retornaListaSelecoes().size() < 4) {
			throw new SelecaoInsuficienteException();
		}
	}
	
	/**
	 * Lanca a excecao de Jogadores insuficientes por selecao
	 * @param selec
	 * @throws JogadorSelecaoFGrupoException
	 */
	public void verificajogselecao(Selecao selec) throws JogadorSelecaoFGrupoException{
		if(selec.getJogadores().size() < 11) {
			throw new JogadorSelecaoFGrupoException(selec);
		}
	}
	
	public List<Selecao> getSelecoes() {
		return selecoes;
	}

	public void setSelecoes(List<Selecao> selecoes) {
		this.selecoes = selecoes;
	}

	public Collection<Grupos> getGrupos() {
		return grupos.values();
	}


	public void setGrupos(Map<Integer, Grupos> grupos) {
		this.grupos = grupos;
	}

	public void imprime() {
		for(Selecao item: selecoes) {
			System.out.println(item.toString());
			
		}
	}
	
	public Grupos buscaGrupo(int index) {
		return grupos.get(index);
	}
	
	@Override
	public String toString() {
		
		return "Selecoes da Fase de Grupos:\n" + this.selecoes + "\n";
	}

}