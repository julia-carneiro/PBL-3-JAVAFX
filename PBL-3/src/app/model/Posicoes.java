package app.model;

import java.util.HashMap;
import java.util.Map;

public class Posicoes {
	public static String[] posicoes = new String[] { "GOLEIRO", "ZAGUEIRO", "LATERAL", "MEIO CAMPO", "ATACANTE" };
	
	public static String get(int posicao) {		
		return posicoes[posicao];
	}

	
}
