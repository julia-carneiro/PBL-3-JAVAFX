package app.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import app.model.FaseDeGrupo;
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
    private Label selecao9;
    
    @FXML
    private Label selecao10;

    @FXML
    private Label selecao11;

    @FXML
    private Label selecao12;

    @FXML
    private Label selecao13;

    @FXML
    private Label selecao14;

    @FXML
    private Label selecao15;

    @FXML
    private Label selecao16;

    @FXML
    private Label selecao17;

    @FXML
    private Label selecao18;

    @FXML
    private Label selecao19;

    @FXML
    private Label selecao20;

    @FXML
    private Label selecao21;

    @FXML
    private Label selecao22;

    @FXML
    private Label selecao23;

    @FXML
    private Label selecao24;

    @FXML
    private Label selecao25;

    @FXML
    private Label selecao26;

    @FXML
    private Label selecao27;

    @FXML
    private Label selecao28;

    @FXML
    private Label selecao29;

    @FXML
    private Label selecao30;

    @FXML
    private Label selecao31;

    @FXML
    private Label selecao32;
    
    @FXML
    void iniciarfase(MouseEvent event) {
    	//Abre tela pop up para perguntar se deseja iniciar a fase de grupos
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

    

    //Seta os labels das selecoes na fase de grupo

    
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
		selecao9.setText(nomeselec9);
		selecao10.setText(nomeselec10);
		selecao11.setText(nomeselec11);
		selecao12.setText(nomeselec12);
	}
	
	public void setText4(String nomeselec13, String nomeselec14, String nomeselec15, String nomeselec16) {
		selecao13.setText(nomeselec13);
		selecao14.setText(nomeselec14);
		selecao15.setText(nomeselec15);
		selecao16.setText(nomeselec16);
	}
	
	public void setText5(String nomeselec17, String nomeselec18, String nomeselec19, String nomeselec20) {
		selecao17.setText(nomeselec17);
		selecao18.setText(nomeselec18);
		selecao19.setText(nomeselec19);
		selecao20.setText(nomeselec20);
	}
	
	public void setText6(String nomeselec21, String nomeselec22, String nomeselec23, String nomeselec24) {
		selecao21.setText(nomeselec21);
		selecao22.setText(nomeselec22);
		selecao23.setText(nomeselec23);
		selecao24.setText(nomeselec24);
	}
	
	public void setText7(String nomeselec25, String nomeselec26, String nomeselec27, String nomeselec28) {
		selecao25.setText(nomeselec25);
		selecao26.setText(nomeselec26);
		selecao27.setText(nomeselec27);
		selecao28.setText(nomeselec28);
	}
	
	public void setText8(String nomeselec29, String nomeselec30, String nomeselec31, String nomeselec32) {
		selecao29.setText(nomeselec29);
		selecao30.setText(nomeselec30);
		selecao31.setText(nomeselec31);
		selecao32.setText(nomeselec32);
	}

    @FXML
    void initialize() {
      
    }

    
    
}

