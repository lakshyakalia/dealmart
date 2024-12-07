Drop database IF EXISTS dealmart_db ;

-- Create the database if it doesn't exist
CREATE DATABASE IF NOT EXISTS dealmart_db;

-- Use the database
USE dealmart_db;

-- Create products Table
CREATE TABLE products (
    productId INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    category VARCHAR(100),
    price DECIMAL(10, 2) NOT NULL,
    seller VARCHAR(255),
    totalQuantity INT NOT NULL
);

-- Create users Table
CREATE TABLE users (
    userId INT AUTO_INCREMENT PRIMARY KEY,
    fullName VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    address TEXT,
    phoneNumber VARCHAR(15),
    paymentDetails TEXT
);


-- Create productRatings Table
CREATE TABLE productRatings (
    ratingId INT AUTO_INCREMENT PRIMARY KEY,
    productId INT NOT NULL,
    userId INT NOT NULL,
    review TEXT,
    reviewDate DATETIME NOT NULL,
    FOREIGN KEY (productId) REFERENCES products(productId),
    FOREIGN KEY (userId) REFERENCES users(userId)
);

-- Create shoppingCart Table
CREATE TABLE shoppingCart (
    cartId INT AUTO_INCREMENT PRIMARY KEY,
    userId INT NOT NULL,
    productId INT NOT NULL,
    quantity INT NOT NULL,
    FOREIGN KEY (userId) REFERENCES users(userId),
    FOREIGN KEY (productId) REFERENCES products(productId)
);
-- Create orders Table
CREATE TABLE orders (
    orderId INT AUTO_INCREMENT PRIMARY KEY,
    productId INT NOT NULL,
    quantity INT NOT NULL,
    totalPrice DECIMAL(10, 2) NOT NULL,
    orderDate DATETIME NOT NULL,
    FOREIGN KEY (productId) REFERENCES products(productId)
);

-- Create orderUsers Table
CREATE TABLE orderUsers (
    recordId INT AUTO_INCREMENT PRIMARY KEY,
    orderId INT NOT NULL,
    userId INT NOT NULL,
    FOREIGN KEY (userId) REFERENCES users(userId)
);

