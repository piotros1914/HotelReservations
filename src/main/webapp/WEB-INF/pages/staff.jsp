<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page language="Java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
</head>
<body style="background-color:#808080">
	<div class="container" style="background-color:white;  border-radius: 5px; margin-top: 20px; margin-bottom: 20px">
		
		
			<section class="content" >
				<div class="col-md-10 col-md-offset-1">
					<div class="row" style="padding-top:50px">	
						<div class="pull-right">
							<a href="<%=request.getContextPath() %>/logout" class="btn btn-default btn-sm" role="button">Wyloguj się</a>				
						</div>
					</div>
					<div class="row">
						<h1 style="padding-bottom:50px">Strona dla pracowników!</h1>
					</div>
				</div>
			</section>
	</div>

</body>
</html>