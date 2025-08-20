package br.com.projetovenda.model;


public class Venda {
    
    private String produto;
    private String marca;
    private Integer quantidade;
    private Double valorunitario;
    private Double desconto;
    private Double valortotal;
    
    public Venda (){ 
    }

    public Venda(String produto, String marca, Integer quantidade, Double valorunitario, Double desconto, Double valortotal) {
        this.produto = produto;
        this.marca = marca;
        this.quantidade = quantidade;
        this.valorunitario = valorunitario;
        this.desconto = desconto;
        this.valortotal = valortotal;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getValorunitario() {
        return valorunitario;
    }

    public void setValorunitario(Double valorunitario) {
        this.valorunitario = valorunitario;
    }

    public Double getDesconto() {
        return desconto;
    }

    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }

    public Double getValortotal() {
        return valortotal;
    }

    public void setValortotal(Double valortotal) {
        this.valortotal = valortotal;
    }
   
}
