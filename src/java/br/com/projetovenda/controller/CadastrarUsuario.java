/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package br.com.projetovenda.controller;

import br.com.projetovenda.dao.GenericDAO;
import br.com.projetovenda.dao.ProdutoDAO;
import br.com.projetovenda.dao.UsuarioDAO;
import br.com.projetovenda.model.Produto;
import br.com.projetovenda.model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Aluno
 */
@WebServlet(name = "CadastrarUsuario", urlPatterns = {"/CadastrarUsuario"})
public class CadastrarUsuario extends HttpServlet {

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
            String idu = request.getParameter("idu");
            String nomeu = request.getParameter("nomeu");
            String email = request.getParameter("email");
            String senha = request.getParameter("senha");
            
            Usuario oUsuario = new Usuario();
            oUsuario.setNomeu(nomeu);
            oUsuario.setEmail(email);
            oUsuario.setSenha(senha);
            
            GenericDAO oUsuarioDAO = new UsuarioDAO();
            
            String mensagem = "";
            
            if(idu.equals("")){
                if (oUsuarioDAO.cadastrar(oUsuario)){
                mensagem = "Usuario cadastrado com sucesso!";
            }else
                mensagem = "Erro ao cadastrar usuario!";
            }
            else{
                oUsuario.setIdu(Integer.parseInt(idu));
                
                if(oUsuarioDAO.alterar(oUsuario)){
                    mensagem = "Usuario alterado com sucesso!";
                    
                }else{
                    mensagem = "Erro ao alterar usuario!";
                }
           }
            
            request.setAttribute("mensagem", mensagem);
            
            request.getRequestDispatcher("cadastrar-usuario.jsp").forward(request, response);
            
            
        }catch(Exception e){
            System.out.println("Erro ao cadastrar Usuario " + e.getMessage());
            
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
