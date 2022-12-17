package app.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import app.model.Jogador;
import app.model.Selecao;
import app.model.DAO.DAO;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class partidaController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

	private Stage stage;
	
	@FXML
	private ComboBox<Jogador> listajogador1;
	
	@FXML
	private ComboBox<Jogador> listajogador2;
	

	private fasedegrupoController controller;
    
    @FXML
    void visualizarPartida(MouseEvent event) {
    	try {
			FXMLLoader loader = new FXMLLoader();
			URL xmlURL = getClass().getResource("/app/view/visualizarPartida.fxml");
			loader.setLocation(xmlURL);

			Parent parent = loader.load();

			Scene scene = new Scene(parent);

			Stage stage = new Stage();
			stage.setTitle("Adicione a seleção");
			stage.setScene(scene);
			stage.setResizable(false);
			stage.centerOnScreen();
			stage.initModality(Modality.APPLICATION_MODAL);

			visualizarPartida controller = loader.getController();
			controller.setDialogStage(stage);
			controller.setVisualizarController(this);

			stage.showAndWait();
			stage.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
    }

    @FXML
    void initialize() {	
    	

    }
    
    public void setDialogStage(Stage stage) {
		// TODO Auto-generated method stub
		this.stage = stage;
	}

	public void setVisualizarController(fasedegrupoController controller) {
		// TODO Auto-generated method stub
		this.controller = controller;
	}
}
