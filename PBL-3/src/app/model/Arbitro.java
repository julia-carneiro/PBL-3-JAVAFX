package app.model;
 
import java.util.concurrent.atomic.AtomicInteger;


/**
 * 
 * @author Julia Carneiro e Humberto Costa
 *
 */ 

public class Arbitro {
	private static AtomicInteger codarb = new AtomicInteger();
	private String name;
	private Integer id;
	
	/**
	 * Construtor de arbitro / o setId com a AtomicInteger codarb serve para gerar um codigo de arbitro automaticamente
	 * @param name nome do arbitro
	 */
	public Arbitro(String name) {
		super();
		this.name = name;
		setId(codarb.incrementAndGet());
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "Nome: " + this.name + "\nId: " + this.id;
	}
	
}
