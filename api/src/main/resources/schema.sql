CREATE TABLE IF NOT EXISTS Student (
    id identity,
    name varchar(25) not null,
    email varchar(50) not null
);

CREATE TABLE IF NOT EXISTS Teacher (
    id identity,
    name varchar(25) not null,
    email varchar(50) not null
);

CREATE TABLE IF NOT EXISTS Course (
    id identity,
    name varchar(25) not null,
    description text
);

CREATE TABLE IF NOT EXISTS enrolled_students (
    course_id identity,
    enrolled_id varchar(50) not null
);

-- ALTER TABLE enrolled_students
--     ADD FOREIGN KEY (student_id) REFERENCES Student(id);