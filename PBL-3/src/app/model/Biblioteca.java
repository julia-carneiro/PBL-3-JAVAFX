package app.model;
 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import app.model.DAO.ArbitroDao;
import app.model.DAO.SelecaoDao;
import app.model.DAO.TecnicoDao;
import app.model.DAO.jogadorDao;
import app.model.Exceptions.JogadorLimiteException;
import app.model.Exceptions.JogadorSelecaoFGrupoException;
import app.model.Exceptions.SelecaoInsuficienteException;
import app.model.Exceptions.SelecaoLimiteException;
import app.Main;

/**
 * Biblioteca com as funcoes MENU/CRUD
 * 
 * @author Julia Carneiro e Humberto Costa
 *
 */
public class Biblioteca {

	/**
	 * Printa os Ids dos grupos
	 * 
	 * @param faseGrupo
	 */
	public static void printidgrupos(FaseDeGrupo faseGrupo) {
		// Partida part = faseGrupo.getGrupos().get(1).getPartidas().get(1);
		Map<Integer, Grupos> grupos = faseGrupo.getGrupos();
		for (Map.Entry<Integer, Grupos> g : grupos.entrySet()) {
			System.out.println(g.getValue());
			System.out.println(g.getValue().getSelecoes());
		}
	}

	/**
	 * Gerencia os dados de JogadorPartida, editando os gols e cartoes do jogador,
	 * na partida desejada
	 * 
	 * @param entrada
	 * @param jogdao
	 * @param faseGrupo
	 * @param selec
	 */
	public static void gerenciarJogadorpartida(Scanner entrada, jogadorDao jogdao, FaseDeGrupo faseGrupo,
			SelecaoDao selec) {
		int qtdgols;
		int qtdcartvermelho;
		int qtdcartamarelo;

		printidgrupos(faseGrupo);

		Map<Integer, Grupos> g = faseGrupo.getGrupos();
		for (Grupos gp : g.values()) {
			System.out.println("\n" + gp.getId());
			for (Partida part : gp.getPartidas().values()) {
				System.out.println("\nId da partida: " + part.getId() + "\nSelecao1 " + part.getSelecao1()
						+ " x selecao2 " + part.getSelecao2() + "\n");
			}
		}

		System.out.println("Digite o id do grupo em que a partida acontece:\n");
		Integer codgrupo = entrada.nextInt();
		entrada.nextLine();

		System.out.println("Digite o id da partida:\n");
		Integer codpartida = entrada.nextInt();
		entrada.nextLine();

		System.out.println("Digite o id do jogador:\n");
		Integer codjog = entrada.nextInt();
		entrada.nextLine();

		System.out.println("Digite a quantidade de gols do jogador na partida:\n");
		qtdgols = entrada.nextInt();
		entrada.nextLine();

		System.out.println("Digite a quantidade de cartao vermelho recebido pelo jogador na partida:\n");
		qtdcartvermelho = entrada.nextInt();
		entrada.nextLine();

		System.out.println("Digite a quantidade de cartao amarelo recebido pelo jogador na partida:\n");
		qtdcartamarelo = entrada.nextInt();
		entrada.nextLine();
		Jogador jog = jogdao.findByCodjog(codjog);
		Map<Integer, Grupos> grupos = faseGrupo.getGrupos();
		Grupos grupo = grupos.get(codgrupo);
		Map<Integer, Partida> partidas = grupo.getPartidas();

		for (Partida part : partidas.values()) { // caso os gols do jogador sejam maiores que a quantidade de gols do
													// seu time, não é adicionado.

			if (part.getSelecao1().getJogadores().contains(codjog) && qtdgols <= part.getGolsTime1()
					|| part.getSelecao2().getJogadores().contains(codjog) && qtdgols <= part.getGolsTime2()) {
				jogPartida jogadorpartida = new jogPartida(qtdgols, qtdcartvermelho, qtdcartamarelo);
				jog.setQtd_gols(qtdgols);
			}
		}
		jog.setRed_card(qtdcartvermelho);
		jog.setYellow_card(qtdcartamarelo);
	}
	
	public static void oitavas(FaseDeGrupo fasegrupo) {
		Map<Integer, Grupos> g = fasegrupo.getGrupos();
		Map<Integer, Selecao> pontuacoes = new TreeMap<>();
		int maior = 0;
		int segmaior = 0;
		for(Grupos gp: g.values()) {
			for(Selecao selec: gp.getSelecoes()) {
				if(selec.getPontuacao() > maior) {
					maior = selec.getPontuacao();
				}
				else if(selec.getPontuacao() < maior && selec.getPontuacao() > segmaior) {
					segmaior = selec.getPontuacao();
				}
			}
		}
		
		for(Grupos gp: g.values()) {
			for(Selecao selec: gp.getSelecoes()) {
				if(selec.getPontuacao() == maior) {
					pontuacoes.put(selec.getPontuacao(), selec);
				}
				else if (selec.getPontuacao() == segmaior){
					pontuacoes.put(selec.getPontuacao(), selec);
				}
			}
		}
		
	}

	/**
	 * Gerencia e seta os dados da Partida
	 * 
	 * @param entrada
	 * @param faseGrupo
	 * @param jogadordao
	 */
	public static void gerenciardadospartida(Scanner entrada, FaseDeGrupo faseGrupo, jogadorDao jogadordao) {
		Map<Integer, Grupos> g = faseGrupo.getGrupos();
		for (Grupos gp : g.values()) {
			System.out.println("\n" + gp.getId());
			for (Partida part : gp.getPartidas().values()) {
				System.out.println("\nId da partida: " + part.getId() + "\nSelecao1 " + part.getSelecao1()
						+ " x selecao2 " + part.getSelecao2() + "\n");
			}
		}

		System.out.println("Digite o codigo do grupo em que a partida acontece:\n");
		Integer codgrupo = entrada.nextInt();
		entrada.nextLine();

		System.out.println("Digite o codigo da partida:\n");
		Integer codpart = entrada.nextInt();
		entrada.nextLine();

		System.out.println("Digite a quantidade de gols da selecao 1: \n");
		int golsel1 = entrada.nextInt();
		entrada.nextLine();

		System.out.println("Digite a quantidade de gols da selecao2: \n");
		int golsel2 = entrada.nextInt();
		entrada.nextLine();

		System.out.println("Digite o local da partida:\n");
		String local = entrada.nextLine().toUpperCase();
		local = validaEntrada_String(entrada, local);

		System.out.println("Digite a data da partida:\n");
		String data = entrada.nextLine().toUpperCase();

		System.out.println("Digite o horario da partida:\n");
		String horario = entrada.nextLine().toUpperCase();

		Grupos grupo = g.get(codgrupo);
		Map<Integer, Partida> p = grupo.getPartidas();
		Partida part = p.get(codpart);
		
		for(Grupos grup: g.values()) {
			for(Partida partida: grup.getPartidas().values()) {
				if(golsel1 > golsel2) {
					int pont = partida.getSelecao1().getPontuacao();
					partida.getSelecao1().setPontuacao(pont+3);					
				}
				else if(golsel2 > golsel1) {
					int pont = partida.getSelecao2().getPontuacao();
					partida.getSelecao2().setPontuacao(pont+3);
				}
				else {
					int pont1 = partida.getSelecao1().getPontuacao();
					int pont2 = partida.getSelecao2().getPontuacao();
					partida.getSelecao1().setPontuacao(pont1+1);
					partida.getSelecao2().setPontuacao(pont2+1);
				}
			}
		}
		
		part.setLocal(local);
		part.setData(data);
		part.setHorario(horario);
		part.setGolsTime1(golsel1);
		part.setGolsTime2(golsel2);
	}

	/**
	 * Printa os dados de uma partida
	 * 
	 * @param faseGrupo
	 */
	public static void dadospartida(FaseDeGrupo faseGrupo) {
		Map<Integer, Grupos> grupo = faseGrupo.getGrupos();
		for (Grupos grup : grupo.values()) {
			for (Partida part : grup.getPartidas().values()) {
				System.out.println(part.toString());
			}
		}
	}

	/**
	 * Menu das pesquisas
	 * 
	 * @param entrada
	 * @param faseGrupo
	 * @param jogadorDao
	 * @param selecaoDao
	 * @param arbDao
	 * @param tecDao
	 */
	public static void pesquisas(Scanner entrada, FaseDeGrupo faseGrupo, jogadorDao jogadorDao, SelecaoDao selecaoDao,
			ArbitroDao arbDao, TecnicoDao tecDao) {
		boolean continua = true;
		Map<Integer, Grupos> g = faseGrupo.getGrupos();
		do {
			System.out.println("1 - PESQUISAR PARTIDAS POR DATA OU NOME DA SELECAO\n");
			System.out.println("2 - PESQUISAR POR NOME E CATEGORIA");
			Integer opc = entrada.nextInt();
			entrada.nextLine();
			switch (opc) {
			case 1:
				System.out.println("Digite a data da partida ou nome da selecao:\n");
				String data = entrada.nextLine().toUpperCase();
				data = validaEntrada_String(entrada, data);
				for (Grupos gp : g.values()) {
					for (Partida part : gp.getPartidas().values()) {
						String selecao1 = part.getSelecao1().getName();
						String selecao2 = part.getSelecao2().getName();
						if (data.equals(part.getData()) || data.equals(selecao1) || data.equals(selecao2)) {
							System.out.println(part.toString());
						}
					}
				}
				break;
			case 2:
				System.out.println("1 - PESQUISAR JOGADOR");
				System.out.println("2 - PESQUISAR ARBITRO");
				System.out.println("3 - PESQUISAR TECNICO");
				Integer opc2 = entrada.nextInt();
				entrada.nextLine();
				switch (opc2) {
				case 1:
					System.out.println("Digite o nome do jogador:\n");
					String nome = entrada.nextLine().toUpperCase();
					nome = validaEntrada_String(entrada, nome);
					Map<Integer, Jogador> mapJog = jogadorDao.retornaMap();
					for (Jogador jog : mapJog.values()) {
						if (nome.equals(jog.getName())) {
							System.out.println("Jogador: " + jog.getName() + "Posicao: " + jog.getPosicao() + "\n");
						}
					}
					break;
				case 2:
					System.out.println("Digite o nome do arbitro:\n");
					String nomeArb = entrada.nextLine().toUpperCase();
					nomeArb = validaEntrada_String(entrada, nomeArb);

					Map<Integer, Arbitro> mapArb = arbDao.retornaMap();
					for (Arbitro arb : mapArb.values()) {
						if (nomeArb.equals(arb.getName())) {
							System.out.println("Arbitro: " + arb.getName() + "Id: " + arb.getId() + "\n");
						}
					}
					break;
				case 3:
					System.out.println("Digite o nome do tecnico:\n");
					String nomeTec = entrada.nextLine().toUpperCase();
					nomeTec = validaEntrada_String(entrada, nomeTec);
					Map<Integer, Tecnico> mapTec = tecDao.retornaMap();
					for (Tecnico tec : mapTec.values()) {
						if (nomeTec.equals(tec.getName())) {
							System.out.println("Tecnico: " + tec.getName() + "Id: " + tec.getId() + "\n");
						}
					}
					break;
				}
				break;
			}
			continua = false;
		} while (continua);
	}

	/**
	 * Menu partida - switch case para editar e deletar partidas, gerenciar
	 * jogadores e mostrar dados das partidas
	 * 
	 * @param entrada
	 * @param faseGrupo
	 * @param jogadordao
	 * @param selecaodao
	 */
	public static void menuPartida(Scanner entrada, FaseDeGrupo faseGrupo, jogadorDao jogadordao, SelecaoDao selecaodao,
			ArbitroDao arbDao, TecnicoDao tecDao) {

		System.out.println("**********GERENCIADOR DE PARTIDAS**********");

		Map<Integer, Grupos> g = faseGrupo.getGrupos();
		boolean continua = true;
		Integer opc;
		do {
			System.out.println("1 - EDITAR PARTIDAS \n");
			System.out.println("2 - DELETAR PARTIDAS\n");
			System.out.println("3 - GERENCIAR JOGADORES\n");
			System.out.println("4 - MOSTRAR DADOS DAS PARTIDAS\n");

			opc = entrada.nextInt();
			entrada.nextLine();
			switch (opc) {
			case 1:
				gerenciardadospartida(entrada, faseGrupo, jogadordao);
				break;

			case 2:
				Map<Integer, Grupos> g1 = faseGrupo.getGrupos();
				System.out.println("Digite o codigo do grupo em que a partida acontece: \n");
				Integer codgrupo1 = entrada.nextInt();
				entrada.nextLine();
				System.out.println("Digite o codigo da partida: \n");
				Integer codpartida1 = entrada.nextInt();
				Grupos grupo1 = g1.get(codgrupo1);

				Map<Integer, Partida> p1 = grupo1.getPartidas();

				p1.remove(codpartida1);

				break;

			case 3:
				gerenciarJogadorpartida(entrada, jogadordao, faseGrupo, selecaodao);
				break;
			case 4:
				dadospartida(faseGrupo);
				break;

			}
			continua = false;

		} while (continua);

	}

	/**
	 * Menu da fase de grupos.
	 * 
	 * @param entrada
	 * @param selecaodao
	 * @param jogadordao
	 * @param faseGrupo
	 * @param limite
	 */
	public static void faseDeGrupos(Scanner entrada, SelecaoDao selecaodao, jogadorDao jogadordao,
			FaseDeGrupo faseGrupo, ArbitroDao arbDao, TecnicoDao tecDao) {
		boolean continua = true;

		// FaseDeGrupo faseGrupo = new FaseDeGrupo(listaSelec);
		do {
			System.out.println("1 - Mostrar selecoes da fase de grupos\n");
			System.out.println("2 - Mostrar grupos\n");
			System.out.println("3 - Gerenciar partidas\n");
			System.out.println("4 - Pesquisas\n");
			int opc;
			opc = entrada.nextInt();
			entrada.nextLine();
			switch (opc) {
			case 1:
				faseGrupo.imprime();
				break;
			case 2:
				printidgrupos(faseGrupo);

				break;
			case 3:
				menuPartida(entrada, faseGrupo, jogadordao, selecaodao, arbDao, tecDao);
				break;
			case 4:
				pesquisas(entrada, faseGrupo, jogadordao, selecaodao, arbDao, tecDao);
				break;

			}
			System.out.println("Deseja continuar na fase de grupo? sim = 1 / nao = 0\n");
			int con = entrada.nextInt();
			entrada.nextLine();
			if (con == 1) {
				System.out.println("\n...\n");
			} else {
				continua = false;
			}

		} while (continua);

	}

	/**
	 * Menu selecao aborda apenas os cases da classe selecao - nao edita ou exclui
	 * nenhuma outra classe do sistema
	 * 
	 * @param entrada    scanner de entrada do usuario
	 * @param selecaodao
	 * @param jogadordao
	 */
	public static void menu_selecao(Scanner entrada, SelecaoDao selecaodao, jogadorDao jogadordao) {
		Integer opc;
		String name;
		String new_name;
		boolean continua = true;

		do {
			System.out.println("");
			System.out.println("1 - ADICIONAR");
			System.out.println("2 - EDITAR");
			System.out.println("3 - DELETAR");
			System.out.println("4 - LISTAR SELEÇÃO");
			System.out.println("5 - LISTAR JOGADORES DA SELEÇÃO");
			System.out.println("0 - Sair do menu\n");

			System.out.println("Digite a opcao que deseja: ");

			try {
				opc = entrada.nextInt();
				entrada.nextLine();

				switch (opc) {
				case 1:
					System.out.println("Digite o nome da selecao: ");
					name = entrada.nextLine().toUpperCase();
					name = validaEntrada_String(entrada, name);
					// validaEntrada_String(entrada, name);
					Selecao selec = selecaodao.findByName(name);
					if (selec == null) {
						Selecao selecao = new Selecao(name);
						try {
							selecaodao.create(selecao);
						} catch (SelecaoLimiteException e) {
							// TODO Auto-generated catch block
							System.out.println(e.getMessage());
						}
					} else {
						System.out.println("Seleção ja existe!");
					}

					break;

				case 2:
					String name_edit;
					System.out.println("Digite o nome da selecao que deseja editar: ");
					name_edit = entrada.nextLine().toUpperCase();
					name_edit = validaEntrada_String(entrada, name_edit);
					Selecao selec1 = selecaodao.findByName(name_edit);
					if (selec1 == null) {
						System.out.println("Seleção não encontrada!");
					} else {
						System.out.println("Digite o novo nome da seleção: ");
						new_name = entrada.nextLine().toUpperCase();
						new_name = validaEntrada_String(entrada, new_name);
						Selecao selecaedit = selecaodao.findByName(name_edit);
						selecaedit.setName(new_name);
						selecaodao.update(name_edit, new_name, selecaedit);

					}
					break;

				case 3:
					String namedelete;
					System.out.println("Digite o nome da selecao que deseja deletar: ");
					namedelete = entrada.nextLine().toUpperCase();
					namedelete = validaEntrada_String(entrada, namedelete);
					selecaodao.delete(namedelete);
					break;

				case 4:
					System.out.println("\nSeleções: \n");
					Map<String, Selecao> selecoes = selecaodao.retornaMap();
					for (Selecao entry : selecoes.values()) {
						System.out.println(entry.toString());
					}

					break;

				case 5:
					String name_selecao;
					System.out.println("Digite o nome da seleção que deseja listar: ");
					name_selecao = entrada.nextLine().toUpperCase();
					name_selecao = validaEntrada_String(entrada, name_selecao);
					if (selecaodao.existeSelecao(name_selecao)) {
						Selecao selecao = selecaodao.findByName(name_selecao);
						List<Integer> listaselecao = selecao.getJogadores();
						if (listaselecao.size() > 0) {
							System.out.println("\n" + name_selecao + ":\n");
							for (int jog : listaselecao) {
								if (selecao.getTecnico() != null) {
									System.out.println("\nTecnico " + selecao.getTecnico());
								}
								System.out.println("\nNome: " + jogadordao.findByCodjog(jog).getName());
								System.out.println("Id: " + jogadordao.findByCodjog(jog).getId() + "\n");

							}

						} else {
							System.out.println("Seleção sem jogadores!");
						}

					} else {
						System.out.println("Seleção não existe!");
					}

					break;

				}

				continua = false;
			} catch (InputMismatchException erroString) {
				System.out.println("ERRO! Insira apenas números.\n");
				entrada.nextLine();
			}

		} while (continua);
	}

	/**
	 * Menu player chama outras 3 funções e um metodo que interagem com a classe
	 * jogador (parte) e a classe (todo) selecao - cria uma selecao caso nao exista
	 * 
	 * @param entrada
	 * @param name
	 * @param red_card
	 * @param yellow_cardb
	 * @param qtdgols
	 * @param jogador_dao
	 * @param selecao_dao
	 * @param posicao
	 */
	public static void menu_player(Scanner entrada, String name, int red_card, int yellow_card, int qtdgols,
			jogadorDao jogador_dao, SelecaoDao selecao_dao, int posicao) {
		Integer opc;
		boolean continua = true;
		Map<Integer, Jogador> jogadores = jogador_dao.retornaMap();
		do {
			try {
				Biblioteca.printMenu_interno();
				System.out.println("Digite a opcao que deseja: ");

				opc = entrada.nextInt();
				entrada.nextLine();

				switch (opc) {
				case 1:
					add_player(entrada, name, red_card, yellow_card, qtdgols, name, jogador_dao, selecao_dao, posicao);
					break;

				case 2:
					edit_player(entrada, jogador_dao, selecao_dao);
					break;

				case 3:
					delete_player(entrada, jogador_dao, selecao_dao);
					break;

				case 4:
					for (Jogador entry : jogadores.values()) {
						System.out.println(entry.toString());
					}
					break;

				}
				continua = false;
			}

			catch (InputMismatchException erroString) {
				System.out.println("ERRO! Insira apenas números.");
				entrada.nextLine();
			}

		} while (continua);
	}

	/**
	 * Menu para arbitro - nao interage com nenhuma outra classe
	 * 
	 * @param entrada
	 * @param arbitro_dao
	 */
	public static void menu_arbitro(Scanner entrada, ArbitroDao arbitro_dao) {
		Integer opc;
		Integer id_editar;
		String new_name;
		String nome_arb = null;
		boolean continua = true;

		do {
			try {
				printMenu_interno();
				System.out.println("Digite a opcao que deseja: ");
				opc = entrada.nextInt();
				entrada.nextLine();

				switch (opc) {
				case 1:

					System.out.println("Digite o nome do árbitro: ");
					nome_arb = entrada.nextLine().toUpperCase();
					nome_arb = validaEntrada_String(entrada, nome_arb);

					Arbitro arbitro = new Arbitro(nome_arb);
					arbitro_dao.create(arbitro);
					break;

				case 2:
					System.out.println("Digite o id do árbitro que deseja editar:");
					id_editar = entrada.nextInt();
					entrada.nextLine();
					System.out.println("Novo nome: ");
					new_name = entrada.nextLine();
					new_name = validaEntrada_String(entrada, new_name);

					Arbitro arbitro_editar = arbitro_dao.findByIdArb(id_editar);
					arbitro_editar.setName(new_name);
					break;

				case 3:
					Integer id_delete;
					System.out.println("Digite o Id do árbitro que voce deseja excluir: ");
					id_delete = entrada.nextInt();
					arbitro_dao.delete(id_delete);

					break;

				case 4:
					Map<Integer, Arbitro> arbitros = arbitro_dao.retornaMap();
					for (Arbitro entry : arbitros.values()) {
						System.out.println(entry.toString());
					}

					break;
				}
				continua = false;
			} catch (InputMismatchException erroString) {
				System.out.println("ERRO! Insira apenas números.");
				entrada.nextLine();
			}

		} while (continua);
	}

	/**
	 * Menu tecnico tem a mesma interacao com seleção que a classe jogador.
	 * 
	 * @param entrada
	 * @param tecnico_dao
	 * @param selecaodao
	 */
	public static void menu_tecnico(Scanner entrada, TecnicoDao tecnico_dao, SelecaoDao selecaodao) {
		Integer opc;
		Integer id_editar;
		String new_name;
		String nome_tec;
		String selecao_tecnico;
		boolean continua = true;

		do {
			try {
				printMenu_interno();
				System.out.println("Digite a opcao que deseja: ");
				opc = entrada.nextInt();
				entrada.nextLine();

				switch (opc) {
				case 1:
					System.out.println("Digite o nome do tecnico: ");
					nome_tec = entrada.nextLine().toUpperCase();
					nome_tec = validaEntrada_String(entrada, nome_tec);
					System.out.println("Digite o nome da seleção do tecnico: ");
					selecao_tecnico = entrada.nextLine().toUpperCase();
					Selecao selec = verifica_selecao(selecao_tecnico, selecaodao);
					if (selec.getTecnico() == null) {
						Tecnico tecnico = new Tecnico(nome_tec);
						selec.setTecnico(tecnico);
						tecnico_dao.create(tecnico);
					} else {
						System.out.println("Seleção já possui um tecnico");
					}
					break;

				case 2:
					System.out.println("Digite o id do tecnico que deseja editar:");
					id_editar = entrada.nextInt();
					entrada.nextLine();
					Tecnico tec = tecnico_dao.findByIdTec(id_editar);
					if (tec != null) {
						System.out.println("Novo nome: ");
						new_name = entrada.nextLine();
						new_name = validaEntrada_String(entrada, new_name);
						tec.setName(new_name);
						tecnico_dao.update(id_editar, tec);
					} else {
						System.out.println("Tecnico não encontrado!");
					}

					break;

				case 3:
					Integer id_delete;
					System.out.println("Digite o Id do tecnico que voce deseja excluir: ");
					id_delete = entrada.nextInt();
					entrada.nextLine();
					System.out.println("Digite a seleção do tecnico que voce deseja excluir: ");
					String selecao_tec = entrada.nextLine().toUpperCase();
					selecao_tec = validaEntrada_String(entrada, selecao_tec);

					// selecao_dao.deleteJogador_List(jogador_dao, id_delete);
					Selecao selecao = selecaodao.findByName(selecao_tec);
					selecao.setTecnico(null);
					tecnico_dao.delete(id_delete);

					break;

				case 4:
					Map<Integer, Tecnico> tecnicos = tecnico_dao.retornaMap();
					for (Tecnico entry : tecnicos.values()) {
						System.out.println(entry.toString());
					}
					break;
				}
			} catch (InputMismatchException erroString) {
				System.out.println("ERRO! Insira apenas números.");
				entrada.nextLine();
			}

			continua = false;

		} while (continua);
	}

	/**
	 * Funcao para adicionar o jogador no sistema - no map de jogadores e na lista
	 * de id de jogadores que fica em selecao.
	 * 
	 * @param entrada
	 * @param name
	 * @param red_card
	 * @param yellow_card
	 * @param qtdgols
	 * @param name_selecao
	 * @param jogador_dao
	 * @param selecao_dao
	 * @param posicao
	 */

	public static void add_player(Scanner entrada, String name, int red_card, int yellow_card, int qtdgols,
			String name_selecao, jogadorDao jogador_dao, SelecaoDao selecao_dao, int posicao) {

		System.out.println("Digite o nome do jogador: ");
		name = entrada.nextLine().toUpperCase();
		name = validaEntrada_String(entrada, name);
		printPosicoes();
		System.out.println("Digite a posicao do jogador: ");
		posicao = entrada.nextInt();
		entrada.nextLine();
		String posicaoString = listaposicoes(posicao, entrada);
		System.out.println("Qual seleção você joga?");
		name_selecao = entrada.nextLine().toUpperCase();
		name_selecao = validaEntrada_String(entrada, name_selecao);

		Jogador jogador = new Jogador();
		jogador.setName(name);
		jogador.setPosicao(posicaoString);

		jogador_dao.create(jogador);

		Selecao selecao = verifica_selecao(name_selecao, selecao_dao);

		try {
			selecao_dao.createListJogador(selecao, jogador.getId());
		} catch (JogadorLimiteException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Deleta o jogador do map e da lista de jogadores da selecao
	 * 
	 * @param entrada
	 * @param jogador_dao
	 */

	public static void delete_player(Scanner entrada, jogadorDao jogador_dao, SelecaoDao selecao_dao) {
		Integer id_delete;
		System.out.println("Digite o Id do jogador que voce deseja excluir: ");
		id_delete = entrada.nextInt();
		selecao_dao.deleteJogador_List(jogador_dao, id_delete);
		jogador_dao.delete(id_delete);
	}

	/**
	 * Edita o jogador no map e verifica se a nova selecao existe ou nao
	 * 
	 * @param entrada
	 * @param jogador_dao
	 * @param selecao_dao
	 */
	public static void edit_player(Scanner entrada, jogadorDao jogador_dao, SelecaoDao selecao_dao) {
		Integer id_editar;
		String new_name;
		String new_selecao;
		String new_posicao;
		int new_red_card;
		int new_yellow_card;
		int new_qtdgols;

		System.out.println("Digite o id do jogador que deseja editar:");
		id_editar = entrada.nextInt();
		entrada.nextLine();

		System.out.println("Novo nome: ");
		new_name = entrada.nextLine();
		new_name = validaEntrada_String(entrada, new_name);

		System.out.println("Nova posição: ");
		new_posicao = entrada.nextLine();
		new_posicao = validaEntrada_String(entrada, new_name);

		System.out.println("Nova selecao: ");
		new_selecao = entrada.nextLine();
		new_selecao = validaEntrada_String(entrada, new_selecao);

		System.out.println("Nova quantidade de cartões vermelhos: ");
		new_red_card = entrada.nextInt();
		entrada.nextLine();

		System.out.println("Nova quantidade de cartões amarelos:  ");
		new_yellow_card = entrada.nextInt();
		entrada.nextLine();

		System.out.println("Nova quantidade de gols: ");
		new_qtdgols = entrada.nextInt();

		Jogador jogador = jogador_dao.findByCodjog(id_editar);

		verifica_selecao(new_selecao, selecao_dao);

		jogador.setName(new_name);
		jogador.setPosicao(new_posicao);
		jogador.setRed_card(new_red_card);
		jogador.setYellow_card(new_yellow_card);
		jogador.setQtd_gols(new_qtdgols);

		jogador_dao.update(id_editar, jogador);
	}

	/**
	 * Verifica se a selecao ja existe, caso nao exista, a selecao é criada
	 * 
	 * @param name_selecao
	 * @param selecao_dao
	 * @return
	 */
	public static Selecao verifica_selecao(String name_selecao, SelecaoDao selecao_dao) {

		boolean temSelecao = selecao_dao.existeSelecao(name_selecao);
		if (!temSelecao) {
			Selecao selecao = new Selecao(name_selecao);
			try {
				selecao_dao.create(selecao);
			} catch (SelecaoLimiteException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
			return selecao;
		}
		return selecao_dao.findByName(name_selecao);
	}

	/**
	 * Verifica se uma selecao ja possui um tecnico
	 * 
	 * @param name_tecnico
	 * @param selecao
	 * @param tecnico_dao
	 * @return
	 */

	/**
	 * Imprime as posicoes disponiveis
	 */
	public static void printPosicoes() {

		System.out
				.println("SELECIONE SUA POSIÇÃO:\n0 - Goleiro\n1- Zagueiro\n2- Lateral\n3- Meio Campo\n4- Atacante\n");
	}

	/**
	 * Verifica se a posicao escolhida esta na lista de posicoes;
	 * 
	 * @param posicao
	 * @param entrada
	 * @return
	 */
	public static String listaposicoes(int posicao, Scanner entrada) {
		String[] posicoes = new String[] { "GOLEIRO", "ZAGUEIRO", "LATERAL", "MEIO CAMPO", "ATACANTE" };

		while (posicao < 0 || posicao >= posicoes.length) {
			System.out.println("Essa posicao não existe! Digite a posição do jogador: ");
			posicao = entrada.nextInt();
		}

		return posicoes[posicao];

	}

	public static String validaEntrada_String(Scanner entrada, String string) {
		while (!string.matches("[a-zA-Z\s]+") || entrada == null) {
			System.out.println("ERRO! Digite apenas letras");
			string = entrada.nextLine().toUpperCase();
		}
		return string;
	}

	/**
	 * Printa as opções do menu geral
	 */
	public static void printMenu() {
		System.out.println("\tCadastro Copa do mundo");
		System.out.println("");
		System.out.println("1 - JOGADOR");
		System.out.println("2 - SELECAO");
		System.out.println("3 - TECNICO");
		System.out.println("4 - ARBITRO");
		System.out.println("5 - FASE DE GRUPOS - VOCE SO PODE ENTRAR UMA VEZ.");
		System.out.println("0 - Sair do sistema\n");
	}

	/**
	 * Printa as opções do menu interno de cada classe
	 */
	public static void printMenu_interno() {
		System.out.println("");
		System.out.println("1 - ADICIONAR");
		System.out.println("2 - EDITAR");
		System.out.println("3 - DELETAR");
		System.out.println("4 - LISTAR");
		System.out.println("0 - Sair do menu\n");
	}

}