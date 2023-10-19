package model;
public class produto {
    private int id;
    private String descrição;
    private boolean emEstoque;
    private int quantidade;
    private String marca;
    private boolean validade;
    public produto(int id, String descrição, boolean emEstoque, int quantidade, String marca, boolean validade) {
        this.id = id;
        this.descrição = descrição;
        this.emEstoque = emEstoque;
        this.quantidade = quantidade;
        this.marca = marca;
        this.validade = validade;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getDescrição() {
        return descrição;
    }
    public void setDescrição(String descrição) {
        this.descrição = descrição;
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
    public boolean isValidade() {
        return validade;
    }
    public void setValidade(boolean validade) {
        this.validade = validade;
    }
}
