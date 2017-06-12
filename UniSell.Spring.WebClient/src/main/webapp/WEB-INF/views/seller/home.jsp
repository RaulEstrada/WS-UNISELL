<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>UniSell: Comprador</title>
		<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap-theme.min.css"/>"/>
		<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap.min.css"/>"/>
		<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/font-awesome.min.css"/>"/>
		<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/custom.css"/>"/>
	
		<script src="<c:url value="/resources/js/jquery-3.1.1.min.js" />"></script>
		<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
	</head>
	<body>
		<nav class="navbar navbar-default">
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
						data-target="#nav-unisell" aria-expanded="false">
						<span class="sr-only">Toggle Navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>	
					</button>
					<a class="navbar-brand a-logo" href="/unisell/">
						<img src="<c:url value="/resources/img/logo.png"/>"
							alt="Logo"/>
					</a>
				</div>
				<div class="collapse navbar-collapse" id="nav-unisell">
					<ul class="nav navbar-nav navbar-right">
						<li><a href="">Bienvenido, ${authCredentials.username}</a></li>
						<li><a href="/logout" class="btn btn-default">Salir</a></li>
					</ul>
				</div>
			</div>
		</nav>
		<main class="container-fluid">
			<div class="jumbotron">
				<div class="row">
					<h1>Tus productos</h1>
					<div class="row">
						<table class="table table-striped table-bordered">
							<thead>
								<tr>
									<td>Id</td>
									<td>Nombre</td>
									<td>Descripción</td>
									<td>Precio</td>
									<td>Unidades</td>
									<td>Categoría</td>
									<td></td>
									<td></td>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${products}" var="product">
									<tr>
										<td><c:out value="${product.id}"/></td>
										<td><c:out value="${product.name}"/></td>
										<td><c:out value="${product.description}"/></td>
										<td><c:out value="${product.price}"/></td>
										<td><c:out value="${product.units}"/></td>
										<td><c:out value="${product.category}"/></td>
										<td class="text-center">
											<a href="" class="btn btn-default">Editar</a>
										</td>
										<td class="text-center">
											<a href="" class="btn btn-danger">Eliminar</a>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<div class="row">
						<a href="" class="btn btn-lg btn-primary">Crear nuevo</a>
					</div>
				</div>
			</div>
		</main>
	</body>
</html>