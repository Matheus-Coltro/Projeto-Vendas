package br.com.projetovenda.dao;

import br.com.projetovenda.model.Produto;
import br.com.projetovenda.util.ConnectionFactory;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import java.util.Set;
public class ProdutoDAO implements GenericDAO{
    
//atributos
    private Connection conexão;
    private ResultSet rs;
    private PreparedStatement stmt;
    
    //construtor
    public ProdutoDAO() throws Exception{
        conexão = ConnectionFactory.conectar();
    }
    
    @Override
    public Boolean cadastrar(Object object) throws Exception {
       try{
           //procedimento para cadastrar no banco
           Produto oProduto = (Produto) object;
           
           String sql = "insert into produto (nome, marca, valor)" + "values (?,?,?)";
           
           stmt = this.conexão.prepareStatement(sql);
           
           stmt.setString(1, oProduto.getNome());
           stmt.setString(2, oProduto.getMarca());
           stmt.setDouble(3, oProduto.getValor());
           
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
            String sql = "select * from produto";
            stmt = this.conexão.prepareStatement(sql);
            rs = stmt.executeQuery();
            while(rs.next()){
                Produto produto = new Produto();
                produto.setCodigo(rs.getInt("codigo"));
                produto.setNome(rs.getString("nome"));
                produto.setMarca(rs.getString("marca"));
                produto.setValor(rs.getDouble("valor"));
                lista.add(produto);
            }   
        }catch(Exception e){
            System.out.println("Erro ao listar produtoDAO "+ e.getMessage());
        }
        return lista;
    }

    @Override
    public Boolean alterar(Object object) throws Exception {
        
        try{
           Produto oProduto = (Produto) object;
           
           String sql = "update produto set nome = ?, " +  "marca = ?, valor = ? where codigo = ? ";
           
           stmt = this.conexão.prepareStatement(sql);
           
           stmt.setString(1, oProduto.getNome());
           stmt.setString(2, oProduto.getMarca());
           stmt.setDouble(3, oProduto.getValor());
           stmt.setInt(4, oProduto.getCodigo());
           
           stmt.execute();
           
           return true;
           
       }catch (Exception e){
           
           System.out.println("Erro ao alterar produto" + e.getMessage()); 
           return false;
       }finally{
           ConnectionFactory.fecharConexao(conexão,rs,stmt);
       }
    }
        
    

    @Override
    public Boolean excluir(Object object) throws Exception {
        try{
            Produto produto = (Produto) object;
            String sql = "delete from produto where codigo = ?";
            stmt = this.conexão.prepareStatement(sql);
            stmt.setInt(1, produto.getCodigo());
            stmt.execute();
            return true;
            
        }catch(Exception e){
            System.out.println("Erro ao excluir produtoDAO "+ e.getMessage());
            return false;
        }
    }

    @Override
    public Object carregar(Integer id) throws Exception {
        
        Produto produto = new Produto();
        try{
            String sql = "select * from produto where codigo = ?";
            stmt = this.conexão.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            rs.next();
                produto.setCodigo(rs.getInt("codigo"));
                produto.setNome(rs.getString("nome"));
                produto.setMarca(rs.getString("marca"));
                produto.setValor(rs.getDouble("valor"));
               
        }catch(Exception e){
            System.out.println("Erro ao alterar produtoDAO "+ e.getMessage());
        }
        return produto;    
    }
    
}
