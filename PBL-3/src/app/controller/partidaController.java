package app.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import app.model.Grupos;
import app.model.Jogador;
import app.model.Main;
import app.model.Partida;
import app.model.Posicoes;
import app.model.Selecao;
import app.model.DAO.DAO;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class partidaController {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	private Stage stage;

	private fasedegrupoController controller;

	@FXML
	private TextField cartaoJog1;

	@FXML
	private TextField cartaoJog2;

	@FXML
	private ComboBox<?> cbCartao;

	@FXML
	private ComboBox<Jogador> cbJog1;

	@FXML
	private ComboBox<?> cbJog2;

	@FXML
	private TextField data;

	@FXML
	private TextField golsJog1;

	@FXML
	private TextField golsJog2;

	@FXML
	private TextField golsSelec1;

	@FXML
	private TextField golsSelec2;

	@FXML
	private TextField horario;

	@FXML
	private TextField local;

	@FXML
	private TextField nomeArb;
	
    @FXML
    private TextField codPartida;
    
    @FXML
    private TextField codGrupo;

	@FXML
	void salvarInfo(MouseEvent event) {

	}

	@FXML
	void visualizarPartida(MouseEvent event) {
		//Abre tela pop up para visualizar partida 
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
		/*String id = codGrupo.getText();
		String idPart = codPartida.getText();
		Grupos grupo = Main.getFaseDeGrupo().getGrupos().get(id);
		Partida partida = grupo.getPartidas().get(idPart);
		
		cbJog1.getItems().addAll(partida.getSelecao1().getJogadores());
		//cbJog2.getItems().add(partida.getSelecao2().getJogadores());*/
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
