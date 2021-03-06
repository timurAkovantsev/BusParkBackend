CREATE TABLE ROUTES
(
    ID   SERIAL PRIMARY KEY,
    NAME VARCHAR(200) NOT NULL
);

CREATE TABLE DRIVERS
(
    ID   SERIAL PRIMARY KEY,
    NAME VARCHAR(200) NOT NULL
);

CREATE TABLE BUSES
(
    ID        SERIAL PRIMARY KEY,
    NAME      VARCHAR(200) NOT NULL,
    ROUTE_ID  INTEGER,
    DRIVER_ID INTEGER,
    CONSTRAINT FK_ROUTE_ID FOREIGN KEY (ROUTE_ID) REFERENCES ROUTES (ID),
    CONSTRAINT FK_DRIVER_ID FOREIGN KEY (DRIVER_ID) REFERENCES DRIVERS (ID)
);

INSERT INTO ROUTES (NAME)
VALUES ('14В');
INSERT INTO ROUTES (NAME)
VALUES ('10А');
INSERT INTO ROUTES (NAME)
VALUES ('122');

INSERT INTO DRIVERS (NAME)
VALUES ('БРАГИН ВАЛЕРИЙ ОЛЕГОВИЧ');
INSERT INTO DRIVERS (NAME)
VALUES ('ЗОЛОТОВА ВАСИЛИСА СТЕПАНОВНА');
INSERT INTO DRIVERS (NAME)
VALUES ('ВАСИЛЬЕВ АЛЕКСЕЙ ЮРЬЕВИЧ');
INSERT INTO DRIVERS (NAME)
VALUES ('ИВАНОВ ВИТАЛИЙ ПАВЛОВИЧ');
INSERT INTO DRIVERS (NAME)
VALUES ('ЛЕВИН МАКСИМ ЭДУАРДОВИЧ');

INSERT INTO BUSES (NAME, ROUTE_ID, DRIVER_ID)
VALUES ('с065мк', 1, 1);
INSERT INTO BUSES (NAME, ROUTE_ID, DRIVER_ID)
VALUES ('в143нс', 1, 2);
INSERT INTO BUSES (NAME, ROUTE_ID, DRIVER_ID)
VALUES ('у959кт', 2, 3);
INSERT INTO BUSES (NAME, ROUTE_ID, DRIVER_ID)
VALUES ('м678ве', 3, 4);
