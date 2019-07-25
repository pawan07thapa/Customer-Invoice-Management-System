/**
 * 
 */
function saveInvoice() {
	var invoice = {};
	invoice.customerId = $("#customerId").val();
	invoice.invoiceNumber = $("#invoiceNumber").val();
	invoice.invoiceDate = $("#invoiceDate").val();
	invoice.invoiceDueDate = $("#invoiceDueDate").val();
	invoice.invoiceAmount = $("#invoiceAmount").val();
	invoice.invoicePendingAmount = "0";
	invoice.status = "Pending";
	// invoice.status = $("#invoiceStatus").val();
	console.log(invoice);
	$.ajax({
		url : ctx + '/invoice',
		type : "POST",
		async : true,
		dataType : 'json',
		contentType : 'application/json',
		data : JSON.stringify(invoice),

		success : function(data) {
			$("#messageAlert").text("Invoice added successfully.").show().delay(2000).fadeOut();

		},
		error : function(XMLHttpRequest, data, message) {
			console.log("Error......");
			$('#failedMessageAlert').text(data.message);
			$('#failedMessageAlert').show();
		}
	});
}

function validateAndSaveInvoice() {

	if (validateCustomerId() && validateInvoiceNumber() && validateCustomerId() && validateInvoiceDate()
			&& validateInvoiceDueDate() && validateInvoiceAmount()) {
		hideValidationMessages();
		saveInvoice();
		emptyAllFields();
	}
}

function validateCustomerId() {
	var isValid = true;
	if (parseInt($("#customerId").val()) <= 0) {
		$("#customerIdValidationMessage").text('! Customer id cannot be less than or equal to zero.')
		isValid = false;
	}

	if ($("#customerId").val() == "") {
		$("#customerIdValidationMessage").text("! Customer id cannot be empty. ");
		isValid = false;
	}

	return isValid;
}

function validateInvoiceDate() {
	var isValid = true;
	if ($("#invoiceDate").val() == "") {
		$("#iinvoiceDateValidationMessage").text("! Invoice date cannot be empty. ");
		isValid = false;
	}

	if ($("#invoiceDate").val() == null) {
		$("#iinvoiceDateValidationMessage").text("! Invoice date tus cannot be null. ");
		isValid = false;
	}
	return isValid;

}

function validateInvoiceNumber() {
	var isValid = true;

	if ($("#invoiceNumber").val() == "") {
		$("#invoiceNumberValidationMessage").text("! Invoice number cannot be empty. ");
		isValid = false;
	}

	if ($("#invoiceNumber").val() == null) {
		$("#invoiceNumberValidationMessage").text("! Invoice number cannot be null. ");
		isValid = false;
	}
	return isValid;

}

function validateInvoiceDueDate() {
	var isValid = true;
	if ($("#invoiceDueDate").val() == "") {
		$("#invoiceDueDateValidationMessage").text("! Invoice duedate cannot be empty. ");
		isValid = false;
	}

	if ($("#invoiceDueDate").val() == null) {
		$("#invoiceDueDateValidationMessage").text("! Invoice duedate cannot be null. ");
		isValid = false;
	}
	return isValid;

}

function validateInvoiceAmount() {
	var isvalid = true;
	if ($("#invoiceAmount").val() == "") {
		$("#invoiceAmountValidationMessage").text("! Amount cannot be empty. ");
		isvalid = false;
	}

	if (parseInt($("#invoiceAmount").val()) <= 0) {
		$("#invoiceAmountValidationMessage").text('! Amount cannot be less than or equal to zero. ');
		isvalid = false;
	}
	return isvalid;
}

function emptyAllFields() {
	$("#customerId").val("");
	$("#invoiceNumber").val("");
	$("#invoiceDate").val("");
	$("#invoiceDueDate").val("");
	$("#invoiceAmount").val("");

}

function hideValidationMessages() {
	$("#customerIdValidationMessage").hide();
	$("#VinvoiceNumberValidationMessage").hide();
	$("#invoiceDateValidationMessage").hide();
	$("#invoiceDueDateValidationMessage").hide();
	$("#invoiceAmountValidationMessage").hide();

}

function setCustomerId() {
	$("#customerid").val($("#customerid").val());
}

/**
 * When an invoice is deleted make sure all the payments with same invoice id
 * are also deleted
 * 
 * @param id
 * @author pawanthapa
 */

function deleteInvoice(id) {

	$('#id-' + id).remove();

	$.ajax({
		url : ctx + '/invoice/' + id,
		type : "DELETE",
		async : false,
		dataType : 'json',
		contentType : 'application/json',
		success : function(data) {
			$('#messageAlert').text(data.message).show().delay(2000).fadeOut();
			;
		},
		error : function(XMLHttpRequest, data, message) {
			console.log("Error......");
			$('#failedMessageAlert').html(data.message);
			$('#failedMessageAlert').show();
		}
	});
	// $("#messageAlert").text('Customer with id ' + id + " deleted
	// successfully. ");

}

function getInvoiceByCustomerId() {
	var val=$("#customerId").val();
	if(val==0){
		$("#customerIdValidationMessage").text("! Please select a Customer id");
	}else{
		var loc = ctx + "/invoices/" + $("#customerId").val();
		window.location.href = loc;
	}
	$("#customerId").val("2").show();
}
