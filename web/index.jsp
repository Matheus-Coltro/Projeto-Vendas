<%-- 
    Document   : index
    Created on : 1 de set de 2022, 20:06:52
    Author     : Aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu Principal</title>
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
      <a href="index.jsp"><li>Home  ✔</li></a>
      ━━━━━━━━━━━━━━━
      <a href="cadastrar-usuario.jsp"><li>Cadastrar Usuário</li></a>
      <a href="cadastrar-cliente.jsp"><li>Cadastrar Cliente</li></a>
      <a href="cadastrar-produto.jsp"><li>Cadastrar Produto</li></a>
      ━━━━━━━━━━━━━━━
      <a href="ListarUsuario"><li>Lista de Usuários</li></a>
      <a href="ListarCliente"><li>Lista de Clientes</li></a>
      <a href="ListarProduto"><li>Lista de Produtos</li></a>
      ━━━━━━━━━━━━━━━
      <br>      <a href="https://twitter.com/m4ths_" target="_blank">
            <img src="tt.png" alt="Twitter logo" height="40" width="40">
                </a>
                ‎ ‎ ‎ ‎ ‎ ‎ ‎ ‎ ‎ ‎ 
                <a href="https://www.instagram.com/maths.coltro/" target="_blank">
            <img class="espac" src="ins.png" alt="Instagram logo" height="40" width="40">
                </a>
                ‎ ‎ ‎ ‎ ‎ ‎ ‎ ‎ ‎ ‎ 
                <a href="https://www.twitch.tv/maths_vlr" target="_blank">
            <img src="twtv.png" alt="Twitch logo" height="40" width="40">
                </a>
      </ul>
  </div>
</nav>
        <center>
            <h1><u>MENU PRINCIPAL</u></h1>
        ${msg} <br> <br>
        
        <a href="cadastrar-usuario.jsp" class="btn mt-4" > Cadastrar Usuário</a>
        ━
        <a href="cadastrar-cliente.jsp" class="btn mt-4"> Cadastrar Cliente</a>
        ━
        <a href="cadastrar-produto.jsp" class="btn mt-4"> Cadastrar Produto</a> <br>
                
        <a href="ListarUsuario" class="btn mt-4">Lista de Usuários</a>
        ━
        <a href="ListarCliente" class="btn mt-4">Lista de Clientes</a>
        ━
        <a href="ListarProduto" class="btn mt-4">Lista de Produtos</a>
            
             <div class="header">
            <path fill="#FFFFFF" stroke="#000000" stroke-width="10" stroke-miterlimit="10" d="M57,283" />
            <g><path fill="#fff"
            d="M250.4,0.8C112.7,0.8,1,112.4,1,250.2c0,137.7,111.7,249.4,249.4,249.4c137.7,0,249.4-111.7,249.4-249.4
            C499.8,112.4,388.1,0.8,250.4,0.8z M383.8,326.3c-62,0-101.4-14.1-117.6-46.3c-17.1-34.1-2.3-75.4,13.2-104.1
            c-22.4,3-38.4,9.2-47.8,18.3c-11.2,10.9-13.6,26.7-16.3,45c-3.1,20.8-6.6,44.4-25.3,62.4c-19.8,19.1-51.6,26.9-100.2,24.6l1.8-39.7		c35.9,1.6,59.7-2.9,70.8-13.6c8.9-8.6,11.1-22.9,13.5-39.6c6.3-42,14.8-99.4,141.4-99.4h41L333,166c-12.6,16-45.4,68.2-31.2,96.2	c9.2,18.3,41.5,25.6,91.2,24.2l1.1,39.8C390.5,326.2,387.1,326.3,383.8,326.3z" />
            </g>
            </svg>
            <h1></h1>
            </div>
            <div>
            <svg class="waves" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink"
            viewBox="0 24 150 28" preserveAspectRatio="none" shape-rendering="auto">
            <defs>
            <path id="gentle-wave" d="M-160 44c30 0 58-18 88-18s 58 18 88 18 58-18 88-18 58 18 88 18 v44h-352z" />
            </defs>
            <g class="parallax">
            <use xlink:href="#gentle-wave" x="48" y="0" fill="rgba(255,255,255,0.7" />
            <use xlink:href="#gentle-wave" x="48" y="3" fill="rgba(255,255,255,0.5)" />
            <use xlink:href="#gentle-wave" x="48" y="5" fill="rgba(255,255,255,0.3)" />
            <use xlink:href="#gentle-wave" x="48" y="7" fill="#fff" />
            </g>
            </svg>
            </div>
        
        </center>
                       
    </body>
</html>
