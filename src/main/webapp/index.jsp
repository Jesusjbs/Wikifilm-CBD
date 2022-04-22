<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style_index.css">
<title>Wikifilm</title>
<link rel="shortcut icon" href="./img/Icono.png">
</head>

<body>
	<header>
		<a href="index.jsp"><img title="Wikifilm" id="id_logo" alt="Logo.png" src="./img/Logo.png" /></a>
	</header> 
	<div id="id_divMain">
		<form id="searchForm" action="SearchController" method="post">
			<div id="id_divSearch">
				<input id="id_search" size=50 type="text" name="searchQuery" placeholder="Busca tu película/serie" required />
				<input type="hidden" name="pageQuery" value="1" />	
				<button id="id_bt" type="submit" value="">
					<img id="id_imgSearch" src="./img/searchButton.png" />
				</button>
			</div>
			<br />
			<div id="id_tipos">
				<input type="radio" id="id_3" name="searchType" value="" checked />
				<label for="id_3">Todo</label> 
				<input type="radio" id="id_1" name="searchType" value="movie" /> 
				<label for="id_1">Películas</label>
				<input type="radio" id="id_2" name="searchType" value="serie" /> 
				<label for="id_2">Series</label>
			</div>
			<br />
			<div id="id_divSearchBtn">
				<input id="id_searchBtn" type="submit" name="searchBtn" value="Buscar">
			</div>
		</form>
	</div>
	<div>
		<form id="populateForm" action="DBController" method="post">
			<button id="id_searchBtn" type="submit" name="populateBtn">Popular BD</button>
		</form>
	</div>
	<br />
	<footer id="id_footer">
		<a href="acerca.html">Acerca</a>
	</footer>
</body>
</html>
