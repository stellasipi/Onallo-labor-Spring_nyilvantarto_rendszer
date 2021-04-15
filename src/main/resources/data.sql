--Default cleaning data
INSERT INTO room (id, name) VALUES (1, 'Pince');
INSERT INTO room (id, name) VALUES (2, 'Nagy terem');
INSERT INTO room (id, name) VALUES (3, 'Konyha');
INSERT INTO room (id, name) VALUES (4, 'Középső terem');
INSERT INTO room (id, name) VALUES (5, 'Mosdók');

INSERT INTO cleaning_item (id, name) VALUES (1, 'felmosás');
INSERT INTO cleaning_item (id, name) VALUES (2, 'rekeszek');
INSERT INTO cleaning_item (id, name) VALUES (3, 'lomok');
INSERT INTO cleaning_item (id, name) VALUES (4, 'elrendezés');
INSERT INTO cleaning_item (id, name) VALUES (5, 'konyhapult');
INSERT INTO cleaning_item (id, name) VALUES (6, 'konyhabútor');
INSERT INTO cleaning_item (id, name) VALUES (7, 'mosogatás');
INSERT INTO cleaning_item (id, name) VALUES (8, 'faliújság');
INSERT INTO cleaning_item (id, name) VALUES (9, 'vitrin');
INSERT INTO cleaning_item (id, name) VALUES (10, 'raktár');
INSERT INTO cleaning_item (id, name) VALUES (11, 'tiszta kagylók');
INSERT INTO cleaning_item (id, name) VALUES (12, 'wcpapír');
INSERT INTO cleaning_item (id, name) VALUES (13, 'törülköző');

INSERT INTO room_cleaning_item_pairing (id, room_id,cleaning_item_id) VALUES (1,1,2);
INSERT INTO room_cleaning_item_pairing (id, room_id,cleaning_item_id) VALUES (2,1,1);
INSERT INTO room_cleaning_item_pairing (id, room_id,cleaning_item_id) VALUES (3,2,3);
INSERT INTO room_cleaning_item_pairing (id, room_id,cleaning_item_id) VALUES (4,2,4);
INSERT INTO room_cleaning_item_pairing (id, room_id,cleaning_item_id) VALUES (5,2,1);
INSERT INTO room_cleaning_item_pairing (id, room_id,cleaning_item_id) VALUES (6,3,5);
INSERT INTO room_cleaning_item_pairing (id, room_id,cleaning_item_id) VALUES (7,3,6);
INSERT INTO room_cleaning_item_pairing (id, room_id,cleaning_item_id) VALUES (8,3,7);
INSERT INTO room_cleaning_item_pairing (id, room_id,cleaning_item_id) VALUES (9,3,1);
INSERT INTO room_cleaning_item_pairing (id, room_id,cleaning_item_id) VALUES (10,4,4);
INSERT INTO room_cleaning_item_pairing (id, room_id,cleaning_item_id) VALUES (11,4,8);
INSERT INTO room_cleaning_item_pairing (id, room_id,cleaning_item_id) VALUES (12,4,9);
INSERT INTO room_cleaning_item_pairing (id, room_id,cleaning_item_id) VALUES (13,4,10);
INSERT INTO room_cleaning_item_pairing (id, room_id,cleaning_item_id) VALUES (14,4,1);
INSERT INTO room_cleaning_item_pairing (id, room_id,cleaning_item_id) VALUES (15,5,11);
INSERT INTO room_cleaning_item_pairing (id, room_id,cleaning_item_id) VALUES (16,5,12);
INSERT INTO room_cleaning_item_pairing (id, room_id,cleaning_item_id) VALUES (17,5,13);
INSERT INTO room_cleaning_item_pairing (id, room_id,cleaning_item_id) VALUES (18,5,1);

--Default scout groups
INSERT INTO scout_group (id, name, sex) VALUES (1, 'Krumpli', 0);
INSERT INTO scout_group (id, name, sex) VALUES (2, 'Bambusz', 0);
INSERT INTO scout_group (id, name, sex) VALUES (3, 'Tarkabab', 0);
INSERT INTO scout_group (id, name, sex) VALUES (4, 'Tobzoska', 1);
INSERT INTO scout_group (id, name, sex) VALUES (5, 'Tukán', 1);
INSERT INTO scout_group (id, name, sex) VALUES (6, 'Jaguár', 1);
INSERT INTO scout_group (id, name, sex) VALUES (7, 'Levendula', 0);
INSERT INTO scout_group (id, name, sex) VALUES (8, 'Lótusz', 0);
INSERT INTO scout_group (id, name, sex) VALUES (9, 'Sebespisztráng', 1);
INSERT INTO scout_group (id, name, sex) VALUES (10, 'Szalamandra', 1);
INSERT INTO scout_group (id, name, sex) VALUES (11, 'Cseresznye', 0);
INSERT INTO scout_group (id, name, sex) VALUES (12, 'Jázmin', 0);
INSERT INTO scout_group (id, name, sex) VALUES (13, 'Mangó', 0);
INSERT INTO scout_group (id, name, sex) VALUES (14, 'Puma', 1);
INSERT INTO scout_group (id, name, sex) VALUES (15, 'Sün', 1);
INSERT INTO scout_group (id, name, sex) VALUES (16, 'Szürkefarkas', 1);

--Test data
INSERT INTO log (id, comment, time, type, user_id) VALUES (1, 'Minden rendben', NOW(), 0, 1);
INSERT INTO log (id, time, type, user_id) VALUES (2, NOW(), 0, 2);

INSERT INTO maintenance (id, comment, time, user_id) VALUES (1, 'Elfogyott a citromlé és nyikorog kapu.', NOW(), 1);

INSERT INTO cleaning (id, time, scout_group_id, user_id) VALUES (1, '2021-02-13 17:44:00', 7, 1);
INSERT INTO cleaning (id, time, scout_group_id, user_id) VALUES (2, '2021-03-01 13:17:18', 10, 2);


--cleaning id: 1
INSERT INTO room_cleaning (id, done, cleaning_id, room_cleaning_item_pairing_id) VALUES (1,true,1,1);
INSERT INTO room_cleaning (id, done, cleaning_id, room_cleaning_item_pairing_id) VALUES (2,true,1,2);
INSERT INTO room_cleaning (id, done, cleaning_id, room_cleaning_item_pairing_id) VALUES (3,false,1,3);
INSERT INTO room_cleaning (id, done, cleaning_id, room_cleaning_item_pairing_id) VALUES (4,true,1,4);
INSERT INTO room_cleaning (id, done, cleaning_id, room_cleaning_item_pairing_id) VALUES (5,true,1,5);
INSERT INTO room_cleaning (id, done, cleaning_id, room_cleaning_item_pairing_id) VALUES (6,true,1,6);
INSERT INTO room_cleaning (id, done, cleaning_id, room_cleaning_item_pairing_id) VALUES (7,false,1,7);
INSERT INTO room_cleaning (id, done, cleaning_id, room_cleaning_item_pairing_id) VALUES (8,true,1,8);
INSERT INTO room_cleaning (id, done, cleaning_id, room_cleaning_item_pairing_id) VALUES (9,true,1,9);
INSERT INTO room_cleaning (id, done, cleaning_id, room_cleaning_item_pairing_id) VALUES (10,false,1,10);
INSERT INTO room_cleaning (id, done, cleaning_id, room_cleaning_item_pairing_id) VALUES (11,true,1,11);
INSERT INTO room_cleaning (id, done, cleaning_id, room_cleaning_item_pairing_id) VALUES (12,true,1,12);
INSERT INTO room_cleaning (id, done, cleaning_id, room_cleaning_item_pairing_id) VALUES (13,true,1,13);
INSERT INTO room_cleaning (id, done, cleaning_id, room_cleaning_item_pairing_id) VALUES (14,false,1,14);
INSERT INTO room_cleaning (id, done, cleaning_id, room_cleaning_item_pairing_id) VALUES (15,true,1,15);
INSERT INTO room_cleaning (id, done, cleaning_id, room_cleaning_item_pairing_id) VALUES (16,true,1,16);
INSERT INTO room_cleaning (id, done, cleaning_id, room_cleaning_item_pairing_id) VALUES (17,true,1,17);
INSERT INTO room_cleaning (id, done, cleaning_id, room_cleaning_item_pairing_id) VALUES (18,true,1,18);


--cleaning id: 2
INSERT INTO room_cleaning (id, done, cleaning_id, room_cleaning_item_pairing_id) VALUES (19,false,2,1);
INSERT INTO room_cleaning (id, done, cleaning_id, room_cleaning_item_pairing_id) VALUES (20,false,2,2);
INSERT INTO room_cleaning (id, done, cleaning_id, room_cleaning_item_pairing_id) VALUES (21,false,2,3);
INSERT INTO room_cleaning (id, done, cleaning_id, room_cleaning_item_pairing_id) VALUES (22,false,2,4);
INSERT INTO room_cleaning (id, done, cleaning_id, room_cleaning_item_pairing_id) VALUES (23,false,2,5);
INSERT INTO room_cleaning (id, done, cleaning_id, room_cleaning_item_pairing_id) VALUES (24,false,2,6);
INSERT INTO room_cleaning (id, done, cleaning_id, room_cleaning_item_pairing_id) VALUES (25,false,2,7);
INSERT INTO room_cleaning (id, done, cleaning_id, room_cleaning_item_pairing_id) VALUES (26,false,2,8);
INSERT INTO room_cleaning (id, done, cleaning_id, room_cleaning_item_pairing_id) VALUES (27,false,2,9);
INSERT INTO room_cleaning (id, done, cleaning_id, room_cleaning_item_pairing_id) VALUES (28,false,2,10);
INSERT INTO room_cleaning (id, done, cleaning_id, room_cleaning_item_pairing_id) VALUES (29,true,2,11);
INSERT INTO room_cleaning (id, done, cleaning_id, room_cleaning_item_pairing_id) VALUES (30,false,2,12);
INSERT INTO room_cleaning (id, done, cleaning_id, room_cleaning_item_pairing_id) VALUES (31,true,2,13);
INSERT INTO room_cleaning (id, done, cleaning_id, room_cleaning_item_pairing_id) VALUES (32,false,2,14);
INSERT INTO room_cleaning (id, done, cleaning_id, room_cleaning_item_pairing_id) VALUES (33,true,2,15);
INSERT INTO room_cleaning (id, done, cleaning_id, room_cleaning_item_pairing_id) VALUES (34,true,2,16);
INSERT INTO room_cleaning (id, done, cleaning_id, room_cleaning_item_pairing_id) VALUES (35,true,2,17);
INSERT INTO room_cleaning (id, done, cleaning_id, room_cleaning_item_pairing_id) VALUES (36,true,2,18);