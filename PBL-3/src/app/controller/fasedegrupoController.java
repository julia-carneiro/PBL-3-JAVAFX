package app.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import app.model.FaseDeGrupo;
import app.model.Grupos;
import app.model.Partida;
import app.model.Selecao;
import app.model.DAO.DAO;
import app.model.Exceptions.JogadorSelecaoFGrupoException;
import app.model.Exceptions.SelecaoInsuficienteException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class fasedegrupoController {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	private static ObservableList<Grupos> grupos;
	private static ObservableList<Selecao> selecData;
	private static ObservableList<Partida> partidaData;

	@FXML
	private ComboBox<Grupos> cbGrupos;

	@FXML
	private TableView<Grupos> grupoTabela;

	@FXML
	private Label labelError;

	@FXML
	private TableView<Partida> tbPartidas;

	@FXML
	void cbAction(ActionEvent event) {
		if(this.cbGrupos.getValue() == DAO.getFaseDeGrupo().buscaGrupo(1)) {
			setSelecData(DAO.getFaseDeGrupo().buscaGrupo(1).getSelecoes());
			
		}
	}

	private void setSelecData(List<Selecao> selecoes) {
		// TODO Auto-generated method stub
		this.selecData = FXCollections.observableArrayList(selecoes);
		
	}

	@FXML
	void btFaseDeGrupo(MouseEvent event) {
		
	}

	@FXML
	void initialize() {
		if (DAO.getSelecDao().retornaListaSelecoes().size() == 4) {
			try {
				FaseDeGrupo fasedegrupo = new FaseDeGrupo(DAO.getSelecDao().retornaListaSelecoes(), DAO.getSelecDao());
				grupos = FXCollections.observableArrayList(fasedegrupo.getGrupos());
				this.cbGrupos.setItems(grupos);
			} catch (JogadorSelecaoFGrupoException | SelecaoInsuficienteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		TableColumn nomeSelecao = new TableColumn("Nome");

		nomeSelecao.setCellValueFactory(new PropertyValueFactory<Selecao, String>("name"));

		this.grupoTabela.getColumns().addAll(nomeSelecao);
		
		
		
		
	}

}
