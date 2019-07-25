<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Customer Invoice Management System</title>
<script type="text/javascript" src="./js/invoice.js"></script>

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
			<h2 class=" text-center align-bottom ">List of all Invoices</h2>
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
				<input id ="dropdownSubmit"type="button" value="Submit" onclick="getInvoiceByCustomerId()">
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
					<th>Invoice Date</th>
					<th>Invoice Due Date</th>
					<th>Invoice Amount</th>
					<th>Inovice Pending Amount</th>
					<th>Status</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${listOfInvoices}" var="invoice" varStatus="loop">
					<tr id="id-${invoice.id}">
						<td>${invoice.id}</td>
						<td>${invoice.customerId}</td>
						<td>${invoice.invoiceNumber}</td>
						<td>${invoice.invoiceDate}</td>
						<td>${invoice.invoiceDueDate}</td>
						<td>${invoice.invoiceAmount}</td>
						<!-- Complex Query Here -->
						<td>${invoice.invoicePendingAmount}</td>
						<td>${invoice.status}</td>
						<td>
							<!-- Complex Query Here -->
							<button id="delete" onclick="deleteInvoice(${invoice.id})">Delete</button>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>