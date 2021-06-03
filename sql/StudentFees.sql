create table student_fees(student_roll_number varchar(30) not null,month varchar(15)not null,student_fees int,receive_date date,CONSTRAINT FK_roll_number FOREIGN KEY (student_roll_number) REFERENCES student_data(student_roll_number) on delete cascade, CONSTRAINT UC_fees UNIQUE (student_roll_number,month));
