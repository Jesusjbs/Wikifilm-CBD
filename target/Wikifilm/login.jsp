<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style_createList.css">
<title>Iniciar Sesión</title>
</head>
<body>
	<header>
		<jsp:include page="header.jsp" />  
	</header>
	
	<div id="id_div">
		<form id="listForm" action="UserController" method="post">
			<input size=30 id="id_title" type="text" placeholder="Inserte usuario" name="user" required/>
			<input size=30 id="id_title" type="password" placeholder="Inserte contraseña" name="pass" required/>			
			<button id="id_Btn" title="Iniciar Sesión"
				type="submit">Iniciar Sesión</button>
		</form>
	</div>
	<div id="id_divMensaje">
		<p style="font-size:large;">${requestScope.mensaje}</p>
	</div>
</body>
</html>