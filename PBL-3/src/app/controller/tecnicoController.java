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

public class tecnicoController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
	private TableView<Tecnico> tecTabela;

	@FXML
	private ObservableList<Tecnico> tecData;
    
    @FXML
    void btAddAction(MouseEvent event) {
    	try {
			FXMLLoader loader = new FXMLLoader();
			URL xmlURL = getClass().getResource("/app/view/addTecnico.fxml");
			loader.setLocation(xmlURL);

			Parent parent = loader.load();

			Scene scene = new Scene(parent);

			Stage stage = new Stage();
			stage.setTitle("Adicione o técnico");
			stage.setScene(scene);
			stage.setResizable(false);
			stage.centerOnScreen();
			stage.initModality(Modality.APPLICATION_MODAL);

			addTecnico controller = loader.getController();
			controller.setDialogStage(stage);
			controller.setTecnicoController(this);

			stage.showAndWait();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void btEditAction(MouseEvent event) {
    	try {
			FXMLLoader loader = new FXMLLoader();
			URL xmlURL = getClass().getResource("/app/view/editTecnico.fxml");
			loader.setLocation(xmlURL);

			Parent parent = loader.load();

			Scene scene = new Scene(parent);

			Stage stage = new Stage();
			stage.setTitle("Edite o técnico");
			stage.setScene(scene);
			stage.setResizable(false);
			stage.centerOnScreen();
			stage.initModality(Modality.APPLICATION_MODAL);

			editTecnico controller = loader.getController();
			controller.setDialogStage(stage);
			controller.setTecnicoController(this);

			stage.showAndWait();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void btRemoveAction(MouseEvent event) {
    	try {
			FXMLLoader loader = new FXMLLoader();
			URL xmlURL = getClass().getResource("/app/view/removeTecnico.fxml");
			loader.setLocation(xmlURL);

			Parent parent = loader.load();

			Scene scene = new Scene(parent);

			Stage stage = new Stage();
			stage.setTitle("Excluir técnico");
			stage.setScene(scene);
			stage.setResizable(false);
			stage.centerOnScreen();
			stage.initModality(Modality.APPLICATION_MODAL);

			removeTecnico controller = loader.getController();
			controller.setDialogStage(stage);
			controller.setTecnicoController(this);

			stage.showAndWait();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    @FXML
    void initialize() {
    	
    	// Inicializa a tabela de tecnico na interface 
    	
    	this.tecData = FXCollections.observableArrayList();
    	
    	TableColumn idTec = new TableColumn("Id");
    	TableColumn nomeTec = new TableColumn("Nome");
    	TableColumn nomeSelecTec = new TableColumn("Selecao");
    	
    	idTec.setCellValueFactory(new PropertyValueFactory<Tecnico, Integer>("id"));
    	nomeTec.setCellValueFactory(new PropertyValueFactory<Tecnico, String>("name"));
    	nomeSelecTec.setCellValueFactory(new PropertyValueFactory<Tecnico, Selecao>("selecao"));
    	
    	this.tecTabela.getColumns().addAll(idTec, nomeTec, nomeSelecTec);
    	this.tecData.addAll(DAO.getTecnicoDao().retornaMap());
    	this.tecTabela.setItems(tecData);
    }
    
    public ObservableList<Tecnico> getTecData(){
    	return tecData;
    }
    
    public TableView<Tecnico> getTecTabela(){
    	return tecTabela;
    }

}
