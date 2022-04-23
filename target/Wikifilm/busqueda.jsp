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
		<jsp:include page="header.jsp" />  
	</header>
	<fieldset id="tmdb">
		<p>Se han encontrado ${requestScope.resultados} resultados de la búsqueda "<c:out value="${param.searchQuery}" />":</p>
		<c:forEach items="${requestScope.movies}" var="movie">			
			<form id="tituloForm" action="TitleController" method="post">
				<input value='${movie.id}' name='titleQuery' type='hidden' /> 
				<input value='${movie.title}' name='trailerQuery' type='hidden' /> 
				<input value='${movie.released}' name='yearTrailerQuery' type='hidden' /> 
				<input value='movie' name='mediaQuery' type='hidden' /> 
				<input value='${param.searchType}' name='tipoQuery' type='hidden' />
				<button title="${movie.title}" type="submit" id='titleBtn'>
					<img alt='poster.png' onerror="this.src='./img/Poster.png'" src='https://image.tmdb.org/t/p/w185${movie.profilePath}' /><br />
					<p>${movie.title}</p>
				</button>
				<br />
				<c:if test="${movie.released != ''}">
				<p id="id_sub">${movie.released}</p>
				</c:if>
				<c:if test="${movie.released == ''}">
				<p id="id_sub">(N/A)</p>
				</c:if>
				<br /> <br />
			</form>
		</c:forEach>
		<c:forEach items="${requestScope.series}" var="serie">			
			<form id="tituloForm" action="TitleController" method="post">
				<input value='${serie.id}' name='titleQuery' type='hidden' /> 
				<input value='${serie.title}' name='trailerQuery' type='hidden' /> 
				<input value='${serie.released}' name='yearTrailerQuery' type='hidden' /> 
				<input value='serie' name='mediaQuery' type='hidden' /> 
				<input value='${param.searchType}' name='tipoQuery' type='hidden' />
				<button title="${serie.title}" type="submit" id='titleBtn'>
					<img alt='poster.png' onerror="this.src='./img/Poster.png'" src='https://image.tmdb.org/t/p/w185${serie.profilePath}' /><br />
					<p>${serie.title}</p>
				</button>
				<br />
				<c:if test="${serie.released != ''}">
				<p id="id_sub">${serie.released}</p>
				</c:if>
				<c:if test="${serie.released == ''}">
				<p id="id_sub">(N/A)</p>
				</c:if>
				<br /> <br />
			</form>
		</c:forEach>
	</fieldset>
</body>
</html>