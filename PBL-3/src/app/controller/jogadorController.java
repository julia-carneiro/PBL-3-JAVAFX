package app.controller;
 
import java.net.URL;
import java.util.ResourceBundle;

import app.model.Jogador;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class jogadorController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<?> jogTabela;
    
    private ObservableList<Jogador> jogData;
    
    @FXML
    void initialize() {
    	
    	this.jogData = FXCollections.observableArrayList();
    	
    	TableColumn idJog = new TableColumn("Id");
    	TableColumn nomeJog = new TableColumn("Nome");
    	TableColumn posicao = new TableColumn("Posição");

  
    	idJog.setCellValueFactory(new PropertyValueFactory<Jogador, Integer>("id"));
    	nomeJog.setCellValueFactory(new PropertyValueFactory<Jogador, String>("name"));
    	posicao.setCellValueFactory(new PropertyValueFactory<Jogador, String>("posicao"));
    	
    	
    	this.jogTabela.getColumns().addAll(idJog, nomeJog, posicao);
    	//this.jogTabela.setItems(jogData);
    		
    }

}
