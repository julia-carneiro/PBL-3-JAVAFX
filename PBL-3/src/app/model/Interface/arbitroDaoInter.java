package app.model.Interface;

import java.util.Map;

import app.model.Arbitro;

/** 
 * 
 * @author Julia Carneiro e Humberto costa 
 *
 */
public interface arbitroDaoInter {
	public void create(Arbitro arbitro);
	public void update(Integer codarb, Arbitro arbitro);
	public void delete(Integer codarb);
	public Arbitro findByIdArb(Integer codarb);
	public Map<Integer, Arbitro> retornaMap();
}
