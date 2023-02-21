INSERT INTO Student (id, name, email) VALUES (1, 'Ben', 'bhlieberman93@gmail.com');
INSERT INTO Student (id, name, email) VALUES (2, 'Joe', 'jrutkin@gmail.com');
INSERT INTO Student (id, name, email) VALUES (3, 'Mehtab', 'mriar@gmail.com');

INSERT INTO Teacher (name, email) VALUES ('Alex', 'awhite@codefellows.com');
INSERT INTO Teacher (name, email) VALUES ('Roger', 'rreyes@codefellows.com');
INSERT INTO Teacher (name, email) VALUES ('David', 'dsouther@codefellows.com');

INSERT INTO Course (id, name, description, begin_date, end_date) VALUES (1, 'JavaScript 401', 'Advanced JavaScript course going deep into React and Node.js', '2022-08-15', '2022-10-15');
INSERT INTO Course (id, name, description, begin_date, end_date) VALUES (2, 'Java 401', 'Advanced Java course with Spring and Android', '2022-10-15', '2022-12-15');
INSERT INTO Course (id, name, description, begin_date, end_date) VALUES (3, 'JavaScript 201', 'Introductory JavaScript', '2022-06-15', '2022-07-15');

-- INSERT INTO enrolled_students (course_id, student_id) VALUES (1, 1);
-- INSERT INTO enrolled_students (course_id, student_id) VALUES (2, 2);
-- INSERT INTO enrolled_students (course_id, student_id) VALUES (3, 3);