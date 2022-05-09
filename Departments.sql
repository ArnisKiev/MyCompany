create table DEPARTMENTS(
DEP_ID number generated always as identity,
DEP_NAME nvarchar2(100) not null unique,
constraint PK_DEPARTMENTS primary key (DEP_ID)
);
insert into DEPARTMENTS (DEP_NAME) values ('Компьютерний відділ');
insert into DEPARTMENTS (DEP_NAME) values ('Виробничий відділ');
insert into DEPARTMENTS (DEP_NAME) values ('фінансовий відділ');
insert into DEPARTMENTS (DEP_NAME) values ('Юридичний відділ');
insert into DEPARTMENTS (DEP_NAME) values ('Відділ продаж');

select * from DEPARTMENTS