package app.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import app.model.Arbitro;
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

public class arbitroController {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TableView<Arbitro> arbitroTabela;

	private ObservableList<Arbitro> arbData;

	@FXML
	void btAddAction(MouseEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader();
			URL xmlURL = getClass().getResource("/app/view/addArbitro.fxml");
			loader.setLocation(xmlURL);

			Parent parent = loader.load();

			Scene scene = new Scene(parent);

			Stage stage = new Stage();
			stage.setTitle("Adicione o árbitro");
			stage.setScene(scene);
			stage.setResizable(false);
			stage.centerOnScreen();
			stage.initModality(Modality.APPLICATION_MODAL);

			addArbitro controller = loader.getController();
			controller.setDialogStage(stage);
			controller.setArbitroController(this);

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
			URL xmlURL = getClass().getResource("/app/view/editArbitro.fxml");
			loader.setLocation(xmlURL);

			Parent parent = loader.load();

			Scene scene = new Scene(parent);

			Stage stage = new Stage();
			stage.setTitle("Edite o árbitro");
			stage.setScene(scene);
			stage.setResizable(false);
			stage.centerOnScreen();
			stage.initModality(Modality.APPLICATION_MODAL);

			editArbitro controller = loader.getController();
			controller.setDialogStage(stage);
			controller.setArbitroController(this);

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
			URL xmlURL = getClass().getResource("/app/view/removeArbitro.fxml");
			loader.setLocation(xmlURL);

			Parent parent = loader.load();

			Scene scene = new Scene(parent);

			Stage stage = new Stage();
			stage.setTitle("Excluir árbitro");
			stage.setScene(scene);
			stage.setResizable(false);
			stage.centerOnScreen();
			stage.initModality(Modality.APPLICATION_MODAL);

			removeArbitro controller = loader.getController();
			controller.setDialogStage(stage);
			controller.setArbitroController(this);

			stage.showAndWait();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	void initialize() {
		this.arbData = FXCollections.observableArrayList();

		TableColumn idArb = new TableColumn("Id");
		TableColumn nomeArb = new TableColumn("Nome");

		idArb.setCellValueFactory(new PropertyValueFactory<Tecnico, Integer>("id"));
		nomeArb.setCellValueFactory(new PropertyValueFactory<Tecnico, String>("name"));

		this.arbitroTabela.getColumns().addAll(idArb, nomeArb);
		this.arbData.addAll(DAO.getArbitroDao().retornaMap());
		this.arbitroTabela.setItems(arbData);
	}

	public ObservableList<Arbitro> getArbData() {
		// TODO Auto-generated method stub
		return arbData;
	}

	public TableView<Arbitro> getArbTabela() {
		return arbitroTabela;
	}

}
