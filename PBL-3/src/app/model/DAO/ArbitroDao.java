package app.model.DAO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import app.model.Arbitro;
import app.model.Interface.arbitroDaoInter;

/**
 * 
 * @author Julia Carneiro e Humberto Costa
 *
 */
public class ArbitroDao implements arbitroDaoInter {
	private Map<Integer, Arbitro> arbitros = new HashMap<>();
	
	@Override
	public void create(Arbitro arbitro) {
		// TODO Auto-generated method stub
		this.arbitros.put(arbitro.getId(), arbitro);
	}
 
	/**
	 * Atualiza o arbitro - remove e depois insere novamente. 
	 * @param codarb codigo do arbitro para remover o desejado
	 * @param arbitro objeto arbitro para inserir novamente no map
	 */
	@Override
	public void update(Integer codarb, Arbitro arbitro) {
		// TODO Auto-generated method stub
		this.arbitros.remove(codarb);
		this.arbitros.put(arbitro.getId(), arbitro);
	}
	
	/**
	 * @param codarb codigo do arbitro para remover o desejado
	 */
	@Override
	public void delete(Integer codarb) {
		// TODO Auto-generated method stub
		this.arbitros.remove(codarb);

	}

	/**
	 * Encontra no map e retorna o objeto arbitro de acordo com seu codigo 
	 * @param cordarb 
	 */
	@Override
	public Arbitro findByIdArb(Integer codarb) {
		// TODO Auto-generated method stub	
		return arbitros.get(codarb);
	}

	/**
	 * Retorna o map de arbitros
	 */
	public Collection<Arbitro> retornaMap() {	
		return arbitros.values();
	}
}

