package app.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import app.model.Selecao;
import app.model.DAO.DAO;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PesquisaSelecao {
    @FXML
    private TextField nomeSelecaoPesquisa;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

	private PesquisaController controller;

	private Stage stage;

    @FXML
    void btPesquisarAction(MouseEvent event) {
    	//Pesquisa selecao por nome 
    	Selecao selec = DAO.getSelecDao().findByName(this.nomeSelecaoPesquisa.getText().toUpperCase());
    	if(selec!=null) {
    		controller.getPesquisaData().addAll(selec.getJogadores());
    		if(selec.getTecnico() != null){
    			controller.setTexts(selec.getName(), selec.getTecnico().getName());
    		}else {
    			controller.setTexts(selec.getName(), "--");
    		}
    	}
    	stage.close();
    	
    }

	public void setDialogStage(Stage stage) {
		this.stage = stage;
		
	}

	public void setPesquisaController(PesquisaController controller) {
		this.controller = controller;
		
	}
}
