
package br.com.projetovenda.model;


public class Cliente {

    private Integer id;
    private String nomec;
    private String cpf;
    private String telefone;
    
        public Cliente (){
        
    }
        
        public Cliente(Integer id, String nomec, String cpf, String telefone) {
        this.id = id;
        this.nomec = nomec;
        this.cpf = cpf;
        this.telefone = telefone;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomec() {
        return nomec;
    }

    public void setNomec(String nomec) {
        this.nomec = nomec;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }


}
