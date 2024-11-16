CREATE TABLE Person (
    PersonId INT PRIMARY KEY AUTO_INCREMENT,
    EGN VARCHAR(20),
    PIK VARCHAR(20),
    FirstName VARCHAR(20),
    LastName VARCHAR(20),
    PhoneNumber VARCHAR(20)
);

CREATE TABLE PersonAD (
    PersonADId INT PRIMARY KEY AUTO_INCREMENT,
    PersonId INT,
    AdmissionDate DATE,
    DischargeDate DATE,
    "Role" VARCHAR(20),
    FOREIGN KEY (PersonId) REFERENCES Person(PersonId)
);

CREATE TABLE Medicine (
    MedicineId INT PRIMARY KEY AUTO_INCREMENT,
    MedicineName VARCHAR(50)
);

CREATE TABLE Prescription (
    PrescriptionId INT PRIMARY KEY AUTO_INCREMENT,
    PersonId INT,
    MedicineId INT,
    "Repeatable" BOOLEAN,
    Frequency VARCHAR(20),
    Dosage VARCHAR(20),
    FOREIGN KEY (PersonId) REFERENCES Person(PersonId),
    FOREIGN KEY (MedicineId) REFERENCES Medicine(MedicineId)
);

CREATE TABLE Allergies (
    AllergyId INT PRIMARY KEY AUTO_INCREMENT,
    Allergy VARCHAR(50) UNIQUE
);

CREATE TABLE Symptoms (
    SymptomId INT PRIMARY KEY AUTO_INCREMENT,
    Symptom VARCHAR(50) UNIQUE
);

CREATE TABLE Sicknesses (
    SicknessId INT PRIMARY KEY AUTO_INCREMENT,
    Sickness VARCHAR(50) UNIQUE
);

CREATE TABLE MedicalRecord (
    MedicalRecordId INT PRIMARY KEY AUTO_INCREMENT,
    PersonId INT,
    Allergy VARCHAR(50),
    Sickness VARCHAR(50),
    Symptom VARCHAR(50),
    FOREIGN KEY (Allergy) REFERENCES Allergies(Allergy),
    FOREIGN KEY (Sickness) REFERENCES Sicknesses(Sickness),
    FOREIGN KEY (Symptom) REFERENCES Symptoms(Symptom),
    FOREIGN KEY (PersonId) REFERENCES Person(PersonId)
);

CREATE TABLE MedicalReport (
    ReportId INT PRIMARY KEY AUTO_INCREMENT,
    PersonId INT NOT NULL,
    Title VARCHAR(100),
    Description VARCHAR(500),
    FOREIGN KEY (PersonId) REFERENCES Person(PersonId)
);