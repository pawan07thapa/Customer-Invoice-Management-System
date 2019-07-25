<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Invoice Invoice Managenent System</title>

<jsp:include page="script.jsp"></jsp:include>
<script type="text/javascript" src="./js/invoice.js"></script>

<script type="text/javascript">
			var ctx = "<%=request.getContextPath()%>";
</script>
</head>
<body>
	<div class="container ">
		<jsp:include page="header.jsp"></jsp:include>
		<div class="align-bottom"
			style="margin-bottom: 10px; padding-bottom: 10px; padding-top: 0px; margin-top: 0px;">
			<h2 class="text-center">Add New Invoice</h2>
			<p class="text-center">
				<span class="text-primary" id="messageAlert"></span>
			</p>
		</div>
		<div class="text-center">
			<form >
			<select id="customerId"
				style="margin-bottom: 10px; padding-bottom: 10px; padding-top: 0px; margin-top: 0px;">
				<option value="0"> CustomerId </option>
				<c:forEach var="customer" items="${customers}" varStatus="loop">
					<option style="text-align:center;"> ${customer.id}</option>
				</c:forEach>
			</select>
			 <input type="reset"  value="Reset">
			<div class="text-danger">
				<span id="customerIdValidationMessage"></span>
			</div>
			</form>
		</div>

		<div>
			<form autocomplete="off" id="addInvoiceForm">
				<div class="row">
					<div class="col-md-4"></div>
					<div class="col-md-2" style="text-align: right;">
						<label> Invoice Number: </label>
					</div>
					<div class="col-md-2" style="text-align: left;">
						<input class="form-sub-headers" id="invoiceNumber" type="text"
							placeholder="Invoice Number" >
					</div>
					<div class="col-md-4">
						<span class="text-danger" id="invoiceNumberValidationMessage"
							style="text-align: left;"> </span>
					</div>
				</div>

				<div class="row">
					<div class="col-md-4"></div>
					<div class="col-md-2" style="text-align: right;">
						<label>Invoice Date: </label>
					</div>
					<div class="col-md-2" style="text-align: left;">
						<input class="form-sub-headers" id="invoiceDate" type="date" value="01/29/2012">
					</div>
					<div class="col-md-4">
						<span class="text-danger" id="invoiceDateValidationMessage">
						</span>
					</div>
				</div>

				<div class="row">
					<div class="col-md-4"></div>
					<div class="col-md-2" style="text-align: right;">
						<label>Invoice DueDate: </label>
					</div>
					<div class="col-md-2" style="text-align: left;">
						<input class="form-sub-headers" id="invoiceDueDate" type="date"
						value="01/29/2020"	>
					</div>
					<div class="col-md-4">
						<span class="text-danger" id="invoiceDueDateValidationMessage">
						</span>
					</div>
				</div>
				<div class="row">
					<div class="col-md-4"></div>
					<div class="col-md-2" style="text-align: right;">
						<label> Invoice Amount: </label>
					</div>
					<div class="col-md-2" style="text-align: left;">
						<input class="form-sub-headers" id="invoiceAmount" type="text"
							placeholder="Invoice Amount" >
					</div>
					<div class="col-md-4">
						<span class="text-danger" id="invoiceAmountValidationMessage">
						</span>
					</div>
				</div>

				<div class="row sub-headers">
					<div class="col-md-4"></div>
					<div class="col-md-4" style="text-align: center;">
												<input class="form-sub-headers" type="button" value="Submit"
													onclick="validateAndSaveInvoice()">
						<input class="form-sub-headers" type="reset" name="Reset">
					</div>
					<div class="col-md-4"></div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>