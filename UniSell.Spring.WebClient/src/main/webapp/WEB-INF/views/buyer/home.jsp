<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>UniSell: Comprador</title>
		<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap-theme.min.css"/>"/>
		<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap.min.css"/>"/>
		<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/font-awesome.min.css"/>"/>
		<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/jquery-ui.min.css"/>"/>
		<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/custom.css"/>"/>
	
		<script src="<c:url value="/resources/js/jquery-3.1.1.min.js" />"></script>
		<script src="<c:url value="/resources/js/jquery-ui.min.js" />"></script>
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
					<a class="navbar-brand a-logo" href="/unisell/home">
						<img src="<c:url value="/resources/img/logo.png"/>"
							alt="Logo"/>
					</a>
				</div>
				<div class="collapse navbar-collapse" id="nav-unisell">
					<ul class="nav navbar-nav navbar-right">
						<li><a href="">Bienvenido, ${authCredentials.username}</a></li>
						<li><a href="/unisell/logout" class="btn btn-default">Salir</a></li>
					</ul>
				</div>
			</div>
		</nav>
		<main class="container-fluid">
			<div class="jumbotron">
				<div class="row">
					<h1>Cat�logo de productos</h1>
					<div class="row">
						<form:form commandName="productFilter" method="get">
							<div class="form-group">
							    <label for="Name">Nombre: </label>
							    <form:input type="text" cssClass="form-control" 
	    							id="Name" path="name"/>
							 </div>
							 <div class="form-group">
							    <label for="Description">Description: </label>
							    <form:input type="text" cssClass="form-control" 
	    							id="Description" path="description"/>
							 </div>
							 <div class="form-group">
							    <label for="PriceFrom">Precio desde: </label>
							    <form:input type="number" cssClass="form-control" 
	    							id="PriceFrom" path="priceFrom"/>
							 </div>
							 <div class="form-group">
							    <label for="PriceTo">Precio hasta: </label>
							   <form:input type="number" cssClass="form-control" 
	    							id="PriceTo" path="priceTo"/>
							 </div>
							 <div class="form-group">
						 		<label for="Category">Categor�a: </label>
						 		<form:select path="category" cssClass="form-control">
								    <form:option value="${null}"></form:option>
								    <form:options items="${categories}" itemLabel="name" itemValue="name" ></form:options>
								</form:select>
							</div>
							<button type="submit" class="btn btn-primary">Filtrar</button>
						 	<button type="reset" class="btn btn-warning">Limpiar</button>
						</form:form>
					</div>
					<div class="row">
						<table class="table table-striped table-bordered">
							<thead>
								<tr>
									<td>Nombre</td>
									<td>Descripci�n</td>
									<td>Precio</td>
									<td>Categor�a</td>
									<td></td>
									<td></td>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${products}" var="product">
									<tr>
										<td><c:out value="${product.name}"/></td>
										<td><c:out value="${product.description}"/></td>
										<td><c:out value="${product.price}"/></td>
										<td><c:out value="${product.category}"/></td>
										<td class="text-center">
											<c:if test="${not empty product.imageBase64}">
												<div class="prod">
													<img src="data:image/jpg;base64, ${product.imageBase64}"/>
												</div>
											</c:if>
										</td>
										<td class="text-center">
											<button id="${product.id}" class="btn btn-primary">A�adir al carro</button>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</main>
	</body>
</html>