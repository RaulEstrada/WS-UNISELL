<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>UniSell: Acceso</title>
		<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap-theme.min.css"/>"/>
		<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap.min.css"/>"/>
		<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/font-awesome.min.css"/>"/>
		<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/custom.css"/>"/>
	
		<script src="<c:url value="/resources/js/jquery-3.1.1.min.js" />"></script>
		<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
	</head>
	<body>
		<main class="container-fluid">
			<div class="jumbotron">
				<div class="row">
					<h1>Acceso al portal</h1>
				</div>
				<div class="row">
					<c:if test="${okMessage}">
						<div class="alert alert-success">
								Cuenta de usuario guardada con éxito
						</div>
					</c:if>
				</div>
				<div class="row">
					<section class="col-sm-12 col-md-6">
						<h2><i class="fa fa-sign-in" aria-hidden="true"></i> Login</h2>
						<form:form commandName="authentication">
							<c:if test="${not empty error}">
								<div class="alert alert-danger">
  									<strong>Credenciales de acceso incorrectas. Por favor, inténtelo de nuevo</strong>
								</div>
							</c:if>
							<div class="form-group">
								<label for="usernameInput">Nombre de usuario</label>
	    						<form:input type="text" cssClass="form-control" 
	    							id="usernameInput" required="required"
	    							path="username"/>
							</div>
							<div class="form-group">
								<label for="passwordInput">Contraseña</label>
	    						<form:input type="password" cssClass="form-control" 
	    							id="passwordInput" required="required"
	    							path="password"/>
							</div>
							<div class="text-left">
								<button type="submit" class="btn btn-primary btn-lg">Enviar</button>
								<button type="reset" class="btn btn-danger">Limpiar</button>
							</div>
						</form:form>
					</section>
					<section class="col-sm-12 col-md-6">
						<h2><i class="fa fa-user-plus" aria-hidden="true"></i> Registro</h2>
						<div class="col-sm-10 col-sm-offset-1">
							<p>Regístrate de forma gratuita como comprador. Para crear una cuenta de vendedor o 
							registrar tu empresa, contacta con el administrador.</p>
							<a href="/unisell/registration" class="btn btn-lg btn-primary">Registro</a>
						</div>
					</section>
				</div>
			</div>
		</main>
	</body>
</html>