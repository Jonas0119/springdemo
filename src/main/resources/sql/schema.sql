-- 创建用户表
CREATE TABLE IF NOT EXISTS users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL,
    registration_date DATE NOT NULL,
    password VARCHAR(100),
    active BOOLEAN DEFAULT TRUE,
    CONSTRAINT uk_username UNIQUE (username),
    CONSTRAINT uk_email UNIQUE (email)
);