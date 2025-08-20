/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package br.com.projetovenda.controller;

import br.com.projetovenda.dao.ClienteDAO;
import br.com.projetovenda.dao.GenericDAO;
import br.com.projetovenda.model.Cliente;
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
@WebServlet(name = "CadastrarCliente", urlPatterns = {"/CadastrarCliente"})
public class CadastrarCliente extends HttpServlet {

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
            String id = request.getParameter("id");
            String nomec = request.getParameter("nomec");
            String cpf = request.getParameter("cpf");
            String telefone = request.getParameter("telefone");
            
            Cliente oCliente = new Cliente();
            oCliente.setNomec(nomec);
            oCliente.setCpf(cpf);
            oCliente.setTelefone(telefone);
            
            GenericDAO oClienteDAO = new ClienteDAO();
            
            String mensagem2 = "";
            
            if(id.equals("")){
                if (oClienteDAO.cadastrar(oCliente)){
                mensagem2 = "Cliente cadastrado com sucesso!";
            }else
                mensagem2 = "Erro ao cadastrar cliente!";
            }
            else{
                oCliente.setId(Integer.parseInt(id));
                
                if(oClienteDAO.alterar(oCliente)){
                    mensagem2 = "Cliente alterado com sucesso!";
                    
                }else{
                    mensagem2 = "Erro ao alterar cliente!";
                }
           }
            
            request.setAttribute("mensagem2", mensagem2);
            
            request.getRequestDispatcher("cadastrar-cliente.jsp").forward(request, response);
            
            
        }catch(Exception e){
            System.out.println("Erro ao cadastrar cliente " + e.getMessage());

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
