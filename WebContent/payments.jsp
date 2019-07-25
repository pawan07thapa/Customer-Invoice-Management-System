<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Customer Invoice Management System</title>
<script type="text/javascript" src="./js/payment.js"></script>

<jsp:include page="script.jsp"></jsp:include>
<script type="text/javascript">
			//for every file it has to be mentioned 
			var ctx = "<%=request.getContextPath()%>"; 
</script>
</head>

<body>
	<div class=" container">
		<jsp:include page="header.jsp"></jsp:include>
		<div class="align-bottom"
			style="margin-bottom: 10px; padding-bottom: 10px; padding-top: 0px; margin-top: 0px;">
			<h2 class=" text-center align-bottom ">List of all Payments</h2>
			<p class="text-center">
				<span class="text-danger" id="messageAlert"></span> <span
					class="text-danger" id="failedMessageAlert"></span>

			</p>
		</div>

		<div class="text-center">
			<form>
				<select id="customerId"
					style="margin-bottom: 20px; padding-bottom: 20px; padding-top: 0px; margin-top: 0px;">
					<option value="0">Select Customer </option>
					<c:forEach var="customer" items="${customers}" varStatus="loop">
						<option style="text-align: center;"> ${customer.id}</option>
					</c:forEach>
				</select> 
				<input id ="dropdownSubmit"type="button" value="Submit" onclick="getPaymentByCustomerId()">
				<input type="reset" value="Reset">
				<div class="text-danger">
					<span id="customerIdValidationMessage"></span>
				</div>
			</form>
<!-- 							<button id ="dropdownSubmit" onclick="getInvoiceByCustomerId()">Submit </button> -->
		</div>

		<table class="table table-bordered">
			<thead>
				<tr>
					<th>id</th>
					<th>Customer Id</th>
					<th>Invoice Number</th>
					<th>Payment Voucher</th>
					<th>Payment Date</th>
					<th>Payment Amount</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${listOfPayments}" var="payment" varStatus="loop">
					<tr id="id-${payment.id}">
						<td>${payment.id}</td>
						<td>${payment.customerId}</td>
						<td>${payment.invoiceNumber}</td>
   						<td>${payment.paymentVoucher}</td>
						<td>${payment.paymentDate}</td>
						<td>${payment.paymentAmount}</td>
						<!-- Complex Query Here -->
						<td>
							<!-- Complex Query Here -->
							<button id="delete" onclick="deletePayment(${payment.id})">Delete</button>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>