create table VACANCIES(
    VACANCY_ID number generated always as identity,
    POSITION nvarchar2(100) not null,
    DEP_ID number not null,
    DUTIES nvarchar2(512) not null,
    SCHEDULE nvarchar2(512) not null,
    SALARY number(10,2) not null,
    QUANTITY number not null,
    constraint PK_VACANCIES primary key (VACANCY_ID),
    constraint FK_VACANCIES_DEPARTMENTS foreign key (DEP_ID) references DEPARTMENTS(DEP_ID) on delete cascade
);
