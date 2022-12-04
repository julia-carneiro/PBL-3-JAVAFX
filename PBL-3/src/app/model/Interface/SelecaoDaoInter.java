package app.model.Interface;

import java.util.List;
import java.util.Map;

import app.model.Jogador;
import app.model.Selecao;
import app.model.DAO.jogadorDao;
import app.model.Exceptions.JogadorLimiteException;
import app.model.Exceptions.SelecaoLimiteException;

/**
 * 
 * @author Julia Carneiro e Humberto Costa
 *
 */
public interface SelecaoDaoInter {
	public void create(Selecao selecao) throws SelecaoLimiteException;
	public void update(String name, String new_name, Selecao selecao);
	public void delete(String name);
	public Selecao findByName(String name);
	public boolean existeSelecao(String name);
	public Map<String, Selecao> retornaMap();
	public void createListJogador(Selecao selecao, Jogador jogador) throws JogadorLimiteException;
	public void deleteJogador_List(jogadorDao jogador_dao, int idjog);	
	public List<Selecao> retornaListaSelecoes();
	/**
	 * Cria lista de ID(codigo) de jogadores da selecao
	 * @param selecao
	 * @param idjog
	 * @throws JogadorLimiteException 
	 */
	
}
