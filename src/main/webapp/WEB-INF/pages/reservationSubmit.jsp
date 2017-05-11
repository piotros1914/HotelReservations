<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page language="Java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% response.setCharacterEncoding("UTF-8"); request.setCharacterEncoding("UTF-8"); %>

<!doctype html>
<html lang="pl-PL">
<head>
<meta charset="UTF-8">
<title>Potwierdzenie rezerwacji</title>
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
</head>

<body style="background-color: #808080">
	<div class="container"
		style="background-color: white; border-radius: 5px; margin-top: 20px; margin-bottom: 20px">
		<div class="row">
			<section class="content">
				<div class="col-md-10 col-md-offset-1" style="margin-top:50px; margin-bottom:50px">
				
				<h1>Potwierdzenie dokonania rezerwacji</h1>
				
				<p>
					<b>Data rezerwacji:</b> <br />
					Od: <fmt:formatDate pattern = "dd-MM-yyyy" value = "${reservationForm.fromDate}" />
					Do: <fmt:formatDate pattern = "dd-MM-yyyy" value = "${reservationForm.toDate}" />
				</p>
				<p>
					<b> Śniadanie:</b><br />	
					<c:forEach var="breakfastDate" items="${reservationForm.breakfastList}">
						<fmt:formatDate pattern = "dd-MM-yyyy, E" value = "${breakfastDate}" /><br />			
					</c:forEach>
				</p>
				
				<p>
					<b>Dane rezerwującego:</b> <br />
					${reservationForm.firstName}
					${reservationForm.lastName} <br />
					${reservationForm.address}, <br />
					${reservationForm.postalCode}
					${reservationForm.city} <br />
				</p>

				<p>
					<b>Kontakt:</b><br /> 
					email: ${reservationForm.email} <br />
					telefon: ${reservationForm.phone} <br />
				</p>

				<p>
					<b>Zarezerwowany pokój:</b> <br />
					<fmt:formatNumber type="number" maxFractionDigits="0" value="${room.sizeOfRoomInPersons}" /> - osobowy, <br />
					Piętro: <fmt:formatNumber type="number" maxFractionDigits="0" value="${room.floor}" />, <br /> 
					Pozycja okna: ${room.positionOfWindow}<br />
				</p>
				<p>Serdecznie dziękujemy za dokonanie rezerwacji! W razie jakich
					kolwiek pytań prosimy o kontakt.</p>
					<a href="<%=request.getContextPath()%>/" class="btn btn-info" role="button">Powrót do głownej</a>
				</div>		
			</section>
		</div>
	</div>
</body>
</html>