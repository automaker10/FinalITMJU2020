CREATE DATABASE IF NOT EXISTS stlpapp;
use stlpapp;
CREATE TABLE Login (
	username VARCHAR ( 20 ) NOT NULL,
	password VARCHAR ( 20 ) NOT NULL,
    type INTEGER NOT NULL,
	CONSTRAINT PK_Login PRIMARY KEY (username)
	);
CREATE TABLE Person (
	username VARCHAR(20) NOT NULL,
	nameperson VARCHAR ( 40 ) NOT NULL,
	emailperson VARCHAR ( 40 ) NOT NULL,
	telperson VARCHAR ( 15 ) NOT NULL,
	CONSTRAINT PK_Person PRIMARY KEY (username),
	CONSTRAINT FK_Login FOREIGN KEY (username) REFERENCES Login(username)
	);
CREATE TABLE IDCardType (
	idcardno VARCHAR ( 13 ) NOT NULL,
	idcardcall VARCHAR ( 255 ) NOT NULL,
	idcardmean VARCHAR ( 500 ) NOT NULL,
	idcardjob VARCHAR ( 500 ) NOT NULL,
	benefitsfromgovern VARCHAR ( 1000 ) NOT NULL,
	CONSTRAINT PK_IDCardType PRIMARY KEY (idcardno)
	);
CREATE TABLE StatelessPerson (
	username VARCHAR(20) NOT NULL,
	gender VARCHAR ( 5 ) NOT NULL,
	birthday date NOT NULL,
	religion VARCHAR ( 25 ) NOT NULL,
	ethnic VARCHAR ( 50 ) NOT NULL,
	nationality VARCHAR ( 50 ) NOT NULL,
	homeid VARCHAR ( 25 ) NOT NULL,
	idcard VARCHAR ( 14 ) NOT NULL,
	statusmarry INTEGER(1) NOT NULL,
	nameofspouse VARCHAR ( 50 ),
	idcardofspouse VARCHAR ( 14 ),
	nationalityofspouse VARCHAR ( 50 ),
	dateofmarry VARCHAR ( 20 ),
	addressofspouse VARCHAR ( 255 ),
	StatusPlaceOfBirth SMALLINT NOT NULL,
	StatusThaiOrAbroadBirth SMALLINT NOT NULL,
	HospitalOfBirth VARCHAR ( 255 ),
	AddressOfVillageBirth VARCHAR ( 255 ),
	StatusWitness boolean NOT NULL,
	CountryofBirth VARCHAR ( 50 ),
	DistrictComeThai VARCHAR ( 20 ),
	DateComeThai VARCHAR ( 20 ),
	ModeComeThai VARCHAR ( 25 ),
    idcardno VARCHAR ( 13 ) NOT NULL,
	CONSTRAINT PK_StatelessPerson PRIMARY KEY (username),
    CONSTRAINT FK_Person_StatelessPerson FOREIGN KEY (username) REFERENCES Person(username),
    CONSTRAINT FK_IDCardType FOREIGN KEY (idcardno) REFERENCES IDCardType(idcardno)
	);
CREATE TABLE Witness (
	WitnessID INTEGER NOT NULL,
	NameWitness VARCHAR ( 50 ) NOT NULL,
	Relationship VARCHAR ( 20 ) NOT NULL,
	StatusBeAlive boolean NOT NULL,
	AddressWitness VARCHAR ( 255 ) NOT NULL,
	username VARCHAR(20) NOT NULL,
	CONSTRAINT PK_Witness PRIMARY KEY (WitnessID),
    CONSTRAINT FK_StatelessPerson_Witness FOREIGN KEY (username) REFERENCES StatelessPerson(username)
	);
CREATE TABLE Address (
	AddressID INTEGER NOT NULL,
	DetailAddress VARCHAR ( 255 ) NOT NULL,
	FromYears INTEGER(5) NOT NULL,
	ToYears INTEGER(5) NOT NULL,
	HomeStatus INTEGER(1) NOT NULL,
	StatusAddress INTEGER(1) NOT NULL,
	username VARCHAR(20) NOT NULL,
	CONSTRAINT PK_Address PRIMARY KEY (AddressID),
    CONSTRAINT FK_StatelessPerson_Address FOREIGN KEY (username) REFERENCES StatelessPerson(username)
	);
CREATE TABLE Education (
	EducationID INTEGER NOT NULL,
	Educationlevel VARCHAR ( 50 ) NOT NULL,
	username VARCHAR(20) NOT NULL,
	CONSTRAINT PK_Education PRIMARY KEY (EducationID),
    CONSTRAINT FK_StatelessPerson_Education FOREIGN KEY (username) REFERENCES StatelessPerson(username)
	);
CREATE TABLE Parent (
	ParentID INTEGER NOT NULL,
	Name VARCHAR ( 50 ) NOT NULL,
	StatusBeAlive boolean NOT NULL,
	Birthday VARCHAR ( 20 ),
	IDCard VARCHAR ( 14 ) NOT NULL,
	Ethnic VARCHAR ( 50 ) NOT NULL,
	Nationality VARCHAR ( 50 ) NOT NULL,
	DateComeThai VARCHAR ( 20 ),
	Address VARCHAR ( 255 ) NOT NULL,
	StatusParent INTEGER(1) NOT NULL,
	username VARCHAR(20) NOT NULL,
	CONSTRAINT PK_Parent PRIMARY KEY (ParentID),
    CONSTRAINT FK_StatelessPerson_Parent FOREIGN KEY (username) REFERENCES StatelessPerson(username)
	);
CREATE TABLE Center (
	Telcenter VARCHAR ( 15 ) NOT NULL,
	Namecenter VARCHAR ( 40 ) NOT NULL,
	Emailcenter VARCHAR ( 40 ) NOT NULL,
	Addresscenter VARCHAR ( 255 ) NOT NULL,
	CONSTRAINT PK_Center PRIMARY KEY (Telcenter)
	);
CREATE TABLE RequestForHelp (
	RequestForHelpID INTEGER NOT NULL,
	CerBirth boolean NOT NULL,
	TR1 boolean NOT NULL,
	TR2 boolean NOT NULL,
	TR3 boolean NOT NULL,
	TR0310 boolean NOT NULL,
	TR1Front boolean NOT NULL,
	TR11Part1 boolean NOT NULL,
	BCerBirth boolean NOT NULL,
	BCerPlaceBirth boolean NOT NULL,
	CerRegister boolean NOT NULL,
	TR14 boolean NOT NULL,
	TR13 boolean NOT NULL,
	FMPerson boolean NOT NULL,
	HFMPersonNO2 boolean NOT NULL,
	TRCHK boolean NOT NULL,
	TR38G boolean NOT NULL,
	TR381 boolean NOT NULL,
	CerIDCard boolean NOT NULL,
	ThaiIDCard boolean NOT NULL,
	NotThaiIDCard boolean NOT NULL,
	StatelessIDCard boolean NOT NULL,
	ResidencyCer boolean NOT NULL,
	RefugeeIDCardFromWar boolean NOT NULL,
	StatusRequest INTEGER(1) NOT NULL,
	Telcenter VARCHAR ( 15 ) NOT NULL,
	username VARCHAR(20) NOT NULL,
	CONSTRAINT PK_RequestForHelp PRIMARY KEY (RequestForHelpID),
    CONSTRAINT FK_Center_RequestForHelp FOREIGN KEY (Telcenter) REFERENCES Center(Telcenter),
    CONSTRAINT FK_StatelessPerson_RequestForHelp FOREIGN KEY (username) REFERENCES StatelessPerson(username)
	);
CREATE TABLE MoreRequest (
	MoreRequestID INTEGER NOT NULL,
	WhatStoryForRequest VARCHAR ( 500 ) NOT NULL,
    answer VARCHAR ( 500 ) NOT NULL,
	StatusMRequest INTEGER(1) NOT NULL,
    RequestForHelpID INTEGER NOT NULL,
	CONSTRAINT PK_MoreRequest PRIMARY KEY (MoreRequestID),
    CONSTRAINT FK_RequestForHelp_MoreRequest FOREIGN KEY (RequestForHelpID) REFERENCES RequestForHelp(RequestForHelpID)
	);
CREATE TABLE Staff (
	username VARCHAR(20) NOT NULL,
	Position VARCHAR ( 50 ) NOT NULL,
	Address VARCHAR ( 255 ) NOT NULL,
    statusstaff SMALLINT NOT NULL,
	Telcenter VARCHAR ( 15 ) NOT NULL,
	CONSTRAINT PK_Staff PRIMARY KEY (username),
    CONSTRAINT FK_Person_Staff FOREIGN KEY (username) REFERENCES Person(username),
    CONSTRAINT FK_Center_Staff FOREIGN KEY (Telcenter) REFERENCES Center(Telcenter)
	);
CREATE TABLE Assign (
	AssignID INTEGER NOT NULL,
	FactPerson VARCHAR ( 1000 ),
	FactFatherMother VARCHAR ( 1000 ),
	ForLegalOpinion VARCHAR ( 1000 ),
	PersonStatus VARCHAR ( 1000 ),
	StatusAssign INTEGER(1) NOT NULL,
	RequestForHelpID INTEGER NOT NULL,
	username VARCHAR(20) NOT NULL,
	CONSTRAINT PK_Assign PRIMARY KEY (AssignID),
    CONSTRAINT FK_Staff_Assign FOREIGN KEY (username) REFERENCES Staff(username),
    CONSTRAINT FK_RequestForHelp_Assign FOREIGN KEY (RequestForHelpID) REFERENCES RequestForHelp(RequestForHelpID)
	);

