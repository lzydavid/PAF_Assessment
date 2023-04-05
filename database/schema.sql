create database paf;
use paf;
create table user(
	user_id varchar(8) not null,
    username varchar(100) not null,
    name varchar(100),
    constraint user_pk primary key (user_id),
    constraint username_check CHECK (username regexp '^[a-zA-Z0-9]+$')
);

create table task(
	task_id int not null auto_increment,
    user_id varchar(200),
    description tinytext,
    priority int check(priority between 1 and 3),
    due_date date,
    constraint task_pk primary key (task_id),
    constraint user_id foreign key (user_id) references user(user_id)
);
