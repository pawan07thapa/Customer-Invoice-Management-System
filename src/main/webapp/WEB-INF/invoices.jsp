<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Customer Invoice Management System</title>
<script type="text/javascript" src="./js/invoice.js"></script>
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
            <h1><i class="fas fa-file-invoice"></i> Invoice Management</h1>
            <p class="lead">View and manage all invoices</p>
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
                    <option value="0" ${empty selectedCustomerId or selectedCustomerId == 0 ? 'selected' : ''}>All Customers</option>
                    <c:forEach var="customer" items="${customers}" varStatus="loop">
                        <option value="${customer.id}" ${selectedCustomerId == customer.id ? 'selected' : ''}>
                            ${customer.id} - ${customer.firstName} ${customer.lastName}
                        </option>
                    </c:forEach>
                </select>
                <input id="dropdownSubmit" type="button" value="Filter" onclick="getInvoiceByCustomerId()" style="margin: 5px;">
                <input type="button" value="Clear Filter" onclick="window.location.href='${pageContext.request.contextPath}/showAllInvoices'" style="margin: 5px; background: #6c757d;">
                <div class="text-danger">
                    <span id="customerIdValidationMessage"></span>
                </div>
            </form>
        </div>

        <!-- Show filter info if filtered -->
        <c:if test="${not empty selectedCustomerId and selectedCustomerId != 0}">
            <div class="alert" style="background: #fff3cd; border-left: 4px solid #ffc107; padding: 15px; margin-bottom: 20px; border-radius: 5px;">
                <i class="fas fa-filter"></i> <strong>Filtered View:</strong> Showing invoices for customer ID #${selectedCustomerId}
            </div>
        </c:if>

        <table class="table table-bordered">
            <thead>
                <tr>
                    <th><i class="fas fa-hashtag"></i> ID</th>
                    <th><i class="fas fa-user"></i> Customer ID</th>
                    <th><i class="fas fa-file-alt"></i> Invoice Number</th>
                    <th><i class="fas fa-calendar"></i> Invoice Date</th>
                    <th><i class="fas fa-calendar-check"></i> Due Date</th>
                    <th><i class="fas fa-dollar-sign"></i> Amount</th>
                    <th><i class="fas fa-exclamation-circle"></i> Pending Amount</th>
                    <th><i class="fas fa-info-circle"></i> Status</th>
                    <th><i class="fas fa-cog"></i> Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${listOfInvoices}" var="invoice" varStatus="loop">
                    <tr id="id-${invoice.id}">
                        <td><strong>${invoice.id}</strong></td>
                        <td>${invoice.customerId}</td>
                        <td><strong>${invoice.invoiceNumber}</strong></td>
                        <td>${invoice.invoiceDate}</td>
                        <td>${invoice.invoiceDueDate}</td>
                        <td style="color: #28a745; font-weight: 600;">$${invoice.invoiceAmount}</td>
                        <td style="color: #dc3545; font-weight: 600;">
                            <c:if test="${invoice.invoicePendingAmount > 0}">
                                $${invoice.invoicePendingAmount}
                            </c:if>
                            <c:if test="${invoice.invoicePendingAmount == 0}">
                                <span style="color: #28a745;">Paid</span>
                            </c:if>
                        </td>
                        <td>
                            <c:if test="${invoice.status == 'PAID'}">
                                <span style="background: #28a745; color: white; padding: 5px 10px; border-radius: 5px; font-weight: 600;">
                                    <i class="fas fa-check-circle"></i> PAID
                                </span>
                            </c:if>
                            <c:if test="${invoice.status == 'PENDING'}">
                                <span style="background: #ffc107; color: white; padding: 5px 10px; border-radius: 5px; font-weight: 600;">
                                    <i class="fas fa-clock"></i> PENDING
                                </span>
                            </c:if>
                            <c:if test="${invoice.status == 'OVERDUE'}">
                                <span style="background: #dc3545; color: white; padding: 5px 10px; border-radius: 5px; font-weight: 600;">
                                    <i class="fas fa-exclamation-triangle"></i> OVERDUE
                                </span>
                            </c:if>
                            <c:if test="${invoice.status != 'PAID' && invoice.status != 'PENDING' && invoice.status != 'OVERDUE'}">
                                ${invoice.status}
                            </c:if>
                        </td>
                        <td>
                            <button id="delete" onclick="deleteInvoice(${invoice.id})" title="Delete Invoice">
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