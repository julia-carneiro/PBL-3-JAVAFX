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

public class addTecnico {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TextField nomeTec;

	@FXML
	private TextField nomeSelecTec; // Selecao que o tecnico participa

	private tecnicoController controller;

	private Stage stage;

	@FXML
	void btSalvarAction(MouseEvent event) {
		//Procura selecao
		Selecao selec = DAO.getSelecDao().findByName(this.nomeSelecTec.getText().toUpperCase());
		if (selec == null) {
			try {
				//Cria tecnico e a seleção caso não exista ainda
				Selecao selecao = new Selecao(this.nomeSelecTec.getText().toUpperCase());
				Tecnico tecnico = new Tecnico(this.nomeTec.getText().toUpperCase(), selecao);
				selecao.setTecnico(tecnico);
				controller.getTecData().add(tecnico);
				//Adiciona no DAO
				DAO.getTecnicoDao().create(tecnico);
				DAO.getSelecDao().create(selecao);
				

			} catch (SelecaoLimiteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			//Caso selecao não tenha tecnico cria e adiciona
			if(selec.getTecnico() == null) {
				Tecnico tecnico = new Tecnico(this.nomeTec.getText().toUpperCase(), selec);
				selec.setTecnico(tecnico);
				controller.getTecData().add(tecnico);
				DAO.getTecnicoDao().create(tecnico);
				
			}
		}

		stage.close();
	}

	public void setDialogStage(Stage stage) {
		// TODO Auto-generated method stub
		this.stage = stage;
	}

	public void setTecnicoController(tecnicoController controller) {
		this.controller = controller;

	}

}
