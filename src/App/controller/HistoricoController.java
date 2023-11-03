package App.controller;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import App.model.ItemVenda;
import App.model.DAO.ItemVendaDAO;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableColumn;
public class HistoricoController {
    @FXML
    private Label dataVendaLabel;

    @FXML
    private Label clienteLabel;

    @FXML
    private TableView<ItemVenda> produtosTableView = new TableView<ItemVenda>();

    @FXML
    private TableColumn<ItemVenda, String> produtoColumn;

    @FXML
    private TableColumn<ItemVenda, Integer> quantidadeColumn;

    @FXML
    private TableColumn<ItemVenda, String> valorUnitarioColumn;

    @FXML
    private Label valorTotalLabel;

    @FXML
    private Label metodoPagamentoLabel;

    public void initialize(URL url, ResourceBundle rb, Date data, String nomeCliente, String valorTotal, String metodoPagamento, int id_venda) throws SQLException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        this.dataVendaLabel.setText(dateFormat.format(data));
        clienteLabel.setText(nomeCliente);
        valorTotalLabel.setText(valorTotal);
        metodoPagamentoLabel.setText(metodoPagamento);
        quantidadeColumn.setCellValueFactory(new PropertyValueFactory<ItemVenda, Integer>("quantidade"));
        produtoColumn.setCellValueFactory(new PropertyValueFactory<ItemVenda, String>("descricao"));
        valorUnitarioColumn.setCellValueFactory(new PropertyValueFactory<ItemVenda, String>("preco"));
        System.out.println(id_venda);
        preencherTabela(id_venda);
    }
      public void preencherTabela(int id_venda) throws SQLException {
        System.out.println("entrou aqui");
        ObservableList<ItemVenda> itensVenda = FXCollections
                .observableArrayList(new ItemVendaDAO().getItensVenda(id_venda));
        produtosTableView.setItems(itensVenda);
    }

}
