DROP TABLE IF EXISTS employee;
CREATE TABLE employee (  
empNum 	INT AUTO_INCREMENT  PRIMARY KEY,  
empName	VARCHAR(20) 	NOT NULL,  
empAddress 	VARCHAR(30) 	NOT NULL,  
empPhone   VARCHAR(12) 	DEFAULT NULL	); 