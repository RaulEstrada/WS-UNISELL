<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>UniSell: Cuenta de usuario</title>
		<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap-theme.min.css"/>"/>
		<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap.min.css"/>"/>
		<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/font-awesome.min.css"/>"/>
		<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/jquery-ui.min.css"/>"/>
		<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/custom.css"/>"/>
	
		<script src="<c:url value="/resources/js/jquery-3.1.1.min.js" />"></script>
		<script src="<c:url value="/resources/js/jquery-ui.min.js" />"></script>
		<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
		<script>
  			$(function(){
    			$("#dialog").dialog({
      				autoOpen: false
    			});
			    $("#opener").on("click", function(e) {
			      	$("#dialog").dialog("open");
			    });
  			});
  		</script>
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
					<c:if test="${empty userProfile}">
						<a class="navbar-brand a-logo" href="/unisell/">
							<img src="<c:url value="/resources/img/logo.png"/>"
								alt="Logo"/>
						</a>
					</c:if>
					<c:if test="${userProfile}">
						<a class="navbar-brand a-logo" href="/unisell/home">
							<img src="<c:url value="/resources/img/logo.png"/>"
								alt="Logo"/>
						</a>
					</c:if>
				</div>
			</div>
		</nav>
		<main class="container-fluid">
			<div class="jumbotron">
				<div class="row">
					<h1>Datos de usuario</h1>
					<div class="row">
						<c:if test="${okMessage}">
							<div class="alert alert-success">
 								Cuenta de usuario guardada con éxito
							</div>
						</c:if>
						<c:if test="${error}">
							<div class="alert alert-danger">
 								${errorMsg}
							</div>
						</c:if>
						<form:form commandName="userData">
							<div class="form-group">
							    <label for="Name">Nombre: </label>
							    <form:input type="text" cssClass="form-control" 
	    							id="Name" required="required"
	    							path="name"/>
							 </div>
						 	<div class="form-group">
						    	<label for="Surname">Apellidos: </label>
						    	<form:input type="text" cssClass="form-control" 
	    							id="Surname" required="required"
	    							path="surname"/>
						 	</div>
						 	<div class="form-group">
						    	<label for="Email">Email: </label>
						    	<form:input type="email" cssClass="form-control" 
	    							id="Email" required="required"
	    							path="email"/>
						 	</div>
						 	<div class="form-group">
						    	<label for="Document">Documento de identidad: </label>
						    	<form:input type="text" cssClass="form-control" 
	    							id="Document" required="required"
	    							path="document"/>
						 	</div>
						 	<div class="form-group">
						 		<label for="documentType">Tipo de documento: </label>
						 		<form:select path="documentType"
								    		items="${documentTypes}" cssClass="form-control"></form:select>
						 	</div>
						 	<div class="form-group">
						    	<label for="Username">Usuario: </label>
						    	<c:if test="${empty userProfile}">
							    	<form:input type="text" cssClass="form-control" 
		    							id="Username" required="required"
		    							path="username"/>
		    					</c:if>
		    					<c:if test="${userProfile}">
							    	<form:input type="text" cssClass="form-control" 
		    							id="Username" required="required" readonly="true"
		    							path="username"/>
		    					</c:if>
						 	</div>
						 	<div class="form-group">
						    	<label for="Password">Contraseña: </label>
						    	<c:if test="${empty userProfile}">
							    	<form:input type="password" cssClass="form-control" 
		    							id="Password" required="required"
		    							path="password"/>
		    					</c:if>
		    					<c:if test="${userProfile}">
							    	<form:input type="password" cssClass="form-control" 
		    							id="Password"
		    							path="password"/>
		    					</c:if>
						 	</div>
						 	<button type="submit" class="btn btn-primary">Enviar</button>
						 	<button type="reset" class="btn btn-warning">Limpiar</button>
						</form:form>
						<c:if test="${userProfile}">
							<a id="opener" class="btn btn-danger">Borrar cuenta</a>
						</c:if>
						<div id="dialog" title="Confirmar borrado">
						  <p>Está a punto de eliminar su cuenta de usuario. Esta acción no se podrá deshacer. ¿Desea continuar?</p>
						  <a href="/unisell/removeUser" class="btn btn-danger">Borrar</a>
						</div>
					</div>
				</div>
			</div>
		</main>
	</body>
</html>