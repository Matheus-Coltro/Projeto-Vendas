
package br.com.projetovenda.model;


public class Usuario {

    private Integer idu;
    private String nomeu;
    private String email;
    private String senha;
    
        public Usuario (){
        
    }
        
        public Usuario(Integer idu, String nomeu, String email, String senha) {
        this.idu = idu;
        this.nomeu = nomeu;
        this.email = email;
        this.senha = senha;
    }
    
    public Integer getIdu() {
        return idu;
    }

    public void setIdu(Integer idu) {
        this.idu = idu;
    }

    public String getNomeu() {
        return nomeu;
    }

    public void setNomeu(String nomeu) {
        this.nomeu = nomeu;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }


}
