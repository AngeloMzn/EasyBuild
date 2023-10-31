import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Produto;
import model.DAO.ProdutoDAO;

public class VendaController {

    @FXML
    private TableColumn<Produto, String> col_descricao;

    @FXML
    private TableColumn<Produto, String> col_marca;

    @FXML
    private TableColumn<Produto, String> col_preco;

    @FXML
    private TableColumn<Produto, Integer> col_quantidade;

    @FXML
    private TableColumn<Produto, Integer> col_venda_id;

    @FXML
    private TextField descricao_itemVenda;

    @FXML
    private TextField id_ItemVenda;

    @FXML
    private TextField marca_ItemVenda;

    @FXML
    private TextField preco_ItemVenda;

    @FXML
    private TableView<Produto> tabela_venda = new TableView<Produto>();;

    @FXML
    void btnBuscarItemVenda(ActionEvent event) {

    }

    @FXML
    void finalizarVenda(ActionEvent event) {

    }

    @FXML
    void removerItemVenda(ActionEvent event) {

    }
      public void initialize(URL url, ResourceBundle rb) throws SQLException {
        col_venda_id.setCellValueFactory(new PropertyValueFactory<Produto, Integer>("id"));
        col_descricao.setCellValueFactory(new PropertyValueFactory<Produto, String>("descricao"));
        col_marca.setCellValueFactory(new PropertyValueFactory<Produto, String>("marca"));
        col_preco.setCellValueFactory(new PropertyValueFactory<Produto, String>("preco"));
        col_quantidade.setCellValueFactory(new PropertyValueFactory<Produto, Integer>("quantidade"));
        preencherTabela();
    }

    private void preencherTabela() throws SQLException {
        ObservableList<Produto> produtos = FXCollections.observableArrayList(new ProdutoDAO().getProdutos());
        tabela_venda.setItems(produtos);
    }

}
