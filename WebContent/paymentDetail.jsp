<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Customer Invoice Managenent System</title>

<jsp:include page="script.jsp"></jsp:include>
<script type="text/javascript" src="./js/payment.js"></script>

</head>
<script type="text/javascript">
    	var ctx = "<%=request.getContextPath()%>";
</script>
<body>
	<div class="container">
		<jsp:include page="header.jsp"></jsp:include>
		<div>
			<div class="sub-headers">
				<h2>Payment Details of ${payment.invoiceNumber} - ${payment.id}</h2>
			</div>

			<div>
				<div class="row">
					<div class="col-md-4"></div>
					<div class="col-md-2" style="text-align: right;">
						<label>Payment Id: </label>
					</div>
					<div class="col-md-2" style="text-align: left;">
						<label>${payment.id}</label>
					</div>
					<div class="col-md-4"></div>
				</div>
				<div class="row">
					<div class="col-md-4"></div>
					<div class="col-md-2" style="text-align: right;">
						<label>Customer Id: </label>
					</div>
					<div class="col-md-2" style="text-align: left;">
						<label>${invoice.customerId}</label>
					</div>
					<div class="col-md-4"></div>
				</div>
				<div class="row">
					<div class="col-md-4"></div>
					<div class="col-md-2" style="text-align: right;">
						<label>Invoice Number </label>
					</div>
					<div class="col-md-2" style="text-align: left;">
						<label>${invoice.invoiceNumber}</label>
					</div>
					<div class="col-md-4"></div>
				</div>
				<div class="row">
					<div class="col-md-4"></div>
					<div class="col-md-2" style="text-align: right;">
						<label>Payment Voucher Number </label>
					</div>
					<div class="col-md-4" style="text-align: left;">
						<label>${payment.paymentVoucher}</label>
					</div>
					<div class="col-md-2"></div>
				</div>
				<div class="row">
					<div class="col-md-4"></div>
					<div class="col-md-2" style="text-align: right;">
						<label>Payment Date: </label>
					</div>
					<div class="col-md-4" style="text-align: left;">
						<label>${payment.paymentDate}</label>
					</div>
					<div class="col-md-2"></div>
				</div>
				<div class="row">
					<div class="col-md-4"></div>
					<div class="col-md-2" style="text-align: right;">
						<label>Payment Amount: </label>
					</div>
					<div class="col-md-2" style="text-align: left;">
						<label>${payment.paymentAmount}</label>
					</div>
					<div class="col-md-4"></div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>