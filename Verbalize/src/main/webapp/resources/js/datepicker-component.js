function setdatepicker() {
	console.log('setdatepicker');
	$('.datetimepicker').datetimepicker({
		locale : 'pt-br',
		format: 'DD/MM/YYYY',
		daysOfWeekDisabled: [0, 6]
	});
	$('.timepicker').datetimepicker({
		locale : 'pt-br',
		format: 'LT'
	});
}

$(setdatepicker);