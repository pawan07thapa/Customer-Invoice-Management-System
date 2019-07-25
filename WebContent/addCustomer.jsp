<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Customer Invoice Managenent System</title>

<jsp:include page="script.jsp"></jsp:include>
<script type="text/javascript" src="./js/customer.js"></script>

<script type="text/javascript">
			var ctx = "<%=request.getContextPath()%>";
</script>
</head>
<body>
	<div class="container ">
		<jsp:include page="header.jsp"></jsp:include>
		<div class="align-bottom"
			style="margin-bottom: 10px; padding-bottom: 10px; padding-top: 0px; margin-top: 0px;">
			<h2 class="text-center">Add New Customer</h2>
			<p class="text-center">
				<span class="text-primary" id="messageAlert"></span>
			</p>
		</div>
		<div>
			<form autocomplete="off" id="addCustomerForm">
				<div class="row">
					<div class="col-md-4"></div>
					<div class="col-md-2" style="text-align: right;">
						<label>First Name: </label>
					</div>
					<div class="col-md-2" style="text-align: left;">
						<input class="form-sub-headers" id="firstName" type="text"
							placeholder="First Name" >
					</div>
					<div class="col-md-4">
						<span class="text-danger" id="firstNameValidationMessage"
							style="text-align: left;"> </span>
					</div>
				</div>
				<div class="row">
					<div class="col-md-4"></div>
					<div class="col-md-2" style="text-align: right;">
						<label>Last Name: </label>
					</div>
					<div class="col-md-2" style="text-align: left;">
						<input class="form-sub-headers" id="lastName" type="text"
							placeholder="Last Name" >
					</div>
					<div class="col-md-4">
						<span class="text-danger" id="lastNameValidationMessage"> </span>
					</div>
				</div>
				<div class="row">
					<div class="col-md-4"></div>
					<div class="col-md-2" style="text-align: right;">
						<label>Address: </label>
					</div>
					<div class="col-md-2" style="text-align: left;">
						<input class="form-sub-headers" id="address" type="text"
							placeholder="Address" >
					</div>
					<div class="col-md-4">
						<span class="text-danger" id="addressValidationMessage">
					</div>
				</div>
				<div class="row">
					<div class="col-md-4"></div>
					<div class="col-md-2" style="text-align: right;">
						<label>Phone: </label>
					</div>
					<div class="col-md-2" style="text-align: left;">
						<input class="form-sub-headers" id="phoneNumber" type="text"
							placeholder="Phone Number" >
					</div>
					<div class="col-md-4">
						<span class="text-danger" id="phoneNumberValidationMessage">
						</span>
					</div>
				</div>
				<div class="row">
					<div class="col-md-4"></div>
					<div class="col-md-2" style="text-align: right;">
						<label>Email: </label>
					</div>
					<div class="col-md-2" style="text-align: left;">
						<input class="form-sub-headers" id="email" type="text"
							placeholder="Email" >
					</div>
					<div class="col-md-4">
						<span class="text-danger" id="emailValidationMessage"> </span>
					</div>
				</div>
				<div class="row">
					<div class="col-md-4"></div>
					<div class="col-md-2" style="text-align: right;">
						<label>Company: </label>
					</div>
					<div class="col-md-2" style="text-align: left;">
						<input class="form-sub-headers" id="company" type="text"
							placeholder="Company" >
					</div>
					<div class="col-md-4">
						<span class="text-danger" id="companyValidationMessage"> </span>
					</div>
				</div>
				<div class="row sub-headers">
					<div class="col-md-4"></div>
					<div class="col-md-4" style="text-align: center;">
						<input class="form-sub-headers" type="button" value="Submit"
							onclick="validateAndSaveCustomer()"> <input
							class="form-sub-headers" type="reset" name="Reset">
					</div>
					<div class="col-md-4"></div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>