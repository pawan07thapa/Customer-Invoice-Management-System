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
	<jsp:include page="header.jsp"></jsp:include>
	<div>
		<div class="sub-headers">
			<h3 style="text-align: center;">Add New Customer</h3>
		</div>

		<!-- <div>
			<form style="text-align: center;">
				<input class="form-sub-headers" id="firstName" type="text"
					placeholder="First Name" required><br> <input
					class="form-sub-headers" id="lastName" type="text"
					placeholder="Last Name" required><br> <input
					class="form-sub-headers" id="address" type="text"
					placeholder="Address" required><br> <input
					class="form-sub-headers" id="phoneNumber" type="text"
					placeholder="Phone Number" required><br> <input
					class="form-sub-headers" id="email" type="text" placeholder="Email"
					required><br> <input class="form-sub-headers"
					id="company" type="text" placeholder="Company" required><br>
				<input class="form-sub-headers" type="submit" onclick="validation()"
					value="Submit"><br> <input class="form-sub-headers"
					type="reset" name="Reset">
			</form>
			<div>
				<span id="message" style="display: none;"></span>
			</div>
		</div> -->

		<div>
			<form onsubmit="return validateAndSaveCustomer()">
				<div class="row">
					<div class="col-md-4"></div>
					<div class="col-md-2" style="text-align: right;">
						<label>First Name: </label>
					</div>
					<div class="col-md-2" style="text-align: left;">
						<input class="form-sub-headers" id="firstName" type="text"
							placeholder="First Name" required> 
					</div>
					<div class="col-md-4"> <span id="firstNameValidationMessage" style="text-align: left;"> </span></div>
				</div>
				<div class="row">
					<div class="col-md-4"></div>
					<div class="col-md-2" style="text-align: right;">
						<label>Last Name: </label>
					</div>
					<div class="col-md-2" style="text-align: left;">
						<input class="form-sub-headers" id="lastName" type="text"
							placeholder="Last Name" required>
					</div>
					<div class="col-md-4"> <span id="lastNameValidationMessage"> </span></div>
				</div>
				<div class="row">
					<div class="col-md-4"></div>
					<div class="col-md-2" style="text-align: right;">
						<label>Address: </label>
					</div>
					<div class="col-md-2" style="text-align: left;">
						<input class="form-sub-headers" id="address" type="text"
							placeholder="Address" required>
					</div>
					<div class="col-md-4"> </div>
				</div>
				<div class="row">
					<div class="col-md-4"></div>
					<div class="col-md-2" style="text-align: right;">
						<label>Phone: </label>
					</div>
					<div class="col-md-2" style="text-align: left;">
						<input class="form-sub-headers" id="phoneNumber" type="text"
							placeholder="Phone Number" required>
					</div>
					<div class="col-md-4"><span id="phoneNumberValidationMessage"> </span></div>
				</div>
				<div class="row">
					<div class="col-md-4"></div>
					<div class="col-md-2" style="text-align: right;">
						<label>Email: </label>
					</div>
					<div class="col-md-2" style="text-align: left;">
						<input class="form-sub-headers" id="email" type="text"
							placeholder="Email" required>
					</div>
					<div class="col-md-4"><span id="emailValidationMessage"> </span> </div>
				</div>
				<div class="row">
					<div class="col-md-4"></div>
					<div class="col-md-2" style="text-align: right;">
						<label>Company: </label>
					</div>
					<div class="col-md-2" style="text-align: left;">
						<input class="form-sub-headers" id="company" type="text"
							placeholder="Company" required>
					</div>
					<div class="col-md-4"></div>
				</div>
				<div class="row sub-headers">
					<div class="col-md-4"></div>
					<div class="col-md-4" style="text-align: center;">
						<input class="form-sub-headers" type="submit" value="Submit">
						<input class="form-sub-headers" type="reset" name="Reset">
					</div>
					<div class="col-md-4"></div>
				</div>
				<div style="text-align: center;">
					<span class="sub-headers" id="message" style="display: none;"></span>
				</div>
			</form>
		</div>
	</div>
</body>
</html>