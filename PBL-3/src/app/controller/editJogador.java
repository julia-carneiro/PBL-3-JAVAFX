package app.controller;

import app.model.Jogador;
import app.model.Posicoes;
import app.model.DAO.DAO;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class editJogador {

    @FXML
    private TextField edtiNomeJog;

    @FXML
    private ComboBox<String> posicaoJog;
    
    private Stage stage;
    
    private jogadorController controller;
    


    @FXML
    void btSalvarAction(MouseEvent event) {
    	int i = this.controller.getJogTabela().getSelectionModel().getSelectedIndex();
    	Jogador jog = DAO.getJogDao().findByCodjog(this.controller.getjogData().get(i).getId());
    	jog.setName(this.edtiNomeJog.getText());
    	jog.setPosicao(this.posicaoJog.getValue());
    	controller.getjogData().set(i, jog);
    	DAO.getJogDao().update(this.controller.getjogData().get(i).getId(), jog);
    	
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
