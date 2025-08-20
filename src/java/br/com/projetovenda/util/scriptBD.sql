/*Script do banco de dados**/
create database loja;

create table produto(
    codigo serial primary key,
    nome varchar(100),
    marca varchar(50),
    valor numeric(9,2)
);

create table cliente(
    id serial primary key,
    nomec varchar(40),
    cpf char(11),
    telefone varchar(11)
);

create table usuario(
    idu serial primary key,
    nomeu varchar(40),
    email varchar(50),
    senha varchar(30)

);