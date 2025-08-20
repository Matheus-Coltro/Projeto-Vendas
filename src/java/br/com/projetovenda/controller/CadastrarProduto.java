/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package br.com.projetovenda.controller;

import br.com.projetovenda.dao.GenericDAO;
import br.com.projetovenda.dao.ProdutoDAO;
import br.com.projetovenda.model.Produto;
import java.io.IOException; 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Aluno
 */
@WebServlet(name = "CadastrarProduto", urlPatterns = {"/CadastrarProduto"})
public class CadastrarProduto extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            String codigo = request.getParameter("codigo");
            String nome = request.getParameter("nome");
            String marca = request.getParameter("marca");
            Double valor = Double.parseDouble(request.getParameter("valor"));
            
            Produto oProduto = new Produto();
            oProduto.setNome(nome);
            oProduto.setMarca(marca);
            oProduto.setValor(valor);
            
            GenericDAO oProdutoDAO = new ProdutoDAO();
            
            String mensagem = "";
            
            if(codigo.equals("")){
                if (oProdutoDAO.cadastrar(oProduto)){
                mensagem = "Produto cadastrado com sucesso!";
            }else
                mensagem = "Erro ao cadastrar produto!";
            }
            else{
                oProduto.setCodigo(Integer.parseInt(codigo));
                
                if(oProdutoDAO.alterar(oProduto)){
                    mensagem = "Produto alterado com sucesso!";
                    
                }else{
                    mensagem = "Erro ao alterar produto!";
                }
           }
            
            request.setAttribute("mensagem", mensagem);
            
            request.getRequestDispatcher("cadastrar-produto.jsp").forward(request, response);
            
            
        }catch(Exception e){
            System.out.println("Erro ao cadastrar produto " + e.getMessage());
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
