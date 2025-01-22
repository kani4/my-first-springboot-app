DROP TABLE IF EXISTS product;

CREATE TABLE product (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         name VARCHAR(255) NOT NULL,
                         price DECIMAL(10,2)
);

ALTER TABLE product
    ADD COLUMN active BOOLEAN DEFAULT true;