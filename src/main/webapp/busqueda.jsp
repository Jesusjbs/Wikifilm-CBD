<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style_busqueda.css">
<title>Búsqueda</title>
</head>
<body>
	<header>
		<jsp:include page="header.html" />  
	</header>
	<fieldset id="tmdb">
		<p>Se han encontrado ${requestScope.resultados} resultados de la búsqueda "<c:out value="${param.searchQuery}" />":</p>
		<c:forEach items="${requestScope.movies}" var="movie">			
			<form id="tituloForm" action="TitleController" method="post">
				<input value='${movie.id}' name='titleQuery' type='hidden' /> 
				<input value='${movie.titulo}' name='trailerQuery' type='hidden' /> 
				<input value='${movie.fecha}' name='yearTrailerQuery' type='hidden' /> 
				<input value='${movie.mediaType}' name='mediaQuery' type='hidden' /> 
				<input value='${param.searchType}' name='tipoQuery' type='hidden' />
				<button title="${movie.titulo}" type="submit" id='titleBtn'>
					<img alt='poster.png' onerror="this.src='./img/Poster.png'" src='https://image.tmdb.org/t/p/w185${movie.posterPath}' /><br />
					<p>${movie.titulo}</p>
				</button>
				<br />
				<c:if test="${movie.fecha != ''}">
				<p id="id_sub">${movie.fecha}</p>
				</c:if>
				<c:if test="${movie.fecha == ''}">
				<p id="id_sub">(N/A)</p>
				</c:if>
				<br /> <br />
			</form>
		</c:forEach>
		<c:forEach items="${requestScope.series}" var="serie">			
			<form id="tituloForm" action="TitleController" method="post">
				<input value='${serie.id}' name='titleQuery' type='hidden' /> 
				<input value='${serie.titulo}' name='trailerQuery' type='hidden' /> 
				<input value='${serie.fecha}' name='yearTrailerQuery' type='hidden' /> 
				<input value='${serie.mediaType}' name='mediaQuery' type='hidden' /> 
				<input value='${param.searchType}' name='tipoQuery' type='hidden' />
				<button title="${serie.titulo}" type="submit" id='titleBtn'>
					<img alt='poster.png' onerror="this.src='./img/Poster.png'" src='https://image.tmdb.org/t/p/w185${serie.posterPath}' /><br />
					<p>${serie.titulo}</p>
				</button>
				<br />
				<c:if test="${serie.fecha != ''}">
				<p id="id_sub">${serie.fecha}</p>
				</c:if>
				<c:if test="${serie.fecha == ''}">
				<p id="id_sub">(N/A)</p>
				</c:if>
				<br /> <br />
			</form>
		</c:forEach>
	</fieldset>
</body>
</html>