package App.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import App.model.Cliente;
import App.model.ItemVenda;
import App.model.Produto;
import core.app.AppDAO;

public class ClienteDAO extends AppDAO {

    private AppDAO appDAO;

    public ClienteDAO() {
        this.appDAO = new AppDAO();
    }

    public int inserir(Cliente cliente) throws SQLException {
        this.appDAO.OpenDataBase();
        String sql = "INSERT INTO cliente (nome, sobrenome, cpf, endereco, idade, venda_id, sexo) VALUES(?,?,?,?,?,?,?)";
        Connection conexao = appDAO.getConexao();
        PreparedStatement pStatement = conexao.prepareStatement(sql);
        pStatement.setString(1, cliente.getNome());
        pStatement.setString(2, cliente.getSobrenome());
        pStatement.setString(3, cliente.getCpf());
        pStatement.setString(4, cliente.getEndereco());
        pStatement.setInt(5, cliente.getIdade());
        pStatement.setInt(6, cliente.getVenda_id());
        pStatement.setString(7, cliente.getSexo());
        pStatement.execute();
        return 1;
    }

    public List<Cliente> buscar(int venda_id) throws SQLException {
        this.appDAO.OpenDataBase();
        String sql = "SELECT * FROM cliente WHERE venda_id= " + venda_id;
        List<Cliente> clientes = new ArrayList<Cliente>();
        Connection conexao = appDAO.getConexao();
        PreparedStatement pStatement = conexao.prepareStatement(sql);
        ResultSet result = pStatement.executeQuery();
        while (result.next()) {
            Cliente cliente = new Cliente();
            cliente.setId(result.getInt("id"));
            cliente.setCpf(result.getString("cpf"));
            cliente.setIdade(result.getInt("idade"));
            cliente.setEndereco(result.getString("endereco"));
            cliente.setNome(result.getString("nome"));
            cliente.setSobrenome(result.getString("sobrenome"));
            cliente.setVenda_id(result.getInt("venda_id"));
            cliente.setSexo(result.getString("sexo"));
            clientes.add(cliente);
        }
        return clientes;
    }

    public Cliente buscarId(int venda_id) throws SQLException {
        this.appDAO.OpenDataBase();
        String sql = "SELECT * FROM cliente WHERE venda_id= " + venda_id;
        Connection conexao = appDAO.getConexao();
        PreparedStatement pStatement = conexao.prepareStatement(sql);
        ResultSet result = pStatement.executeQuery();
        Cliente cliente = new Cliente();
        if (result.next()) {
            cliente.setId(result.getInt("id"));
            cliente.setCpf(result.getString("cpf"));
            cliente.setIdade(result.getInt("idade"));
            cliente.setEndereco(result.getString("endereco"));
            cliente.setNome(result.getString("nome"));
            cliente.setSobrenome(result.getString("sobrenome"));
            cliente.setVenda_id(result.getInt("venda_id"));
            cliente.setSexo(result.getString("sexo"));
            return cliente;
        }
        return cliente;
    }
}
