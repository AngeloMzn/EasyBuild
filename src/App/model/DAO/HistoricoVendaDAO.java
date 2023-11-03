package App.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import App.model.Cliente;
import App.model.HistoricoVenda;
import core.app.AppDAO;

public class HistoricoVendaDAO extends AppDAO {
    private AppDAO appDAO;
    public HistoricoVendaDAO() {
        this.appDAO = new AppDAO();
    }
    public int inserir(HistoricoVenda historico) throws SQLException {
        this.appDAO.OpenDataBase();
        String sql = "INSERT INTO historico_venda ( id, id_cliente, venda_id, valorTotal, metodoPagamento, data) VALUES(?,?,?,?,?,?)";
        Connection conexao = appDAO.getConexao();
        PreparedStatement pStatement = conexao.prepareStatement(sql);
        pStatement.setInt(1, historico.getId());
        pStatement.setInt(2, historico.getId_cliente());
        pStatement.setInt(3, historico.getVenda_id());
        pStatement.setString(4, historico.getValorTotal());
        pStatement.setString(5, historico.getMetodoPagamento());
        pStatement.setDate(6, historico.getData());
        pStatement.execute();
        return 1;
    }
}
