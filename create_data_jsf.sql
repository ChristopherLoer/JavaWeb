create table ship
	(ship_id integer(4) not null,
	description varchar(45) not null,
	passengers integer(4) not null,
	cars integer(4) not null,
	primary key(ship_id)
);

insert into ship values(5001, 'Sardenia Ferries', 2000, 500);
insert into ship values(5002, 'Corsica Ferries', 1800, 400);
insert into ship values(5003, 'Elba Ferries', 800, 250);

create table cabintype
	(cabintype_id integer(4) not null,
	description varchar(45) not null,
	passengers integer(2),
	primary key(cabintype_id)
);

insert into cabintype values (6001, 'A1', 4);
insert into cabintype values (6002, 'B1', 6);
insert into cabintype values (6003, 'A2', 6);
insert into cabintype values (6004, 'B2', 8);
insert into cabintype values (6005, 'C1', 6);
insert into cabintype values (6006, 'C2', 8);
	
create table ship_cabin (
	ship_id integer(4) not null references ship(ship_id),
	cabintype_id integer(4) not null references cabin(cabintype_id),
	count integer(3) not null,
	price double not null,
	cabin_index integer(2),
	primary key (ship_id, cabintype_id)
);

insert into ship_cabin values(5001, 6001, 60, 25, 0);
insert into ship_cabin values(5001, 6002, 60, 30, 1);
insert into ship_cabin values(5001, 6003, 40, 35, 2);
insert into ship_cabin values(5001, 6004, 40, 40, 3);
insert into ship_cabin values(5001, 6005, 20, 40, 4);
insert into ship_cabin values(5001, 6006, 20, 45, 5);

insert into ship_cabin values(5002, 6001, 50, 20, 0);
insert into ship_cabin values(5002, 6002, 50, 25, 1);
insert into ship_cabin values(5002, 6003, 35, 30, 2);
insert into ship_cabin values(5002, 6004, 35, 35, 3);
insert into ship_cabin values(5002, 6005, 20, 40, 4);
insert into ship_cabin values(5002, 6006, 20, 45, 5);

insert into ship_cabin values(5003, 6001, 30, 20, 0);
insert into ship_cabin values(5003, 6002, 30, 25, 1);
insert into ship_cabin values(5003, 6003, 15, 25, 2);
insert into ship_cabin values(5003, 6004, 15, 30, 3);
insert into ship_cabin values(5003, 6005, 10, 35, 4);
insert into ship_cabin values(5003, 6006, 10, 40, 5);

create table route (
	route_id integer(4),
	ship_id integer(4) not null references ship(ship_id),
	start varchar(30) not null,
	destination varchar(30) not null,
	primary key (route_id)
);

insert into route values(1001, 5001, 'Genua', 'Olbia');
insert into route values(1002, 5001, 'Olbia', 'Genua');
insert into route values(1011, 5002, 'Genua', 'Bastia');
insert into route values(1012, 5002, 'Bastia', 'Genua');
insert into route values(1021, 5003, 'Piombino', 'Portoferraio');
insert into route values(1022, 5003, 'Portoferraio', 'Piombino');

create table trip(
	trip_id integer(4) not null,
	route_id integer(4) not null references route(route_id),
	date date not null,
	departure time not null,
	arrival time not null,
	price_car double not null,
	price_passenger double not null,
	trip_index integer(2),
	primary key (trip_id)
);

insert into trip values(2001, 1001, '2015-01-05', '07:00:00', '16:00:00', 200, 50, 0);
insert into trip values(2002, 1001, '2015-01-12', '07:00:00', '16:00:00', 200, 50, 1);
insert into trip values(2003, 1001, '2015-01-19', '07:00:00', '16:00:00', 200, 50, 2);

insert into trip values(2011, 1002, '2015-01-05', '20:00:00', '05:00:00', 250, 70, 0);
insert into trip values(2012, 1002, '2015-01-12', '20:00:00', '05:00:00', 250, 70, 1);
insert into trip values(2013, 1002, '2015-01-19', '20:00:00', '05:00:00', 250, 70, 2);

insert into trip values(2021, 1011, '2015-01-06', '08:00:00', '14:00:00', 100, 40, 0);
insert into trip values(2022, 1011, '2015-01-10', '08:00:00', '14:00:00', 100, 40, 1);
insert into trip values(2023, 1011, '2015-01-14', '08:00:00', '14:00:00', 100, 40, 2);

insert into trip values(2031, 1012, '2015-01-06', '18:00:00', '24:00:00', 100, 60, 0);
insert into trip values(2032, 1012, '2015-01-10', '18:00:00', '24:00:00', 100, 60, 1);
insert into trip values(2033, 1012, '2015-01-14', '18:00:00', '24:00:00', 100, 60, 2);

insert into trip values(2041, 1021, '2015-01-06', '08:00:00', '09:30:00', 80, 30, 0);
insert into trip values(2042, 1021, '2015-01-06', '12:00:00', '13:30:00', 80, 30, 1);
insert into trip values(2043, 1021, '2015-01-10', '08:00:00', '09:30:00', 80, 30, 2);

insert into trip values(2051, 1022, '2015-01-06', '16:00:00', '17:30:00', 80, 30, 0);
insert into trip values(2052, 1022, '2015-01-06', '20:00:00', '21:30:00', 80, 30, 1);
insert into trip values(2053, 1022, '2015-01-10', '16:00:00', '17:30:00', 80, 30, 2);

create table bank(
	bank_id integer(8) not null,
	description varchar(40) not null,
	primary key (bank_id)
);

insert into bank values(11111111, 'SuperBank');

create table customer(
	id integer(4) auto_increment,
	bank_id integer(8) references bank(bank_id),
	name varchar(40) not null,
	firstname varchar(40) not null,
	street varchar(50) not null,
	zipcode char(5) not null,
	city varchar(40) not null,
	account_nr integer(9),
	email varchar(40),
	password varchar(40),
	primary key (id)
);

insert into customer(bank_id, name, firstname, street, zipcode, city, account_nr, email, password) values(11111111, 'test', 'test', 'test', 33106, 'Paderborn', 111111111, 'test@test', 'test');

create table reservation(
	reservation_id integer(4) auto_increment,
	trip_id integer(4) references trip(trip_id),
	customer_id integer(4) references customer(customer_id),
	cars integer(2),
	primary key (reservation_id)
);

create table ID_RES(
    	GEN_KEY varchar(255),
    	GEN_VALUE int(11)
);

create table reservation_cabin(
	reservation_id integer(4) not null references reservation(reservation_id),
	cabintype_id integer(4) not null references cabin(cabintype_id),
	cabin_index integer(2),
	count integer(3) not null default 1,
	primary key (reservation_id, cabintype_id)
);

create table travellers(
	travellers_id integer(4) auto_increment,
	travellers_index integer(2),
	reservation_id integer(4) references reservation(reservation_id),
	fullname varchar(40) not null,
	primary key (travellers_id)
);
