CREATE TABLE IF NOT EXISTS book(
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    price INT,
    gender VARCHAR(255) NOT NULL
);