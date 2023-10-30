package model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import com.mysql.cj.jdbc.Driver;

import core.AppDAO;
import model.Produto;

public class ProdutoDAO {
 
    private AppDAO appDAO;
    public ProdutoDAO(){
        this.appDAO = new AppDAO();
    }
    public List<Produto> buscar(int id, String descricao, String marca) throws SQLException{
        this.appDAO.OpenDataBase();
        String sql = "SELECT * FROM produtos WHERE 1=1";
        if (id > 0) {
            sql += " AND id = " + id;
        }
        if (descricao != null && !descricao.isEmpty()) {
            sql += " AND descricao LIKE '%" + descricao + "%'";
        }
        if (marca != null && !marca.isEmpty()) {
            sql += " AND marca LIKE '%" + marca + "%'";
        }if (descricao.isEmpty() && marca.isEmpty() && id==0) {
            sql = "SELECT * FROM produtos";
        }
        List<Produto> produtos = new ArrayList<Produto>();
        Connection conexao = appDAO.getConexao();
        PreparedStatement pStatement = conexao.prepareStatement(sql);
        ResultSet result = pStatement.executeQuery();
       while (result.next()) {
            Produto produto = new Produto();
            produto.setId(result.getInt("id"));
            produto.setDescricao(result.getString("descricao"));
            produto.setMarca(result.getString("marca"));
            produto.setQuantidade(result.getInt("quantidade"));
            produto.setEmEstoque(result.getBoolean("em_estoque"));
            produto.setPreco(result.getString("preco"));
            produto.setValidade(result.getString("validade"));
            produtos.add(produto);
        }
        return produtos;
    }
    public List<Produto> getProdutos() throws SQLException{
        this.appDAO.OpenDataBase();
        String sql = "SELECT * FROM produtos";
        List<Produto> produtos = new ArrayList<Produto>();
        Connection conexao = appDAO.getConexao();
        PreparedStatement pStatement = conexao.prepareStatement(sql);
        ResultSet result = pStatement.executeQuery();
        while (result.next()) {
            Produto produto = new Produto();
            produto.setId(result.getInt("id"));
            produto.setDescricao(result.getString("descricao"));
            produto.setMarca(result.getString("marca"));
            produto.setQuantidade(result.getInt("quantidade"));
            produto.setEmEstoque(result.getBoolean("em_estoque"));
            produto.setPreco(result.getString("preco"));
            produto.setValidade(result.getString("validade"));
            produtos.add(produto);
        }
        return produtos;
    }
    public int inserir(String descricao, String marca, String validade, String preco, int quantidade) throws SQLException{
        this.appDAO.OpenDataBase();
        String sql = "INSERT INTO produtos (descricao, marca, validade, preco, quantidade, em_estoque) VALUES(?,?,?,?,?, 1)";
        Connection conexao = appDAO.getConexao();
        PreparedStatement pStatement = conexao.prepareStatement(sql);
        pStatement.setString(1, descricao);
        pStatement.setString(2, marca);
        pStatement.setString(3, validade);
        pStatement.setString(4, preco);
        pStatement.setInt(5, quantidade);
        pStatement.execute();
        return 1;
    }
    public int delete(int id) throws SQLException{
        this.appDAO.OpenDataBase();
        String sql = "DELETE FROM produtos WHERE id = " + id;
        Connection conexao = appDAO.getConexao();
        PreparedStatement pStatement = conexao.prepareStatement(sql);
        pStatement.execute();
        return 1; 
    }
    public int editar(String descricao, String marca, String validade, String preco, int quantidade) {
        this.appDAO.OpenDataBase();
        Connection conexao = appDAO.getConexao();
        try {
            String sql = "UPDATE produtos SET descricao = ?, marca = ?, validade = ?, preco = ?, quantidade = ? WHERE em_estoque = ?";
            PreparedStatement pStatement = conexao.prepareStatement(sql);
            pStatement.setString(1, descricao);
            pStatement.setString(2, marca);
            pStatement.setString(3, validade);
            pStatement.setString(4, preco);
            pStatement.setInt(5, quantidade);
            pStatement.setBoolean(6, true); 
            int rowsUpdated = pStatement.executeUpdate();
            return rowsUpdated; 
        } catch (SQLException e) {
            e.printStackTrace();
            return -1; 
        } 
    }
    
    
}
