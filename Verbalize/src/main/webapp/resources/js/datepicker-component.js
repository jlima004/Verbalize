function setdatepicker() {
	console.log('setdatepicker');
	$('.datetimepicker').datetimepicker({
		locale : 'pt-br',
	});
	$('.timepicker').datetimepicker({
		locale : 'pt-br',
		format: 'LT'
	});
	$('.datetimepickerformat').datetimepicker({
		locale : 'pt-br',
		format: 'DD/MM/YYYY',
		daysOfWeekDisabled: [0, 6]
	});
}

$(setdatepicker);