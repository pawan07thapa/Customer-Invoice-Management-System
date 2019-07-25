<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Customer Invoice Managenent System</title>

<jsp:include page="script.jsp"></jsp:include>
<script type="text/javascript" src="./js/home.js"></script>

</head>
<script type="text/javascript">
    	var ctx = "<%=request.getContextPath()%>";
</script>

<c:set var="context" value="${pageContext.request.contextPath}" />
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div style="margin: 30px;">
		<div>
			<h3 style="text-align: center;">Customer Management</h3>
		</div>
		<div style="text-align: center;">
			<a href="${context}/addCustomer">Add New Customer</a>
		</div>

		<div style="text-align: center;">
			<a href="${context}/showAllCustomers">Get All Customers</a>
		</div>
		<div style="text-align: center;">
			<form id="customerDetailForm">
				Get Customer: <select id="customerSelect">
					<option value="0" selected>Select Customer</option>
					<c:forEach var="customer" items="${customers}" varStatus="loop">
						<option value="${customer.id}">${customer.firstName} ${customer.lastName} - ${customer.id}</option>
					</c:forEach>
				</select> <input type="button" id="customerBtn" value="Submit"
					onclick="getCustomer()"> <input type="reset"
					id="cusomerResetBtn" value="Reset">
			</form>
		</div>
	</div>


	<!--<div>
			<select id="dropdown">
				<option value="">Select</option>
				<option for="let val of array"></option>
			</select>
		</div>
		-->

	<div style="margin: 30px;">
		<div>
			<h3 style="text-align: center;">Invoice Management</h3>
		</div>
		<div style="text-align: center;">
			<a href="">Add New Invoice</a>
		</div>

		<div style="text-align: center;">
			<a href="">Get All Invoices</a>
		</div>
		<div style="text-align: center;">
			Get Customer
			<button onclick="getDropdown">Select Customer</button>
		</div>
	</div>

	<div style="margin: 30px;">
		<div>
			<h3 style="text-align: center;">Payment Management</h3>
		</div>
		<div style="text-align: center;">
			<a href="">Add New Payment</a>
		</div>

		<div style="text-align: center;">
			<a href="">Get All Payments</a>
		</div>
		<div style="text-align: center;">
			Get Payment
			<button onclick="getDropdown">Select Customer</button>
		</div>
	</div>
</body>
</html>