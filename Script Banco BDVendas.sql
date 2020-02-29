

CREATE DATABASE DBCLIENT;



GRANT ALL ON *.* TO 'teste'@'%' WITH GRANT OPTION;


flush privileges;


USE DBCLIENT;

/***** TABLE CLIENT *****/
/***** ssh = RG and CPF in brazil, is like a identificatin people in our country*****/
CREATE TABLE tb_client (
  id int auto_increment primary key,
  name varchar(100),
  ssn varchar (30),
  email varchar(200),
  phone varchar(30),
  celphone varchar(30),
  zipcode varchar(100),
  address varchar (255),
  number int,
  complement varchar (200),
  neighborhood varchar (100),
  city varchar (100),
  state varchar (2)
);
/*****************/

/***** TABELA FORNECEDORES *****/
CREATE TABLE tb_provider (
  id int auto_increment primary key,
  name varchar(100),
  EIN varchar (100),
  email varchar(200),
  phone varchar(30),
  celphone varchar(30),
  zipcode varchar(100),
  endereco varchar (255),
  number int,
  complement varchar (200),
  neighborhood varchar (100),
  city varchar (100),
  state varchar (2)
);
/*****************/
