package app.controller;

import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

import app.model.Grupos;
import app.model.Main;
import app.model.Partida;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class visualizarPartida {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

	private partidaController controller;

	private Stage stage;

    @FXML
    private Label p1s1;

    @FXML
    private Label p1s2;

    @FXML
    private Label p2s1;

    @FXML
    private Label p2s2;

    @FXML
    private Label p3s1;

    @FXML
    private Label p3s2;

    @FXML
    private Label p4s1;

    @FXML
    private Label p4s2;

    @FXML
    private Label p5s1;

    @FXML
    private Label p5s2;

    @FXML
    private Label p6s1;

    @FXML
    private Label p6s2;

    @FXML
    private TextField idGrupo;
    
    @FXML
    private Label labelError;
    
    @FXML
    void btPesquisar(MouseEvent event) {
    	
    	String id = idGrupo.getText().toUpperCase();
    	Grupos grupo = Main.getFaseDeGrupo().getGrupos().get(id);
    	
    	
    	
    	if(grupo == null) {
    		labelError.setText("Grupo inexistente");
    		p1s1.setText("--");
	    	p1s2.setText("--");
	    	
	    	p2s1.setText("--");
	    	p2s2.setText("--");
	    	
	    	p3s1.setText("--");
	    	p3s2.setText("--");
	    	
	    	p4s1.setText("--");
	    	p4s2.setText("--");
	    	
	    	p5s1.setText("--");
	    	p5s2.setText("--");
	    	
	    	p6s1.setText("--");
	    	p6s2.setText("--");
    		
    	}else {

    		//Seta partidas na interface

	    	Map <Integer, Partida> partidas = grupo.getPartidas();
	    	System.out.println(partidas);
	    	p1s1.setText(partidas.get(1).getSelecao1().getName());
	    	p1s2.setText(partidas.get(1).getSelecao2().getName());
	    	
	    	p2s1.setText(partidas.get(2).getSelecao1().getName());
	    	p2s2.setText(partidas.get(2).getSelecao2().getName());
	    	
	    	p3s1.setText(partidas.get(3).getSelecao1().getName());
	    	p3s2.setText(partidas.get(3).getSelecao2().getName());
	    	
	    	p4s1.setText(partidas.get(4).getSelecao1().getName());
	    	p4s2.setText(partidas.get(4).getSelecao2().getName());
	    	
	    	p5s1.setText(partidas.get(5).getSelecao1().getName());
	    	p5s2.setText(partidas.get(5).getSelecao2().getName());
	    	
	    	p6s1.setText(partidas.get(6).getSelecao1().getName());
	    	p6s2.setText(partidas.get(6).getSelecao2().getName());
	    	labelError.setText("");
    	}
    }

    @FXML
    void initialize() {
    	
    }

	public void setDialogStage(Stage stage) {
		// TODO Auto-generated method stub
		this.stage = stage;
	}

	public void setVisualizarController(partidaController controller) {
		// TODO Auto-generated method stub
		this.controller = controller;
	}

}
