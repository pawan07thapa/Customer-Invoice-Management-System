-- Create the schema if it doesn't exist
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

-- Create a trigger function to update the modified_on column
CREATE OR REPLACE FUNCTION update_modified_on()
RETURNS TRIGGER AS $$
BEGIN
    NEW.modified_on = CURRENT_TIMESTAMP;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

-- Create a trigger to call the function before each update
CREATE TRIGGER update_customer_modified_on
BEFORE UPDATE ON cmis.customer
FOR EACH ROW
EXECUTE FUNCTION update_modified_on();




-- Create the invoice table
CREATE TABLE IF NOT EXISTS cmis.invoice (
    id SERIAL PRIMARY KEY,
    customer_id INT REFERENCES cmis.customer(id), -- Foreign key referencing customer
    invoice_number VARCHAR(255),
    invoice_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    invoice_due_date TIMESTAMP,
    invoice_amount DECIMAL(10, 2), -- Adjust precision and scale as needed
    status VARCHAR(50),
    created_by VARCHAR(255),
    created_on TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    modified_by VARCHAR(255),
    modified_on TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Create a trigger function to update the modified_on column
CREATE OR REPLACE FUNCTION update_invoice_modified_on()
RETURNS TRIGGER AS $$
BEGIN
    NEW.modified_on = CURRENT_TIMESTAMP;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

-- Create a trigger to call the function before each update
CREATE TRIGGER update_invoice_modified_on
BEFORE UPDATE ON cmis.invoice
FOR EACH ROW
EXECUTE FUNCTION update_invoice_modified_on();



-- Create the payment table
CREATE TABLE IF NOT EXISTS cmis.payment (
    id SERIAL PRIMARY KEY,
    customer_id INT REFERENCES cmis.customer(id), -- Foreign key referencing customer
    invoice_id INT REFERENCES cmis.invoice(id), -- Foreign key referencing invoice
    payment_voucher VARCHAR(255),
    payment_amount DECIMAL(10, 2), -- Adjust precision and scale as needed
    created_by VARCHAR(255),
    created_on TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    modified_by VARCHAR(255),
    modified_on TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Create a trigger function to update the modified_on column
CREATE OR REPLACE FUNCTION update_payment_modified_on()
RETURNS TRIGGER AS $$
BEGIN
    NEW.modified_on = CURRENT_TIMESTAMP;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

-- Create a trigger to call the function before each update
CREATE TRIGGER update_payment_modified_on
BEFORE UPDATE ON cmis.payment
FOR EACH ROW
EXECUTE FUNCTION update_payment_modified_on();
