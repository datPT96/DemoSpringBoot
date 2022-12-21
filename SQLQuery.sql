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

DROP TABLE customers