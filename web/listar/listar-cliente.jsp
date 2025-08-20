<%-- 
    Document   : listar-cliente
    Created on : 20 de out de 2022, 20:21:15
    Author     : Aluno
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Clientes</title>
        <link rel="stylesheet" href="pog.css">
    </head>
    <body>
        
        <nav role="navigation">
  <div id="menuToggle">
    <input type="checkbox" />
    <span></span>
    <span></span>
    <span></span>
    <ul id="menu">
      <a href="index.jsp"><li>Home</li></a>
      ━━━━━━━━━━━━━━━
      <a href="cadastrar-usuario.jsp"><li>Cadastrar Usuário</li></a>
      <a href="cadastrar-cliente.jsp"><li>Cadastrar Cliente</li></a>
      <a href="cadastrar-produto.jsp"><li>Cadastrar Produto</li></a>
      ━━━━━━━━━━━━━━━
      <a href="ListarUsuario"><li>Lista de Usuários </li></a>
      <a><li>Lista de Clientes  ✔</li></a>
      <a href="ListarProduto"><li>Lista de Produtos</li></a>
      </ul>
  </div>
</nav>
        
        <center>
        <h1>Lista de Clientes </h1>
        
        <table border="1">
            
            <tr> 
                <td>ID</td>
                <td>Nome</td> 
                <td>CPF</td> 
                <td>Telefone</td>  
                <td></td>
                <td></td>
            </tr>
            
            <c:forEach items="${clientes}" var="cliente">
            <tr> 
                <td>${cliente.id}</td>
                <td>${cliente.nomec}</td> 
                <td>${cliente.cpf}</td> 
                <td>${cliente.telefone}</td> 
                <td>
                   <a class="two" href=#openModal>Excluir</a>
                    <div id="openModal" class="modalDialog">
                        <div>
                        <center>
                            <h2>Você tem certeza que deseja excluir o cliente selecionado?</h2>
                        <a class="three" href="ExcluirCliente?id=${cliente.id}">Sim</a>
                        <a class="two" href="#close">Não</a>
                        </center>
                        </div>
                </td>
                <td>
                    <a class="four" href="CarregarCliente?id=${cliente.id}">Alterar</a>
                </td>
            </tr>    
            </c:forEach>  
            
        </table>
        <br>
        </center>
    </body>
</html>
