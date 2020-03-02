$(document).ready(function() {
	$.ajax({
		type: "GET",
		contentType: "application/json; charset=utf-8",
		url: "http://localhost:8080/api/products"
	}).then(function(resp) {
		var trHTML = '';
		$.each(resp, function (i, userData) {
//			for (i = 0; i < resp.length; i++) {
				trHTML +=
					'<tr><td>'
					+ resp[i].id
					+ '</td><td>'
					+ resp[i].name
					+ '</td><td>'
					+ resp[i].currentPrice
					+ '</td><td>'
					+ resp[i].lastUpdated
					+ '</td></tr>';
//			}
		});
		$('#tBody').append(trHTML);
	});
});