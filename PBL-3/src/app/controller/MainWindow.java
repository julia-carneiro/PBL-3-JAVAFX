package app.controller;
 
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class MainWindow {


	@FXML 
	private BorderPane bp;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
  
    @FXML
    void arbitro(MouseEvent event) {
    	loadPage("arbitro");
    }

    @FXML
    void fasedegrupo(MouseEvent event) {
    	loadPage("fasedegrupo");
    }

    @FXML
    void jogador(MouseEvent event) {
    	loadPage("jogador");
    }

    @FXML
    void selecao(MouseEvent event) {
    	loadPage("selecao");

    }

    @FXML
    void tecnico(MouseEvent event) {
    	loadPage("tecnico");
    }
    
   
   
    private void loadPage(String page) {
    	Parent root = null;
    	try {
    		root = FXMLLoader.load(getClass().getResource("/app/view/"+page+".fxml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	bp.setCenter(root);
    }
    
    @FXML
    void initialize() {

    }

}
