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
            <h1><i class="fas fa-building"></i> Customer Invoice Management System</h1>
            <p class="lead">Manage your customers, invoices, and payments efficiently</p>
        </div>

        <!-- Statistics Cards -->
        <div class="stats-container">
            <div class="stat-card">
                <div class="stat-icon" style="background: var(--primary-gradient);">
                    <i class="fas fa-users"></i>
                </div>
                <div class="stat-content">
                    <div class="stat-number">${customers.size()}</div>
                    <div class="stat-label">Total Customers</div>
                </div>
            </div>
            
            <div class="stat-card">
                <div class="stat-icon" style="background: var(--secondary-gradient);">
                    <i class="fas fa-file-invoice-dollar"></i>
                </div>
                <div class="stat-content">
                    <div class="stat-number">${invoices.size()}</div>
                    <div class="stat-label">Total Invoices</div>
                </div>
            </div>
            
            <div class="stat-card">
                <div class="stat-icon" style="background: var(--success-gradient);">
                    <i class="fas fa-credit-card"></i>
                </div>
                <div class="stat-content">
                    <div class="stat-number">${payments.size()}</div>
                    <div class="stat-label">Total Payments</div>
                </div>
            </div>
        </div>

        <!-- Management Cards -->
        <div class="row mt-4">
            <!-- Customer Management Card -->
            <div class="col-md-4">
                <div class="management-card">
                    <h3><i class="fas fa-users"></i> Customer Management</h3>
                    <div class="text-center">
                        <a href="${context}/addCustomer" class="btn btn-primary">
                            <i class="fas fa-plus"></i> Add New Customer
                        </a>
                        <a href="${context}/showAllCustomers" class="btn btn-secondary">
                            <i class="fas fa-list"></i> View All Customers
                        </a>
                    </div>
                    <div class="text-center" style="margin-top: 20px;">
                        <form id="customerDetailForm">
                            <label style="font-weight: 600; color: #667eea;"><i class="fas fa-search"></i> Search Customer:</label>
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
                        <a href="${context}/addInvoice" class="btn btn-primary">
                            <i class="fas fa-plus"></i> Add New Invoice
                        </a>
                        <a href="${context}/showAllInvoices" class="btn btn-secondary">
                            <i class="fas fa-list"></i> View All Invoices
                        </a>
                    </div>
                    <div class="text-center" style="margin-top: 20px;">
                        <form id="invoiceDetailForm">
                            <label style="font-weight: 600; color: #667eea;"><i class="fas fa-search"></i> Search Invoice:</label>
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
                        <a href="${context}/addPayment" class="btn btn-primary">
                            <i class="fas fa-plus"></i> Add New Payment
                        </a>
                        <a href="${context}/showAllPayments" class="btn btn-secondary">
                            <i class="fas fa-list"></i> View All Payments
                        </a>
                    </div>
                    <div class="text-center" style="margin-top: 20px;">
                        <form id="paymentDetailForm">
                            <label style="font-weight: 600; color: #667eea;"><i class="fas fa-search"></i> Search Payment:</label>
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
    </div>
</body>
</html>
