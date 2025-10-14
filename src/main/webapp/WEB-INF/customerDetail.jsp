<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Customer Details - CMIS</title>
<jsp:include page="script.jsp"></jsp:include>
</head>
<body>
    <div class="container">
        <jsp:include page="header.jsp"></jsp:include>
        
        <div class="jumbotron text-center">
            <h1><i class="fas fa-user-circle"></i> Customer Details</h1>
            <p class="lead">Complete information about the customer</p>
        </div>

        <div class="management-card">
            <h3 style="color: #667eea; margin-bottom: 25px;">
                <i class="fas fa-info-circle"></i> Customer Information
            </h3>
            
            <div class="detail-row">
                <div class="detail-label"><i class="fas fa-id-badge"></i> Customer ID:</div>
                <div class="detail-value"><span class="badge badge-info">${customer.id}</span></div>
            </div>
            
            <div class="detail-row">
                <div class="detail-label"><i class="fas fa-user"></i> First Name:</div>
                <div class="detail-value">${customer.firstName}</div>
            </div>
            
            <div class="detail-row">
                <div class="detail-label"><i class="fas fa-user"></i> Last Name:</div>
                <div class="detail-value">${customer.lastName}</div>
            </div>
            
            <div class="detail-row">
                <div class="detail-label"><i class="fas fa-map-marker-alt"></i> Address:</div>
                <div class="detail-value">${customer.address}</div>
            </div>
            
            <div class="detail-row">
                <div class="detail-label"><i class="fas fa-phone"></i> Phone Number:</div>
                <div class="detail-value">${customer.phoneNumber}</div>
            </div>
            
            <div class="detail-row">
                <div class="detail-label"><i class="fas fa-envelope"></i> Email:</div>
                <div class="detail-value">${customer.email}</div>
            </div>
            
            <div class="detail-row">
                <div class="detail-label"><i class="fas fa-building"></i> Company:</div>
                <div class="detail-value">${customer.company}</div>
            </div>
            
            <div class="text-center" style="margin-top: 30px;">
                <a href="${pageContext.request.contextPath}/showAllCustomers" class="btn btn-primary">
                    <i class="fas fa-arrow-left"></i> Back to Customers
                </a>
            </div>
        </div>
    </div>
</body>
</html>
