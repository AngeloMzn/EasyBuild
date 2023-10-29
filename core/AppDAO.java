package core;

import java.sql.*;

public class AppDAO {
    public static String url = "jdbc:mysql://localhost:3306/easybuild";
    public static String user = "root";
    public static String pwd = "";

    private Connection conexao = null;
    private Statement statement = null;
    private ResultSet result = null;

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

    public void query(String sql){
        try {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
           System.out.println("Query executada com erro: " + e.getMessage());
        }
    }
}
