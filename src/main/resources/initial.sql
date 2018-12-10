DROP TABLE  if exists CITY;
CREATE TABLE CITY(
  ID BIGINT PRIMARY KEY AUTO_INCREMENT,
  NAME varchar(100) NOT NULL,
  constraint UK_CITY_NAME unique (NAME)
);

DROP TABLE if exists WEATHER;
CREATE TABLE WEATHER(
	ID BIGINT PRIMARY KEY AUTO_INCREMENT,
	TEMPERATURE DOUBLE NOT NULL,
	WIND_SPEED DOUBLE NOT NULL,
	CREATED_AT TIMESTAMP NOT NULL default CURRENT_TIMESTAMP,
	CITY_ID BIGINT,
	constraint FK_WEATHER_CITY_ID foreign key (CITY_ID) references CITY (ID)
);

DROP TABLE  if exists YAHOO_CITY;
CREATE TABLE YAHOO_CITY(
  ID BIGINT PRIMARY KEY AUTO_INCREMENT,
  CODE varchar(100) NOT NULL,
  CITY_ID BIGINT,
  constraint FK_YAHOO_CITY_CITY_ID foreign key (CITY_ID) references CITY (ID),
  constraint UK_YAHOO_CITY_CITY_ID unique (CITY_ID)
);


insert into city (id, name) values (1, 'moscow');
insert into yahoo_city(id, code, city_id) values (1, 'moscow', 1);
insert into city (id, name) values (2, 'Saint-Petersburg');
insert into yahoo_city(id, code, city_id) values (2, 'Saint-Petersburg', 2);
insert into city (id, name) values (3, 'samara');
insert into yahoo_city(id, code, city_id) values (3, 'samara', 3);