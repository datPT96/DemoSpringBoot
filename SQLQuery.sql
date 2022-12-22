USE BookDB
GO

CREATE TABLE customers(
    id INT PRIMARY KEY IDENTITY,
    first_name NVARCHAR(255),
    last_name NVARCHAR(255),
    email NVARCHAR(255),
    is_active BIT
)
GO

SELECT * FROM customers

INSERT INTO customers (first_name, last_name, email, is_active)
VALUES
('Dat', 'PT1', 'datpt1@gmail.com', 1),
('Dat', 'PT2', 'datpt2@gmail.com', 0),
('Dat', 'PT3', 'datpt3@gmail.com', 0)
GO

DROP TABLE customers
