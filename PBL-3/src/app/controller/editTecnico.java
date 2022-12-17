package app.controller;

import java.net.URL;
import java.util.ResourceBundle;

import app.model.Selecao;
import app.model.Tecnico;
import app.model.DAO.DAO;
import app.model.Exceptions.SelecaoLimiteException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class editTecnico {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TextField editNomeTec;
	
	@FXML
	private TextField editNomeSelecTec;
	

	private tecnicoController controller;

	private Stage stage;

	@FXML
    void btSalvarAction(MouseEvent event) {
		// Posição do tecnico na tabela
    	int i = this.controller.getTecTabela().getSelectionModel().getSelectedIndex();
    	
    	if(i>=0){
    		// Busca o tecnico e sua seleção nos respectivos DAOs
	    	Tecnico tecnico = DAO.getTecnicoDao().findByIdTec(this.controller.getTecData().get(i).getId());
	    	Selecao selec = DAO.getSelecDao().findByName(this.editNomeTec.getText());
	    	if(selec == null) {
				try {
					// Cria a seleção caso não exista
					Selecao selecao = new Selecao(this.editNomeSelecTec.getText());
					DAO.getSelecDao().create(selecao);
					
					// Seta as novas informações
					tecnico.setName(this.editNomeTec.getText());
		    		tecnico.setSelecao(selecao);
		    		controller.getTecData().set(i, tecnico);
		    		
		    		DAO.getTecnicoDao().update(tecnico.getId(), tecnico);
				} catch (SelecaoLimiteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

	    	}else {
	    		if(selec.getTecnico() != null) {
		    		//Seta novo nome
		    		tecnico.setName(this.editNomeTec.getText());
		    		tecnico.setSelecao(selec);
		    		controller.getTecData().set(i, tecnico);
		    	}
	    	}
	    	
	    	
	    	//Seta o novo objeto na observableList
	    	
	    	

    	}

    	stage.close();
    }

	public void setDialogStage(Stage stage) {
		this.stage = stage;
	}

	void setTecnicoController(tecnicoController controller) {
		this.controller = controller;

	}

}
