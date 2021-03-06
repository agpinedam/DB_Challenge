# DB_Challenge

## Creation of DB people


Using mySQL Workench, we have written the following instructions for the creation of the employee, company, children, instituttion, and degree tables, additionally they were filled with some values with the following commands:

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
	idCompany 	INT NOT NULL,
	CONSTRAINT	PK_idEmployee_id  PRIMARY KEY (idEmployee),
	CONSTRAINT 	FK_idCompany  FOREIGN KEY (idCompany)  
			REFERENCES Company  (idCompany) 
			ON DELETE CASCADE ON UPDATE CASCADE
);   
````

````sql
CREATE TABLE children (
	idChild		INT AUTO_INCREMENT PRIMARY KEY,
	idEmployee	INT NOT NULL,
	fullName	VARCHAR(45) NOT NULL,
	birthDate	DATE NOT NULL,
	gender		VARCHAR(20), 
	CONSTRAINT 	FK_idEmployee  FOREIGN KEY (idEmployee)  
			REFERENCES Employee  (idEmployee)
			ON DELETE CASCADE
			ON UPDATE CASCADE
);
````

````sql
CREATE TABLE institution (
	idInstitution	INT NOT NULL,
	idEmployee	INT NOT NULL,
	institutionName VARCHAR(45) NOT NULL,
	CONSTRAINT 	FKey_idEmployee  FOREIGN KEY (idEmployee)  
			REFERENCES Employee  (idEmployee)
                    	ON DELETE CASCADE
			ON UPDATE CASCADE
);
````

````sql
INSERT INTO Company (idCompany, coName, phoneNumber, email, address) VALUES ('1', 'Ara', ' 54136579', 'ara@gmail.com', ' 72 Lancaster rd');
INSERT INTO Company (idCompany, coName, phoneNumber, email, address) VALUES ('2', 'Olimpica', '54335486', 'olimpic@gmail.com', '81 Stevenson st');
INSERT INTO Company (idCompany, coName, phoneNumber, email, address) VALUES ('3', 'Only', '487257', 'only@gmail.com', '12 Oxford st.');
INSERT INTO Company (idCompany, coName, phoneNumber, email, address) VALUES ('4', 'Exito', '7822365', 'extio@gmail.com', '36 Jackson rd.');
INSERT INTO Company (idCompany, coName, phoneNumber, email, address) VALUES ('5', 'PriceSmart', '5522678', 'pricemart@gmail.com', '85 Turbo Ave.');

INSERT INTO Employee (idEmployee, firstName, lastName, email, phoneNumber, address, Salary, birthDate, idCompany) VALUES ('74', 'Goku', 'Kameja', 'gokuz@gmail.com', '523657563', '96 Toohey rd', '2900', '1985-05-23', '5');
INSERT INTO Employee (idEmployee, firstName, lastName, email, phoneNumber, address, Salary, birthDate, idCompany) VALUES ('83', 'Vegueta', 'Vegito', 'vegueta@gmail.com', '6952335', '15 Adelade st', '3800', '1982-04-16', '5');
INSERT INTO Employee (idEmployee, firstName, lastName, email, phoneNumber, address, Salary, birthDate, idCompany) VALUES ('92', 'Krilin', 'Perez', 'krilip@gmail.com', '45623688', '87 Woolbor st', '3500', '1984-09-17', '3');
INSERT INTO Employee (idEmployee, firstName, lastName, email, phoneNumber, address, Salary, birthDate, idCompany) VALUES ('95', 'Natalia', 'Gonzalez', 'natis@gmail.com', '78962426', '42 George av.', '4100', '1979-02-06', '4');
INSERT INTO Employee (idEmployee, firstName, lastName, email, phoneNumber, address, Salary, birthDate, idCompany) VALUES ('64', 'Paola', 'Ramirez', 'paos@gmail.com', '6324584', '37 George st.', '3050', '1990-05-07', '1');

INSERT INTO Children (idChild, idEmployee, fullName, birthDate, gender) VALUES ('1', '74', 'Gohan', '2006-11-14', 'Male');
INSERT INTO Children (idChild, idEmployee, fullName, birthDate, gender) VALUES ('2', '95', 'Diana', '2009-05-24', 'Female');
INSERT INTO Children (idChild, idEmployee, fullName, birthDate, gender) VALUES ('3', '83', 'Trunks', '2016-02-16', 'Male');
INSERT INTO Children (idChild, idEmployee, fullName, birthDate, gender) VALUES ('4', '74', 'Goten', '2016-07-28', 'Male');
INSERT INTO Children (idChild, idEmployee, fullName, birthDate, gender) VALUES ('5', '92', 'Maron', '2017-10-01', 'Female');

INSERT INTO Institution (idInstitution, idEmployee, institutionName) VALUES ('1', '74', 'Harvard University');
INSERT INTO Institution (idInstitution, idEmployee, institutionName) VALUES ('2', '95', 'Stanford University');
INSERT INTO Institution (idInstitution, idEmployee, institutionName) VALUES ('3', '83', 'University of Cambridge');
INSERT INTO Institution (idInstitution, idEmployee, institutionName) VALUES ('4', '74', 'Princeton University');
INSERT INTO Institution (idInstitution, idEmployee, institutionName) VALUES ('5', '92', 'Massachusetts Institute of Technology');
````

### Relations between tables

![plot](relations.png)

### SQL commands

* Select and join Employee and Instituttion tables.
````sql
 SELECT em.*, ins.* From Employee em INNER JOIN Institution ins on em.idEmployee = ins.idEmployee;
````

* Bring the information of the children "Children table" whose parents work in PriceSmart which has an idCompany = 5. Note: Just bring the information from the Children table.
````sql
 SELECT * From Children Where idEmployee in (SELECT idEmployee From Employee Where idCompany in (SELECT idCompany From Company Where idCompany = 5));
````

## Program details

### Dependencies used:
* Hibernate core
* Hibernate entitymager
* Javax persistance
* mysql

### Structure

* ***resources:*** Contains the main and the following actions:
	- Get all the employees from the Employee table.
	- Insert an employee into the Employee table.
	- Update information from an employee in Employee table.
	- Find an employee with the last name from Employee table.
	- Delete an employee from the Employee table. 

**Packages**

* ***resources:*** Contains the package META_INFO that contains persistance.xml, that file contains the configuration for the connection with the database people.
* ***database:*** Have the following classes:
	- _JPAUTIL:_ Allow the connection between the persistence.xlm and the program. Also, generate the entity factory.
	- _BaseQuer:y_ Contains generic actions (add, remove, update, delete, select) using the entity manager.
	- _EmployeeQuery:_ Inherits from BaseQuery and creates specifics actions for the Employee table.
* ***entities:*** Have the class Employee, witch contains the getters and setters for the table columns.
* ***helper:*** Have the class CrudEmployee that aims to display the actions by console and connect the class ModifyDB with the others classes.   
