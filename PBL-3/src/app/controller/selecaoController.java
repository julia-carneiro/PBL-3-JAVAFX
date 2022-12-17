package app.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import app.model.Jogador;
import app.model.Selecao;
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

public class selecaoController {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TableView<Selecao> selecTabela;

	@FXML
	private ObservableList<Selecao> selecData;

	@FXML
	void btAddAction(MouseEvent event) {
		//Abre tela pop up para add selecao
		try {
			FXMLLoader loader = new FXMLLoader();
			URL xmlURL = getClass().getResource("/app/view/addSelecao.fxml");
			loader.setLocation(xmlURL);

			Parent parent = loader.load();

			Scene scene = new Scene(parent);

			Stage stage = new Stage();
			stage.setTitle("Adicione a seleção");
			stage.setScene(scene);
			stage.setResizable(false);
			stage.centerOnScreen();
			stage.initModality(Modality.APPLICATION_MODAL);

			addSelecao controller = loader.getController();
			controller.setDialogStage(stage);
			controller.setSelecaoController(this);

			stage.showAndWait();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	void btEditAction(MouseEvent event) {
		//Abre tela pop up para editar selecao
		try {
			FXMLLoader loader = new FXMLLoader();
			URL xmlURL = getClass().getResource("/app/view/editSelecao.fxml");
			loader.setLocation(xmlURL);

			Parent parent = loader.load();

			Scene scene = new Scene(parent);

			Stage stage = new Stage();
			stage.setTitle("Edite a seleção");
			stage.setScene(scene);
			stage.setResizable(false);
			stage.centerOnScreen();
			stage.initModality(Modality.APPLICATION_MODAL);

			editSelecao controller = loader.getController();
			controller.setDialogStage(stage);
			controller.setSelecaoController(this);

			stage.showAndWait();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	void btRemoveAction(MouseEvent event) {
		//Abre tela pop up para remover selecao
		try {
			FXMLLoader loader = new FXMLLoader();
			URL xmlURL = getClass().getResource("/app/view/removeSelecao.fxml");
			loader.setLocation(xmlURL);

			Parent parent = loader.load();

			Scene scene = new Scene(parent);

			Stage stage = new Stage();
			stage.setTitle("Excluir seleção");
			stage.setScene(scene);
			stage.setResizable(false);
			stage.centerOnScreen();
			stage.initModality(Modality.APPLICATION_MODAL);

			removeSelecao controller = loader.getController();
			controller.setDialogStage(stage);
			controller.setSelecaoController(this);

			stage.showAndWait();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	void initialize() {

		this.selecData = FXCollections.observableArrayList();

		TableColumn nomeSelecao = new TableColumn("Nome");

		nomeSelecao.setCellValueFactory(new PropertyValueFactory<Selecao, String>("name"));
		
		//Inicializa tabela de selecao 
		this.selecTabela.getColumns().addAll(nomeSelecao);
		this.selecData.addAll(DAO.getSelecDao().retornaListaSelecoes());
		this.selecTabela.setItems(selecData);

	}

	public ObservableList<Selecao> getSelecData() {
		return selecData;
	}

	public TableView<Selecao> getSelecTabela() {

		return selecTabela;
	}
}
