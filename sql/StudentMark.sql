create table student_mark(student_roll_number varchar(30) not null primary key ,test_number int,tamil_mark int,english_mark int,mathamatics_mark int,science_mark int,social_mark int,total_mark int,average_mark float(1),grade_Mark char(1),grade_comment varchar(15),CONSTRAINT FK_roll_number FOREIGN KEY (student_roll_number) REFERENCES student_data(student_roll_number) on delete cascade);


