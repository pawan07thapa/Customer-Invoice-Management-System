<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Customer Invoice Management System</title>
<script type="text/javascript" src="./js/customer.js"></script>
<jsp:include page="script.jsp"></jsp:include>
<script type="text/javascript">
    var ctx = "<%=request.getContextPath()%>"; 
</script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
</head>

<body>
    <div class="container">
        <jsp:include page="header.jsp"></jsp:include>
        
        <div class="jumbotron text-center">
            <h1><i class="fas fa-users"></i> Customer Management</h1>
            <p class="lead">View and manage all customers</p>
        </div>

        <div class="text-center" style="margin-bottom: 20px;">
            <span class="text-primary" id="messageAlert"></span>
            <span class="text-danger" id="failedMessageAlert"></span>
        </div>

        <div class="alert alert-info" style="background: #e3f2fd; border: none; border-left: 4px solid #667eea; padding: 15px; margin-bottom: 20px;">
            <i class="fas fa-info-circle"></i> <strong>Tip:</strong> Click on any text in the table to modify data, then press 'Update' to save changes.
        </div>

        <table class="table table-bordered">
            <thead>
                <tr>
                    <th><i class="fas fa-id-badge"></i> Customer ID</th>
                    <th><i class="fas fa-user"></i> First Name</th>
                    <th><i class="fas fa-user"></i> Last Name</th>
                    <th><i class="fas fa-map-marker-alt"></i> Address</th>
                    <th><i class="fas fa-phone"></i> Phone Number</th>
                    <th><i class="fas fa-envelope"></i> Email</th>
                    <th><i class="fas fa-building"></i> Company</th>
                    <th><i class="fas fa-cog"></i> Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${listOfCustomers}" var="cus" varStatus="loop">
                    <tr id="id-${cus.id}">
                        <td contenteditable="false"><strong>${cus.id}</strong></td>
                        <td contenteditable="true" id="firstName${cus.id}">${cus.firstName}</td>
                        <td contenteditable="true" id="lasttName${cus.id}">${cus.lastName}</td>
                        <td contenteditable="true" id="address${cus.id}">${cus.address}</td>
                        <td contenteditable="true" id="phoneNumber${cus.id}">${cus.phoneNumber}</td>
                        <td contenteditable="true" id="email${cus.id}">${cus.email}</td>
                        <td contenteditable="true" id="company${cus.id}">${cus.company}</td>
                        <td>
                            <button id="update" onclick="update(${cus.id})" title="Update Customer">
                                <i class="fas fa-save"></i> Update
                            </button>
                            <button id="delete" onclick="deleteCustomer(${cus.id})" title="Delete Customer">
                                <i class="fas fa-trash"></i> Delete
                            </button>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>