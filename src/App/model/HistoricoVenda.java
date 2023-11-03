package App.model;

import java.sql.Date;

public class HistoricoVenda {
    private int id;
    private Date data; 
    private int id_cliente;
    private int venda_id;
    private String valorTotal;
    private String metodoPagamento;
    public HistoricoVenda(Date data, int id_cliente, int venda_id, String valorTotal, String metodoPagamento, int id) {
        this.data = data;
        this.id_cliente = id_cliente;
        this.venda_id = venda_id;
        this.valorTotal = valorTotal;
        this.metodoPagamento = metodoPagamento;
        this.id = id;
    }
    public HistoricoVenda() {
    }
    public Date getData() {
        return data;
    }
    public void setData(Date data) {
        this.data = data;
    }
    public int getId_cliente() {
        return id_cliente;
    }
    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }
    public int getVenda_id() {
        return venda_id;
    }
    public void setVenda_id(int venda_id) {
        this.venda_id = venda_id;
    }
    public String getValorTotal() {
        return valorTotal;
    }
    public void setValorTotal(String valorTotal) {
        this.valorTotal = valorTotal;
    }
    public String getMetodoPagamento() {
        return metodoPagamento;
    }
    public void setMetodoPagamento(String metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    
}
