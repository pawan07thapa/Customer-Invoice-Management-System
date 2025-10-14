<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Customer Invoice Management System</title>
<jsp:include page="script.jsp"></jsp:include>
<script type="text/javascript" src="./js/home.js"></script>
<script type="text/javascript">
    var ctx = "<%=request.getContextPath()%>";
</script>
</head>
<c:set var="context" value="${pageContext.request.contextPath}" />
<body>
    <div class="container">
        <div class="jumbotron text-center">
            <h1>🏢 Customer Invoice Management System</h1>
            <p class="lead">Manage your customers, invoices, and payments efficiently</p>
        </div>

        <div class="row">
            <!-- Customer Management Card -->
            <div class="col-md-4">
                <div class="management-card">
                    <h3><i class="fas fa-users"></i> Customer Management</h3>
                    <div class="text-center">
                        <a href="${context}/addCustomer">➕ Add New Customer</a>
                        <a href="${context}/showAllCustomers">📋 View All Customers</a>
                    </div>
                    <div class="text-center" style="margin-top: 20px;">
                        <form id="customerDetailForm">
                            <label style="font-weight: 600; color: #667eea;">Search Customer:</label>
                            <select id="customerSelect" class="form-control" style="margin: 10px 0;">
                                <option value="0" selected>Select Customer</option>
                                <c:forEach var="customer" items="${customers}" varStatus="loop">
                                    <option value="${customer.id}">
                                        ${customer.firstName} ${customer.lastName} (#${customer.id})
                                    </option>
                                </c:forEach>
                            </select>
                            <input type="button" id="customerBtn" value="View Details" onclick="getCustomer()" class="btn">
                            <input type="reset" id="customerResetBtn" value="Reset" class="btn">
                        </form>
                    </div>
                </div>
            </div>

            <!-- Invoice Management Card -->
            <div class="col-md-4">
                <div class="management-card">
                    <h3><i class="fas fa-file-invoice"></i> Invoice Management</h3>
                    <div class="text-center">
                        <a href="${context}/addInvoice">➕ Add New Invoice</a>
                        <a href="${context}/showAllInvoices">📋 View All Invoices</a>
                    </div>
                    <div class="text-center" style="margin-top: 20px;">
                        <form id="invoiceDetailForm">
                            <label style="font-weight: 600; color: #667eea;">Search Invoice:</label>
                            <select id="invoiceSelect" class="form-control" style="margin: 10px 0;">
                                <option value="0">Select Invoice</option>
                                <c:forEach var="invoice" items="${invoices}" varStatus="loop">
                                    <option value="${invoice.id}">
                                        ${invoice.invoiceNumber} (#${invoice.id})
                                    </option>
                                </c:forEach>
                            </select>
                            <input type="button" id="invoiceBtn" value="View Details" onclick="getInvoice()" class="btn">
                            <input type="reset" value="Reset" class="btn">
                        </form>
                    </div>
                </div>
            </div>

            <!-- Payment Management Card -->
            <div class="col-md-4">
                <div class="management-card">
                    <h3><i class="fas fa-credit-card"></i> Payment Management</h3>
                    <div class="text-center">
                        <a href="${context}/addPayment">➕ Add New Payment</a>
                        <a href="${context}/showAllPayments">📋 View All Payments</a>
                    </div>
                    <div class="text-center" style="margin-top: 20px;">
                        <form id="paymentDetailForm">
                            <label style="font-weight: 600; color: #667eea;">Search Payment:</label>
                            <select id="paymentSelect" class="form-control" style="margin: 10px 0;">
                                <option value="0">Select Payment</option>
                                <c:forEach var="payment" items="${payments}" varStatus="loop">
                                    <option value="${payment.id}">
                                        ${payment.paymentVoucher} (#${payment.id})
                                    </option>
                                </c:forEach>
                            </select>
                            <input type="button" id="paymentBtn" value="View Details" onclick="getPayment()" class="btn">
                            <input type="reset" value="Reset" class="btn">
                        </form>
                    </div>
                </div>
            </div>
        </div>

        <!-- Quick Stats Section -->
        <div class="row" style="margin-top: 30px;">
            <div class="col-md-12">
                <div class="management-card">
                    <h3 style="text-align: center;">📊 Quick Statistics</h3>
                    <div class="row text-center" style="margin-top: 20px;">
                        <div class="col-md-4">
                            <div style="padding: 20px; background: #e3f2fd; border-radius: 10px;">
                                <h2 style="color: #667eea; margin: 0;">${customers.size()}</h2>
                                <p style="margin: 5px 0 0 0; font-weight: 600;">Total Customers</p>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div style="padding: 20px; background: #f3e5f5; border-radius: 10px;">
                                <h2 style="color: #764ba2; margin: 0;">${invoices.size()}</h2>
                                <p style="margin: 5px 0 0 0; font-weight: 600;">Total Invoices</p>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div style="padding: 20px; background: #e8f5e9; border-radius: 10px;">
                                <h2 style="color: #28a745; margin: 0;">${payments.size()}</h2>
                                <p style="margin: 5px 0 0 0; font-weight: 600;">Total Payments</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Font Awesome for Icons -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
</body>
</html>