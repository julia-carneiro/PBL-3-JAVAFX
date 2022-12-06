package app.model;
  
import java.util.concurrent.atomic.AtomicInteger;

public class Jogador {
	private static AtomicInteger codJog = new AtomicInteger();
	private String name;
	private Integer id;
	private Integer yellow_card;
	private Integer red_card;
	private Integer qtd_gols;
	private String posicao;
	private Selecao selecao;

	/**
	 * Construtor de Jogador / o setId com a AtomicInteger codJog serve para gerar um codigo de jogador automaticamente
	 * @param name
	 * @param yellow_card
	 * @param red_card
	 * @param qtd_gols
	 * @param posicao
	 */


	public Jogador(String name, String posicao, Selecao selecao) {
		setId(codJog.incrementAndGet());
		this.name = name;
		this.posicao = posicao;
		this.selecao = selecao;
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
	
	public Integer getYellow_card() {
		return yellow_card;
	}
	
	public void setYellow_card(Integer yellow_card) {
		this.yellow_card = yellow_card;
	}
	
	public Integer getRed_card() {
		return red_card;
	}
	
	public void setRed_card(Integer red_card) {
		this.red_card = red_card;
	}
	
	public Integer getQtd_gols() {
		return qtd_gols;
	}
	
	public void setQtd_gols(Integer qtd_gols) {
		this.qtd_gols = qtd_gols;
	}
	

	public String getPosicao() {
		return posicao;
	}

	public void setPosicao(String posicao) {
		this.posicao = posicao;
	}
	
	public Selecao getSelecao() {
		return selecao;
	}

	public void setSelecao(Selecao selecao) {
		this.selecao = selecao;
	}
	
/*	@Override
	public String toString() {
		return "\n\nNome: " + this.name +"\nId: " + this.id + "\nPosicao: " + this.posicao + "\nQuantidade de gols: " + this.qtd_gols
				+"\nQuantidade de cartoes vermelho: " + this.red_card + "\nQuantidade de cartoes amarelo: " +this.yellow_card + "\nSelecao: " + this.selecao;
	}*/

	@Override
	public String toString() {
		return "\n\nNome: " + this.name.toUpperCase() + "\nPosicao: " + this.posicao;
		
	}
	 
}