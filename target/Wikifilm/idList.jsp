<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style_idList.css">
<title>Lista "${requestScope.nombreLista}"</title>
</head>
<body>
	<header>
		<jsp:include page="header.jsp" />  
	</header>
	<h1>Mostrando la lista "${requestScope.nombreLista}" con ID ${requestScope.idLista}</h1>
	<fieldset id="tmdb">
		<c:forEach items="${requestScope.itemsMovies}" var="item">
			<form id="tituloForm" action="TitleController" method="post">
				<input value='${item.id}' name='titleQuery' type='hidden' /> 
				<input value='serie' name='mediaQuery' type='hidden' /> 
				<button title="${item.title}" type="submit" id='titleBtn'>
					<img alt='poster.png' onerror="this.src='./img/Poster.png'" src='https://image.tmdb.org/t/p/w185${item.profilePath}' /><br />
					<p>${item.title}</p>
				</button>
				<br />
				<c:if test="${item.released != ''}">
					<p id="id_sub">${item.released}</p>
				</c:if>
				<c:if test="${item.released == ''}">
					<p id="id_sub">(N/A)</p>
				</c:if>
				<br /> <br />
			</form>
		</c:forEach>
		<c:forEach items="${requestScope.itemsSeries}" var="item">
			<form id="tituloForm" action="TitleController" method="post">
				<input value='${item.id}' name='titleQuery' type='hidden' /> 
				<input value='serie' name='mediaQuery' type='hidden' /> 
				<button title="${item.title}" type="submit" id='titleBtn'>
					<img alt='poster.png' onerror="this.src='./img/Poster.png'" src='https://image.tmdb.org/t/p/w185${item.profilePath}' /><br />
					<p>${item.title}</p>
				</button>
				<br />
				<c:if test="${item.released != ''}">
					<p id="id_sub">${item.released}</p>
				</c:if>
				<c:if test="${item.released == ''}">
					<p id="id_sub">(N/A)</p>
				</c:if>
				<br /> <br />
			</form>
		</c:forEach>
		<form id="id_formList" action="/ListIDController" method="post">
			<input type="hidden" value="${requestScope.nombreLista}" name="nameEdit">
			<input type="hidden" value="${requestScope.idLista}" name="listBtn">
			<select id="id_lista" name="itemDelete" required>
				<option label="Eliminar de la lista"/>
					<c:forEach items="${requestScope.itemsMovies}" var="item">
							<option value="${item.id}" label="${item.title}"/>
					</c:forEach>
					<c:forEach items="${requestScope.itemsSeries}" var="item">
							<option value="${item.id}" label="${item.title}"/>
					</c:forEach>
			</select>
			<button id="id_anyadir" type="submit" name="añadir">Eliminar</button>
		</form>
	</fieldset>
</body>
</html>