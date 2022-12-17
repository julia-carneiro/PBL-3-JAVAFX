package app.controller;

import java.net.URL;
import java.util.ResourceBundle;

import app.model.Jogador;
import app.model.Posicoes;
import app.model.DAO.DAO;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class removeJogador {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    private Stage stage;

	private jogadorController controller;
    
    @FXML
    void btRemoveAction(MouseEvent event) {

    	//Remove jogador selecionado na tabela 

    	int i = this.controller.getJogTabela().getSelectionModel().getSelectedIndex();
    	// busca e remove o jogador no DAO
    	Jogador jog = DAO.getJogDao().findByCodjog(this.controller.getjogData().get(i).getId());
    	this.controller.getjogData().remove(i);
    	DAO.getJogDao().delete(jog.getId());
 
    	stage.close();
    }
    
    
    @FXML
    void btCancelAction(MouseEvent event) {
    	stage.close();
    }
    
    void setJogadorController(jogadorController controller) {
    	this.controller = controller;
    }

	public void setDialogStage(Stage stage) {
		this.stage = stage;
		
	}


}
