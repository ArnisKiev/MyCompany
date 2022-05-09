create table EMPLOYEES(
EMP_ID number generated always as identity,
EMP_FULLNAME nvarchar2(100) not null unique,
constraint PK_EMPLOYEES primary key (EMP_ID)
);

insert into EMPLOYEES (EMP_FULLNAME) values ('Stakhniuk Oleksandr');
insert into EMPLOYEES (EMP_FULLNAME) values ('Employee 2');
insert into EMPLOYEES (EMP_FULLNAME) values ('Employee 3');
insert into EMPLOYEES (EMP_FULLNAME) values ('Employee 4');
insert into EMPLOYEES (EMP_FULLNAME) values ('Employee 5');

select * from EMPLOYEES;