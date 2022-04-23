<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style_list.css">
<title>Listas</title>
</head>
<body>
	<header>
		<jsp:include page="header.jsp" />  
	</header>

	<h1>Mis Listas</h1>
	
	<c:forEach items="${requestScope.lista}" var="list">
		<div id="id_div">
			<form id="id_formDatos" action="ListIDController" method="post">	
				<input type="hidden" name="nameEdit" value="${list.name}"/>
				<button name="listBtn" id="id_listBtn" value="${list.id}" type="submit">${list.name}
					<c:if test="${list.description != ''}">
						<p>${list.description}</p>
					</c:if>
					<c:if test="${list.description == ''}">
						<p>Sin descripción</p>
					</c:if>
				</button>
			</form>
			<form id="id_formE" action="ListIDController" method="post">
			<input type="hidden" name="nameEdit" value="${list.name}"/>
			<input type="hidden" name="descriptionEdit" value="${list.description}"/>

				<button name="editBtn" id="id_editBtn" value="${list.id}" type="submit">
					<img style="width:50px;height:50px" src="./img/edit_list.png" alt="Editar Lista"
							title="Editar Lista" />
				</button>
			</form>
			<form id="id_formD" action="ListIDController" method="post">
				<button name="deleteBtn" id="id_deleteBtn" value="${list.id}" type="submit">
					<img style="width:50px;height:50px" src="./img/delete_list.png" alt="Eliminar Lista"
							title="Eliminar Lista" />
				</button>
			</form>		
		</div>
	</c:forEach>
	
	<div id="id_divAdd">
		<a id="id_addBtn" href="/createList.jsp">
			<img style="width:50px;height:50px" src="./img/add_list.png" alt="Crear Lista"
				title="Crear Lista" />
		</a>
	</div>
</body>
</html>