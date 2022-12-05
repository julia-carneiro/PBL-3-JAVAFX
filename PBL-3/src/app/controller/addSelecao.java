package app.controller;

import java.net.URL;
import java.util.ResourceBundle;

import app.model.Jogador;
import app.model.Selecao;
import app.model.DAO.DAO;
import app.model.Exceptions.SelecaoLimiteException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class addSelecao {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	private selecaoController controller;

	@FXML
	private TextField nomeSelecao;

	private Stage stage;

	@FXML
	void btSalvarAction(MouseEvent event) {
		if (DAO.getSelecDao().existeSelecao(this.nomeSelecao.getText()) == false) {
			Selecao selec = new Selecao(this.nomeSelecao.getText());
			controller.getSelecData().add(selec);
			try {
				DAO.getSelecDao().create(selec);
			} catch (SelecaoLimiteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// Debug
		System.out.println(DAO.getSelecDao().retornaListaSelecoes());
		stage.close();

	}

	void setSelecaoController(selecaoController controller) {
		this.controller = controller;
	}

	public void setDialogStage(Stage stage) {
		this.stage = stage;

	}

}
