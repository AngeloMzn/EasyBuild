package App.model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import com.mysql.cj.jdbc.Driver;

import App.model.ItemVenda;
import App.model.Produto;
import core.app.AppDAO;

public class ItemVendaDAO extends AppDAO {

    private AppDAO appDAO;

    public ItemVendaDAO() {
        this.appDAO = new AppDAO();
    }

    public List<ItemVenda> buscar(int produto_id, String descricao, String marca, String preco, int id_venda) throws SQLException {
        this.appDAO.OpenDataBase();
        String sql = "SELECT * FROM item_venda WHERE  venda_id = " + id_venda;
        if (produto_id > 0) {
            sql += " AND produto_id = " + produto_id;
        }
        if (descricao != null && !descricao.isEmpty()) {
            sql += " AND descricao LIKE '%" + descricao + "%'";
        }
        if (marca != null && !marca.isEmpty()) {
            sql += " AND marca LIKE '%" + marca + "%'";
        }
        if (preco != null && !preco.isEmpty()) {
            sql += " AND preco = '" + preco + "'";
        }
        List<ItemVenda> itensVenda = new ArrayList<ItemVenda>();
        Connection conexao = appDAO.getConexao();
        PreparedStatement pStatement = conexao.prepareStatement(sql);
        ResultSet result = pStatement.executeQuery();
        while (result.next()) {
            ItemVenda itemVenda = new ItemVenda();
            itemVenda.setId(result.getInt("id"));
            itemVenda.setProduto_id(result.getInt("produto_id"));
            itemVenda.setDescricao(result.getString("descricao"));
            itemVenda.setMarca(result.getString("marca"));
            itemVenda.setQuantidade(result.getInt("quantidade"));
            itemVenda.setPreco(result.getString("preco"));
            itensVenda.add(itemVenda);
        }
        return itensVenda;
    }

    public int inserir(ItemVenda itemVenda) throws SQLException {
        this.appDAO.OpenDataBase();
        String sql = "INSERT INTO item_venda (venda_id, produto_id, quantidade, descricao, marca,preco) VALUES(?,?,?,?,?,?)";
        Connection conexao = appDAO.getConexao();
        PreparedStatement pStatement = conexao.prepareStatement(sql);
        pStatement.setInt(1, itemVenda.getVenda_id());
        pStatement.setInt(2, itemVenda.getProduto_id());
        pStatement.setInt(3, itemVenda.getQuantidade());
        pStatement.setString(4, itemVenda.getDescricao());
        pStatement.setString(5, itemVenda.getMarca());
        pStatement.setString(6, itemVenda.getPreco());
        pStatement.execute();
        return 1;
    }

    public int delete(int id) throws SQLException {
        this.appDAO.OpenDataBase();
        String sql = "DELETE FROM item_venda WHERE id = " + id;
        Connection conexao = appDAO.getConexao();
        PreparedStatement pStatement = conexao.prepareStatement(sql);
        pStatement.execute();
        return 1;
    }

    public List<ItemVenda> getItensVenda(int venda_id) throws SQLException {
        this.appDAO.OpenDataBase();
        String sql = "SELECT * FROM item_venda WHERE venda_id = " + venda_id;
        List<ItemVenda> itensVenda = new ArrayList<ItemVenda>();
        Connection conexao = appDAO.getConexao();
        PreparedStatement pStatement = conexao.prepareStatement(sql);
        ResultSet result = pStatement.executeQuery();
        while (result.next()) {
            ItemVenda itemVenda = new ItemVenda();
            itemVenda.setId(result.getInt("id"));
            itemVenda.setDescricao(result.getString("descricao"));
            itemVenda.setMarca(result.getString("marca"));
            itemVenda.setQuantidade(result.getInt("quantidade"));
            itemVenda.setPreco(result.getString("preco"));
            itemVenda.setVenda_id(result.getInt("venda_id"));
            itemVenda.setProduto_id(result.getInt("produto_id"));
            itensVenda.add(itemVenda);
        }
        return itensVenda;
    }
    public float calculaTotal(int venda_id) throws SQLException {
        this.appDAO.OpenDataBase();
        String sql = "SELECT SUM(quantidade * CAST(REPLACE(preco, ',', '.') AS DECIMAL(10, 2)) ) as total FROM item_venda WHERE venda_id = ?";
        Connection conexao = appDAO.getConexao();
        PreparedStatement pStatement = conexao.prepareStatement(sql);
        pStatement.setInt(1, venda_id);
        ResultSet result = pStatement.executeQuery();
        float total = 0.00f; 
        if (result.next()) { 
            total = result.getFloat("total"); 
        }
        return total;
    }
    
}
