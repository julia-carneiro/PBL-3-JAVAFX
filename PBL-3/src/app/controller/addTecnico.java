package app.controller;

import java.net.URL;
import java.util.ResourceBundle;

import app.model.Tecnico;
import app.model.DAO.DAO;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class addTecnico {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField nomeTec;

	private tecnicoController controller;

	private Stage stage;
   
    
    @FXML
    void btSalvarAction(MouseEvent event) {
    	Tecnico tecnico = new Tecnico(this.nomeTec.getText());
    	controller.getTecData().add(tecnico);
    	DAO.getTecnicoDao().create(tecnico);
    	stage.close();
    }

	public void setDialogStage(Stage stage) {
		// TODO Auto-generated method stub
		this.stage = stage;
	}

	public void setTecnicoController(tecnicoController controller) {
		this.controller = controller;
		
	}

}
