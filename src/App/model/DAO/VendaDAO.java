package App.model.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import com.mysql.cj.jdbc.Driver;

import App.model.Produto;
import App.model.Venda;
import core.app.AppDAO;

public class VendaDAO extends AppDAO {
 
    private AppDAO appDAO;
    public VendaDAO(){
        this.appDAO = new AppDAO();
    }
    public int buscarIdVenda(String codigoVenda) throws SQLException {
        this.appDAO.OpenDataBase();
        String sql = "SELECT * FROM venda WHERE codigo = '"+ codigoVenda +"'";
        Connection conexao = appDAO.getConexao();
        PreparedStatement pStatement = conexao.prepareStatement(sql);
        ResultSet result = pStatement.executeQuery();
        if (result.next()) {
            return result.getInt("id");
        } else {
            return -1;
        }
    }
    public int inserir(Date dataCriacao, String status, String codigo) throws SQLException{
        this.appDAO.OpenDataBase();
        String sql = "INSERT INTO venda (data_criacao, status, codigo) VALUES (?,?,?)";
        Connection conexao = appDAO.getConexao();
        PreparedStatement pStatement = conexao.prepareStatement(sql);
        pStatement.setDate(1, dataCriacao);
        pStatement.setString(2, status);
        pStatement.setString(3, codigo);
        pStatement.execute();
        this.appDAO.closeDataBase();
        return 1;
    }
}
