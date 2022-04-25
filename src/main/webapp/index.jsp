<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style_index.css">
<link rel="stylesheet"
	href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css">
<title>Wikifilm</title>
<link rel="shortcut icon" href="./img/Icono.png">
</head>

<body>
	<header>
		<a href="index.jsp"><img title="Wikifilm" id="id_logo"
			alt="Logo.png" src="./img/Logo.png" /></a>
		<div id="id_sesion">
			<c:if test="${sessionScope.username != null}">
				<ul class="w3-navbar w3-card-2 w3-light-grey">
					<li class="dropdown"><p style="cursor: pointer;">${sessionScope.username}
							<i class="fa fa-caret-down"></i>
						</p>
						<div class="dropdown-content">
							<form id="listForm" action="ListController" method="post">
								<button style="cursor: pointer; margin-top: 0.5rem;margin-bottom: 0.5rem;" title="Ver mis listas"
									type="submit" id='listBtn'>Mis Listas</button>
							</form>
							<form id="logoutForm" action="UserController" method="post">
								<button
									style="border: none; padding: 0; background: none; cursor: pointer;"
									type="submit" value="Cerrar Sesión">Cerrar Sesión</button>
								<input type="hidden" name="logout" value="logout" checked />
							</form>
						</div></li>
				</ul>
			</c:if>
			<c:if test="${sessionScope.username == null}">
				<a href="/login.jsp">
					<button class="loginButton" type="submit">Iniciar Sesión</button>
				</a>
			</c:if>
		</div>
	</header>
	<div id="id_divMain">
		<form id="searchForm" action="SearchController" method="post">
			<div id="id_divSearch">
				<input id="id_search" size=50 type="text" name="searchQuery"
					placeholder="Busca tu película/serie" required />
				<button id="id_bt" type="submit" value="">
					<img id="id_imgSearch" src="./img/searchButton.png" />
				</button>
			</div>
			<br />
			<div id="id_tipos">
				<input type="radio" id="id_3" name="mediaQuery" value="" checked />
				<label for="id_3">Todo</label> <input type="radio" id="id_1"
					name="mediaQuery" value="movie" /> <label for="id_1">Películas</label>
				<input type="radio" id="id_2" name="mediaQuery" value="serie" /> <label
					for="id_2">Series</label>
			</div>
			<br />
			<div id="id_divSearchBtn">
				<input id="id_searchBtn" type="submit" name="searchBtn"
					value="Buscar">
			</div>
		</form>
	</div>
	<div>
		<form id="populateForm" action="DBController" method="post">
			<button id="id_searchBtn" type="submit" name="populateBtn">Popular
				BD</button>
		</form>
	</div>
	<br />
	<footer id="id_footer">
		<a href="acerca.html">Acerca</a>
	</footer>
</body>
</html>
