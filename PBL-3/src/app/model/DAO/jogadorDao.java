package app.model.DAO;

import java.util.HashMap;
import java.util.Map;

import app.model.Jogador;
import app.model.Interface.jogadorDaoInter;

public class jogadorDao implements jogadorDaoInter {
	private Map<Integer, Jogador> jogadores = new HashMap<>();
	
	/**
	 * Cria um jogador adicionando no Map jogadores
	 * @param jogador
	 */
	@Override
	public void create(Jogador jogador) {
		// TODO Auto-generated method stub
		this.jogadores.put(jogador.getId(), jogador);
	 
	}
	
	/**
	 * Atualiza um jogador de acordo com seu codigo - remove e adiciona novamente no map
	 * @param codjog
	 * @param jogador
	 */
	@Override
	public void update(int codjog, Jogador jogador) {
		// TODO Auto-generated method stub
		this.jogadores.remove(codjog);
		this.jogadores.put(codjog, jogador);

	}
	
	/**
	 * Deleta um jogador do map
	 * @param codjog
	 */
	@Override
	public void delete(int codjog) {
		// TODO Auto-generated method stub
		this.jogadores.remove(codjog);

	}
	
	/**
	 * Encontra no map e retorna um jogador de acordo com seu codigo
	 * @param codjog
	 */
	@Override
	public Jogador findByCodjog(int codjog) {
		return jogadores.get(codjog);
	}

	/**
	 * Retorna o map 
	 */
	public  Map<Integer, Jogador> retornaMap() {
		return jogadores;
	}

}
