package app.controller;

import java.net.URL;
import java.util.ResourceBundle;

import app.model.Jogador;
import app.model.Posicoes;
import app.model.Selecao;
import app.model.Tecnico;
import app.model.DAO.DAO;
import app.model.Exceptions.JogadorLimiteException;
import app.model.Exceptions.SelecaoLimiteException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class addJogador {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private ComboBox<String> posicaoJog;

	@FXML
	private TextField nomeJog;

	@FXML
	private TextField nomeSelec;

	private Stage stage;

	private jogadorController controller;
	
	//
	@FXML
	void btSalvarAction(MouseEvent event) {
		//Encontra selecao a partir do nome
		Selecao selec = DAO.getSelecDao().findByName(this.nomeSelec.getText().toUpperCase());
		
		//Cria o jogador e a selecao do jogador caso não tenha sido encontrada
		if (selec == null) {
			try {
				Selecao selecao = new Selecao(this.nomeSelec.getText().toUpperCase());
				Jogador jog = new Jogador(this.nomeJog.getText().toUpperCase(), this.posicaoJog.getValue(), selecao);
				// Cria nos DAOS
				DAO.getSelecDao().create(selecao);
				DAO.getJogDao().create(jog);
				try {
					DAO.getSelecDao().createListJogador(selecao, jog);
				} catch (JogadorLimiteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//Add no controller
				controller.getjogData().add(jog);

			} catch (SelecaoLimiteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			try {
				//Cria um jogador e adiciona na selecao existente
				Jogador jog = new Jogador(this.nomeJog.getText().toUpperCase(), this.posicaoJog.getValue(), selec);
				controller.getjogData().add(jog);
				DAO.getJogDao().create(jog);
				DAO.getSelecDao().createListJogador(selec, jog);

			} catch (JogadorLimiteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		stage.close();

	}

	void setJogadorController(jogadorController controller) {
		this.controller = controller;
	}

	@FXML
	void initialize() {
		//Add a lista de posicoes no combobox
		posicaoJog.getItems().addAll(Posicoes.posicoes);
	}

	public void setDialogStage(Stage stage) {
		this.stage = stage;

	}

}
