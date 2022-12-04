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

		// boolean existeSelec =
		// DAO.getSelecDao().existeSelecao(this.nomeSelecTec.getText());
		Selecao selec = DAO.getSelecDao().findByName(this.nomeSelecTec.getText());

		// System.out.println(existeSelec);
		if (selec == null) {
			try {
				Selecao selecao = new Selecao(this.nomeSelecTec.getText());
				Tecnico tecnico = new Tecnico(this.nomeTec.getText(), selecao);
				controller.getTecData().add(tecnico);
				DAO.getTecnicoDao().create(tecnico);
				DAO.getSelecDao().create(selecao);

			} catch (SelecaoLimiteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			if(selec.getTecnico() != null) {
				Tecnico tecnico = new Tecnico(this.nomeTec.getText(), selec);
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
