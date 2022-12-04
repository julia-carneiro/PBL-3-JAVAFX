package app.controller;

import java.net.URL;
import java.util.ResourceBundle;

import app.model.Arbitro;

import app.model.DAO.DAO;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class removeArbitro {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

	private Stage stage;

	private arbitroController controller;

   
    @FXML
    void btRemoveAction(MouseEvent event) {
    	//Pega index do selecionado na tabela
    	int i = this.controller.getArbTabela().getSelectionModel().getSelectedIndex();
    	
    	//Pega objeto do index selecionado na tabela
		Arbitro arb = DAO.getArbitroDao().findByIdArb(this.controller.getArbData().get(i).getId());
		
		//Remove da observableList
		this.controller.getArbData().remove(i);
		
		//Remove do DAO
    	DAO.getArbitroDao().delete(arb.getId());
    	
    	//Debug
    	System.out.println(DAO.getArbitroDao().retornaMap());
    	stage.close();
    }
    
    @FXML
    void btCancelAction(MouseEvent event) {
    	stage.close();
    }

	public void setDialogStage(Stage stage) {
		this.stage = stage;
		
	}

	public void setArbitroController(arbitroController controller) {
		this.controller = controller;
		
	}


}
