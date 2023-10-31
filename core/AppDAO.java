package core;

import java.sql.*;

public class AppDAO {
    public static String url = "jdbc:mysql://localhost:3306/easybuild";
    public static String user = "root";
    public static String pwd = "12345";

    public Connection conexao = null;
    private Statement statement = null;

    public void OpenDataBase() {
        try {
            conexao = DriverManager.getConnection(url, user, pwd);
            System.out.println("conectado com sucesso em: " + url);
            statement = conexao.createStatement();
        } catch (Exception Error) {
            System.out.println("Erro de conexao: " + Error.getMessage());
        }
    }
    
    public void closeDataBase() throws SQLException{
        statement.close();
        conexao.close();
    }

    public Connection getConexao() {
        return conexao;
    }
    
}
