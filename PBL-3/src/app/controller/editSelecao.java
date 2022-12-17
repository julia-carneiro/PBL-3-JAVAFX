package app.controller;

import java.net.URL;
import java.util.ResourceBundle;

import app.model.Jogador;
import app.model.Selecao;
import app.model.DAO.DAO;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class editSelecao {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField editNomeSelecao;
    
    private Stage stage;

	private selecaoController controller;

    @FXML
    void btSalvarAction(MouseEvent event) {

    	//Pega index da selecao selecionada na tabela

    	int i = this.controller.getSelecTabela().getSelectionModel().getSelectedIndex();
    	
    	// Encontra a seleção atraves do nome no DAO
    	Selecao selec = DAO.getSelecDao().findByName(this.controller.getSelecData().get(i).getName());
    	
    	//Pega nome da tabela, nome pra edição e objeto selecao
    	DAO.getSelecDao().update(this.controller.getSelecData().get(i).getName(), editNomeSelecao.getText(), selec);
    	controller.getSelecData().set(i, selec);
    	
    	// Seta uma nova informação da seleção
    	selec.setName(this.editNomeSelecao.getText());
    
    	stage.close();
    }

    void setSelecaoController(selecaoController controller) {
    	this.controller = controller;
    }
    
    public void setDialogStage(Stage stage) {
		this.stage = stage;
		
	}

}
