drop table if exists user_inf_r2dbc;
-- 创建user_inf表
create table user_inf_r2dbc
(
    user_id  int primary key auto_increment,
    name     varchar(255) not null,
    password varchar(255),
    age      int
);