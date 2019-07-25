/**
 * for selecting a particular customer from the dropdown and then directs to a
 * diffrent page where information about the customer is present
 * 
 * @author pawanthapa
 */
function getCustomer() {
	var id = $("#customerSelect").val();
	window.location.href = ctx + "/showCustomer?customerId=" + id;
}

function getInvoice() {
	var id = $("#invoiceSelect").val();
	window.location.href = ctx + "/showInvoice?invoiceId=" + id;
}
