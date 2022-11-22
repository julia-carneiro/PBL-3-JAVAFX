package app.model.Interface;

import java.util.Map;

import app.model.Jogador;

/**
 * 
 * @author Julia Carneiro e Humberto Costa
 *
 */
public interface jogadorDaoInter {
	public void create(Jogador jogador);
	public void update(int codjog, Jogador jogador);
	public void delete(int codjog);
	public Jogador findByCodjog(int codjog);
}
