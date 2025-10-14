<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Invoice Details - CMIS</title>
<jsp:include page="script.jsp"></jsp:include>
</head>
<body>
    <div class="container">
        <jsp:include page="header.jsp"></jsp:include>
        
        <div class="jumbotron text-center">
            <h1><i class="fas fa-file-invoice-dollar"></i> Invoice Details</h1>
            <p class="lead">Complete information about the invoice</p>
        </div>

        <div class="management-card">
            <h3 style="color: #667eea; margin-bottom: 25px;">
                <i class="fas fa-info-circle"></i> Invoice Information
            </h3>
            
            <div class="detail-row">
                <div class="detail-label"><i class="fas fa-hashtag"></i> Invoice ID:</div>
                <div class="detail-value"><span class="badge badge-info">${invoice.id}</span></div>
            </div>
            
            <div class="detail-row">
                <div class="detail-label"><i class="fas fa-user"></i> Customer ID:</div>
                <div class="detail-value">${invoice.customerId}</div>
            </div>
            
            <div class="detail-row">
                <div class="detail-label"><i class="fas fa-file-alt"></i> Invoice Number:</div>
                <div class="detail-value"><strong>${invoice.invoiceNumber}</strong></div>
            </div>
            
            <div class="detail-row">
                <div class="detail-label"><i class="fas fa-calendar"></i> Invoice Date:</div>
                <div class="detail-value">${invoice.invoiceDate}</div>
            </div>
            
            <div class="detail-row">
                <div class="detail-label"><i class="fas fa-calendar-check"></i> Due Date:</div>
                <div class="detail-value">${invoice.invoiceDueDate}</div>
            </div>
            
            <div class="detail-row">
                <div class="detail-label"><i class="fas fa-dollar-sign"></i> Invoice Amount:</div>
                <div class="detail-value" style="color: #28a745; font-size: 1.3rem;">$${invoice.invoiceAmount}</div>
            </div>
            
            <div class="detail-row">
                <div class="detail-label"><i class="fas fa-exclamation-circle"></i> Pending Amount:</div>
                <div class="detail-value">
                    <c:if test="${invoice.invoicePendingAmount > 0}">
                        <span style="color: #dc3545; font-size: 1.3rem;">$${invoice.invoicePendingAmount}</span>
                    </c:if>
                    <c:if test="${invoice.invoicePendingAmount == 0}">
                        <span class="badge badge-success">Fully Paid</span>
                    </c:if>
                </div>
            </div>
            
            <div class="detail-row">
                <div class="detail-label"><i class="fas fa-info-circle"></i> Status:</div>
                <div class="detail-value">
                    <c:if test="${invoice.status == 'PAID'}">
                        <span class="badge badge-success"><i class="fas fa-check-circle"></i> PAID</span>
                    </c:if>
                    <c:if test="${invoice.status == 'PENDING'}">
                        <span class="badge badge-warning"><i class="fas fa-clock"></i> PENDING</span>
                    </c:if>
                    <c:if test="${invoice.status == 'OVERDUE'}">
                        <span class="badge badge-danger"><i class="fas fa-exclamation-triangle"></i> OVERDUE</span>
                    </c:if>
                </div>
            </div>
            
            <div class="text-center" style="margin-top: 30px;">
                <a href="${pageContext.request.contextPath}/showAllInvoices" class="btn btn-primary">
                    <i class="fas fa-arrow-left"></i> Back to Invoices
                </a>
            </div>
        </div>
    </div>
</body>
</html>
