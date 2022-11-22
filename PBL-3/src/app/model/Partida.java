package app.model;
 
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 
 * @author Julia Carneiro e Humberto Bandeira
 *
 */
public class Partida {
	private static AtomicInteger codPartida = new AtomicInteger();
	
	private int id;
	private Selecao selecao1; 
	private Selecao selecao2;
	private int golsTime1;
	private int golsTime2;
	private String local;
	private String data;
	private String horario;
	
	/**
	 * Construtor de Partida
	 * @param selecao1
	 * @param selecao2
	 */
	public Partida(Selecao selecao1, Selecao selecao2) {
		super();
		setId(codPartida.incrementAndGet());
		this.selecao1 = selecao1;
		this.selecao2 = selecao2;
		
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	public Selecao getSelecao1() {
		return selecao1;
	}
	public void setSelecao1(Selecao selecao1) {
		this.selecao1 = selecao1;
	}
	
	
	public Selecao getSelecao2() {
		return selecao2;
	}
	public void setSelecao2(Selecao selecao2) {
		this.selecao2 = selecao2;
	}
	
	
	public int getGolsTime1() {
		return golsTime1;
	}
	public void setGolsTime1(int golsTime1) {
		this.golsTime1 = golsTime1;
	}
	
	
	public int getGolsTime2() {
		return golsTime2;
	}
	public void setGolsTime2(int golsTime2) {
		this.golsTime2 = golsTime2;
	}
	
	
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
	
	@Override
	public String toString() {
		return   this.selecao1 + " x " + this.selecao2 + ""
	+ "\nId partida: "+ this.id + "\nGols " +this.selecao1+": "+ this.golsTime1 +"\ngols "+this.selecao2+ ": " +  
				this.golsTime2 + "\nLocal partida: " + this.local +"\nData partida: "+ this.data +"\nHorario partida: "+ this.horario +"\n\n";
	}
	

	
}