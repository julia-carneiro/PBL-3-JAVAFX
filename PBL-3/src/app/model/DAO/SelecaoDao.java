package app.model.DAO;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import app.model.Jogador;
import app.model.Selecao;
import app.model.Exceptions.JogadorLimiteException;
import app.model.Exceptions.SelecaoLimiteException;
import app.model.Interface.SelecaoDaoInter;

/**
 * 
 * @author Julia Carneiro e Humberto Costa
 *
 */
public class SelecaoDao implements SelecaoDaoInter {
	private Map <String, Selecao> selecoes = new HashMap<>();
	public List<Integer> listajogadores = new ArrayList<Integer>();
	
	/**
	 * Cria a selecao no map, com seu nome sendo a chave e o objeto como valor.
	 * @param selecao
	 * @throws SelecaoLimiteException 
	 */
 
	@Override
	public void create(Selecao selecao) throws SelecaoLimiteException {
		// TODO Auto-generated method stub
		if(selecoes.size() < 32) {
			this.selecoes.put(selecao.getName(), selecao);
		}
		else {
			SelecaoLimiteException exc = new SelecaoLimiteException(selecao, selecoes.size());
			throw exc;
		} 
	}
	
	/**
	 * Atualiza a selecao acordo com seu nome - remove e adiciona novamente no map
	 */
	@Override
	public void update(String name,String new_name, Selecao selecao) {
		// TODO Auto-generated method stub
		this.selecoes.remove(name);
		this.selecoes.put(new_name, selecao);
	}
	
	/**
	 * Cria lista de ID(codigo) de jogadores da selecao
	 * @param selecao
	 * @param idjog
	 * @throws JogadorLimiteException 
	 */
	@Override
	public void createListJogador(Selecao selecao, int idjog) throws JogadorLimiteException{
		if(listajogadores.size() < 11) {
			listajogadores = selecao.getJogadores();
			listajogadores.add(idjog);
			selecao.setJogadores(listajogadores);
		}
		else {
			JogadorLimiteException exc = new JogadorLimiteException(listajogadores.size());
			throw exc;
		}	
	}
	
	/**
	 * Deleta o jogador da lista de jogadores, de acordo com seu codigo.
	 * Percorre a lista de jogadores da selecao, e usa o findByCodjog do jogador_dao para encontrar o jogador, se o id dele for igual ao enviado pelo usuário, o ID eh removido da lista.
	 * @param jogador_dao
	 * @param idjog
	 */
	public void deleteJogador_List(jogadorDao jogador_dao, int idjog) {
		//listajogadores = selecao.getJogadores();
		for(int i=1; i < listajogadores.size(); i++) {
			Jogador jogador = jogador_dao.findByCodjog(idjog);
			if(idjog == jogador.getId()) {
				listajogadores.remove(i);
				//break;
			}
		}
	}

	
	/**
	 * Deleta selecao do map 
	 * @param name
	 */
	@Override
	public void delete(String name) {
		// TODO Auto-generated method stub
		this.selecoes.remove(name);
	}	
	

	/**
	 * Encontra no map e retorna uma selecao de acordo com seu nome
	 * @param name
	 */
	@Override
	public Selecao findByName(String name) {
		return selecoes.get(name);
	}
	

	/**
	 * Verifica se a selecao existe no map
	 * @param name
	 */
	@Override 
	public boolean existeSelecao(String name) {
		return selecoes.containsKey(name);
	}
	
	/**
	 * Retorna o map de selecoes
	 */
	public Map <String, Selecao> retornaMap() {
		return selecoes;
	}
	
	/**
	 * Retorna a lista de selecoes para ser enviada para fase de grupo
	 */
	public List<Selecao> retornaListaSelecoes() {
		List<Selecao> listaSelecoes = new ArrayList<Selecao>();
		for(Selecao selec: selecoes.values()) {
			listaSelecoes.add(selec);
		}
		return listaSelecoes;
	}
}
	
