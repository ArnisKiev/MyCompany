create table Roles(
    ROLE_ID number generated always as identity,
    ROLE_NAME nvarchar2(100) not null unique,
    constraint PK_ROLES primary key (ROLE_ID)
);

insert into ROLES (ROLE_NAME) values ('admin');
insert into ROLES (ROLE_NAME) values ('user');
insert into ROLES (ROLE_NAME) values ('moder');
insert into ROLES (ROLE_NAME) values ('editor');
insert into ROLES (ROLE_NAME) values ('manager');

select * from ROLES;



create table STATUSES(
    STATUS_ID number generated always as identity,
    STATUS_NAME nvarchar2(100) not null unique,
    constraint PK_STATUSES primary key (STATUS_ID)
);

insert into STATUSES (STATUS_NAME) values ('pending');
insert into STATUSES (STATUS_NAME) values ('newuser');
insert into STATUSES (STATUS_NAME) values ('stable');
insert into STATUSES (STATUS_NAME) values ('friend');
insert into STATUSES (STATUS_NAME) values ('blocked');
insert into STATUSES (STATUS_NAME) values ('staff');


select * from STATUSES;


create table USERS(
    USER_ID number generated always as identity,
    LOGIN nvarchar2(100) not null,
    PASSW nvarchar2(100) not null,
    EMAIL nvarchar2(100) not null unique,
    REGDATE date default SYSDATE,
    ROLE_ID number not null,
    STATUS_ID number not null,
    MAIL_CONFIRM number(1,0) default 0,
    constraint PK_USERS primary key (USER_ID),
    constraint FK_USERS_ROLES foreign key (ROLE_ID) references ROLES (ROLE_ID),
    constraint FK_USERS_STATUSES foreign key (STATUS_ID) references STATUSES (STATUS_ID)
);

select * from USERS;