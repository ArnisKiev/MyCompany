create table DEPARTMENTS(
DEP_ID number generated always as identity,
DEP_NAME nvarchar2(100) not null unique,
constraint PK_DEPARTMENTS primary key (DEP_ID)
);
insert into DEPARTMENTS (DEP_NAME) values ('������������ ����');
insert into DEPARTMENTS (DEP_NAME) values ('���������� ����');
insert into DEPARTMENTS (DEP_NAME) values ('���������� ����');
insert into DEPARTMENTS (DEP_NAME) values ('��������� ����');
insert into DEPARTMENTS (DEP_NAME) values ('³��� ������');

select * from DEPARTMENTS