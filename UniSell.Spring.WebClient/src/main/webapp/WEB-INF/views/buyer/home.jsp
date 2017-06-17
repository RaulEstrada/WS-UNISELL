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
						<li><a href="/unisell/profile" class="btn btn-default">Perfil</a></li>
						<li><a href="/unisell/logout" class="btn btn-default">Salir</a></li>
					</ul>
				</div>
			</div>
		</nav>
		<main class="container-fluid">
			<div class="jumbotron">
				<c:if test="${not empty orderNumber}">
					<div class="row">
						<div class="alert alert-success">
							Compra <c:out value="${orderNumber}"></c:out> creada con éxito
						</div>
					</div>
				</c:if>
				<c:if test="${not empty orderError}">
					<div class="row">
						<div class="alert alert-danger">
							Error en el proceso de compra: <c:out value="${orderError}"></c:out>
						</div>
					</div>
				</c:if>
				<div class="row">
					<h1>Catálogo de productos</h1>
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
						 		<label for="Category">Categoría: </label>
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
									<td>Descripción</td>
									<td>Precio</td>
									<td>Categoría</td>
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
											<a href="/unisell/additem/${product.id}" class="btn btn-primary">Añadir al carro</a>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
			<div class="jumbotron">
				<div class="row">
					<h1>Tu carrito de la compra</h1>
					<c:if test="${empty shoppingCart.items}">
						El carrito está vacío
					</c:if>
					<c:if test="${not empty shoppingCart.items}">
						<table class="table table-striped table-bordered">
							<thead>
								<tr>
									<td>Nombre</td>
									<td>Unidades</td>
									<td>Total</td>
									<td></td>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${shoppingCart.items}" var="item">
									<tr>
										<td><c:out value="${item.product.name}"/></td>
										<td><c:out value="${item.quantity}"/></td>
										<td><c:out value="${item.quantity * item.product.price}"/></td>
										<td class="text-center">
											<a href="/unisell/removeitem/${item.product.id}" class="btn btn-danger">Quitar del carro</a>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<form action="/unisell/checkout" method="get">
							<div class="form-group">
							    <label for="Username">Paypal Username: </label>
							    <input type="text" class="form-control" id="Username" required="required"
	    							name="Username"/>
							 </div>
							 <div class="form-group">
							    <label for="Password">Paypal Password: </label>
							    <input type="text" class="form-control" id="Password" required="required"
	    							name="Password"/>
							 </div>
							 <div class="form-group">
							    <label for="Signature">Paypal Signature: </label>
							    <input type="text" class="form-control" id="Signature" required="required"
	    							name="Signature"/>
							 </div>
							 <button type="submit" class="btn btn-primary">Enviar</button>
						 	<button type="reset" class="btn btn-warning">Limpiar</button>
						</form>
					</c:if>
				</div>
			</div>
		</main>
	</body>
</html>