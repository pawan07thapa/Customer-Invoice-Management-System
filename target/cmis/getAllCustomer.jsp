<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Customer Invoice Management System</title>
<jsp:include page="script.jsp"></jsp:include>
<script type="text/javascript" src="./js/customer.js"></script>
<script type="text/javascript">
			var ctx = "<%=request.getContextPath()%>"; // for every file it has to be mentioned 
</script>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="sub-headers">
		<h3>List Of All Customers</h3>
	</div>

	<span id="mssg"> </span>
	<div style="text-align: center; width: 80%">
		<table>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Address</th>
				<th>Phone Number</th>
				<th>Email</th>
				<th>Company</th>
				<th>Actions</th>
			</tr>
			<c:forEach items="${listOfCustomers}" var="cus" varStatus="loop">
				<tr id="id-${cus.id}">
					<td contenteditable="false">${cus.id}</td>
					<td contenteditable="true">${cus.firstName}</td>
					<td contenteditable="true">${cus.address}</td>
					<td contenteditable="true">${cus.phoneNumber}</td>
					<td contenteditable="true">${cus.email}</td>
					<td contenteditable="true">${cus.company}</td>
					<td>
						<button id="edit" onclick="update(${cus})">Update</button>
						<button id="delete-${cus.id}" onclick="deleteCustomer(${cus.id})">
							Delete</button>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>



