package model;
public class Usuário {
    private int id;
    private String login;
    private String senha;
    private String dataCadastro;
    private String tipo;
    public Usuário(int id, String login, String senha, String dataCadastro, String tipo) {
        this.id = id;
        this.login = login;
        this.senha = senha;
        this.dataCadastro = dataCadastro;
        this.tipo = tipo;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public String getDataCadastro() {
        return dataCadastro;
    }
    public void setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
