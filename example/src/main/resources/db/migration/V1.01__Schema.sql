CREATE TABLE IF NOT EXISTS Users (
                       User_ID INT PRIMARY KEY AUTO_INCREMENT,
                       Username VARCHAR(50) NOT NULL,
                       Email VARCHAR(100) NOT NULL,
                       Password_Hash VARCHAR(256) NOT NULL,
                       Created_At TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
CREATE TABLE IF NOT EXISTS Products (
                          Product_ID INT PRIMARY KEY AUTO_INCREMENT,
                          Product_Name VARCHAR(100) NOT NULL,
                          Description VARCHAR(500),
                          Price DECIMAL(10, 2) NOT NULL,
                          Stock INT NOT NULL,
                          Created_At TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
CREATE TABLE IF NOT EXISTS Orders (
                        Order_ID INT PRIMARY KEY AUTO_INCREMENT,
                        User_ID INT NOT NULL,
                        Order_Date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                        Total_Amount DECIMAL(10, 2) NOT NULL,
                        FOREIGN KEY (User_ID) REFERENCES Users(User_ID)
);
