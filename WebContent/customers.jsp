<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Customer Invoice Management System</title>
<script type="text/javascript" src="./js/customer.js"></script>

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
			<h2 class=" text-center align-bottom ">List of all Customers</h2>
			<p class="text-center">
				<span class="text-danger" id="messageAlert"></span>
				<span class="text-danger" id="failedMessageAlert"></span>
				
			</p>
		</div>
		<div class="text-primary" style="margin-bottom: 10px;">*Click on
			the text in below table to modify the data and press 'Update' button
			to save the changes.</div>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>Customer Id</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Address</th>
					<th>Phone Number</th>
					<th>Email</th>
					<th>Company</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${listOfCustomers}" var="cus" varStatus="loop">
					<tr id="id-${cus.id}">
						<td contenteditable="false">${cus.id}</td>
						<td contenteditable="true" id="firstName${cus.id}">${cus.firstName}</td>
						<td contenteditable="true" id="lasttName${cus.id}">${cus.lastName}</td>
						<td contenteditable="true" id="address${cus.id}">${cus.address}
						</td>
						<td contenteditable="true" id="phoneNumber${cus.id}">${cus.phoneNumber}
						</td>
						<td contenteditable="true" id="email${cus.id}">${cus.email}</td>
						<td contenteditable="true" id="company${cus.id}">${cus.company}
						</td>
						<td>
							<button id="update" onclick="update(${cus.id})">Update</button>
							<button id="delete" onclick="deleteCustomer(${cus.id})">Delete</button>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>