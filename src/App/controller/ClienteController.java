package App.controller;

import java.sql.SQLException;

import App.model.Cliente;
import App.model.DAO.ClienteDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ClienteController {
    private int venda_id;

    @FXML
    private TextField nome_cliente;

    @FXML
    private TextField cliente_sexo;

    @FXML
    private TextField sobrenome_cliente;

    @FXML
    private TextField idade_cliente;

    @FXML
    private TextField cpf_cliente;

    @FXML
    private TextField endereco_cliente;

    @FXML
    void inserirCliente(ActionEvent event) throws SQLException {
        String nome = nome_cliente.getText();
        String sobrenome = sobrenome_cliente.getText();
        int idade = Integer.parseInt(idade_cliente.getText());
        String cpf = cpf_cliente.getText();
        String endereco = endereco_cliente.getText();
        String sexo = cliente_sexo.getText();
        Cliente cliente = new Cliente();
        cliente.setNome(nome);
        cliente.setSobrenome(sobrenome);
        cliente.setIdade(idade);
        cliente.setCpf(cpf);
        cliente.setEndereco(endereco);
        cliente.setSexo(sexo);
        cliente.setVenda_id(venda_id);
        new ClienteDAO().inserir(cliente);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
    public void setVenda_id(int venda_id) {
        this.venda_id = venda_id;
    }
}
