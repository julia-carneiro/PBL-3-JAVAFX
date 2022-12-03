package app.controller;

import java.net.URL;
import java.util.ResourceBundle;

import app.model.Jogador;
import app.model.Selecao;
import app.model.DAO.DAO;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class removeSelecao {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

	private selecaoController controller;

	private Stage stage;

    @FXML
    void btRemoveAction(MouseEvent event) {
    	int i = this.controller.getSelecTabela().getSelectionModel().getSelectedIndex();
    	Selecao selec = DAO.getSelecDao().findByName(this.controller.getSelecData().get(i).getName());
   
    	
    	this.controller.getSelecData().remove(i);
    	DAO.getSelecDao().delete(selec.getName());
    	//Debug
    	System.out.println(DAO.getJogDao().retornaMap());
    	stage.close();
    }
    
    @FXML
    void btCancelAction(MouseEvent event) {
    	stage.close();
    }
    
    void setSelecaoController(selecaoController controller) {
    	this.controller = controller;
    }

	public void setDialogStage(Stage stage) {
		this.stage = stage;
		
	}
    
 

}
