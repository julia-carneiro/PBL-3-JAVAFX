package app.controller;

import java.net.URL;
import java.util.ResourceBundle;

import app.model.Tecnico;
import app.model.DAO.DAO;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class editTecnico {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField editNomeTec;

	private tecnicoController controller;

	private Stage stage;

	@FXML
    void btSalvarAction(MouseEvent event) {
    	int i = this.controller.getTecTabela().getSelectionModel().getSelectedIndex();
    	Tecnico tecnico = DAO.getTecnicoDao().findByIdTec(this.controller.getTecData().get(i).getId());
    	//Seta novo nome
    	tecnico.setName(this.editNomeTec.getText());
    	
    	//Seta o novo objeto na observableList
    	controller.getTecData().set(i, tecnico);
    	
    	//Edita o tecnico no DAO
    	DAO.getTecnicoDao().update(this.controller.getTecData().get(i).getId(), tecnico);
    	
    	//Debug
    	System.out.println(DAO.getTecnicoDao().retornaMap());
    }


	public void setDialogStage(Stage stage) {
		this.stage = stage;
	}

	void setTecnicoController(tecnicoController controller) {
		this.controller = controller;
		
	}

}
