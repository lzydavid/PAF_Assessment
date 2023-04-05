-- user_id,username,name
-- 1b80114c,fred,Fred
-- cf66dae3,wilma,Wilma
-- a8b9800d,barney,Barney
-- 66223e28,betty,Betty


insert into user(user_id,username,name) values ('1b80114c','fred','Fred');
insert into user(user_id,username,name) values ('cf66dae3','wilma','Wilma');
insert into user(user_id,username,name) values ('a8b9800d','barney','Barney');
insert into user(user_id,username,name) values ('66223e28','betty','Betty');

select * from user;
select * from task where user_id ='1b80114c';

select * from user where username = 'fred';

insert into task(user_id,description,priority,due_date) value ('1b80114c','swim',2,'2023-4-4');

select user_id from user where username = 'betty';

