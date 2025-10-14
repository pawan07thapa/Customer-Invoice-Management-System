<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Record New Payment - CMIS</title>
<jsp:include page="script.jsp"></jsp:include>
<script type="text/javascript" src="./js/payment.js"></script>
<script type="text/javascript">
    var ctx = "<%=request.getContextPath()%>";
</script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
<style>
    .form-container {
        max-width: 800px;
        margin: 30px auto;
        background: white;
        padding: 40px;
        border-radius: 15px;
        box-shadow: 0 10px 40px rgba(0, 0, 0, 0.1);
    }
    .form-header {
        text-align: center;
        margin-bottom: 30px;
        padding-bottom: 20px;
        border-bottom: 3px solid #667eea;
    }
    .form-header h2 {
        color: #667eea;
        font-weight: bold;
        margin-bottom: 10px;
    }
    .form-group {
        margin-bottom: 25px;
    }
    .form-group label {
        display: block;
        font-weight: 600;
        color: #333;
        margin-bottom: 8px;
    }
    .form-group label i {
        color: #667eea;
        margin-right: 8px;
    }
    .form-control, .form-select {
        width: 100%;
        padding: 12px 15px;
        border: 2px solid #e0e0e0;
        border-radius: 8px;
        font-size: 15px;
        transition: all 0.3s ease;
        box-sizing: border-box;
    }
    .form-control:focus, .form-select:focus {
        border-color: #667eea;
        outline: none;
        box-shadow: 0 0 0 3px rgba(102, 126, 234, 0.1);
    }
    .form-row {
        display: grid;
        grid-template-columns: 1fr 1fr;
        gap: 20px;
    }
    .btn-group {
        display: flex;
        gap: 15px;
        margin-top: 30px;
    }
    .btn-submit {
        flex: 1;
        padding: 14px 30px;
        background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
        color: white;
        border: none;
        border-radius: 8px;
        font-size: 16px;
        font-weight: 600;
        cursor: pointer;
        transition: all 0.3s ease;
    }
    .btn-submit:hover {
        transform: translateY(-2px);
        box-shadow: 0 8px 20px rgba(102, 126, 234, 0.4);
    }
    .btn-reset {
        flex: 1;
        padding: 14px 30px;
        background: #6c757d;
        color: white;
        border: none;
        border-radius: 8px;
        font-size: 16px;
        font-weight: 600;
        cursor: pointer;
    }
    .alert-message {
        padding: 15px 20px;
        border-radius: 8px;
        margin-bottom: 20px;
        display: none;
    }
    .alert-success {
        background: #d4edda;
        color: #155724;
        border-left: 4px solid #28a745;
    }
    .required {
        color: #dc3545;
    }
    @media (max-width: 768px) {
        .form-row {
            grid-template-columns: 1fr;
        }
    }
</style>
</head>
<body>
    <div class="container">
        <jsp:include page="header.jsp"></jsp:include>
        
        <div class="form-container">
            <div class="form-header">
                <h2><i class="fas fa-credit-card"></i> Record New Payment</h2>
                <p>Record a payment received from customer</p>
            </div>
            
            <div id="messageAlert" class="alert-message alert-success">
                <i class="fas fa-check-circle"></i> <span id="successMessage"></span>
            </div>
            
            <form id="paymentForm">
                <div class="form-group">
                    <label for="customerId">
                        <i class="fas fa-user"></i>Select Customer<span class="required">*</span>
                    </label>
                    <select class="form-select" id="customerId" name="customerId" required>
                        <option value="">-- Choose Customer --</option>
                        <c:forEach var="customer" items="${customers}">
                            <option value="${customer.id}">
                                ${customer.firstName} ${customer.lastName} - ${customer.company}
                            </option>
                        </c:forEach>
                    </select>
                </div>
                
                <div class="form-group">
                    <label for="invoiceNumber">
                        <i class="fas fa-file-invoice"></i>Invoice Number<span class="required">*</span>
                    </label>
                    <input type="text" class="form-control" id="invoiceNumber" name="invoiceNumber" 
                           placeholder="INV-2025-001" required>
                </div>
                
                <div class="form-group">
                    <label for="paymentVoucher">
                        <i class="fas fa-receipt"></i>Payment Voucher<span class="required">*</span>
                    </label>
                    <input type="text" class="form-control" id="paymentVoucher" name="paymentVoucher" 
                           placeholder="PV-2025-001" required>
                </div>
                
                <div class="form-row">
                    <div class="form-group">
                        <label for="paymentDate">
                            <i class="fas fa-calendar"></i>Payment Date<span class="required">*</span>
                        </label>
                        <input type="date" class="form-control" id="paymentDate" name="paymentDate" required>
                    </div>
                    
                    <div class="form-group">
                        <label for="paymentAmount">
                            <i class="fas fa-dollar-sign"></i>Payment Amount<span class="required">*</span>
                        </label>
                        <input type="number" class="form-control" id="paymentAmount" name="paymentAmount" 
                               placeholder="0.00" step="0.01" min="0" required>
                    </div>
                </div>
                
                <div class="btn-group">
                    <button type="button" onclick="addPayment()" class="btn-submit">
                        <i class="fas fa-save"></i> Record Payment
                    </button>
                    <button type="reset" class="btn-reset">
                        <i class="fas fa-redo"></i> Reset Form
                    </button>
                </div>
            </form>
        </div>
    </div>
</body>
</html>
