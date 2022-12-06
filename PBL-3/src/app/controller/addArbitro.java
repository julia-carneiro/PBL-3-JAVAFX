package app.controller;

import java.net.URL;
import java.util.ResourceBundle;

import app.model.Arbitro;
import app.model.Tecnico;
import app.model.DAO.DAO;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class addArbitro {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField nomeArb;

	private Stage stage;

	private arbitroController controller;



    @FXML
    void btSalvarAction(MouseEvent event) {
    	Arbitro arbitro = new Arbitro(this.nomeArb.getText().toUpperCase());
    	controller.getArbData().add(arbitro);
    	DAO.getArbitroDao().create(arbitro);
    	stage.close();
    }

	public void setDialogStage(Stage stage) {
		this.stage = stage;
		
	}

	public void setArbitroController(arbitroController controller) {
		this.controller = controller;
		
	}

}
