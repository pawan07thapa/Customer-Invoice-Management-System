/**
 * @author pawan thapa- fetches all the input fields value from addCustomer form
 *         and sets it to customer object respectively, then using ajax , the
 *         url, method type(GET ,POST etc.), asynchronous(should data be send
 *         serially or parallely) , dataType( json, xml etc) are set and finally
 *         data is added using Json.stringify( data). Depending on success or
 *         failure, respective messages are displayed
 */
function saveCustomer() {
	var customer = {};
	customer.firstName = document.getElementById("firstName").value;
	customer.lastName = document.getElementById("lastName").value;
	customer.address = document.getElementById("address").value;
	customer.email = document.getElementById("email").value;
	customer.company = document.getElementById("company").value;
	customer.phoneNumber = $('#phoneNumber').val();
	console.log(customer);
	$.ajax({
		url : ctx + '/customer',
		type : "POST",
		async : false,
		dataType : 'json',
		contentType : 'application/json',
		data : JSON.stringify(customer),

		success : function(data) {
			$('#mssg').html(data.message);
			$('#mssg').show();
		},
		error : function(XMLHttpRequest, data, message) {
			console.log("Error......");
			$('#mssg').html(data.message);
			$('#mssg').show();
		}
	});
}

/**
 * @author pawan thapa -this function performs validation of all the fields in
 *         addCustomer form. It one by one calls all the validations and if all
 *         of them return true(validated) it then saves the customer
 */

function validateAndSaveCustomer() {
	if (!nameValidation())
		return false;
	else if (!phoneNumberValidation())
		return false;
	// else if (!emailValidation())
	// return false;
	else {
		saveCustomer();
		return true;
	}

}

/**
 * @author pawan thapa -performs name validation
 */
function nameValidation() {
	var nameChecker = /^[A-Za-z]+$/;
	var firstName = document.getElementById("firstName").value;
	var lastName = document.getElementById("lastName").value;

	if (firstName.match(nameChecker)){ 
		if( lastName.match(nameChecker)) {
			if (firstName.length < 3 || lastName.length < 3) {
				$("#firstNameValidationMessage").text('length of name cannot be smaller than 3 characters')
				return false;
			} else if (firstName.length > 20 || lastName.length > 20) {
				$("#firstNameValidationMessage").text('Length of name cannot be greater than 20 characters')
				return false;
			} else {
				return true;
			}
	}
	} else {
		alert("Enter only alphabets in name fields");
		return false;
	}
}

/**
 * @author pawan thapa -performs email validation
 */
function emailValidation() {
	var emailChecker = /^[A-Za-z._]{3,}@[A-Za-z]{3,}[.]{2,}[A-Za-z.]{3,}$/
	var email = document.getElementById("email").value;

	if (emailChecker.test(email))
		return true;
	else {
		alert("Invalid email");
		return false;
	}
}

/**
 * @author pawan thapa -performs phone number validation
 */
function phoneNumberValidation() {

	var phoneNumberChecker = /^[0-9]{10}$/;
	var phoneNumber = document.getElementById("phoneNumber").value;

	if (phoneNumberChecker.test(phoneNumber))
		return true;
	else {
		alert("Invalid phone number");
		return false;
	}
}

/**
 * @author pawan thapa-
 *  deletes a row from the table. The remove function removes
 *  the row with the given id from the table and then using ajax , the
 *  url, method type(GET , POST etc. here DELETE), asynchronous(should data be send
 *  serially or parallely) , dataType( json, xml etc). Since data is being deleted,data
 *  is not added here . Depending on success or
 *  failure, respective messages are displayed 
 * @param id
 */
function deleteCustomer(id) {
	$('#id-' + id).remove();
	alert("customer with id " + id + " deleted");
	$.ajax({
		url : ctx + '/customer/' + id,
		type : "DELETE",
		async : false,
		dataType : 'json',
		contentType : 'application/json',
		success : function(data) {
			$('#mssg').html(data.message);
			$('#mssg').show();
		},
		error : function(XMLHttpRequest, data, message) {
			console.log("Error......");
			$('#mssg').html(data.message);
			$('#mssg').show();
		}
	});
}

/**
 * @author pawan thapa-
 *  This method updates the table data in the DB. Using ajax , the
 *  url, method type(GET , POST etc. here DELETE), asynchronous(should data be send
 *  serially or parallely) , dataType( json, xml etc) are set and finally
 *  data is updated using Json.stringify( data). Depending on success or
 *  failure, respective messages are displayed 
 * @param id
 */
function update(id) {
	var customer = {};
	var currentRow = $("#id-" + id).closest("tr");
	customer.id = id;
	customer.firstName = currentRow.find("td:eq(1)").html();
	customer.address = currentRow.find("td:eq(2)").html(); 
	customer.phoneNumber = currentRow.find("td:eq(3)").html();
	customer.email = currentRow.find("td:eq(4)").html();
	customer.company = currentRow.find("td:eq(5)").html();
	console.log(customer);

	$.ajax({
		url : ctx + '/customer',
		type : "PUT",
		async : false,
		dataType : 'json',
		contentType : 'application/json',
		data : JSON.stringify(customer),
		success : function(data) {
			$('#mssg').html(data.message);
			$('#mssg').show();
		},
		error : function(XMLHttpRequest, data, message) {
			console.log("Error......");
			$('#mssg').html(data.message);
			$('#mssg').show();
		}
	});
	alert("customer with id " + id + " updated");

}
