<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>All Payments - CMIS</title>
<script type="text/javascript" src="./js/payment.js"></script>
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
            <h1><i class="fas fa-credit-card"></i> Payment Management</h1>
            <p class="lead">View and manage all payment records</p>
        </div>

        <div class="text-center" style="margin-bottom: 20px;">
            <span class="text-primary" id="messageAlert"></span>
            <span class="text-danger" id="failedMessageAlert"></span>
        </div>

        <!-- Filter Section -->
        <div class="management-card" style="margin-bottom: 20px;">
            <h3 style="text-align: center;"><i class="fas fa-filter"></i> Filter by Customer</h3>
            <form class="text-center">
                <select id="customerId" class="form-control" style="width: 300px; display: inline-block; margin: 10px;">
                    <option value="0">All Customers</option>
                    <c:forEach var="customer" items="${customers}" varStatus="loop">
                        <option value="${customer.id}">${customer.id} - ${customer.firstName} ${customer.lastName}</option>
                    </c:forEach>
                </select>
                <input type="button" value="Filter" onclick="getPaymentByCustomerId()" style="margin: 5px;">
                <input type="reset" value="Reset" style="margin: 5px;">
                <div class="text-danger">
                    <span id="customerIdValidationMessage"></span>
                </div>
            </form>
        </div>

        <div class="table-responsive">
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th><i class="fas fa-hashtag"></i> ID</th>
                        <th><i class="fas fa-user"></i> Customer ID</th>
                        <th><i class="fas fa-file-invoice"></i> Invoice Number</th>
                        <th><i class="fas fa-receipt"></i> Payment Voucher</th>
                        <th><i class="fas fa-calendar"></i> Payment Date</th>
                        <th><i class="fas fa-dollar-sign"></i> Amount</th>
                        <th><i class="fas fa-cog"></i> Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${listOfPayments}" var="payment" varStatus="loop">
                        <tr id="id-${payment.id}">
                            <td><strong>#${payment.id}</strong></td>
                            <td>${payment.customerId}</td>
                            <td><strong>${payment.invoiceNumber}</strong></td>
                            <td>${payment.paymentVoucher}</td>
                            <td>${payment.paymentDate}</td>
                            <td style="color: #28a745; font-weight: 600;">$${payment.paymentAmount}</td>
                            <td>
                                <button id="delete" onclick="deletePayment(${payment.id})" title="Delete Payment">
                                    <i class="fas fa-trash"></i> Delete
                                </button>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>

        <div class="text-center" style="margin-top: 20px; padding: 15px; background: #f8f9fa; border-radius: 10px;">
            <strong><i class="fas fa-list"></i> Total Payments: ${listOfPayments.size()}</strong>
        </div>
    </div>
</body>
</html>