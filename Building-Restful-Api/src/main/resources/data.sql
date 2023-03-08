INSERT INTO user_details(id,birthdate,name) VALUES (1001,CURRENT_DATE,'Ivan');
INSERT INTO user_details(id,birthdate,name) VALUES (1002,CURRENT_DATE,'Rachmet');


INSERT INTO post(id,description,user_id) VALUES (1,'Awesome',1001);
INSERT INTO post(id,description,user_id) VALUES (2,'Bad',1001);
INSERT INTO post(id,description,user_id) VALUES (3,'Norm',1001);