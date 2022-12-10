package app.controller;

import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.ResourceBundle;

import app.model.Grupos;
import app.model.Jogador;
import app.model.Selecao;
import app.model.DAO.DAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class fasedegrupoController {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private ComboBox<Grupos> grupos;
	
	@FXML
	private ObservableList<Grupos> gruposData;
	
	@FXML
	private TableView<Grupos> grupoTabela;

	@FXML
	void btFaseDeGrupo(MouseEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader();
			URL xmlURL = getClass().getResource("/app/view/iniciarFase.fxml");
			loader.setLocation(xmlURL);

			Parent parent = loader.load();

			Scene scene = new Scene(parent);

			Stage stage = new Stage();
			stage.setTitle("Adicione a seleção");
			stage.setScene(scene);
			stage.setResizable(false);
			stage.centerOnScreen();
			stage.initModality(Modality.APPLICATION_MODAL);

			iniciarFase controller = loader.getController();
			controller.setDialogStage(stage);
			controller.setFaseController(this);

			stage.showAndWait();
			stage.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}

	@FXML
	void initialize() {
		this.gruposData = FXCollections.observableArrayList();

		TableColumn nomeSelecao = new TableColumn("Nome");
		TableColumn pontuacao = new TableColumn("Pontuacao");
		
		//nomeSelecao.setCellValueFactory(new PropertyValueFactory<Selecao, String>("name"));
		pontuacao.setCellValueFactory(new PropertyValueFactory<Selecao, Integer>("pontuacao"));
		
		this.grupoTabela.getColumns().addAll(pontuacao);
		this.grupoTabela.setItems(gruposData);
	}
	
	public ObservableList<Grupos> getGruposData() {
		return gruposData;
	}
	
	public TableView<Grupos> getGruposTabela() {
		return grupoTabela;
	}
	
	
}
