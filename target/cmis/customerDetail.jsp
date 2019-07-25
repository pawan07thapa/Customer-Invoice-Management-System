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
	<jsp:include page="header.jsp"></jsp:include>
	<div>
		<div class="sub-headers">
			<h3>Customer Details of
				${customer.firstName} ${customer.lastName}</h3>
		</div>

		<div>
			<div class="row">
				<div class="col-md-4"></div>
				<div class="col-md-2" style="text-align: right;">
					<label>CustomerId: </label>
				</div>
				<div class="col-md-2" style="text-align: left;">
					<label>${customer.id}</label>
				</div>
				<div class="col-md-4"></div>
			</div>
			<div class="row">
				<div class="col-md-4"></div>
				<div class="col-md-2" style="text-align: right;">
					<label>First Name: </label>
				</div>
				<div class="col-md-2" style="text-align: left;">
					<label>${customer.firstName}</label>
				</div>
				<div class="col-md-4"></div>
			</div>
			<div class="row">
				<div class="col-md-4"></div>
				<div class="col-md-2" style="text-align: right;">
					<label>Last Name: </label>
				</div>
				<div class="col-md-2" style="text-align: left;">
					<label>${customer.lastName}</label>
				</div>
				<div class="col-md-4"></div>
			</div>
			<div class="row">
				<div class="col-md-4"></div>
				<div class="col-md-2" style="text-align: right;">
					<label>Address: </label>
				</div>
				<div class="col-md-2" style="text-align: left;">
					<label>${customer.address}</label>
				</div>
				<div class="col-md-4"></div>
			</div>
			<div class="row">
				<div class="col-md-4"></div>
				<div class="col-md-2" style="text-align: right;">
					<label>Phone: </label>
				</div>
				<div class="col-md-2" style="text-align: left;">
					<label>${customer.phoneNumber}</label>
				</div>
				<div class="col-md-4"></div>
			</div>
			<div class="row">
				<div class="col-md-4"></div>
				<div class="col-md-2" style="text-align: right;">
					<label>Email: </label>
				</div>
				<div class="col-md-2" style="text-align: left;">
					<label>${customer.email}</label>
				</div>
				<div class="col-md-4"></div>
			</div>
			<div class="row">
				<div class="col-md-4"></div>
				<div class="col-md-2" style="text-align: right;">
					<label>Company: </label>
				</div>
				<div class="col-md-2" style="text-align: left;">
					<label>${customer.company}</label>
				</div>
				<div class="col-md-4"></div>
			</div>
		</div>
	</div>
</body>
</html>