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
<body>
	<div class="container">
		<jsp:include page="header.jsp"></jsp:include>
		<div>
			<div class="sub-headers">
				<h2>Invoice Details of ${invoice.invoiceNumber} - ${invoice.id}</h2>
			</div>

			<div>
				<div class="row">
					<div class="col-md-4"></div>
					<div class="col-md-2" style="text-align: right;">
						<label>Invoice Id: </label>
					</div>
					<div class="col-md-2" style="text-align: left;">
						<label>${invoice.id}</label>
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
						<label>Invoice Date: </label>
					</div>
					<div class="col-md-4" style="text-align: left;">
						<label>${invoice.invoiceDate}</label>
					</div>
					<div class="col-md-2"></div>
				</div>
				<div class="row">
					<div class="col-md-4"></div>
					<div class="col-md-2" style="text-align: right;">
						<label>Invoice DueDate: </label>
					</div>
					<div class="col-md-4" style="text-align: left;">
						<label>${invoice.invoiceDueDate}</label>
					</div>
					<div class="col-md-2"></div>
				</div>
				<div class="row">
					<div class="col-md-4"></div>
					<div class="col-md-2" style="text-align: right;">
						<label>Invoice Amount: </label>
					</div>
					<div class="col-md-2" style="text-align: left;">
						<label>${invoice.invoiceAmount}</label>
					</div>
					<div class="col-md-4"></div>
				</div>
				<div class="row">
					<div class="col-md-2"></div>
					<div class="col-md-4" style="text-align: right;">
						<label>Invoice Pending Amount: </label>
					</div>
					<div class="col-md-2" style="text-align: left;">
						<label>${invoice.invoicePendingAmount}</label>
					</div>
					<div class="col-md-4"></div>
				</div>
				<div class="row">
					<div class="col-md-4"></div>
					<div class="col-md-2" style="text-align: right;">
						<label>Status: </label>
					</div>
					<div class="col-md-2" style="text-align: left;">
						<label>${invoice.status}</label>
					</div>
					<div class="col-md-4"></div>
				</div>
				
			</div>
		</div>
	</div>
</body>
</html>