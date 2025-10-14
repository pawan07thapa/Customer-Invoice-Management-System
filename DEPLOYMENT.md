# Customer Invoice Management System - Deployment Guide

## ✅ Application is Now Running Successfully!

The application has been fixed and is now fully operational.

### 🌐 Access URLs

- **Home Page**: http://localhost:8080/
- **All Customers (JSON API)**: http://localhost:8080/customers
- **All Customers (JSP Page)**: http://localhost:8080/showAllCustomers
- **Add Customer**: http://localhost:8080/addCustomer
- **pgAdmin (Database Management)**: http://localhost:8081
  - Email: `admin@admin.com`
  - Password: `admin`

### 🔧 What Was Fixed

1. **Added JSP Support Dependencies** (pom.xml):
   - `tomcat-embed-jasper` - JSP engine
   - `jakarta.servlet.jsp.jstl-api` - JSTL API
   - `jakarta.servlet.jsp.jstl` - JSTL implementation

2. **Fixed View Resolver Configuration** (application.yml):
   - Corrected SQL initialization properties indentation
   - Added Spring Boot Actuator for monitoring

3. **Fixed JSP View Names** in all controllers:
   - Changed from `"home.jsp"` to `"home"` (Spring adds prefix/suffix automatically)
   - Fixed all view names in:
     - `HomeControllerImpl.java`
     - `CustomerControllerImpl.java`
     - `InvoiceControllerImpl.java`
     - `PaymentControllerImpl.java`

4. **Database Configuration**:
   - PostgreSQL running on port 5432
   - Database name: `cmis`
   - Schema: `cmis`
   - 200 sample customers loaded

### 🚀 How to Run

1. **Build the application**:
   ```bash
   mvn clean package
   ```

2. **Start all services**:
   ```bash
   docker-compose up --build -d
   ```

3. **Check logs**:
   ```bash
   docker-compose logs -f app
   ```

4. **Stop all services**:
   ```bash
   docker-compose down
   ```

5. **Stop and remove volumes** (clean database):
   ```bash
   docker-compose down -v
   ```

### 📊 Database Schema

Tables created in the `cmis` schema:
- `customer` - Customer information
- `invoice` - Invoice records
- `payment` - Payment records

All tables have triggers for automatic `modified_on` timestamp updates.

### 🔍 Available Endpoints

#### Customer Endpoints
- `GET /customers` - Get all customers (JSON)
- `GET /customer/{id}` - Get customer by ID (JSON)
- `POST /customer` - Create new customer (JSON)
- `PUT /customer` - Update customer (JSON)
- `DELETE /customer/{id}` - Delete customer (JSON)
- `GET /showAllCustomers` - Customer list page (JSP)
- `GET /showCustomer?customerId={id}` - Customer detail page (JSP)
- `GET /addCustomer` - Add customer form (JSP)

#### Invoice Endpoints
- `GET /invoices` - Get all invoices (JSON)
- `GET /invoice/{id}` - Get invoice by ID (JSON)
- `POST /invoice` - Create new invoice (JSON)
- `PUT /invoice` - Update invoice (JSON)
- `DELETE /invoice/{id}` - Delete invoice (JSON)
- `GET /showAllInvoices` - Invoice list page (JSP)
- `GET /addInvoice` - Add invoice form (JSP)

#### Payment Endpoints
- `GET /payments` - Get all payments (JSON)
- `GET /payment/{id}` - Get payment by ID (JSON)
- `POST /payment` - Create new payment (JSON)
- `PUT /payment` - Update payment (JSON)
- `DELETE /payment/{id}` - Delete payment (JSON)
- `GET /showAllPayments` - Payment list page (JSP)
- `GET /addPayment` - Add payment form (JSP)

### 🛠️ Troubleshooting

If you encounter issues:

1. **Check if containers are running**:
   ```bash
   docker-compose ps
   ```

2. **View application logs**:
   ```bash
   docker-compose logs app
   ```

3. **Rebuild everything**:
   ```bash
   mvn clean package
   docker-compose down -v
   docker-compose up --build -d
   ```

4. **Check if port 8080 is in use**:
   ```bash
   lsof -i :8080
   ```

### 📝 Notes

- The application runs on **Java 17**
- Uses **Spring Boot 3.3.4**
- Database: **PostgreSQL 16**
- The insert script creates 100 customers (currently showing 200 due to duplicate runs)
- JSP files are located in `src/main/webapp/WEB-INF/`
- View resolver prefix: `/WEB-INF/`, suffix: `.jsp`

### ✅ Verification

Test that everything works:
```bash
# Test home page
curl http://localhost:8080/

# Test API endpoint
curl http://localhost:8080/customers

# Test JSP page
curl http://localhost:8080/showAllCustomers
```

All should return HTTP 200 status.
