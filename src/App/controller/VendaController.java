package App.controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import App.model.ItemVenda;
import App.model.Produto;
import App.model.DAO.ItemVendaDAO;
import App.model.DAO.ProdutoDAO;
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
import javafx.stage.Stage;

public class VendaController {
    private int id_venda;
    @FXML
    private TableColumn<ItemVenda, String> col_descricao;

    @FXML
    private TableColumn<ItemVenda, String> col_marca;

    @FXML
    private TableColumn<ItemVenda, String> col_preco;

    @FXML
    private TableColumn<ItemVenda, Integer> col_quantidade;

    @FXML
    private TableColumn<ItemVenda, Integer> col_venda_id;

    @FXML
    private TextField descricao_itemVenda;

    @FXML
    private TextField id_ItemVenda;

    @FXML
    private TextField marca_ItemVenda;

    @FXML
    private TextField preco_ItemVenda;

    @FXML
    private TextField formaDePagamento;

    @FXML
    private TextField valorTotal;

    @FXML
    private TableView<ItemVenda> tabela_venda = new TableView<ItemVenda>();

    @FXML
    void btnBuscarItemVenda(ActionEvent event) throws SQLException {
        String idText = id_ItemVenda.getText().trim();
        int id = 0;
        if (!idText.isEmpty()) {
            try {
                id = Integer.parseInt(idText);
            } catch (NumberFormatException e) {

            }
        }
        String descricao = descricao_itemVenda.getText();
        String marca = marca_ItemVenda.getText();
        String preco = preco_ItemVenda.getText();
        ObservableList<ItemVenda> itensVenda = FXCollections
                .observableArrayList(new ItemVendaDAO().buscar(id, descricao, marca, preco, this.id_venda));
        tabela_venda.setItems(itensVenda);
    }

    @FXML
    void finalizarVenda(ActionEvent event) {

    }

    @FXML
    void removerItemVenda(ActionEvent event) throws SQLException {
        ItemVenda selectedItemVenda = tabela_venda.getSelectionModel().getSelectedItem();
        if (selectedItemVenda != null) {
            int selectedId = selectedItemVenda.getId();
            ItemVendaDAO itemVendaDAO = new ItemVendaDAO();
            itemVendaDAO.delete(selectedId);
            calculaTotal();
            preencherTabela();
        }
    }

    @FXML
    void addCliente(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/App/view/cadastrarCliente.fxml"));
        Parent root;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        ClienteController novaPaginaController = loader.getController();
        Stage stage = new Stage();
        Scene cena = new Scene(root);
        stage.setScene(cena);
        stage.show();
    }

    public void initialize(URL url, ResourceBundle rb) throws SQLException {
        col_venda_id.setCellValueFactory(new PropertyValueFactory<ItemVenda, Integer>("produto_id"));
        col_descricao.setCellValueFactory(new PropertyValueFactory<ItemVenda, String>("descricao"));
        col_marca.setCellValueFactory(new PropertyValueFactory<ItemVenda, String>("marca"));
        col_preco.setCellValueFactory(new PropertyValueFactory<ItemVenda, String>("preco"));
        col_quantidade.setCellValueFactory(new PropertyValueFactory<ItemVenda, Integer>("quantidade"));
        valorTotal.setEditable(false);
        calculaTotal();
        preencherTabela();
    }

    public void preencherTabela() throws SQLException {
        ObservableList<ItemVenda> itensVenda = FXCollections
                .observableArrayList(new ItemVendaDAO().getItensVenda(this.id_venda));
        tabela_venda.setItems(itensVenda);
    }

    public void calculaTotal() throws SQLException {
        float total = new ItemVendaDAO().calculaTotal(this.id_venda);
        valorTotal.setText(String.valueOf(total));
    }

    public void setIdVenda(int id_venda) {
        this.id_venda = id_venda;
    }
}
