drop table if exists absence cascade;
drop table if exists customer cascade;
drop table if exists employee cascade;
drop table if exists employee_project_period cascade;
drop table if exists project cascade;
drop table if exists skill cascade;
drop table if exists employee_project cascade;
drop table if exists project_skill cascade;
drop table if exists skill_employee cascade;


create table customer (
	id serial,
	active boolean, 
	age int, 
	email varchar(255), 
	language varchar(255), 
	lastname varchar(255), 
	name varchar(255), 
	password varchar(255), 
	rol varchar(255), 
	primary key (id)	
);

create table employee (
	id serial, 
	hiredate date, 
	primary key (id),
	foreign key (id) references customer (id)
);

create table absence (
	id serial, 
	description varchar(255),
	end_date date, 
	star_date date, 
	type varchar(255), 
	primary key (id),
	foreign key (id) references employee (id)
);

create table project (
	id serial, 
	description varchar(255), 
	end_date date, 
	name varchar(255), 
	star_date date, 
	primary key (id)
);

create table employee_project_period (
	id serial, 
	id_employee int, 
	id_project int,  
	end_date date, 
	star_date date, 
	dedication int,
	primary key (id, id_project, id_employee),
	foreign key (id_project) references project (id),
	foreign key (id_employee) references employee (id)
);



create table skill (
	id serial, 
	description varchar(255),
 	name varchar(255), 
	primary key (id)
);

create table employee_project (
	id_employee int,
	id_project int,
	primary key (id_employee, id_project),
	foreign key (id_project) references project (id),
 	foreign key (id_employee) references employee (id)
);

create table project_skill (
	id_skill int,
	id_project int,
	primary key (id_skill, id_project),
	foreign key (id_skill) references skill (id),
 	foreign key (id_project) references project (id)
);

create table skill_employee (
	id_skill int,
	id_employee int,
	primary key (id_skill, id_employee),
	foreign key (id_skill) references skill (id),
 	foreign key (id_employee) references employee (id)
);



insert into customer values (1, false, 24, 'roqueroMalote@palmareño.com', 'poligloto', 'melenas', 'suajili', '', 'el to crazy de la zona');
insert into employee values (1, current_date);
insert into absence values (1, '', current_date + 1, current_date - 1, '');
insert into project values (1, '', current_date + 1, 'papadopoulus', current_date);
insert into employee_project_period values (1, 1, 1, current_date + 1, current_date - 1, 288);
insert into skill values (1, 'el má chulo de chueca', 'ese tío mirando pa cuenca');
insert into skill_employee values (1, 1);
insert into project_skill values (1, 1);
insert into employee_project values (1, 1);