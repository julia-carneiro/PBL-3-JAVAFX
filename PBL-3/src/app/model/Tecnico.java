package app.model;
import java.util.concurrent.atomic.AtomicInteger;
 

/**
 * 
 * @author Julia Carneiro e Humberto Costa
 *
 */
public class Tecnico {
	private String name;
	private Integer id;
	private Selecao selecao;
	private static AtomicInteger codtec = new AtomicInteger();	
	
	/**  
	 * Construtor de tecnico
	 * @param name 
	 */
	public Tecnico(String name, Selecao selecao) {
		super();
		this.name = name;
		this.selecao = selecao;
		setId(codtec.incrementAndGet());
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

	@Override
	public String toString() {
		return "Nome: " + this.name + "\nId: " + this.id;
	}

	public Selecao getSelecao() {
		return selecao;
	}

	public void setSelecao(Selecao selecao) {
		this.selecao = selecao;
	}
}
