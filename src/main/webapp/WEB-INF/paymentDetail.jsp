<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Payment Details - CMIS</title>
<jsp:include page="script.jsp"></jsp:include>
</head>
<body>
    <div class="container">
        <jsp:include page="header.jsp"></jsp:include>
        
        <div class="jumbotron text-center">
            <h1><i class="fas fa-money-check-alt"></i> Payment Details</h1>
            <p class="lead">Complete information about the payment</p>
        </div>

        <div class="management-card">
            <h3 style="color: #667eea; margin-bottom: 25px;">
                <i class="fas fa-info-circle"></i> Payment Information
            </h3>
            
            <div class="detail-row">
                <div class="detail-label"><i class="fas fa-hashtag"></i> Payment ID:</div>
                <div class="detail-value"><span class="badge badge-info">${payment.id}</span></div>
            </div>
            
            <div class="detail-row">
                <div class="detail-label"><i class="fas fa-user"></i> Customer ID:</div>
                <div class="detail-value">${payment.customerId}</div>
            </div>
            
            <div class="detail-row">
                <div class="detail-label"><i class="fas fa-file-invoice"></i> Invoice Number:</div>
                <div class="detail-value"><strong>${payment.invoiceNumber}</strong></div>
            </div>
            
            <div class="detail-row">
                <div class="detail-label"><i class="fas fa-receipt"></i> Payment Voucher:</div>
                <div class="detail-value"><span class="badge badge-success">${payment.paymentVoucher}</span></div>
            </div>
            
            <div class="detail-row">
                <div class="detail-label"><i class="fas fa-calendar"></i> Payment Date:</div>
                <div class="detail-value">${payment.paymentDate}</div>
            </div>
            
            <div class="detail-row">
                <div class="detail-label"><i class="fas fa-dollar-sign"></i> Payment Amount:</div>
                <div class="detail-value" style="color: #28a745; font-size: 1.5rem; font-weight: 700;">$${payment.paymentAmount}</div>
            </div>
            
            <div class="text-center" style="margin-top: 30px;">
                <a href="${pageContext.request.contextPath}/showAllPayments" class="btn btn-primary">
                    <i class="fas fa-arrow-left"></i> Back to Payments
                </a>
            </div>
        </div>
    </div>
</body>
</html>
