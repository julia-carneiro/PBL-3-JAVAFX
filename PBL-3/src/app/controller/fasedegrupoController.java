package app.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class fasedegrupoController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label selecao1;

    @FXML
    private Label selecao2;

    @FXML
    private Label selecao3;

    @FXML
    private Label selecao4;
    
    @FXML
    private Label selecao5;

    @FXML
    private Label selecao6;

    @FXML
    private Label selecao7;

    @FXML
    private Label selecao8;
    
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
    void iniciarfase(MouseEvent event) {
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
	void btFaseDeGrupo(MouseEvent event) {

	}
    
    
	public void setText1(String nomeselec1, String nomeselec2, String nomeselec3, String nomeselec4) {
		selecao1.setText(nomeselec1);
		selecao2.setText(nomeselec2);
		selecao3.setText(nomeselec3);
		selecao4.setText(nomeselec4);
	}
	
	   
	public void setText2(String nomeselec5, String nomeselec6, String nomeselec7, String nomeselec8) {
		selecao5.setText(nomeselec5);
		selecao6.setText(nomeselec6);
		selecao7.setText(nomeselec7);
		selecao8.setText(nomeselec8);
	}
	
	public void setText3(String nomeselec9, String nomeselec10, String nomeselec11, String nomeselec12) {
		selecao5.setText(nomeselec9);
		selecao6.setText(nomeselec10);
		selecao7.setText(nomeselec11);
		selecao8.setText(nomeselec12);
	}
	
	public void setText4(String nomeselec13, String nomeselec14, String nomeselec15, String nomeselec16) {
		selecao5.setText(nomeselec13);
		selecao6.setText(nomeselec14);
		selecao7.setText(nomeselec15);
		selecao8.setText(nomeselec16);
	}
	
	public void setText5(String nomeselec17, String nomeselec18, String nomeselec19, String nomeselec20) {
		selecao5.setText(nomeselec17);
		selecao6.setText(nomeselec18);
		selecao7.setText(nomeselec19);
		selecao8.setText(nomeselec20);
	}
	
	public void setText6(String nomeselec21, String nomeselec22, String nomeselec23, String nomeselec24) {
		selecao5.setText(nomeselec21);
		selecao6.setText(nomeselec22);
		selecao7.setText(nomeselec23);
		selecao8.setText(nomeselec24);
	}
	
	public void setText7(String nomeselec25, String nomeselec26, String nomeselec27, String nomeselec28) {
		selecao5.setText(nomeselec25);
		selecao6.setText(nomeselec26);
		selecao7.setText(nomeselec27);
		selecao8.setText(nomeselec28);
	}
	
	public void setText8(String nomeselec29, String nomeselec30, String nomeselec31, String nomeselec32) {
		selecao5.setText(nomeselec29);
		selecao6.setText(nomeselec30);
		selecao7.setText(nomeselec31);
		selecao8.setText(nomeselec32);
	}

    @FXML
    void initialize() {
      
    }

    
}
/*
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
import javafx.scene.control.Label;
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
	private Label selecao1;

	@FXML
	private Label selecao2;

	@FXML
	private Label selecao3;

	@FXML
	private Label selecao4;

	    
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
    
	public void setText1(String nomeselec1, String nomeselec2, String nomeselec3, String nomeselec4) {
		selecao1.setText(nomeselec1);
		selecao2.setText(nomeselec2);
		selecao3.setText(nomeselec3);
		selecao4.setText(nomeselec4);

	}
 
    
   
    

	@FXML
	void initialize() {
		this.gruposData = FXCollections.observableArrayList();

		TableColumn nomeSelecao = new TableColumn("Nome");
		TableColumn pontuacao = new TableColumn("Pontuacao");
		
		nomeSelecao.setCellValueFactory(new PropertyValueFactory<Grupos, Selecao>("Selecao1"));
	
		pontuacao.setCellValueFactory(new PropertyValueFactory<Selecao, Integer>("pontuacao"));
		
		this.grupoTabela.getColumns().addAll(nomeSelecao, pontuacao);
		this.grupoTabela.setItems(gruposData);
	}
	
	public ObservableList<Grupos> getGruposData() {
		return gruposData;
	}
	
	public TableView<Grupos> getGruposTabela() {
		return grupoTabela;
	}
	
	
}

*/