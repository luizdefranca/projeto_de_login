<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
Bem vindo ao nosso gerenciador de empresas!<br/>
<form action="FazTudo?tarefa=NovaEmpresa" method="POST">
	Nome:<input type="text" name="nome">
	<button type="submit">Nova Empresa</button>
</form>
<form action="login" method="POST">
	Email: <input type="text" name="email"> </br>
	Senha: <input type="password" name="senha"> </br>
	<button type="submit">Enviar</button>
</form>
<form action="FazTudo?tarefa=Logout" method="POST">
	<button type="submit">Logout</button>
	
</form>

<c:if test="${not empty usuarioLogado}">
    Você está logado como ${usuarioLogado.email}<br/>
</c:if>
</body>
</html>