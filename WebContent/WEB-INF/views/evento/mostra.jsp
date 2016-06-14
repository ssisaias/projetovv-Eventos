<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Alterar Evento</title>
</head>
<body>

	<h3>Alterar Evento</h3>

	<form action="alteraEvento" method="get">
		Filme:
		<select name="filmeId">
			<c:forEach items="${filmes}" var="filme">				
				<option value="${filme.idFilme}" ${evento.filme.nomeFilme eq filme.nomeFilme ?'selected':''} >${filme.nomeFilme}</option>
			</c:forEach>
		</select>
		<br />
		Sala: 
		<select name="salaId">
			<c:forEach items="${salas}" var="sala">				
				<option value="${sala.idSala}" ${evento.sala.idSala eq sala.idSala ? 'selected':'' }>Sala ${sala.idSala}</option>
			</c:forEach>
		</select>
		<br />
		Data: <input type="text" name="dataEvento" value="<fmt:formatDate value="${evento.dataEvento}" pattern="dd/MM/yyyy HH:mm"/>" />
		<br /> 
		<input type="hidden" name="id" value="${evento.id}" />
		<input type="submit" value="Alterar" />
	</form>

</body>
</html>