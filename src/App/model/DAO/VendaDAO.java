package App.model.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import com.mysql.cj.jdbc.Driver;

import App.model.Produto;
import App.model.Venda;
import core.app.AppDAO;

public class VendaDAO extends AppDAO {

    private AppDAO appDAO;

    public VendaDAO() {
        this.appDAO = new AppDAO();
    }

    public int buscarIdVenda(String codigoVenda) throws SQLException {
        this.appDAO.OpenDataBase();
        String sql = "SELECT * FROM venda WHERE codigo = '" + codigoVenda + "'";
        Connection conexao = appDAO.getConexao();
        PreparedStatement pStatement = conexao.prepareStatement(sql);
        ResultSet result = pStatement.executeQuery();
        if (result.next()) {
            return result.getInt("id");
        } else {
            return -1;
        }
    }

    public Venda buscarVenda(int id_venda) throws SQLException {
        this.appDAO.OpenDataBase();
        String sql = "SELECT * FROM venda WHERE id = '" + id_venda + "'";
        Connection conexao = appDAO.getConexao();
        PreparedStatement pStatement = conexao.prepareStatement(sql);
        ResultSet result = pStatement.executeQuery();
        Venda venda = new Venda();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        if (result.next()) {
            venda.setId(result.getInt("id"));
            venda.setData(result.getDate("data_criacao"));
            venda.setCodigoVenda(result.getString("codigo"));
            venda.setStatus(result.getString("status"));
            return venda;
        } else {
            return venda;
        }
    }

    public int inserir(Date dataCriacao, String status, String codigo) throws SQLException {
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

    public void atualizar(Venda venda) throws SQLException, ParseException {
        this.appDAO.OpenDataBase();
        String sql = "UPDATE venda SET data_criacao = ?, status = ?, codigo = ? WHERE id = ?";
        Connection conexao = appDAO.getConexao();
        PreparedStatement pStatement = conexao.prepareStatement(sql);
        pStatement.setDate(1, venda.getData());
        pStatement.setString(2, venda.getStatus());
        pStatement.setString(3, venda.getCodigoVenda());
        pStatement.setInt(4, venda.getId());
        pStatement.executeUpdate();
        this.appDAO.closeDataBase();
    }

}
