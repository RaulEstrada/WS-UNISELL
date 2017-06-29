<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>UniSell: Producto</title>
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
					<h1>Detalle de producto</h1>
					<div class="row">
						<c:if test="${okMessage}">
							<div class="alert alert-success">
 								Producto guardado con éxito
							</div>
						</c:if>
						<c:if test="${error}">
							<div class="alert alert-danger">
 								${errorMsg}
							</div>
						</c:if>
						<form enctype="multipart/form-data" method="post">
							<div class="form-group">
							    <label for="Name">Nombre: </label>
							    <input type="text" id="Name" name="Name" class="form-control" required
							    	value="${product.name}"/>
							 </div>
						 	<div class="form-group">
						    	<label for="Description">Descripción: </label>
						    	<input type="text" id="Description" name="Description" class="form-control" required
						    		value="${ product.description }"/>
						 	</div>
						 	<div class="form-group">
						    	<label for="Price">Precio: </label>
						    	<input type="number" id="Price" name="Price" class="form-control" required
						    		min="0.01" step="0.01"
						    		value="${ product.price }"/>
						 	</div>
						 	<div class="form-group">
						    	<label for="Units">Unidades: </label>
						    	<input type="number" id="Units" name="Units" class="form-control" required
						    		min="1" step="1"
						    		value="${ product.units }"/>
						 	</div>
						 	<div class="form-group">
						 		<label for="Category">Categoría: </label>
						 		<select id="Category" name="Category" required class="form-control">
						 			<c:forEach items="${categories}" var="category">
						 				<c:if test="${category.id == product.category}">
						 					<option value="${category.id}" selected="selected">
							 					<c:out value="${category.name}"></c:out>
							 				</option>
						 				</c:if>
						 				<c:if test="${category.id != product.category}">
						 					<option value="${category.id}">
							 					<c:out value="${category.name}"></c:out>
							 				</option>
						 				</c:if>
						 			</c:forEach>
						 		</select>
						 	</div>
						 	<div class="row">
						 		<div class="prod">
									<img src="data:image/jpg;base64, ${product.imageBase64}"/>
								</div>
						 	</div>
							<div class="form-group">
						    	<label for="Image">Imagen: </label>
						    	<c:if test="${not empty newProduct}">
						    		<input type="file" id="Image" name="Image" required="required"/>
						    	</c:if>
						    	<c:if test="${empty newProduct}">
						    		<input type="file" id="Image" name="Image"/>
						    	</c:if>
						 	</div>
						 	<button type="submit" class="btn btn-primary">Enviar</button>
						 	<button type="reset" class="btn btn-warning">Limpiar</button>
						</form>
					</div>
				</div>
			</div>
		</main>
	</body>
</html>