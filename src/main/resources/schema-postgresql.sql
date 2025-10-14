
CREATE SCHEMA IF NOT EXISTS cmis;

-- Create the customer table
CREATE TABLE IF NOT EXISTS cmis.customer (
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    address TEXT,
    phone_number VARCHAR(20),
    email VARCHAR(255),
    company VARCHAR(255),
    created_by VARCHAR(255),
    created_on TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    modified_by VARCHAR(255),
    modified_on TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Create the invoice table
CREATE TABLE IF NOT EXISTS cmis.invoice (
    id SERIAL PRIMARY KEY,
    customer_id INT REFERENCES cmis.customer(id),
    invoice_number VARCHAR(255),
    invoice_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    invoice_due_date TIMESTAMP,
    invoice_amount DECIMAL(10, 2),
    status VARCHAR(50),
    created_by VARCHAR(255),
    created_on TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    modified_by VARCHAR(255),
    modified_on TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Create the payment table
CREATE TABLE IF NOT EXISTS cmis.payment (
    id SERIAL PRIMARY KEY,
    customer_id INT REFERENCES cmis.customer(id),
    invoice_id INT REFERENCES cmis.invoice(id),
    payment_voucher VARCHAR(255),
    payment_amount DECIMAL(10, 2),
    created_by VARCHAR(255),
    created_on TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    modified_by VARCHAR(255),
    modified_on TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
