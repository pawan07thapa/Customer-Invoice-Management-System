<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Add New Customer - CMIS</title>
<jsp:include page="script.jsp"></jsp:include>
<script type="text/javascript" src="./js/customer.js"></script>
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
    .form-header p {
        color: #666;
        font-size: 16px;
    }
    .form-group {
        margin-bottom: 25px;
    }
    .form-group label {
        display: block;
        font-weight: 600;
        color: #333;
        margin-bottom: 8px;
        font-size: 14px;
    }
    .form-group label i {
        color: #667eea;
        margin-right: 8px;
        width: 20px;
    }
    .form-control {
        width: 100%;
        padding: 12px 15px;
        border: 2px solid #e0e0e0;
        border-radius: 8px;
        font-size: 15px;
        transition: all 0.3s ease;
        box-sizing: border-box;
    }
    .form-control:focus {
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
        padding-top: 20px;
        border-top: 1px solid #e0e0e0;
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
    .btn-reset:hover {
        background: #5a6268;
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
    .alert-error {
        background: #f8d7da;
        color: #721c24;
        border-left: 4px solid #dc3545;
    }
    .required {
        color: #dc3545;
    }
    @media (max-width: 768px) {
        .form-row {
            grid-template-columns: 1fr;
        }
        .form-container {
            padding: 25px;
        }
    }
</style>
</head>
<body>
    <div class="container">
        <jsp:include page="header.jsp"></jsp:include>
        
        <div class="form-container">
            <div class="form-header">
                <h2><i class="fas fa-user-plus"></i> Add New Customer</h2>
                <p>Fill in the customer information below</p>
            </div>
            
            <div id="messageAlert" class="alert-message alert-success">
                <i class="fas fa-check-circle"></i> <span id="successMessage"></span>
            </div>
            
            <div id="errorAlert" class="alert-message alert-error">
                <i class="fas fa-exclamation-circle"></i> <span id="errorMessage"></span>
            </div>
            
            <form id="customerForm">
                <div class="form-row">
                    <div class="form-group">
                        <label for="firstName">
                            <i class="fas fa-user"></i>First Name<span class="required">*</span>
                        </label>
                        <input type="text" class="form-control" id="firstName" name="firstName" 
                               placeholder="Enter first name" required>
                    </div>
                    
                    <div class="form-group">
                        <label for="lastName">
                            <i class="fas fa-user"></i>Last Name<span class="required">*</span>
                        </label>
                        <input type="text" class="form-control" id="lastName" name="lastName" 
                               placeholder="Enter last name" required>
                    </div>
                </div>
                
                <div class="form-group">
                    <label for="email">
                        <i class="fas fa-envelope"></i>Email Address<span class="required">*</span>
                    </label>
                    <input type="email" class="form-control" id="email" name="email" 
                           placeholder="customer@example.com" required>
                </div>
                
                <div class="form-group">
                    <label for="phoneNumber">
                        <i class="fas fa-phone"></i>Phone Number<span class="required">*</span>
                    </label>
                    <input type="tel" class="form-control" id="phoneNumber" name="phoneNumber" 
                           placeholder="(555) 123-4567" required>
                </div>
                
                <div class="form-group">
                    <label for="address">
                        <i class="fas fa-map-marker-alt"></i>Address<span class="required">*</span>
                    </label>
                    <textarea class="form-control" id="address" name="address" rows="3" 
                              placeholder="Enter full address" required></textarea>
                </div>
                
                <div class="form-group">
                    <label for="company">
                        <i class="fas fa-building"></i>Company<span class="required">*</span>
                    </label>
                    <input type="text" class="form-control" id="company" name="company" 
                           placeholder="Company name" required>
                </div>
                
                <div class="btn-group">
                    <button type="button" onclick="addCustomer()" class="btn-submit">
                        <i class="fas fa-save"></i> Save Customer
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
