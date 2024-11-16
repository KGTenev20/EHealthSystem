CREATE DATABASE ProjectDatabase

USE ProjectDatabase

CREATE TABLE Person(
	PersonId INT PRIMARY KEY IDENTITY(1,1),
	EGN VARCHAR(20),
	PIK VARCHAR(20),
	FirstName VARCHAR(20),
	LastName VARCHAR(20),
	PhoneNumber VARCHAR(20),
);

CREATE TABLE PersonAD(
	PersonADId INT PRIMARY KEY IDENTITY(1,1),
	PersonId INT,
	AdmissionDate DATE,
	DischargeDate DATE,
	[Role] VARCHAR(20),
	FOREIGN KEY (PersonId) REFERENCES Person(PersonId)
);

CREATE TABLE Medicine(
	MedicineId INT PRIMARY KEY IDENTITY(1,1),
	MedicineName VARCHAR(50),
);

CREATE TABLE Prescription(
	PrescriptionId INT PRIMARY KEY IDENTITY(1,1),
	PersonId INT,
	MedicineId INT,
	[Repeatable] BIT,
	Frequency VARCHAR(20),
	Dosage VARCHAR(20),
	FOREIGN KEY (PersonId) REFERENCES Person(PersonId),
	FOREIGN KEY (MedicineId) REFERENCES Medicine(MedicineId),
);

CREATE TABLE Allergies(
	AllergyId INT PRIMARY KEY IDENTITY(1,1),
	Allergy VARCHAR(50) UNIQUE,
);

CREATE TABLE Symptoms(
	SymptomId INT PRIMARY KEY IDENTITY(1,1),
	Symptom VARCHAR(50) UNIQUE,
);

CREATE TABLE Sicknesses(
	SicknessId INT PRIMARY KEY IDENTITY(1,1),
	Sickness VARCHAR(50) UNIQUE,
);

CREATE TABLE MedicalRecord(
	MedicalRecordId INT PRIMARY KEY IDENTITY(1,1),
	PersonId INT,
	Allergy VARCHAR(50),
	Sickness VARCHAR(50),
	Symptom VARCHAR(50),
	FOREIGN KEY (Allergy) REFERENCES  Allergies(Allergy),
	FOREIGN KEY (Sickness) REFERENCES  Sicknesses(Sickness),
	FOREIGN KEY (Symptom) REFERENCES  Symptoms(Symptom),
	FOREIGN KEY (PersonId) REFERENCES  Person(PersonId),
);

CREATE TABLE MedicalReport (
    ReportId INT IDENTITY(1,1) PRIMARY KEY,
    PersonId INT NOT NULL,
    Title VARCHAR(100),
    Description VARCHAR(500),
    FOREIGN KEY (PersonId) REFERENCES Person(PersonId),
);