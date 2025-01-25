create database musicapp;
use musicapp;

create table usuario (
cod_usuario integer auto_increment primary key,
nome_usuario varchar(255),
dt_nasc date,
email varchar(100),
senha varchar(13));

create table album (
cod_album integer auto_increment primary key,
nome_album varchar(30),
dt_lanc date,
editora varchar(30),
descricao varchar(255));

create table musico (
cod_musico integer auto_increment primary key,
nome_musico varchar(50),
genero varchar(40));

alter table album
add column cod_musico integer;

alter table album
add constraint fk_cod_musico
foreign key (cod_musico)
references musico(cod_musico);

