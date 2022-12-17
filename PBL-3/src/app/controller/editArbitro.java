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

public class editArbitro {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField editNomeArb;

	private arbitroController controller;

	private Stage stage;

    @FXML
    void btSalvarAction(MouseEvent event) {
    	//posição do arbitro na tabela
    	int i = this.controller.getArbTabela().getSelectionModel().getSelectedIndex();
  
    	Arbitro arbitro = DAO.getArbitroDao().findByIdArb(this.controller.getArbData().get(i).getId());
    	//Seta novo nome
    	arbitro.setName(this.editNomeArb.getText());
    	
    	//Seta o novo objeto na observableList
    	controller.getArbData().set(i, arbitro);
    	
    	//Edita o tecnico no DAO
    	DAO.getArbitroDao().update(this.controller.getArbData().get(i).getId(), arbitro);
    	
    	//Debug
    	System.out.println(DAO.getArbitroDao().retornaMap());
    }


	public void setDialogStage(Stage stage) {
		this.stage = stage;
		
	}

	public void setArbitroController(arbitroController controller) {
		this.controller = controller;
		
	}

}
