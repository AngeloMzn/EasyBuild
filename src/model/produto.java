package model;
public class Produto {
    private int id;
    private String descricao;
    private boolean emEstoque;
    private int quantidade;
    private String marca;
    private String validade;
    private String preco;
    public Produto(int id, String descricao, boolean emEstoque, int quantidade, String marca, String validade) {
        this.id = id;
        this.descricao = descricao;
        this.emEstoque = emEstoque;
        this.quantidade = quantidade;
        this.marca = marca;
        this.validade = validade;
    }
    public Produto() {
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public boolean isEmEstoque() {
        return emEstoque;
    }
    public void setEmEstoque(boolean emEstoque) {
        this.emEstoque = emEstoque;
    }
    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getValidade() {
        return validade;
    }
    public void setValidade(String validade) {
        this.validade = validade;
    }
    public String getPreco() {
        return preco;
    }
    public void setPreco(String preco) {
        this.preco = preco;
    }

}
