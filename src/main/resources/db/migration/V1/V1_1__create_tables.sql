CREATE TABLE MEMBER
(
    id VARCHAR(36) NOT NULL PRIMARY KEY,
    name VARCHAR(36) NOT NULL,
    nickname VARCHAR(36) NOT NULL
);

CREATE TABLE COACH
(
    coach_id VARCHAR(36) NOT NULL PRIMARY KEY,
    name VARCHAR(36) NOT NULL
);

CREATE TABLE FITNESS_CLASS
(
    coach_id VARCHAR(36) NOT NULL,
    fitness_class_id VARCHAR(36) NOT NULL,
    start_time TIMESTAMP,
    end_time TIMESTAMP,
    PRIMARY KEY (fitness_class_id)
);

CREATE TABLE FITNESS_CLASSES_MEMBERS
(
    fitness_class_id VARCHAR(36) NOT NULL,
    id VARCHAR(36) NOT NULL
);
