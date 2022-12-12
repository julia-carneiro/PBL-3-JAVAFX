package app.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import app.model.FaseDeGrupo;
import app.model.Grupos;
import app.model.Selecao;
import app.model.DAO.DAO;
import app.model.Exceptions.JogadorSelecaoFGrupoException;
import app.model.Exceptions.SelecaoInsuficienteException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class iniciarFase {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Label labelError;

	private Stage stage;

	private fasedegrupoController controller;

	@FXML
	void btAction(MouseEvent event) {
		int qtdSelecoes = DAO.getSelecDao().retornaListaSelecoes().size();
		if (qtdSelecoes == 8) {
			try {
				FaseDeGrupo fasedegrupo = new FaseDeGrupo(DAO.getSelecDao().retornaListaSelecoes(), DAO.getSelecDao());
				// controller.getGruposData().addAll(fasedegrupo.getGrupos().values());
				List<Grupos> grupo = new ArrayList<Grupos>();
				grupo.addAll(fasedegrupo.getGrupos().values());
				controller.setText1(grupo.get(0).getSelecao1().getName(), grupo.get(0).getSelecao2().getName(),
						grupo.get(0).getSelecao3().getName(), grupo.get(0).getSelecao4().getName());

				controller.setText2(grupo.get(1).getSelecao1().getName(), grupo.get(1).getSelecao2().getName(),
						grupo.get(1).getSelecao3().getName(), grupo.get(1).getSelecao4().getName());

				controller.setText3(grupo.get(2).getSelecao1().getName(), grupo.get(2).getSelecao2().getName(),
						grupo.get(2).getSelecao3().getName(), grupo.get(2).getSelecao4().getName());

				controller.setText4(grupo.get(3).getSelecao1().getName(), grupo.get(3).getSelecao2().getName(),
						grupo.get(3).getSelecao3().getName(), grupo.get(3).getSelecao4().getName());

				controller.setText5(grupo.get(4).getSelecao1().getName(), grupo.get(4).getSelecao2().getName(),
						grupo.get(4).getSelecao3().getName(), grupo.get(4).getSelecao4().getName());

				controller.setText6(grupo.get(5).getSelecao1().getName(), grupo.get(5).getSelecao2().getName(),
						grupo.get(5).getSelecao3().getName(), grupo.get(5).getSelecao4().getName());
				
				controller.setText7(grupo.get(6).getSelecao1().getName(), grupo.get(6).getSelecao2().getName(),
						grupo.get(6).getSelecao3().getName(), grupo.get(6).getSelecao4().getName());
				
				controller.setText8(grupo.get(7).getSelecao1().getName(), grupo.get(7).getSelecao2().getName(),
						grupo.get(7).getSelecao3().getName(), grupo.get(7).getSelecao4().getName());
				
			} catch (JogadorSelecaoFGrupoException | SelecaoInsuficienteException e) {
				// TODO Auto-generated catch block
				labelError.setText(e.getMessage());
			}
		} else {
			labelError.setText("Só é possível iniciar com 32 seleções");
		}
		stage.close();
	}

	@FXML
	void btCancelAction(MouseEvent event) {
		stage.close();
	}

	@FXML
	void initialize() {

	}

	public void setDialogStage(Stage stage) {
		// TODO Auto-generated method stub
		this.stage = stage;

	}

	public void setFaseController(fasedegrupoController controller) {
		// TODO Auto-generated method stub
		this.controller = controller;
	}

}
