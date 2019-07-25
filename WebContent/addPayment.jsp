<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Payment Payment Managenent System</title>

<jsp:include page="script.jsp"></jsp:include>
<script type="text/javascript" src="./js/payment.js"></script>

<script type="text/javascript">
			var ctx = "<%=request.getContextPath()%>";
</script>
</head>
<body>
	<div class="container ">
		<jsp:include page="header.jsp"></jsp:include>
		<div class="align-bottom"
			style="margin-bottom: 10px; padding-bottom: 10px; padding-top: 0px; margin-top: 0px;">
			<h2 class="text-center">Add New Payment</h2>
			<p class="text-center">
				<span class="text-primary" id="messageAlert"></span>
			</p>
		</div>
		<div class="text-center">
			<form>
				<select id="customerId"
					style="margin-bottom: 15px; padding-bottom: 15px; padding-top: 0px; margin-top: 0px;">
					<option value="0"> Customer Id </option>
					<c:forEach var="customer" items="${customers}" varStatus="loop">
						<option style="text-align: center;"> ${customer.id}</option>
					</c:forEach>
				</select> 
				<input type="button" value="Apply" onclick="getAllInvoices()">
				<input type="reset" value="Reset">
				<div class="text-danger">
					<span id="customerIdValidationMessage"></span>
				</div>
			</form>
		</div>

		<div class="text-center">
			<form>
				<select id="invoiceId"
					style="margin-bottom: 15px; padding-bottom: 15px; padding-top: 0px; margin-top: 0px;">
					<option value="0"> Invoice Id </option>
					<c:forEach var="invoice" items="${invoices}" varStatus="loop">
						<option style="text-align: center;"> ${invoice.id}</option>
					</c:forEach>
				</select> <input type="reset" value="Reset">
				<div class="text-danger">
					<span id="invoiceIdValidationMessage"></span>
				</div>
			</form>
		</div>
		<!-- ABOVE THIS IS CUSTOMER & INVOICE DROPDOWN AREA -->
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-4" style="text-align: right;">
				<label> Invoice Pending Amount: </label>
			</div>
			<div class="col-md-2" style="text-align: left;">
<!-- 			WE NEED TO WRITE A FUNCTION FOR PENDING AMOUNT -->
				<label> {invoices.pendingAmount}</label>
			</div>
			<div class="col-md-4">
				<span class="text-danger" id="pendingAmountValidationMessage"
					style="text-align: left;"> </span>
			</div>
		</div>
		<div>
			<form autocomplete="off" id="addPaymentForm">
				<div class="row">
					<div class="col-md-4"></div>
					<div class="col-md-2" style="text-align: right;">
						<label> Payment Voucher: </label>
					</div>
					<div class="col-md-2" style="text-align: left;">
						<input class="form-sub-headers" id="paymentVoucher" type="text"
							placeholder="Payment Voucher">
					</div>
					<div class="col-md-4">
						<span class="text-danger" id="paymentVoucherValidationMessage"
							style="text-align: left;"> </span>
					</div>
				</div>

				<div class="row">
					<div class="col-md-4"></div>
					<div class="col-md-2" style="text-align: right;">
						<label> Payment Amount: </label>
					</div>
					<div class="col-md-2" style="text-align: left;">
						<input class="form-sub-headers" id="paymentAmount" type="text"
							placeholder="Payment Amount">
					</div>
					<div class="col-md-4">
						<span class="text-danger" id="paymentAmountValidationMessage">
						</span>
					</div>
				</div>

				<div class="row sub-headers">
					<div class="col-md-4"></div>
					<div class="col-md-4" style="text-align: center;">
						<input class="form-sub-headers" type="button" value="Submit"
							onclick="validateAndSavePayment()"> <input
							class="form-sub-headers" type="reset" name="Reset">
					</div>
					<div class="col-md-4"></div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>