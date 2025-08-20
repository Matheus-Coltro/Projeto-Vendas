package br.com.projetovenda.dao;

import br.com.projetovenda.model.Cliente;
import br.com.projetovenda.model.Produto;
import br.com.projetovenda.util.ConnectionFactory;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;
public class ClienteDAO implements GenericDAO{
    
//atributos
    private Connection conexão;
    private ResultSet rs;
    private PreparedStatement stmt;
    
    //construtor
    public ClienteDAO() throws Exception{
        conexão = ConnectionFactory.conectar();
    }
    
    @Override
    public Boolean cadastrar(Object object) throws Exception {
       try{
           //procedimento para cadastrar no banco
           Cliente oCliente = (Cliente) object;
           
           String sql = "insert into cliente (nomec, cpf, telefone)" + "values (?,?,?)";
           
           stmt = this.conexão.prepareStatement(sql);
           
           stmt.setString(1, oCliente.getNomec());
           stmt.setString(2, oCliente.getCpf());
           stmt.setString(3, oCliente.getTelefone());
           
           stmt.execute();
                      
           return true;
           
       }catch (Exception e){
           
           System.out.println("Erro ao cadastrar produto" + e.getMessage()); 
           return false;
       }finally{
           ConnectionFactory.fecharConexao(conexão,rs,stmt);
       }
    }

    @Override
    public List<Object> listar() throws Exception {
        
        List<Object> lista = new ArrayList<>();
        try{
            String sql = "select * from cliente";
            stmt = this.conexão.prepareStatement(sql);
            rs = stmt.executeQuery();
            while(rs.next()){
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNomec(rs.getString("nomec"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setTelefone(rs.getString("telefone"));
                lista.add(cliente);
            }   
        }catch(Exception e){
            System.out.println("Erro ao listar clienteDAO "+ e.getMessage());
        }
        return lista;    
    }

    @Override
    public Boolean alterar(Object object) throws Exception {
try{
           Cliente oCliente = (Cliente) object;
           
           String sql = "update cliente set nomec = ?, " +  "cpf = ?, telefone = ? where id = ? ";
           
           stmt = this.conexão.prepareStatement(sql);
           
           stmt.setString(1, oCliente.getNomec());
           stmt.setString(2, oCliente.getCpf());
           stmt.setString(3, oCliente.getTelefone());
           stmt.setInt(4, oCliente.getId());
           
           stmt.execute();
           
           return true;
           
       }catch (Exception e){
           
           System.out.println("Erro ao alterar cliente" + e.getMessage()); 
           return false;
       }finally{
           ConnectionFactory.fecharConexao(conexão,rs,stmt);
       }
    }    

    @Override
    public Boolean excluir(Object object) throws Exception {
        try{
            Cliente cliente = (Cliente) object;
            String sql = "delete from cliente where id = ?";
            stmt = this.conexão.prepareStatement(sql);
            stmt.setInt(1, cliente.getId());
            stmt.execute();
            return true;
            
        }catch(Exception e){
            System.out.println("Erro ao excluir clienteDAO "+ e.getMessage());
            return false;
        }   
    }

    @Override
    public Object carregar(Integer id) throws Exception {
        
    Cliente cliente = new Cliente();
        try{
            String sql = "select * from cliente where id = ?";
            stmt = this.conexão.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            rs.next();
                cliente.setId(rs.getInt("id"));
                cliente.setNomec(rs.getString("nomec"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setTelefone(rs.getString("telefone"));
               
        }catch(Exception e){
            System.out.println("Erro ao alterar clienteDAO "+ e.getMessage());
        }
        return cliente;    
    }
    
}
