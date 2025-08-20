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
        <title>Lista de Usuários</title>
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
      <a><li>Lista de Usuários  ✔</li></a>
      <a href="ListarCliente"><li>Lista de Clientes</li></a>
      <a href="ListarProduto"><li>Lista de Produtos</li></a>
      </ul>
  </div>
</nav>
        
        <center>
        <h1>Lista de Usuários </h1>
        
        <table border="1">
            
            <tr> 
                <td>ID</td>
                <td>Nome</td> 
                <td>Email</td> 
                <td>Senha</td>  
                <td></td>
                <td></td>
            </tr>
            <c:forEach items="${usuarios}" var="usuario">
            <tr> 
                <td>${usuario.idu}</td>
                <td>${usuario.nomeu}</td> 
                <td>${usuario.email}</td> 
                <td>${usuario.senha}</td> 
                <td>
                    <a class="two" href=#openModal>Excluir</a>
                    <div id="openModal" class="modalDialog">
                        <div>
                        <center>
                            <h2>Você tem certeza que deseja excluir o usuário selecionado?</h2>
                        <a class="three" href="ExcluirUsuario?idu=${usuario.idu}">Sim</a>
                        <a class="two" href="#close">Não</a>
                        </center>
                        </div>
                </td>
                <td>
                    <a class="four" href="CarregarUsuario?idu=${usuario.idu}">Alterar</a>
                </td>
            </tr>    
            </c:forEach>  
            
        </table>
        <br>
        </center>
    </body>
</html>
