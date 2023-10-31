
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.scene.Node;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
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
        String idText = input_id.getText().trim();
        int id = 0;
        if (!idText.isEmpty()) {
            try {
                id = Integer.parseInt(idText);
            } catch (NumberFormatException e) {

            }
        }
        String descricao = input_descricao.getText();
        String marca = input_marca.getText();
        ObservableList<Produto> produtos = FXCollections.observableArrayList(new ProdutoDAO().buscar(id, descricao, marca));
        tabela_produto.setItems(produtos);
    }

    @FXML
    void btnExcluir(ActionEvent event) throws SQLException {
        Produto selectedProduto = tabela_produto.getSelectionModel().getSelectedItem();
        if (selectedProduto != null) {
            int selectedId = selectedProduto.getId();
            ProdutoDAO  produtoDao = new ProdutoDAO();
            produtoDao.delete(selectedId);
        }
    }

    @FXML
    void btnFinalizar(ActionEvent event) throws SQLException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("venda.fxml"));
        Parent root;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        VendaController novaPaginaController = loader.getController(); 
        novaPaginaController.initialize(null, null);
        Stage stage = new Stage();
        Scene cena = new Scene(root);
        stage.setScene(cena);
        stage.show();
    }

    @FXML
    void btnAddCarrinho(ActionEvent event) {

    }

    @FXML
    void btnEditar(ActionEvent event) throws SQLException {
        /*Produto selectedProduto = tabela_produto.getSelectionModel().getSelectedItem();
        if (selectedProduto != null) {
            int selectedId = selectedProduto.getId();
            ProdutoDAO produtoDAO = new ProdutoDAO();
            List<Produto> produtos= produtoDAO.buscar(selectedId, null, null);
            for (Produto produto : produtos) {
                String descricao = produto.getDescricao();
                String marca = produto.getMarca();
                String preco = produto.getPreco();
                String validade = produto.getValidade();
                String quantidade = parseInt(produto.getQuantidade());
            }
            
        }*/
    }
    
    
    @FXML
    void colGetId(MouseEvent event) {
        col_id.getCellData(0);
    }

    @FXML
    void btnInserir(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("cadastrarProduto.fxml"));
        Parent root;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        CadastrarProdutoController novaPaginaController = loader.getController(); 
        Stage stage = new Stage();
        Scene cena = new Scene(root);
        stage.setScene(cena);
        stage.show();
    }
    public void initialize(URL url, ResourceBundle rb) throws SQLException {
        col_id.setCellValueFactory(new PropertyValueFactory<Produto, Integer>("id"));
        col_descricao.setCellValueFactory(new PropertyValueFactory<Produto, String>("descricao"));
        col_marca.setCellValueFactory(new PropertyValueFactory<Produto, String>("marca"));
        col_validade.setCellValueFactory(new PropertyValueFactory<Produto, String>("validade"));
        col_preco.setCellValueFactory(new PropertyValueFactory<Produto, String>("preco"));
        col_quantidade.setCellValueFactory(new PropertyValueFactory<Produto, Integer>("quantidade"));
        col_em_estoque.setCellValueFactory(new PropertyValueFactory<Produto, Boolean>("emEstoque"));
        preencherTabela();
    }

    private void preencherTabela() throws SQLException {
        ObservableList<Produto> produtos = FXCollections.observableArrayList(new ProdutoDAO().getProdutos());
        tabela_produto.setItems(produtos);
    }

}
