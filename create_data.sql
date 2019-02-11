create table schiff
	(schiff_id		integer(4) not null,
	beschreibung	varchar(45) not null,
	passagiere		integer(4) not null,
	autos			integer(4) not null,
	primary key(schiff_id)
);

insert into schiff values(5001, 'Sardenia Ferries', 2000, 500);
insert into schiff values(5002, 'Corsica Ferries', 1800, 400);
insert into schiff values(5003, 'Elba Ferries', 800, 250);

create table kabinentyp
	(kabinentyp_id		integer(4) not null,
	beschreibung	varchar(45) not null,
	passagiere		integer(2),
	primary key(kabinentyp_id)
);

insert into kabinentyp values (6001, 'A1', 4);
insert into kabinentyp values (6002, 'B1', 6);
insert into kabinentyp values (6003, 'A2', 6);
insert into kabinentyp values (6004, 'B2', 8);
insert into kabinentyp values (6005, 'C1', 6);
insert into kabinentyp values (6006, 'C2', 8);
	
create table schiff_kabine (
	schiff_id		integer(4) not null references schiff(schiff_id),
	kabinentyp_id	integer(4) not null references kabine(kabinentyp_id),
	anzahl		integer(3) not null,
	preis			double not null,
	kabine_index	integer(2),
	primary key (schiff_id, kabinentyp_id)
);

insert into schiff_kabine values(5001, 6001, 60, 25, 0);
insert into schiff_kabine values(5001, 6002, 60, 30, 1);
insert into schiff_kabine values(5001, 6003, 40, 35, 2);
insert into schiff_kabine values(5001, 6004, 40, 40, 3);
insert into schiff_kabine values(5001, 6005, 20, 40, 4);
insert into schiff_kabine values(5001, 6006, 20, 45, 5);

insert into schiff_kabine values(5002, 6001, 50, 20, 0);
insert into schiff_kabine values(5002, 6002, 50, 25, 1);
insert into schiff_kabine values(5002, 6003, 35, 30, 2);
insert into schiff_kabine values(5002, 6004, 35, 35, 3);
insert into schiff_kabine values(5002, 6005, 20, 40, 4);
insert into schiff_kabine values(5002, 6006, 20, 45, 5);

insert into schiff_kabine values(5003, 6001, 30, 20, 0);
insert into schiff_kabine values(5003, 6002, 30, 25, 1);
insert into schiff_kabine values(5003, 6003, 15, 25, 2);
insert into schiff_kabine values(5003, 6004, 15, 30, 3);
insert into schiff_kabine values(5003, 6005, 10, 35, 4);
insert into schiff_kabine values(5003, 6006, 10, 40, 5);

create table linie (
	linie_id		integer(4),
	schiff_id		integer(4) not null references schiff(schiff_id),
	start			varchar(30) not null,
	ziel			varchar(30) not null,
	primary key (linie_id)
);

insert into linie values(1001, 5001, 'Genua', 'Olbia');
insert into linie values(1002, 5001, 'Olbia', 'Genua');
insert into linie values(1011, 5002, 'Genua', 'Bastia');
insert into linie values(1012, 5002, 'Bastia', 'Genua');
insert into linie values(1021, 5003, 'Piombino', 'Portoferraio');
insert into linie values(1022, 5003, 'Portoferraio', 'Piombino');

create table fahrt(
	fahrt_id		integer(4) not null,
	linie_id		integer(4) not null references linie(linie_id),
	datum			date not null,
	abfahrt		time not null,
	ankunft		time not null,
	preis_auto		double not null,
	preis_passagier	double not null,
	fahrt_index		integer(2),
	primary key (fahrt_id)
);

insert into fahrt values(2001, 1001, '2010-01-05', '07:00:00', '16:00:00', 200, 50, 0);
insert into fahrt values(2002, 1001, '2010-01-12', '07:00:00', '16:00:00', 200, 50, 0);
insert into fahrt values(2003, 1001, '2010-01-19', '07:00:00', '16:00:00', 200, 50, 0);

insert into fahrt values(2011, 1002, '2010-01-05', '20:00:00', '05:00:00', 250, 70, 0);
insert into fahrt values(2012, 1002, '2010-01-12', '20:00:00', '05:00:00', 250, 70, 0);
insert into fahrt values(2013, 1002, '2010-01-19', '20:00:00', '05:00:00', 250, 70, 0);

insert into fahrt values(2021, 1011, '2010-01-06', '08:00:00', '14:00:00', 100, 40, 0);
insert into fahrt values(2022, 1011, '2010-01-10', '08:00:00', '14:00:00', 100, 40, 0);
insert into fahrt values(2023, 1011, '2010-01-14', '08:00:00', '14:00:00', 100, 40, 0);

insert into fahrt values(2031, 1012, '2010-01-06', '18:00:00', '24:00:00', 100, 60, 0);
insert into fahrt values(2032, 1012, '2010-01-10', '18:00:00', '24:00:00', 100, 60, 0);
insert into fahrt values(2033, 1012, '2010-01-14', '18:00:00', '24:00:00', 100, 60, 0);

insert into fahrt values(2041, 1021, '2010-01-06', '08:00:00', '09:30:00', 80, 30, 0);
insert into fahrt values(2042, 1021, '2010-01-06', '12:00:00', '13:30:00', 80, 30, 1);
insert into fahrt values(2043, 1021, '2010-01-10', '08:00:00', '09:30:00', 80, 30, 0);

insert into fahrt values(2051, 1022, '2010-01-06', '16:00:00', '17:30:00', 80, 30, 0);
insert into fahrt values(2052, 1022, '2010-01-06', '20:00:00', '21:30:00', 80, 30, 1);
insert into fahrt values(2053, 1022, '2010-01-10', '16:00:00', '17:30:00', 80, 30, 0);

create table bankverbindung(
	bank_id		integer(8) not null,
	beschreibung	varchar(40) not null,
	primary key (bank_id)
);

create table kunde(
	kunde_id		integer(4) auto_increment,
	bank_id		integer(8) references bankverbindung(bank_id),
	nachname		varchar(40) not null,
	vorname		varchar(40) not null,
	strasse		varchar(50) not null,
	plz			char(5) not null,
	ort			varchar(40) not null,
	konto_nr		integer(9),
	email			varchar(40),
	passwort		varchar(40),
	primary key (kunde_id)
);

create table buchung(
	buchung_id		integer(4) auto_increment,
	fahrt_id		integer(4) references fahrt(fahrt_id),
	kunde_id		integer(4) references kunde(kunde_id),
	autos			integer(2),
	primary key (buchung_id)
);

create table buchung_kabine(
	buchung_id		integer(4) not null references buchung(buchung_id),
	kabinentyp_id	integer(4) not null references kabine(kabinentyp_id),
	kabine_index	integer(2),
	anzahl		integer(3) not null default 1,
	primary key (buchung_id, kabinentyp_id)
);

create table rechnung(
	rechnung_id		integer(4) auto_increment,
	buchung_id		integer(4) references buchung(buchung_id),
	datum			date not null,
	betrag		double not null,
	status		integer(2),
	primary key (rechnung_id)
);

create table reisende(
	reisende_id		integer(4) auto_increment,
	reisende_index	integer(2),
	buchung_id		integer(4) references buchung(buchung_id),
	nachname		varchar(40) not null,
	vorname		varchar(40) not null,
	primary key (reisende_id)
);
