import java.net.URL;
import java.sql.Date;
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

public class ProdutoController {

    @FXML
    private TextField input_id;

    @FXML
    private TextField input_descricao;

    @FXML
    private TextField input_marca;

    @FXML
    private TableView<Produto> tabela_produto = new TableView<Produto>();

    @FXML
    private TableColumn<Produto, Integer> col_id = new TableColumn<>();

    @FXML
    private TableColumn<Produto, String> col_descricao = new TableColumn<>();

    @FXML
    private TableColumn<Produto, String> col_marca = new TableColumn<>();

    @FXML
    private TableColumn<Produto, String> col_validade = new TableColumn<>();

    @FXML
    private TableColumn<Produto, String> col_preco = new TableColumn<>();

    @FXML
    private TableColumn<Produto, Integer> col_quantidade = new TableColumn<>();
    
    @FXML
    private TableColumn<Produto, Boolean> col_em_estoque = new TableColumn<>();

    @FXML
    void btnBuscar(ActionEvent event) throws SQLException {
        
    }
    public void initialize(URL url, ResourceBundle rb) throws SQLException{
        col_id.setCellValueFactory(new PropertyValueFactory<Produto, Integer>("id"));
        col_descricao.setCellValueFactory(new PropertyValueFactory<Produto, String>("descricao"));
        col_marca.setCellValueFactory(new PropertyValueFactory<Produto, String>("marca"));
        col_validade.setCellValueFactory(new PropertyValueFactory<Produto, String>("validade"));
        col_preco.setCellValueFactory(new PropertyValueFactory<Produto, String>("preco"));
        col_quantidade.setCellValueFactory(new PropertyValueFactory<Produto, Integer>("quantidade"));
        col_em_estoque.setCellValueFactory(new PropertyValueFactory<Produto, Boolean>("emEstoque"));
        preencherTabela();
    }
    private void preencherTabela() throws SQLException{
        ObservableList<Produto> produtos = FXCollections.observableArrayList(new ProdutoDAO().getProdutos());
        tabela_produto.setItems(produtos);
    }
}
