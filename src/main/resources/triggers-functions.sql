-- Triggers and functions for PostgreSQL (run manually after tables are created)

-- Customer modified_on trigger function
CREATE OR REPLACE FUNCTION update_modified_on()
RETURNS TRIGGER AS $$
BEGIN
    NEW.modified_on = CURRENT_TIMESTAMP;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER update_customer_modified_on
BEFORE UPDATE ON cmis.customer
FOR EACH ROW
EXECUTE FUNCTION update_modified_on();

-- Invoice modified_on trigger function
CREATE OR REPLACE FUNCTION update_invoice_modified_on()
RETURNS TRIGGER AS $$
BEGIN
    NEW.modified_on = CURRENT_TIMESTAMP;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER update_invoice_modified_on
BEFORE UPDATE ON cmis.invoice
FOR EACH ROW
EXECUTE FUNCTION update_invoice_modified_on();

-- Payment modified_on trigger function
CREATE OR REPLACE FUNCTION update_payment_modified_on()
RETURNS TRIGGER AS $$
BEGIN
    NEW.modified_on = CURRENT_TIMESTAMP;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER update_payment_modified_on
BEFORE UPDATE ON cmis.payment
FOR EACH ROW
EXECUTE FUNCTION update_payment_modified_on();
