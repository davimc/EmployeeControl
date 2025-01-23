INSERT INTO tb_store (name, type) VALUES ('Italy', 1);
INSERT INTO tb_store (name, type) VALUES ('Russian',2);
INSERT INTO tb_store (name, type) VALUES ('United States',2);
INSERT INTO tb_store (name, type) VALUES ('Vietnam',3);
INSERT INTO tb_store (name, type) VALUES ('Brazil',3);


INSERT INTO tb_employee (name,email,gender,store_beloging_id, store_current_id,cpf,password,birth_date,dt_admission, dt_resignation) VALUES ('Sandra de Fatima','sollicitudin@icloud.org','M',2,2,'248.686-73','$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG','1988-10-25','2014-08-01','2018-04-20');
INSERT INTO tb_employee (name,email,gender,store_beloging_id, store_current_id,cpf,password,birth_date,dt_admission, dt_resignation) VALUES ('Astra Brandao','massa.vestibulum@hotmail.net','M',2,2,'286.566-61','$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG','1999-01-27','2018-04-20','2020-11-08');
INSERT INTO tb_employee (name,email,gender,store_beloging_id, store_current_id,cpf,password,birth_date,dt_admission, dt_resignation) VALUES ('Anthony Chaves','dis.parturient@grupotsm.com','M',3,3,'266.349-16','$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG','1975-10-14','2016-02-06','2018-12-01');

INSERT INTO tb_employee (name,email,gender,store_beloging_id, store_current_id,cpf,password,birth_date,dt_admission) VALUES ('Slade Santana','hendrerit@google.edu','M',1,1,'591.252-64','$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG','1975-04-16','2019-01-30');
INSERT INTO tb_employee (name,email,gender,store_beloging_id, store_current_id,cpf,password,birth_date,dt_admission) VALUES ('Randall Candido','feugiat.sed@icloud.edu','M',3,3,'718.348-26','$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG','1976-03-26','2014-12-23');

INSERT INTO tb_employee (name,email,gender,store_beloging_id, store_current_id,cpf,password,birth_date,dt_admission) VALUES ('Cheyenne Carneiro','nunc@outlook.org','M',5,5,'732.962-74','$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG','1979-06-15','2020-11-08');
INSERT INTO tb_employee (name,email,gender,store_beloging_id, store_current_id,cpf,password,birth_date,dt_admission) VALUES ('Alfreda Guimaraes','sapien@grupotsm.net','F',4,4,'176.388-75','$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG','1975-12-09','2017-12-02');
INSERT INTO tb_employee (name,email,gender,store_beloging_id, store_current_id,cpf,password,birth_date,dt_admission) VALUES ('Shea Paiva','cum.sociis.natoque@yahoo.couk','F',2,2,'792.864-48','$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG','1993-05-21','2017-10-11');
INSERT INTO tb_employee (name,email,gender,store_beloging_id, store_current_id,cpf,password,birth_date,dt_admission) VALUES ('Clark Messias','gravida.molestie@aol.net','M',3,3,'695.247-67','$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG','1977-05-05','2015-11-28');
INSERT INTO tb_employee (name,email,gender,store_beloging_id, store_current_id,cpf,password,birth_date,dt_admission) VALUES ('Jeanette Sántos','luctus@grupotsm.org','M',2,2,'254.575-37','$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG','1993-06-14','2016-08-08');


INSERT INTO tb_role (authority) VALUES ('ROLE_OPERATOR');
INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN');

INSERT INTO tb_employee_role (employee_id, role_id) VALUES (1, 1);
INSERT INTO tb_employee_role (employee_id, role_id) VALUES (2, 1);
INSERT INTO tb_employee_role (employee_id, role_id) VALUES (3, 1);
INSERT INTO tb_employee_role (employee_id, role_id) VALUES (4, 1);
INSERT INTO tb_employee_role (employee_id, role_id) VALUES (4, 2);
INSERT INTO tb_employee_role (employee_id, role_id) VALUES (5, 1);
INSERT INTO tb_employee_role (employee_id, role_id) VALUES (5, 2);
INSERT INTO tb_employee_role (employee_id, role_id) VALUES (6, 1);
INSERT INTO tb_employee_role (employee_id, role_id) VALUES (8, 1);
INSERT INTO tb_employee_role (employee_id, role_id) VALUES (7, 1);
INSERT INTO tb_employee_role (employee_id, role_id) VALUES (9, 1);
INSERT INTO tb_employee_role (employee_id, role_id) VALUES (10, 1);

INSERT INTO tb_license(dt_Start, dt_expected, dt_End, reason, employee_id) VALUES ('2022-10-13', '2022-10-14', '2022-10-14', 1, 3);
INSERT INTO tb_license(dt_Start, dt_expected, dt_End, reason, employee_id) VALUES ('2022-11-13', '2022-10-18', '2022-10-14', 2, 2);
INSERT INTO tb_license(dt_Start, dt_expected, dt_End, reason, employee_id) VALUES ('2022-12-13', '2022-10-24', '2022-10-14', 30, 1);

INSERT INTO tb_license(dt_Start, dt_expected, reason, employee_id) VALUES ('2021-01-13', '2023-01-13', 30, 9);
INSERT INTO tb_license(dt_Start, dt_expected, reason, employee_id) VALUES ('2021-01-13', '2023-01-13', 30, 7);
INSERT INTO tb_license(dt_Start, dt_expected, reason, employee_id) VALUES ('2021-01-13', '2023-01-13', 30, 8);


INSERT INTO tb_exchange(id,created_at, dt_start, Employee_generator_id, employee_exchanged_id, expedient,state) VALUES (1,TIMESTAMP '2022-01-13T20:50:07.12345Z','2021-07-13',1,2,1,1)
INSERT INTO tb_exchange_temporary(id,created_at, dt_start, Employee_generator_id, employee_exchanged_id, dt_expected,expedient,state) VALUES (2,TIMESTAMP '2022-01-13T20:50:07.12345Z', '2022-08-13',3,2, '2022-08-16',3,2)
INSERT INTO tb_exchange_temporary(id,created_at, dt_start, Employee_generator_id, dt_expected,expedient,state) VALUES (3,TIMESTAMP '2022-01-13T20:50:07.12345Z', '2022-08-13',10, '2022-08-16',2,3)
INSERT INTO tb_exchange_temporary(id,created_at, dt_start, Employee_generator_id, dt_expected,expedient,state) VALUES (4,TIMESTAMP '2022-01-13T20:50:07.12345Z', '2022-08-13',8, '2022-08-16',1,4)


INSERT INTO tb_request(id, created_at, dt_proposed_start, dt_proposed_end, dt_end, state, employee_id, exchange_id) VALUES (1, TIMESTAMP '2022-01-13T20:50:07.12345Z',  '2022-08-13', '2022-08-16', null, 1, 7, 3);
INSERT INTO tb_request(id, created_at, dt_proposed_start, dt_proposed_end, dt_end, state, employee_id, exchange_id) VALUES (2, TIMESTAMP '2022-01-13T20:50:07.12345Z',  '2022-08-13', '2022-08-16', null, 1, 9, 4);
INSERT INTO tb_request(id, created_at, dt_proposed_start, dt_proposed_end, dt_end, state, employee_id, exchange_id) VALUES (3, TIMESTAMP '2022-01-13T20:50:07.12345Z',  '2022-08-13', '2022-08-16', null, 2, 1, 4);