import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.DAO.ProdutoDAO;
import javafx.scene.Node;

public class CadastrarProdutoController {

    @FXML
    private TextField descricao;

    @FXML
    private TextField preco;

    @FXML
    private TextField marca;

    @FXML
    private TextField validade;

    @FXML
    private TextField quantidade;

    @FXML
    void cadastrar(ActionEvent event) throws SQLException {
        String descricaoText = descricao.getText();
        String precoText = preco.getText();
        String marcaText = marca.getText();
        String validadeText = validade.getText();
        int quantidadeText = Integer.parseInt(quantidade.getText());
        new ProdutoDAO().inserir(descricaoText, marcaText, validadeText, precoText, quantidadeText);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

}
