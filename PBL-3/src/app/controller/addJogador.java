package app.controller;

import java.net.URL;
import java.util.ResourceBundle;

import app.model.Jogador;
import app.model.Posicoes;
import app.model.DAO.DAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class addJogador {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> posicaoJog;
    
    @FXML
    private TextField nomeJog; 
    
    @FXML
    private Button btSalvar;
    
    private Stage stage;
    
    private jogadorController controller;
    
    @FXML
    void btSalvarAction(ActionEvent event) {
    	Jogador jog = new Jogador(this.nomeJog.getText(), this.posicaoJog.getValue());
    	controller.getjogData().add(jog);
    	DAO.getJogDao().create(jog);
    	stage.close();
   
    }

    void setJogadorController(jogadorController controller) {
    	this.controller = controller;
    }
    
 
    
    @FXML
    void initialize() {
    	posicaoJog.getItems().addAll(Posicoes.posicoes);
    }

	public void setDialogStage(Stage stage) {
		this.stage = stage;
		
	}

}
