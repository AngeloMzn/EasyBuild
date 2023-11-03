package App.model;
public class Cliente{
    private int id;
    private String nome;
    private String sobrenome;
    private int idade;
    private String endereco;
    private String cpf;
    private int venda_id;
    private String sexo;
    public Cliente(String nome, String sobrenome, int idade, String endereco, String cpf, int venda_id, String sexo) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.idade = idade;
        this.endereco = endereco;
        this.cpf = cpf;
        this.venda_id = venda_id;
        this.sexo = sexo;
    }
    public Cliente() {
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getSobrenome() {
        return sobrenome;
    }
    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public int getVenda_id() {
        return venda_id;
    }
    public void setVenda_id(int venda_id) {
        this.venda_id = venda_id;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getSexo() {
        return sexo;
    }
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
}
