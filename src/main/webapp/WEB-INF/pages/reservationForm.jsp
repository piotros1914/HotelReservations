<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page language="Java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	response.setCharacterEncoding("UTF-8");
	request.setCharacterEncoding("UTF-8");
%>

<!doctype html>
<html lang="pl-PL">
<head>
	<meta charset="UTF-8">
	<title>Rezerwacja</title>
	<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
	<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
</head>
<body style="background-color: #808080">
	<div class="container"
		style="background-color: white; border-radius: 5px; margin-top: 20px; margin-bottom: 20px">
		<div class="row">
			<section class="content">

				<div class="col-md-10 col-md-offset-1">
					<h1>Rezerwacja</h1>
					<br /><br />
					<div class="panel panel-default">
						<div class="panel-body">
							<div class="col-md-3">
								<a href="#" class="pull-left"> <img
									src="data:image/jpeg;base64,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"
									class="media-photo">
								</a>
							</div>
							<div class="col-md-9">
								<div class="col-md-12">
									<h4 class="title">
										Pokój <fmt:formatNumber type="number" maxFractionDigits="0" value="${room.sizeOfRoomInPersons}" /> -osobowy
									</h4>
								</div>
								<div class="col-md-6">

									<p>
										Cena:
										<fmt:formatNumber type="number" maxFractionDigits="0"
											value="${room.price}" />
										PLN
									</p>
									<p>
										Piętro:
										<fmt:formatNumber type="number" maxFractionDigits="0"
											value="${room.floor}" />
									</p>
								</div>
								<div class="col-md-6">
									<p>Kierunek okna: ${room.positionOfWindow}</p>
								</div>
							</div>
						</div>
					</div>

					<form:form modelAttribute="reservationForm" method="POST" class="form-horizontal" servletRelativeAction="/reservation/${room.id}">
						<div class="panel panel-default">
							<div class="panel-heading clearfix">
								<div class="row">						
									<div class="col-md-4">
										<div class="form-group" id="formGroupToDate">
											<div class="col-md-3">
												<label class="control-label text-right" for="fromDate">Początek</label>
											</div>
											<div class="col-md-9">
												<form:input path="fromDate" class="form-control" id="fromDate" 
												name="fromDate" placeholder="dd-mm-yyy"  onfocus="this.blur()" readonly="readonly" type="text" />
													<form:errors path="fromDate" style="color:red"/>
											</div>
										</div>
									</div>
									<div class="col-md-4">
										<div class="form-group" id="toGroupToDate">
											<div class="col-md-3">
												<label class="control-label" for="fromDate">Koniec </label>
											</div>
											<div class="col-md-9">
												<form:input path="toDate" class="form-control" id="toDate"
													name="fromDate" placeholder="dd-mm-yyy" onfocus="this.blur()" readonly="readonly" type="text" />
												<form:errors path="toDate" style="color:red" />
											</div>
										</div>
									</div>		
									<div class="col-md-4">
										<button type="button" id="checkAvailability" class="btn btn-info btn-md">Sprawdź dostępność</button>
									</div>
								</div>
							</div>

							<div class="panel-body">
								<div class="col-md-12" id ="panelHeadingToAlert">
								</div>
								<div class="form-group">
									<div class="col-sm-4">
										<label class="control-label">Pobyt ze śniadaniem</label>
									</div>
									<div class="col-sm-8">
										<div class="checkbox">
											<label> <input type="checkbox" id="breakfasts" /> </label>
										</div>
									</div>
								</div>
								<div class="form-group breakfastDetails">
									<div class="col-sm-4">
										<label class="control-label">Szczegóły</label>
									</div>
									<div class="col-sm-8" id="checkboxDivBreakFastDetails"></div>
								</div>
								<div class="form-group">
									<div class="col-md-4">
										<label for="firstName" class="control-label">Imię</label>
									</div>
									<div class="col-md-8">
										<form:input path="firstName" id="firstName" class="form-control" />
										<form:errors path="firstName" style="color:red"/>
									</div>
								</div>
								<div class="form-group">
									<div class="col-md-4">
										<label for="lastName" class="control-label">Nazwisko</label>
									</div>
									<div class="col-md-8">
										<form:input path="lastName" id="lastName" class="form-control" />
										<form:errors path="lastName" style="color:red"/>
									</div>
								</div>
								<div class="form-group">
									<div class="col-md-4">
										<label for="address" class="control-label">Adres zamieszkania</label>
									</div>
									<div class="col-md-8">
										<form:input path="address" id="address" class="form-control" />
										<form:errors path="address" style="color:red"/>
									</div>
								</div>
								<div class="form-group">
									<div class="col-md-4">
										<label for="postalCode" class="control-label">Kod pocztowy</label>
										
									</div>
									<div class="col-md-8">
										<form:input path="postalCode" id="postalCode" class="form-control" />
										<form:errors path="postalCode" style="color:red"/>
									</div>
								</div>
								<div class="form-group">
									<div class="col-md-4">
										<label for="city" class="control-label">Miasto</label>
									</div>
									<div class="col-md-8">
										<form:input path="city" id="city" class="form-control" />
										<form:errors path="city" style="color:red"/>
									</div>
								</div>
								<div class="form-group">
									<div class="col-md-4">
										<label for="phone" class="control-label">Telefon kontaktowy</label>
									</div>
									<div class="col-md-8">
										<form:input path="phone" id="phone" class="form-control" />
										<form:errors path="phone" style="color:red"/>
									</div>
								</div>
								<div class="form-group">
									<div class="col-md-4">
										<label for="email" class="control-label">Adres email</label>
									</div>
									<div class="col-md-8">
										<form:input path="email" id="email" class="form-control" />
										<form:errors path="email" style="color:red"/>
									</div>
								</div>
								<div class="panel-footer" style="padding-left: 200px">
									<button type="submit" class="btn btn-success">Zarezerwuj</button>
									<a href="<%=request.getContextPath()%>/" class="btn btn-info" role="button">Powrót</a>
								</div>
							</div>
						</div>
					</form:form>

				</div>
			</section>
		</div>
	</div>
	<script src="/HotelReservation/resources/js/reservationForm.js"></script>
	<script>
		var roomID=${room.id}; // for reservationForm.js
	</script>
</body>
</html>