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
    	int i = this.controller.getTecTabela().getSelectionModel().getSelectedIndex();
    	if(i>=0){
	    	Tecnico tecnico = DAO.getTecnicoDao().findByIdTec(this.controller.getTecData().get(i).getId());
	    	Selecao selec = DAO.getSelecDao().findByName(this.editNomeTec.getText());
	    	if(selec == null) {
				try {
					Selecao selecao = new Selecao(this.editNomeSelecTec.getText());
					DAO.getSelecDao().create(selecao);
					
					tecnico.setName(this.editNomeTec.getText());
		    		tecnico.setSelecao(selecao);
		    		controller.getTecData().set(i, tecnico);
		    		
		    		DAO.getTecnicoDao().update(tecnico.getId(), tecnico);
				} catch (SelecaoLimiteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

	    	}else {
	    		if(selec.getTecnico() == null) {
		    		//Seta novo nome
		    		tecnico.setName(this.editNomeTec.getText());
		    		tecnico.setSelecao(selec);
		    		controller.getTecData().set(i, tecnico);
		    	}
	    	}
	    	
	    	
	    	//Seta o novo objeto na observableList
	    	
	    	
	    	//Edita o tecnico no DAO
	    	//DAO.getTecnicoDao().update(this.controller.getTecData().get(i).getId(), tecnico);
    	}
    	//Debug
    	System.out.println(DAO.getTecnicoDao().retornaMap());
    	stage.close();
    }

	public void setDialogStage(Stage stage) {
		this.stage = stage;
	}

	void setTecnicoController(tecnicoController controller) {
		this.controller = controller;

	}

}
