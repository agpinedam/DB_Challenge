# DB_Challenge

##Creation of DB people

Using the file Create.sql we have written the following instructions for the creation of the employee, company, children and instituttion tables, additionally they were filled with some values with the following commands:

````sql
CREATE DATABASE PEOPLE;
USE PEOPLE; 
````

````sql
CREATE TABLE Company (
	idCompany	INT PRIMARY KEY,
	coName		VARCHAR(45) NOT NULL,
	phoneNumber	VARCHAR(45) NOT NULL,
	email		VARCHAR(45) NOT NULL,
	address		VARCHAR(45)
);
````

````sql
CREATE TABLE employee (
	idEmployee	INT NOT NULL,
	firstName	VARCHAR(45) NOT NULL,
	lastName	VARCHAR(45) NOT NULL,
	email		VARCHAR(45) NOT NULL,
	phoneNumber	VARCHAR(45) NOT NULL,
	address		VARCHAR(45) NULL,
	Salary		DOUBLE NOT NULL,
	birthDate	DATE NOT NULL,
	idCompany 	INT NOT NULL
	CONSTRAINT	PK_factura_id  PRIMARY KEY (idEmployee)
	CONSTRAINT 	FK_idCompany  FOREIGN KEY (idCompany)  
			REFERENCES Company  (idCompany) 
			ON DELETE CASCADE ON UPDATE CASCADE;	
);   
````

````sql
CREATE TABLE children (
	idChild		INT AUTO_INCREMENT PRIMARY KEY,
	idEmployee	INT NOT NULL,
	fullName		VARCHAR(45) NOT NULL,
	birthDate	DATE NOT NULL,
	gender		VARCHAR(20), 
	CONSTRAINT 	FK_idEmployee  FOREIGN KEY (idEmployee)  
			REFERENCES Employee  (idEmployee)
                    	ON DELETE CASCADE
);
````

````sql
CREATE TABLE institution (
	idInstitution	INT NOT NULL,
	idEmployee	INT NOT NULL,
	institutionName VARCHAR(45) NOT NULL,
	degree		VARCHAR(45) NOT NULL,
	CONSTRAINT 	FKe_idEmployee  FOREIGN KEY (idEmployee)  
			REFERENCES Employee  (idEmployee)
                    	ON DELETE CASCADE ON UPDATE CASCADE
);
````