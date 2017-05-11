//roomID needed from an external script;
		
$(function() {
			
	$('#fromDate').datepicker({
		minDate: new Date(),
		onSelect : function(selectedDate) {

			var selectedDate = $(this).datepicker('getDate');
			if(selectedDate < new Date())
				selectedDate = new Date();
		
			var minEndDate = addDays(selectedDate, 1);
			$('#toDate').datepicker('option', 'minDate', minEndDate);
			
			var maxEndDate = addDays(selectedDate, 6);
			$('#toDate').datepicker('option', 'maxDate', maxEndDate);
			$('#toDate').datepicker('setDate', maxEndDate);
			
			$("#toDate, #fromDate").datepicker("option", "dateFormat", "dd-mm-yy");
			checkAvailabilityOfDates();
		}
	});

	var today = new Date();
	var tomorow = addDays(today, 1);

	$('#toDate').datepicker({
		minDate: tomorow,
		onSelect : function(selectedDate) {
			$("#toDate, #fromDate").datepicker("option","dateFormat", "dd-mm-yy");
			checkAvailabilityOfDates();
		}
	});

	$("#checkAvailability").click(function(){
		checkAvailabilityOfDates();
	});
	
	$("#breakfasts").change( function() {		
		if ($(this).is(':checked')) {

			$(".breakfastDetails").show();

			var startDateString = $('#fromDate').val();
			var endDateString = $('#toDate').val();

			var startDate = checkStringDateAndConvertToDate(startDateString);
			var endDate = checkStringDateAndConvertToDate(endDateString);

			diffDays = calcDiffDays(startDate, endDate);

			for (i = 0; i <= diffDays; i++) {	
				var day = addDays(startDate, i);	
				$("#checkboxDivBreakFastDetails")
					.append(
						'<div class="checkbox" ><label><input type="checkbox" name="breakfastList" value="'
						+ convertDateToString(day)
						+ '" id="breakfastList'+ i
						+ '" checked="checked"/>'
						+ convertDateToString(day)
						+ '</label></div>');
			}
		} 
		else {
			$(".breakfastDetails").hide();
			$("#checkboxDivBreakFastDetails").empty();
		}
	});

	function clearDateClassAndAlert() {
		 $( "#formGroupToDate, #toGroupToDate" ).removeClass( "has-success has-error has-feedback" );
         $("#panelHeadingToAlert").empty();
	};

	function addDays(date, days) {
	    return new Date(date.getTime() + days*24*60*60*1000);
	}

	function checkStringDateAndConvertToDate(dateString) {
		var pattern = /(\d{2})\-(\d{2})\-(\d{4})/;
		var date = new Date(dateString.replace(pattern, '$3-$2-$1'));
		return date;
	};

	function calcDiffDays(startDate, endDate) {
		var oneDay = 24 * 60 * 60 * 1000; // hours*minutes*seconds*milliseconds				
		var diffDays = Math.round(
					Math.abs((endDate.getTime() - startDate.getTime())/ (oneDay))
				);

		return diffDays;
	};

	function convertDateToString(date) {
		var mm = date.getMonth() + 1; // getMonth() is zero-based
		var dd = date.getDate();
		var yyyy = date.getFullYear();
		var dateString = dd + '-' + mm + '-' + yyyy;
		return dateString
	};


	function checkAvailabilityOfDates() {
		var startDateString = $('#fromDate').val();
		var endDateString = $('#toDate').val();

		var startDate = checkStringDateAndConvertToDate(startDateString);
		var endDate = checkStringDateAndConvertToDate(endDateString);

		var data = 'roomId='
			+ encodeURIComponent(roomID)
			+ '&fromDate='
			+ encodeURIComponent(startDate.getTime())
			+ '&toDate='
			+ encodeURIComponent(endDate.getTime());

		$.ajax({
			url: '/HotelReservation/ajax/dateIsPosible',
			data : data,
			type : "GET",
			dataType: 'json',
			contentType: "application/json",
			headers: { 
			    Accept : "application/json"
			},
			
			success : function(data) {		
	             //alert(data.s);
	          	clearDateClassAndAlert();
	             if(data.isRoomAvailable){
	            	 $("#panelHeadingToAlert").append('<div class="alert alert-success"><strong>Termin dostępny!</strong></div>');
		             $( "#formGroupToDate, #toGroupToDate" ).addClass( "has-success has-feedback" );
		         }
	             else{
	            	 $("#panelHeadingToAlert").append('<div class="alert alert-danger"><strong>Termin jest już zarezerwowany! Prosimy wybrać inny termin lub pokój.</strong></div>');
		             $( "#formGroupToDate, #toGroupToDate" ).addClass( "has-error has-feedback" );
			    }
			},
			error : function(xhr, status, error) {
				clearDateClassAndAlert();
				 $("#panelHeadingToAlert").append('<div class="alert alert-danger"><strong>Przepraszamy!</strong> Nastąpił błąd połączenia z serwerem. Sprawdź poprawność daty.</div>');     
			}
		});
	};
});
	