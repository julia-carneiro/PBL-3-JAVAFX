package app.controller;

import app.model.Jogador;
import app.model.Posicoes;
import app.model.Selecao;
import app.model.DAO.DAO;
import app.model.Exceptions.JogadorLimiteException;
import app.model.Exceptions.SelecaoLimiteException;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class editJogador {

	@FXML
	private TextField editNomeJog;

	@FXML
	private TextField nomeSelec;

	@FXML
	private ComboBox<String> posicaoJog;

	private Stage stage;

	private jogadorController controller;

	@FXML
	void btSalvarAction(MouseEvent event) {
		int i = this.controller.getJogTabela().getSelectionModel().getSelectedIndex();
		if (i >= 0) {
			Jogador jog = DAO.getJogDao().findByCodjog(this.controller.getjogData().get(i).getId());
			Selecao selec = DAO.getSelecDao().findByName(this.nomeSelec.getText());
			if (selec == null) {
				// Cria nos DAOS
				try {
					//Cria nova selecao
					Selecao selecao = new Selecao(this.nomeSelec.getText());
					DAO.getSelecDao().create(selecao);
					
					//Seta novas informações
					jog.setName(this.editNomeJog.getText());
					jog.setPosicao(this.posicaoJog.getValue());
					jog.setSelecao(selecao);
					
					//Cria e atualiza no DAO
					DAO.getJogDao().create(jog);
					DAO.getJogDao().update(jog.getId(), jog);
					DAO.getSelecDao().createListJogador(selecao, jog);
					
					//Seta no controller
					controller.getjogData().set(i,jog);
					
					//Atualiza no DAO
					DAO.getJogDao().update(this.controller.getjogData().get(i).getId(), jog);
					
					
				} catch (SelecaoLimiteException | JogadorLimiteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(DAO.getJogDao().retornaMap());
			}else {
				jog.setName(this.editNomeJog.getText());
				jog.setPosicao(this.posicaoJog.getValue());
				jog.setSelecao(selec);
				controller.getjogData().set(i, jog);
				
				System.out.println(DAO.getJogDao().retornaMap());
			}
		}
		stage.close();
	}

	void setJogadorController(jogadorController controller) {
		this.controller = controller;
	}

	@FXML
	void initialize() {
		posicaoJog.getItems().addAll(Posicoes.posicoes);
	}

	public void setDialogStage(Stage stage) {
		this.stage = stage;

	}
}
