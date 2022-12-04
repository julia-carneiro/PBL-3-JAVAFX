package app.controller;

import java.net.URL;
import java.util.ResourceBundle;

import app.model.Tecnico;
import app.model.DAO.DAO;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class removeTecnico {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	private Stage stage;

	private tecnicoController controller;

	@FXML
	void btRemoveAction(MouseEvent event) {
		//Pega index do selecionado na tabela
		int i = this.controller.getTecTabela().getSelectionModel().getSelectedIndex();
		
		//Pega objeto do index selecionado na tabela
		Tecnico tec = DAO.getTecnicoDao().findByIdTec(this.controller.getTecData().get(i).getId());
		
		//Remove da observableList
		this.controller.getTecData().remove(i);
		
		//Remove do DAO
    	DAO.getTecnicoDao().delete(tec.getId());
    	
    	//Debug
    	System.out.println(DAO.getTecnicoDao().retornaMap());
    	stage.close();
	}

	@FXML
	void btCancelAction(MouseEvent event) {
		stage.close();
	}

	void setTecnicoController(tecnicoController controller) {
		this.controller = controller;
	}

	public void setDialogStage(Stage stage) {
		this.stage = stage;

	}

}
