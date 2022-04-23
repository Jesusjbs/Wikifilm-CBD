<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link rel="stylesheet" type="text/css" href="./css/style_header.css">
<meta charset="UTF-8">
<div id="id_superior">
	<a href="index.jsp"><img id="id_logo" title="Wikifilm"
		alt="Logo.png" src="./img/Logo.png" /></a>
	<c:if test="${sessionScope.username != null}">
		<p>${sessionScope.username}a</p>
	</c:if>
	<c:if test="${sessionScope.username == null}">
		<a href="/login.jsp">
			<button class="btn btn-default" type="submit">Iniciar Sesión</button>
		</a>
	</c:if>
	<form id="searchForm" action="SearchController" method="post">
		<div id="id_divSearch">
			<input id="id_search" size=50 type="text" name="searchQuery"
				placeholder="Buscar" required />
			<button id="id_bt" type="submit" value="">
				<img id="id_imgSearch" src="./img/searchButton.png" />
			</button>
		</div>
		<input type="hidden" id="id_3" name="mediaQuery" value="" checked />
	</form>
	<c:if test="${sessionScope.username != null}">
		<form id="listForm" action="ListController" method="post">
			<button title="Ver mis listas" type="submit" id='listBtn'>
				<img id="listIMG" src="./img/list.png" alt="Mis Listas"
					title="Mis Listas" />
			</button>
		</form>
	</c:if>
</div>