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
        String sql = "SELECT * FROM produtos WHERE";
        if (id > 0) {
            sql += " id = " + id;
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

    
}
