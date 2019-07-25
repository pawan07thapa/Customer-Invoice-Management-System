/**
 * fetches all the input fields value from addCustomer form and sets it to
 * customer object respectively, then using ajax , the url, method type(GET
 * ,POST etc.), asynchronous(should data be send serially or parallely) ,
 * dataType( json, xml etc) are set and finally data is added using
 * Json.stringify( data). Depending on success or failure, respective messages
 * are displayed
 * 
 * @author pawan thapa
 */
function saveCustomer() {
	var customer = {};
	customer.firstName = $("#firstName").val();
	customer.lastName = $("#lastName").val();
	customer.address = $("#address").val();
	customer.email = $("#email").val();
	customer.company = $("#company").val();
	customer.phoneNumber = $('#phoneNumber').val();
	console.log(customer);
	$.ajax({
		url : ctx + '/customer',
		type : "POST",
		async : true,
		dataType : 'json',
		contentType : 'application/json',
		data : JSON.stringify(customer),

		success : function(data) {
			$("#messageAlert").text("Customer added successfully.").show().delay(1000).fadeOut();
			
		},
		error : function(XMLHttpRequest, data, message) {
			console.log("Error......");
			$('#failedMessageAlert').text(data.message);
			$('#failedMessageAlert').show();
		}
	});
}

/**
 * this function performs validation of all the fields in addCustomer form. It
 * one by one calls all the validations and if all of them return
 * true(validated) it then saves the customer
 * 
 * @author pawan thapa
 */

function validateAndSaveCustomer() {
	// hide all validation messages

	hideAllValidationMessages();
	var isFirstName = nameValidation("firstName", "firstNameValidationMessage");
	var isLastName = nameValidation("lastName", "lastNameValidationMessage");
	var isPhone = phoneNumberValidation();
	var isEmail = emailValidation();
	var isaddress = addressValidation();
	var iscompany = companyValidation();

	if (isFirstName && isLastName && isPhone && isEmail && isaddress && iscompany) {
		hideAllValidationMessages();
		saveCustomer();
		emptyAllFields();
		return true;
	} else {
		return false;
	}
}

function hideAllValidationMessages() {
	$("#firstNameValidationMessage").hide();
	$("#lastNameValidationMessage").hide();
	$("#emailValidationMessage").hide();
	$("#phoneNumberValidationMessage").hide();
	$("#addressValidationMessage").hide();
	$("#companyValidationMessage").hide();
}
/**
 * performs name validation
 * 
 * @author pawan thapa
 */
function emptyAllFields() {
	$("#firstName").val("");
	$("#lastName").val("");
	$("#address").val("");
	$("#email").val("");
	$("#company").val("");
	$("#phoneNumber").val("");
}

function nameValidation(id, alertMsgId) {
	var nameChecker = /^[A-Za-z  ]+$/;
	var name = $("#" + id).val();
	if (id == "firstName")
		id = "First name ";
	else
		id = "Last name";
	if (name == '') {
		$("#" + alertMsgId).text("! " + id + " cannot be empty.");
		$("#" + alertMsgId).show();
		return false;
	} else if (name.match(nameChecker)) {
		if (name.length < 3 || name.length > 20) {
			$("#" + alertMsgId).text("! Length of " + id + " cannot be < 3 and > 20 characters.");
			$("#" + alertMsgId).show();
			return false;
		}
	} else {
		$("#" + alertMsgId).text("! " + id + " should contain only alphabets.");
		$("#" + alertMsgId).show();
		return false;
	}

	return true;
}

/**
 * performs email validation
 * 
 * @author pawan thapa -
 */
function emailValidation() {
	var emailChecker = /^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/;
	var email = $("#email").val();
	if (email == "") {
		$("#emailValidationMessage").text("! Email cannot be empty.");
		$("#emailValidationMessage").show();
		return false;
	} else if (emailChecker.test(email)) {
		return true;
	} else {
		$("#emailValidationMessage").text("! Invalid email format.");
		$("#emailValidationMessage").show();
		return false;
	}
}

function companyValidation() {
	var companyName = $("#company").val();
	if (companyName == "") {
		$("#companyValidationMessage").text("! Company name cannot be empty. ");
		$("#companyValidationMessage").show();
		return false;
	} else {
		return true;
	}
}

function addressValidation() {
	var address = $("#address").val();
	if (address == "") {
		$("#addressValidationMessage").text("! Address cannot be empty. ");
		$("#addressValidationMessage").show();
		return false;
	} else {
		return true;
	}
}

/**
 * performs phone number validation
 * 
 * @author pawan thapa
 */
function phoneNumberValidation() {

	var phoneNumberChecker = /^[0-9]{10}$/;
	var phoneNumber = $("#phoneNumber").val();
	if (phoneNumber == '') {
		$("#phoneNumberValidationMessage").text('! Phone number cannot be empty.');
		$("#phoneNumberValidationMessage").show();
		return false;
	} else {

		if (phoneNumberChecker.test(phoneNumber))
			return true;
		else {
			$("#phoneNumberValidationMessage").text('! Invalid phone number.');
			$("#phoneNumberValidationMessage").show();
			return false;
		}
	}
}

/**
 * deletes a row from the table. The remove function removes the row with the
 * given id from the table and then using ajax , the url, method type(GET , POST
 * etc. here DELETE), asynchronous(should data be send serially or parallely) ,
 * dataType( json, xml etc). Since data is being deleted,data is not added here .
 * Depending on success or failure, respective messages are displayed
 * 
 * @param id
 * @author pawan thapa-
 */
function deleteCustomer(id) {
	$('#id-' + id).remove();

	$.ajax({
		url : ctx + '/customer/' + id,
		type : "DELETE",
		async : false,
		dataType : 'json',
		contentType : 'application/json',
		success : function(data) {
			$('#messageAlert').html(data.message);
			$('#messageAlert').show();
		},
		error : function(XMLHttpRequest, data, message) {
			console.log("Error......");
			$('#failedMessageAlert').html(data.message);
			$('#failedMessageAlert').show();
		}
	});
	$("#messageAlert").text('Customer with id ' + id + " deleted successfully. ");
}

/**
 * This method updates the table data in the DB. Using ajax ,≠≠ the url, method
 * type(GET , POST etc. here DELETE), asynchronous(should data be send serially
 * or parallely) , dataType( json, xml etc) are set and finally data is updated
 * using Json.stringify( data). Depending on success or failure, respective
 * messages are displayed
 * 
 * @param id
 * @author pawan thapa
 */
function update(id) {
	var customer = {};
	var currentRow = $("#id-" + id).closest("tr");
	customer.id = id;
	customer.firstName = currentRow.find("td:eq(1)").html().trim();
	customer.lastName = currentRow.find("td:eq(2)").html().trim();
	customer.address = currentRow.find("td:eq(3)").html().trim();
	customer.phoneNumber = currentRow.find("td:eq(4)").html().trim();
	customer.email = currentRow.find("td:eq(5)").html().trim();
	customer.company = currentRow.find("td:eq(6)").html().trim();
	console.log(customer);

	$.ajax({
		url : ctx + '/customer',
		type : "PUT",
		async : false,
		dataType : 'json',
		contentType : 'application/json',
		data : JSON.stringify(customer),
		success : function(data) {
			$('#messageAlert').text(data.message);
			$('#messageAlert').show();
		},
		error : function(XMLHttpRequest, data, message) {
			console.log("Error......");
			$('#failedMessageAlert').html(data.message);
			$('#failedMessageAlert').show();
		}
	});
//	$("#messageAlert").text("Customer with id " + id + " updated successfully.");
}

