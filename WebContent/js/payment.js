function validateAndSaveInvoice() {

	if (validatePaymentVoucher() && validatePaymentAmount() && validateCustomerId()) {
		hideValidationMessages();
		savePayment();
		emptyAllFields();
	}
}

/**
 * Adds the details of the payment in the DB
 * 
 * @author pawanthapa
 */
function savePayment() {
	var payment = {};
	payment.customerId = $("#customerId").val();
	payment.invoiceId = $("#invoiceId").val();
	payment.paymentVoucher = $("#paymentVoucher").val();
	payment.paymentAmount = $("#paymentAmount").val();
	console.log(payment);
	$.ajax({
		url : ctx + '/payment',
		type : "POST",
		async : true,
		dataType : 'json',
		contentType : 'application/json',
		data : JSON.stringify(payment),

		success : function(data) {
			$("#messageAlert").text("! Payment added successfully.").show().delay(2000).fadeOut();

		},
		error : function(XMLHttpRequest, data, message) {
			console.log("Error......");
			$('#failedMessageAlert').text(data.message);
			$('#failedMessageAlert').show();
		}
	});
}

/**
 * validates payment voucher in addPayment form
 * 
 * @author pawanthapa
 */
function validatePaymentVoucher() {
	var isValid = true;
	if ($("#paymentVoucher").val() == "") {
		$("#paymentVoucherValidationMessage").text("! Payment voucher cannot be empty. ");
		isValid = false;
	}

	if ($("#paymentVoucher").val() == null) {
		$("#paymentVoucherValidationMessage").text("! Payment voucher tus cannot be null. ");
		isValid = false;
	}
	return isValid;
}

/**
 * validates payment amount in addPayment form
 * 
 * @author pawanthapa
 */
function validatePaymentAmount() {
	var isValid = true;
	if ($("#paymentAmount").val() == "") {
		$("#paymentAmountValidationMessage").text("! Payment Amount cannot be empty. ");
		isValid = false;
	}

	if ($("#paymentAmount").val() == null) {
		$("#paymentAmountValidationMessage").text("! Payment Amount tus cannot be null. ");
		isValid = false;
	}
	return isValid;
}

/**
 * hides all the validation messages
 * 
 * @author pawanthapa
 */
function hideValidationMessages() {
	$("#paymentVoucherValidationMessage").hide();
	$("#paymentAmountValidationMessage").hide();
}

/**
 * after the form has been submit, all the fields will be made empty
 * 
 * @author pawanthapa
 */
function emptyAllFields() {
	$("#paymentVoucherValidationMessage").val("");
	$("#paymentAmountValidationMessage").val("");
}

/**
 * this function deletes payment with given id from DB
 * 
 * @param id
 * @author pawanthapa
 */
function deletePayment(id) {

	$('#id-' + id).remove();

	$.ajax({
		url : ctx + '/payment/' + id,
		type : "DELETE",
		async : false,
		dataType : 'json',
		contentType : 'application/json',
		success : function(data) {
			$('#messageAlert').text(data.message).show().delay(2000).fadeOut();
		},
		error : function(XMLHttpRequest, data, message) {
			console.log("Error......");
			$('#failedMessageAlert').text(data.message).show();
		}
	});
}

/**
 * Fetches all the customer from db from backend and populates the Invoice Dropdown
 * 
 */
function getAllInvoices(id){
	$.ajax({
		// url still not fixed. get invoices by CustomerId
		url : ctx+"/invoices/"+id,
		type :"GET",
		async :false,
		dataType: 'json',
		contentType :'application/json',
		success : function(data){
			//for invoices in data ...if invoice status=pending || notPending
			jQuery.each(data, function(index , invoices){
				if(invoices[index].status!="Clear"){
					$("#invoiceId").append("<option> ${invoices.id}</option>");
				}
			});
			
			jQuery.each(data, function(index,invoices){
				var total;
				jQuery.each(invoices , function(j, payments){
					total+=payments.paymentAmount;
				})
			});
			$('#messageAlert').text(data.message).show().delay(2000).fadeOut();
		}, 
		error: function(XMLHttpRequest , data, message){
			console.log("Error......");
			$('#messageAlert').text(data.message).show().delay(2000).fadeOut();
		}
	});
}
function getPendingAmount(){
	
}

