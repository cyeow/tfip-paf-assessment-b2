-- create database
CREATE DATABASE todo;

USE todo;

-- create user table
CREATE TABLE user (
    user_id VARCHAR(8) NOT NULL PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    name VARCHAR(50)
);

-- create task table
CREATE TABLE task (
    task_id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    description VARCHAR(255) NOT NULL,
    priority INT NOT NULL,
    due_date DATE NOT NULL,
    user_id VARCHAR(8) NOT NULL,
    FOREIGN KEY (user_id) REFERENCES user(user_id),
    CHECK (priority >= 1 AND priority <= 3)
);