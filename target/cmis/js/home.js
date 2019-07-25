function getCustomer() {
	var id = $("#customerSelect").val();
	window.location.href = ctx + "/showCustomer?customerId=" + id;
}

function resetCustomer() {
	$("#customerSelect").val("0");
}