 
INSERT Person(name,surname,birthday) Values('Josias','Aparicio','1996-02-02');
 
 /* Create DATABASE MProject_v1;

use MProject_v1;

-- 1 Person
Create table IF NOT EXISTS Person(
idPerson INT primary key,
name TEXT,
surname TEXT,
birthday DATE	
)ENGINE = InnoDB;

-- 2 PersonInfo
Create table IF NOT EXISTS Personalnfo(
idPersonalInfo INT auto_increment primary key,
idPerson INT,
phone TEXT,
cellphone TEXT,
Foreign	key (idPerson) REFERENCES Person(idPerson)
)ENGINE = InnoDB;


-- 3 Medicalcondition
  CREATE TABLE IF NOT EXISTS Medicalcondition (
  idMedicalcondition INT auto_increment  PRIMARY KEY,
  description text
  )ENGINE = InnoDB;

  
-- 4 Person_Medicalcondition 
CREATE TABLE IF NOT EXISTS Person_Medicalcondition(
  idPerson_Medicalcondition INT auto_increment  PRIMARY KEY,
  idPerson INT,
  idMedicalcondition INT ,
  FOREIGN KEY (idPerson) REFERENCES Person(idPerson),
  FOREIGN KEY (idMedicalcondition) REFERENCES Medicalcondition(idMedicalcondition)
  )ENGINE = InnoDB;
 
 
 
 
-- 5 Doctor
CREATE TABLE IF NOT EXISTS Doctor (
  idDoctor INT auto_increment  PRIMARY KEY,
  profesionalId text,
  speciality text ,
  idPerson INT,
  FOREIGN KEY (idPerson) REFERENCES Person(idPerson)
  )ENGINE = InnoDB;
  
  
  -- 6 account
CREATE TABLE IF NOT EXISTS Account (
  idAccount INT auto_increment  PRIMARY KEY,
  username text,
  password text ,
  idPerson INT,
  FOREIGN KEY (idPerson) REFERENCES Person(idPerson)
  )ENGINE = InnoDB;
  
  
  -- 7 Role
CREATE TABLE IF NOT EXISTS Role (
  idRole INT auto_increment  PRIMARY KEY,
  description text
  )ENGINE = InnoDB;
  
    
  -- 8 Role_Account
CREATE TABLE IF NOT EXISTS Role_Account (
  idRole_account INT auto_increment  PRIMARY KEY,
  idAccount INT,
  idRole INT,
  FOREIGN KEY (idRole) REFERENCES Role(idRole),
  FOREIGN KEY (idAccount) REFERENCES Account(idAccount)
  )ENGINE = InnoDB;
  
    
  -- 9 Permission  
  CREATE TABLE IF NOT EXISTS Permission (
  idPermission INT auto_increment  PRIMARY KEY,
  description text
  )ENGINE = InnoDB;
  
  
   -- 10 Permission_Role  
  CREATE TABLE IF NOT EXISTS Permission_Role (
  idPermission_role INT auto_increment  PRIMARY KEY,
  idPermission INT,
  idRole INT,
  FOREIGN KEY (idPermission) REFERENCES Permission(idPermission),
  FOREIGN KEY (idRole) REFERENCES Role(idRole)
  )ENGINE = InnoDB;
  
  
-- Dont be used this one below : 

*/


