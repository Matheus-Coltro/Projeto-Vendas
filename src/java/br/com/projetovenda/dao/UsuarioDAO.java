package br.com.projetovenda.dao;


import br.com.projetovenda.model.Usuario;
import br.com.projetovenda.util.ConnectionFactory;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;

public class UsuarioDAO implements GenericDAO{
    
//atributos
    private Connection conexão;
    private ResultSet rs;
    private PreparedStatement stmt;
    
    //construtor
    public UsuarioDAO() throws Exception{
        conexão = ConnectionFactory.conectar();
    }
    
    @Override
    public Boolean cadastrar(Object object) throws Exception {
       try{
           //procedimento para cadastrar no banco
           Usuario oUsuario = (Usuario) object;
           
           String sql = "insert into usuario (nomeu, email, senha)" + "values (?,?,?)";
           
           stmt = this.conexão.prepareStatement(sql);
           
           stmt.setString(1, oUsuario.getNomeu());
           stmt.setString(2, oUsuario.getEmail());
           stmt.setString(3, oUsuario.getSenha());
           
           stmt.execute();
                      
           return true;
           
       }catch (Exception e){
           
           System.out.println("Erro ao cadastrar usuario" + e.getMessage()); 
           return false;
       }finally{
           ConnectionFactory.fecharConexao(conexão,rs,stmt);
       }
    }

    @Override
    public List<Object> listar() throws Exception {
        
        List<Object> lista = new ArrayList<>();
        try{
            String sql = "select * from usuario";
            stmt = this.conexão.prepareStatement(sql);
            rs = stmt.executeQuery();
            while(rs.next()){
                Usuario usuario = new Usuario();
                usuario.setIdu(rs.getInt("idu"));
                usuario.setNomeu(rs.getString("nomeu"));
                usuario.setEmail(rs.getString("email"));
                usuario.setSenha(rs.getString("senha"));
                lista.add(usuario);
            }   
        }catch(Exception e){
            System.out.println("Erro ao listar usuarioDAO "+ e.getMessage());
        }
        return lista;    
    }

    @Override
    public Boolean alterar(Object object) throws Exception {
try{
           Usuario oUsuario = (Usuario) object;
           
           String sql = "update usuario set nomeu = ?, " +  "email = ?, senha = ? where idu = ? ";
           
           stmt = this.conexão.prepareStatement(sql);
           
           stmt.setString(1, oUsuario.getNomeu());
           stmt.setString(2, oUsuario.getEmail());
           stmt.setString(3, oUsuario.getSenha());
           stmt.setInt(4, oUsuario.getIdu());
           
           stmt.execute();
           
           return true;
           
       }catch (Exception e){
           
           System.out.println("Erro ao alterar usuario" + e.getMessage()); 
           return false;
       }finally{
           ConnectionFactory.fecharConexao(conexão,rs,stmt);
       }
        }

    @Override
    public Boolean excluir(Object object) throws Exception {
        try{
            Usuario usuario = (Usuario) object;
            String sql = "delete from usuario where idu = ?";
            stmt = this.conexão.prepareStatement(sql);
            stmt.setInt(1, usuario.getIdu());
            stmt.execute();
            return true;
            
        }catch(Exception e){
            System.out.println("Erro ao excluir usuarioDAO "+ e.getMessage());
            return false;
        }   
    }

    @Override
    public Object carregar(Integer id) throws Exception {
    Usuario usuario = new Usuario();
        try{
            String sql = "select * from usuario where idu = ?";
            stmt = this.conexão.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            rs.next();
                usuario.setIdu(rs.getInt("idu"));
                usuario.setNomeu(rs.getString("nomeu"));
                usuario.setEmail(rs.getString("email"));
                usuario.setSenha(rs.getString("senha"));
               
        }catch(Exception e){
            System.out.println("Erro ao alterar usuarioDAO "+ e.getMessage());
        }
        return usuario;    
    }
    
            public Boolean logar(String email, String senha) throws Exception{
                
        try{
            String sql = "select * from usuario " + "where email = ? and senha = ?";
            stmt = this.conexão.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, senha);
            
            rs = stmt.executeQuery();

            return rs.next();
               
        }catch(Exception e){
            System.out.println("Erro ao logarDAO "+ e.getMessage());
         return false;
        }
            }
}
    

