CREATE DATABASE CRUDDB;

USE CRUDDB;

CREATE TABLE Employee (
    EmployeeID INT PRIMARY KEY,
    Name VARCHAR(50),
    Department VARCHAR(50),
    Salary DOUBLE
);

CREATE TABLE Student (
    RollNo INT PRIMARY KEY,
    Name VARCHAR(50),
    Course VARCHAR(50),
    Marks DOUBLE
);

INSERT INTO Employee VALUES
(101, 'Chaitanya', 'IT', 50000),
(102, 'Rahul', 'HR', 45000);

INSERT INTO Student VALUES
(1, 'Chaitanya', 'Computer Engineering', 85),
(2, 'Rahul', 'Information Technology', 78);

SELECT * FROM Employee;

SELECT * FROM Student;