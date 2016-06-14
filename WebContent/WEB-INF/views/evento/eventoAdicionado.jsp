
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Evento Adicionado</title>
</head>
<body>
	Evento adicionado com sucesso!
	<br /> Filme ${evento.filme.nomeFilme} na Sala	${evento.sala.idSala} em <fmt:formatDate value="${evento.dataEvento}" pattern="dd/MM/yyyy HH:mm"/> 
</body>
</html>