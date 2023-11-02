package App.model;

public class Venda {
    private int id;
    private String data;
    private String status;
    private String codigoVenda;
    
    public String getStatus() {
        return status;
    }
    public String getCodigoVenda() {
        return codigoVenda;
    }
    public void setCodigoVenda(String codigoVenda) {
        this.codigoVenda = codigoVenda;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    
}
