create table clazz
(
    clazzno int auto_increment
        primary key,
    cname   varchar(55) null
);

create table student
(
    sid     int auto_increment
        primary key,
    sname   varchar(55) null,
    clazzno int null
);

create table user
(
    uid   int(5) primary key auto_increment,
    uname varchar(55),
    pwd   varchar(55)
);

create table employee
(
    eid    int(5) primary key auto_increment,
    ename  varchar(55),
    pwd    varchar(55),
    sex    varchar(55),
    hobby  varchar(55),
    birth  date,
    phone  varchar(55),
    remark varchar(55)
);