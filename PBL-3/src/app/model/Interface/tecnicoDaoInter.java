package app.model.Interface;

import java.util.Collection;
import java.util.Map;

import app.model.Tecnico;

/**
 * 
 * @author Julia Carneiro e Humberto Costa
 *
 */
public interface tecnicoDaoInter {
	public void create(Tecnico tecnico);
	public void update(Integer codtec, Tecnico tecnico);
	public void delete(Integer codtec);
	public Tecnico findByIdTec(Integer codtec);
	public Collection<Tecnico> retornaMap();
}
