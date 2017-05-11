<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isELIgnored="false"%>
<%@ page language="Java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	response.setCharacterEncoding("UTF-8");
	request.setCharacterEncoding("UTF-8");
%>

<!doctype html>
<html lang="pl-PL">
<head>
<meta charset="UTF-8">
<title>Nasze pokoje</title>
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.css" />
</head>
<body style="background-color: #808080">
	<div class="container"
		style="background-color: white; border-radius: 5px; margin-top: 20px; margin-bottom: 20px">
		<section class="content">
			<div class="col-md-10 col-md-offset-1">
				<div class="row">
					<h1 style="padding-bottom: 50px">Logowanie!</h1>
					<div class="panel panel-default">
						<div class="panel-body">
							<c:url var="loginUrl" value="/login" />
							<form:form modelAttribute="reservationForm" method="POST"
								class="form-horizontal" servletRelativeAction="${loginUrl}">
								<c:if test="${param.error != null}">
									<div class="alert alert-danger">
										<p>Invalid username and password.</p>
									</div>
								</c:if>
								<c:if test="${param.logout != null}">
									<div class="alert alert-success">
										<p>You have been logged out successfully.</p>
									</div>
								</c:if>
								<div class="input-group input-sm">
									<label class="input-group-addon" for="username"><i
										class="fa fa-user"></i></label> <input type="text"
										class="form-control" id="username" name="ssoId"
										placeholder="Login" required>
								</div>
								<div class="input-group input-sm">
									<label class="input-group-addon" for="password"><i
										class="fa fa-lock"></i></label> <input type="password"
										class="form-control" id="password" name="password"
										placeholder="Hasło" required>
								</div>
								<input type="hidden" name="${_csrf.parameterName}"
									value="${_csrf.token}" />

								<div class="form-actions">
									<input type="submit"
										class="btn btn-block btn-primary btn-default" value="Zaloguj">
								</div>
							</form:form>
						</div>
					</div>
				</div>
			</div>
		</section>
	</div>
</body>
</html>














