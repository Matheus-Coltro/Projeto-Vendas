package br.com.projetovenda.model;

public class Produto {
    
    private Integer codigo;
    private String nome;
    private String marca;
    private Double valor;
    
    // construtores

    public Produto() {
    }

    public Produto(Integer codigo, String nome, String marca, Double valor) {
        this.codigo = codigo;
        this.nome = nome;
        this.marca = marca;
        this.valor = valor;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
    
    
}
