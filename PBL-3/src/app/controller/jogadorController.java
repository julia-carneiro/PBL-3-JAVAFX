package app.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import app.model.Jogador;
import app.model.Selecao;
import app.model.DAO.DAO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class jogadorController {
	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TableView<Jogador> jogTabela;

	@FXML
	private ObservableList<Jogador> jogData;

	@FXML
	void btAddAction(MouseEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader();
			URL xmlURL = getClass().getResource("/app/view/addJogador.fxml");
			loader.setLocation(xmlURL);

			Parent parent = loader.load();

			Scene scene = new Scene(parent);

			Stage stage = new Stage();
			stage.setTitle("Adicione o jogador");
			stage.setScene(scene);
			stage.setResizable(false);
			stage.centerOnScreen();
			stage.initModality(Modality.APPLICATION_MODAL);

			addJogador controller = loader.getController();
			controller.setDialogStage(stage);
			controller.setJogadorController(this);

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
			URL xmlURL = getClass().getResource("/app/view/editJogador.fxml");
			loader.setLocation(xmlURL);

			Parent parent = loader.load();

			Scene scene = new Scene(parent);

			Stage stage = new Stage();
			stage.setTitle("Edite o jogador");
			stage.setScene(scene);
			stage.setResizable(false);
			stage.centerOnScreen();
			stage.initModality(Modality.APPLICATION_MODAL);

			editJogador controller = loader.getController();
			controller.setDialogStage(stage);
			controller.setJogadorController(this);

			stage.showAndWait();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//System.out.println("teste2");
	}

	@FXML
	void btRemoveAction(MouseEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader();
			URL xmlURL = getClass().getResource("/app/view/removeJogador.fxml");
			loader.setLocation(xmlURL);

			Parent parent = loader.load();

			Scene scene = new Scene(parent);

			Stage stage = new Stage();
			stage.setTitle("Excluir jogador");
			stage.setScene(scene);
			stage.setResizable(false);
			stage.centerOnScreen();
			stage.initModality(Modality.APPLICATION_MODAL);

			removeJogador controller = loader.getController();
			controller.setDialogStage(stage);
			controller.setJogadorController(this);

			stage.showAndWait();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	void initialize() {
		// Inicializa a tabela de jogadores com os IDs, nomes, posição, e Seleções 
		
		this.jogData = FXCollections.observableArrayList();
		TableColumn idJog = new TableColumn("Id");
		TableColumn nomeJog = new TableColumn("Nome");
		TableColumn posicao = new TableColumn("Posição");
		TableColumn nomeSelec = new TableColumn("Seleção");

		idJog.setCellValueFactory(new PropertyValueFactory<Jogador, Integer>("id"));
		nomeJog.setCellValueFactory(new PropertyValueFactory<Jogador, String>("name"));
		posicao.setCellValueFactory(new PropertyValueFactory<Jogador, String>("posicao"));
		nomeSelec.setCellValueFactory(new PropertyValueFactory<Jogador, Selecao>("selecao"));

		this.jogTabela.getColumns().addAll(idJog, nomeJog, posicao, nomeSelec);
		this.jogData.addAll(DAO.getJogDao().retornaMap());
		this.jogTabela.setItems(jogData);

	}
	
	public ObservableList<Jogador> getjogData() {
		return jogData;
	}
	
	public TableView<Jogador> getJogTabela(){
		
		return jogTabela;
	}
}
