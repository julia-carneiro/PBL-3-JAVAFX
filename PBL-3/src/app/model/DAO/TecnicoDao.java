package app.model.DAO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import app.model.Arbitro;
import app.model.Tecnico;
import app.model.Interface.tecnicoDaoInter;

/**
 * 
 * @author Julia Carneiro e Humberto Costa
 *
 */
public class TecnicoDao implements tecnicoDaoInter {
	private Map<Integer,  Tecnico> tecnicos = new HashMap<>();
	 
	/**
	 * Cria um tecnico adicionando no map, a chave eh o nome, o valor eh o objeto tecnico
	 * @param tecnico
	 */
	@Override
	public void create(Tecnico tecnico) {
		// TODO Auto-generated method stub
		this.tecnicos.put(tecnico.getId(), tecnico);
	}
	
	/**
	 * Atualiza o tecnico de acordo com seu codigo, remove e adiciona novamente no map
	 * @param codtec
	 * @param tecnico
	 */
	@Override
	public void update(Integer codtec, Tecnico tecnico) {
		// TODO Auto-generated method stub
		this.tecnicos.remove(codtec);
		this.tecnicos.put(tecnico.getId(), tecnico);

	}
	
	/**
	 * Deleta o tecnico do map de acordo com seu codigo
	 * @param codtec
	 */
	@Override
	public void delete(Integer codtec) {
		// TODO Auto-generated method stub
		this.tecnicos.remove(codtec);
	}
	
	/**
	 * Encontra no map e retorna um tecnico de acordo com seu codigo
	 * @param codtec
	 */
	@Override
	public Tecnico findByIdTec(Integer codtec) {
		// TODO Auto-generated method stub
		return tecnicos.get(codtec);
	}
	
	/**
	 * Retorna map de tecnicos 
	 */
	public Collection<Tecnico> retornaMap() {
		return tecnicos.values();
	}
}
