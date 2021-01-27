create database IF NOT EXISTS test
    DEFAULT CHARACTER SET utf8;

show databases;

use test;

create table person
(
    id         varchar(25),
    first_name varchar(25),
    last_name  varchar(25)
);

create table car
(
    id        varchar(25),
    person_id varchar(25),
    car_name  varchar(25)
);

drop table car;

alter table person
    add column age int(3);

select *
from person
where first_name like '%yon%';
select id, first_name
from person p
where p.id = '1';

select person0_.id         as id1_1_,
       person0_.age        as age2_1_,
       person0_.first_name as first_na3_1_,
       person0_.last_name  as last_nam4_1_
from person person0_
order by person0_.id
    desc
limit 2;

select person0_.id         as id1_1_,
       person0_.age        as age2_1_,
       person0_.first_name as first_na3_1_,
       person0_.last_name  as last_nam4_1_
from person person0_
order by person0_.id asc
limit 2;

insert into person (id, first_name, last_name)
values ('1', 'yong', 'liang');
insert into person (id, first_name, last_name)
values ('2', 'yingwen', 'tan');

insert into car (id, person_id, car_name)
values ('1001', '1', 'QQ');
insert into car (id, person_id, car_name)
values ('1002', '2', 'Audi');
insert into car (id, person_id, car_name)
values ('1003', '2', 'BWM');

update person
set age=18
where id = '1';


show tables;


# drop table person;
