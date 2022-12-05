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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PesquisaController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Selecao> pesquisaTabela;

	@FXML
	private ObservableList<Selecao> pesquisaData;

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

			stage.showAndWait();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public ObservableList<Selecao> geTpesquisaData(){
    	return pesquisaData;
    }

    @FXML
    void initialize() {

		this.pesquisaData = FXCollections.observableArrayList();
    	TableColumn nome = new TableColumn("Pesquisa");
    	TableColumn jogadoreselec = new TableColumn("Jogadores");
    	TableColumn tecselec = new TableColumn("Tecnico");
    	
    	
    	nome.setCellValueFactory(new PropertyValueFactory<Selecao, String>("name"));
    	jogadoreselec.setCellValueFactory(new PropertyValueFactory<Selecao, Jogador>("jogadores"));
    	tecselec.setCellValueFactory(new PropertyValueFactory<Selecao, Tecnico>("tecnico"));


    	this.pesquisaTabela.getColumns().addAll(nome, jogadoreselec, tecselec);
    	//pesquisa.setCellValueFactory(new PropertyValueFactory<Selecao, Jogador>("jogadores"));
    	this.pesquisaTabela.setItems(pesquisaData);

    }

}
