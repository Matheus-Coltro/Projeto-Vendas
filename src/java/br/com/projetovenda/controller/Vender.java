package br.com.projetovenda.controller;


import br.com.projetovenda.model.Venda;
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
@WebServlet(urlPatterns = {"/Vender"})
public class Vender extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
   
        String produto = request.getParameter("produto");
        String marca = request.getParameter("marca");
        Integer quantidade = Integer.parseInt(request.getParameter("quantidade"));
        Double valorunitario = Double.parseDouble(request.getParameter("valorunitario"));
        Double desconto = Double.parseDouble(request.getParameter("desconto"));
        //Double valortotal = Double.parseDouble(request.getParameter("valortotal"));
        
        Venda objVenda = new Venda();
        
       // objVenda.setProduto(produto);
       // objVenda.setMarca(marca);        
        objVenda.setQuantidade(quantidade);
        objVenda.setDesconto(desconto);
        objVenda.setValorunitario(valorunitario);
        //objVenda.setValortotal(valortotal);
        
        objVenda.setValortotal((objVenda.getQuantidade() * objVenda.getValorunitario()) - objVenda.getDesconto());
        
        request.setAttribute("resultado", objVenda.getValortotal());
        
        request.getRequestDispatcher("resultado.jsp").forward(request, response);
        
        
        
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
