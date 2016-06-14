<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Novo Evento</title>
</head>
<body>

	<h3>Adicionar novo Evento</h3>

	<form action="adicionaEvento" method="get">
		Filme:
		<select name="filmeId">
			<c:forEach items="${filmes}" var="filme">				
				<option value="${filme.idFilme}">${filme.nomeFilme}</option>
			</c:forEach>
		</select>
		<br />
		Sala: 
		<select name="salaId">
			<c:forEach items="${salas}" var="sala">				
				<option value="${sala.idSala}">Sala ${sala.idSala}</option>
			</c:forEach>
		</select>
		<br />
		Data do Evento: <input type="text" name="dataEvento" /> <br />
		<br /> <input type="submit" value="Adicionar" />
	</form>

</body>
</html>