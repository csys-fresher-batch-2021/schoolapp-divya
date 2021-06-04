create table staff_data(staff_name varchar(30) not null primary key,staff_password varchar(15) not null,staff_class varchar(10) not null,staff_mobile_number bigint not null,staff_email_id varchar(30) not null,CONSTRAINT UC_staff_data UNIQUE (staff_password));


insert into staff_data values('M.LAKSHMI','Rlakshmi@123','XI','8070605040','laksram@gmail.com');