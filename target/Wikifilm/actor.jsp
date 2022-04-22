<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style_actor.css">
<title>${requestScope.nombre}</title>
</head>
<body>
	<header><jsp:include page="header.html" /></header>
	<div id="id_foto">
	<img id="id_poster" alt='poster.png' onerror="this.src='./img/Poster.png'"
		src='https://image.tmdb.org/t/p/w185${requestScope.poster}' />
	</div>
	<div id="id_datos">
		<h1>${requestScope.nombre}</h1>
		<p><span>Fecha de Nacimiento:</span> ${requestScope.nacimiento}
			(${requestScope.edad} años)</p>
		<p><span>Lugar de Nacimiento:</span> ${requestScope.lugar}</p>
		<p><span>Fecha de Defunción:</span> ${requestScope.muerte}</p>
		<p><span>Género:</span> ${requestScope.genero}</p>
		<c:if test="${requestScope.biografia != ''}">
			<p><span>Biografía:</span> ${requestScope.biografia}</p>
		</c:if>
		<c:if test="${requestScope.biografia == ''}">
			<p><span>Biografía:</span> N/A</p>
		</c:if>
	</div>
</body>
</html>