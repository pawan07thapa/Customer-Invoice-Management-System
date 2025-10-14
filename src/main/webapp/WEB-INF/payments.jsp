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
                <input type="button" value="Filter" onclick="getPaymentByCustomerId()" class="btn btn-primary" style="margin: 5px;">
                <input type="reset" value="Reset" class="btn btn-secondary" style="margin: 5px;">
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
                            <td><span class="badge badge-info">${payment.id}</span></td>
                            <td>${payment.customerId}</td>
                            <td><strong>${payment.invoiceNumber}</strong></td>
                            <td><span class="badge badge-success">${payment.paymentVoucher}</span></td>
                            <td>${payment.paymentDate}</td>
                            <td style="color: #28a745; font-weight: 600;">$${payment.paymentAmount}</td>
                            <td>
                                <button id="delete" onclick="deletePayment(${payment.id})" title="Delete Payment" class="btn btn-danger">
                                    <i class="fas fa-trash"></i> Delete
                                </button>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>

        <div class="stat-card" style="margin-top: 30px;">
            <div class="stat-icon" style="background: var(--success-gradient);">
                <i class="fas fa-list"></i>
            </div>
            <div class="stat-content">
                <div class="stat-number">${listOfPayments.size()}</div>
                <div class="stat-label">Total Payments</div>
            </div>
        </div>
    </div>
</body>
</html>
