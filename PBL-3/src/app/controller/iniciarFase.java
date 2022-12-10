package app.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import app.model.FaseDeGrupo;
import app.model.Grupos;
import app.model.Selecao;
import app.model.DAO.DAO;
import app.model.Exceptions.JogadorSelecaoFGrupoException;
import app.model.Exceptions.SelecaoInsuficienteException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class iniciarFase {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Label labelError;

	private Stage stage;
	
	
	private fasedegrupoController controller;


	@FXML
	void btAction(MouseEvent event) {
		int qtdSelecoes = DAO.getSelecDao().retornaListaSelecoes().size();
		if (qtdSelecoes == 4) {
			try {
				FaseDeGrupo fasedegrupo = new FaseDeGrupo(DAO.getSelecDao().retornaListaSelecoes(), DAO.getSelecDao());
				controller.getGruposData().addAll(fasedegrupo.getGrupos().values());
				
			} catch (JogadorSelecaoFGrupoException | SelecaoInsuficienteException e) {
				// TODO Auto-generated catch block
				labelError.setText(e.getMessage());
			}
		} else {
			labelError.setText("Só é possível iniciar com 32 seleções");
		}
	}

	@FXML
	void btCancelAction(MouseEvent event) {
		stage.close();
	}

	@FXML
	void initialize() {
		
	}

	public void setDialogStage(Stage stage) {
		// TODO Auto-generated method stub
		this.stage = stage;

	}

	public void setFaseController(fasedegrupoController controller) {
		// TODO Auto-generated method stub
		this.controller = controller;
	}

}