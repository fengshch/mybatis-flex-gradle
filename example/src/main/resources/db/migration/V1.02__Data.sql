INSERT INTO Users (Username, Email, Password_Hash) VALUES ('john_doe', 'john@example.com', 'hash1234');
INSERT INTO Users (Username, Email, Password_Hash) VALUES ('jane_smith', 'jane@example.com', 'hash5678');
INSERT INTO Users (Username, Email, Password_Hash) VALUES ('alice_jones', 'alice@example.com', 'hash91011');


INSERT INTO Products (Product_Name, Description, Price, Stock) VALUES ('Laptop', '15-inch laptop with 8GB RAM', 799.99, 10);
INSERT INTO Products (Product_Name, Description, Price, Stock) VALUES ('Smartphone', 'Latest model smartphone with 128GB storage', 599.99, 25);
INSERT INTO Products (Product_Name, Description, Price, Stock) VALUES ('Headphones', 'Wireless over-ear headphones', 199.99, 50);

INSERT INTO Orders (User_ID, Total_Amount) VALUES (1, 1399.98);
INSERT INTO Orders (User_ID, Total_Amount) VALUES (2, 599.99);
INSERT INTO Orders (User_ID, Total_Amount) VALUES (3, 199.99);
