<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Eventos</title>
</head>
<body>

	<table style="width: 775px; height: 10px" border="1">
		<tr>
			<th>ID</th>
			<th>FILME</th>
			<th>SALA</th>
			<th>DATA</th>
			<th>APAGAR</th>
			<th>ALTERAR</th>
		</tr>
		<c:forEach items="${eventos}" var="evento">
			<tr>
				<td>${evento.id}</td>
				<td>${evento.filme.nomeFilme}</td>
				<td>${evento.sala.idSala}</td>
				<td><fmt:formatDate value="${evento.dataEvento}"
						pattern="dd/MM/yyyy HH:mm" /></td>
				<td><a href="apagaEvento?id=${evento.id}">Apagar</a></td>
				<td><a href="mostraEvento?id=${evento.id}">Alterar</a></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>