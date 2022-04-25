<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link rel="stylesheet" type="text/css" href="./css/style_header.css">
<link rel="stylesheet"
	href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css">
<meta charset="UTF-8">
<div id="id_superior">
	<a href="index.jsp"><img id="id_logo" title="Wikifilm"
		alt="Logo.png" src="./img/Logo.png" /></a>
	<div id="id_sesion">
		<c:if test="${sessionScope.username != null}">
			<ul class="w3-navbar w3-card-2 w3-light-grey">
				<li class="dropdown"><p style="cursor: pointer;">${sessionScope.username}
						<i class="fa fa-caret-down"></i>
					</p>
					<div class="dropdown-content">
						<form id="logoutForm" action="UserController" method="post">
							<button
								style="border: none; padding: 0; background: none; cursor: pointer; margin-bottom: 1rem"
								type="submit" value="Cerrar Sesión">Cerrar Sesión</button>
							<input type="hidden" name="logout" value="logout" checked />
						</form>
						<form id="listForm" action="ListController" method="post">
							<button style="cursor: pointer;" title="Ver mis listas"
								type="submit" id='listBtn'>Mis Listas</button>
						</form>
					</div></li>
			</ul>
		</c:if>
		<c:if test="${sessionScope.username == null}">
			<a href="/login.jsp">
				<button class="loginButton" type="submit">Iniciar
					Sesión</button>
			</a>
		</c:if>
	</div>
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
</div>