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
	<div class="container">
		<%-- 		<a href="${context}/cmis" style="text-align: left:"> Back</a> --%>
		<div class="jumbotron text-center">
			<h1>Customer Invoice Management System</h1>
		</div>

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

		<div style="margin: 30px;">
			<div>
				<h3 style="text-align: center;">Invoice Management</h3>
			</div>
			<div style="text-align: center;">
				<a href="${context}/addInvoice">Add New Invoice</a>
			</div>

			<div style="text-align: center;">
				<a href="${context}/showAllInvoices">Get All Invoices</a>
			</div>
			<div style="text-align: center;">
				<form id="invoiceDetailForm">
					Select Invoice: <select id="invoiceSelect">
						<option value="0">Select Invoice </option>
						<c:forEach var="invoice" items="${invoices}" varStatus="loop">
							<option value="${invoice.id}"> ${invoice.id}-${invoice.invoiceNumber} </option>
						</c:forEach>

					</select> <input type="button" id="invoiceBtn" value="Submit"
						onclick="getInvoice()"> <input type="reset" value="Reset">
				</form>
			</div>
		</div>

		<div style="margin: 30px;">
			<div>
				<h3 style="text-align: center;">Payment Management</h3>
			</div>
			<div style="text-align: center;">
				<a href="${context}/addPayment">Add New Payment</a>
			</div>

			<div style="text-align: center;">
				<a href="${context}/showAllPayments">Get All Payments</a>
			</div>
			<div style="text-align: center;">
				<form id="paymentDetailForm">
					Select Paymet: <select id="paymentSelect">
						<option value="0">Select payment </option>
						<c:forEach var="payment" items="${payments}" varStatus="loop">
							<option value="${payment.id}"> ${payment.id} - ${payment.paymentVoucher} </option>
						</c:forEach>

					</select> <input type="button" id="paymentBtn" value="Submit"
						onclick="getpayment()"> <input type="reset" value="Reset">
				</form>
			</div>
		</div>
	</div>
</body>
</html>