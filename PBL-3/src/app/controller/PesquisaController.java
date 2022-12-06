package app.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import app.model.Jogador;
import app.model.Selecao;
import app.model.Tecnico;
import app.model.DAO.DAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PesquisaController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Jogador> pesquisaTabela;
    
    @FXML
    private Label selecao;

    @FXML
    private Label tecnico;

	@FXML
	private ObservableList<Jogador> pesquisaData;

    @FXML
    void btPesquisarAction(MouseEvent event) {
    	
    	try {
			FXMLLoader loader = new FXMLLoader();
			URL xmlURL = getClass().getResource("/app/view/PesquisaSelecao.fxml");
			loader.setLocation(xmlURL);

			Parent parent = loader.load();

			Scene scene = new Scene(parent);

			Stage stage = new Stage();
			stage.setTitle("Pesquise a selecao");
			stage.setScene(scene);
			stage.setResizable(false);
			stage.centerOnScreen();
			stage.initModality(Modality.APPLICATION_MODAL);

			PesquisaSelecao controller = loader.getController();
			controller.setDialogStage(stage);
			controller.setPesquisaController(this);
			
			pesquisaData.clear();
			stage.showAndWait();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public ObservableList<Jogador> getPesquisaData(){
    	return pesquisaData;
    }
    
    
 
    
    public void setTexts(String nomeSelec, String nomeTec) {
    	selecao.setText(nomeSelec);
    	tecnico.setText(nomeTec);
    	
    }
    
   
    
    @FXML
    void initialize() {

		this.pesquisaData = FXCollections.observableArrayList();
		
		TableColumn idJog = new TableColumn("Id");
		TableColumn nomeJog = new TableColumn("Nome");
		TableColumn posicao = new TableColumn("Posição");

		idJog.setCellValueFactory(new PropertyValueFactory<Jogador, Integer>("id"));
		nomeJog.setCellValueFactory(new PropertyValueFactory<Jogador, String>("name"));
		posicao.setCellValueFactory(new PropertyValueFactory<Jogador, String>("posicao"));
		
    
		this.pesquisaTabela.getColumns().addAll(idJog, nomeJog, posicao);
    	this.pesquisaTabela.setItems(pesquisaData);
    	
    	

    }

}
