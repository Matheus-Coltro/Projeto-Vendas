<%-- 
    Document   : lista-produto
    Created on : 18 de out de 2022, 22:05:07
    Author     : Aluno
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Produtos</title>
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
      <a href="ListarCliente"><li>Lista de Clientes</li></a>
      <a><li>Lista de Produtos  ✔</li></a>
      </ul>
  </div>
</nav>
        
        <center>
        <h1>Lista de Produtos</h1>
        
        <table border="1">
            
            <tr> 
                <td>ID</td> 
                <td>Nome</td> 
                <td>Marca</td> 
                <td>Valor</td>
                <td></td>
                <td></td>
            </tr>
            
            <c:forEach items="${produtos}" var="produto">
            <tr> 
                <td>${produto.codigo}</td> 
                <td>${produto.nome}</td> 
                <td>${produto.marca}</td> 
                <td>${produto.valor}</td>
                <td>
                <a class="two" href=#openModal>Excluir</a>
                    <div id="openModal" class="modalDialog">
                        <div>
                        <center>
                            <h2>Você tem certeza que deseja excluir o produto selecionado?</h2>
                        <a class="three" href="ExcluirProduto?codigo=${produto.codigo}">Sim</a>
                        <a class="two" href="#close">Não</a>
                        </center>
                        </div>
                </td>
                <td>
                    <a class="four" href="CarregarProduto?codigo=${produto.codigo}">Alterar</a>
                </td>
            </tr>    
            </c:forEach>  
            
        </table>
                <br>
        </center>
    </body>
</html>
