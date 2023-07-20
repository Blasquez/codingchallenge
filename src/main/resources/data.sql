INSERT INTO users (name, phone, email) VALUES ('user 1', '+55 21 983482494', 'email1@test.com');
INSERT INTO users (name, phone, email) VALUES ('user 2', '+55 21 995746845', 'email2@test.com');
INSERT INTO users (name, phone, email) VALUES ('user 3', '+55 21 997581237', 'email3@test.com');
INSERT INTO users (name, phone, email) VALUES ('user 4', '+55 21 997581237', 'email4@test.com');
INSERT INTO users (name, phone, email) VALUES ('user 5', '+55 21 997581237', 'email5@test.com');
INSERT INTO users (name, phone, email) VALUES ('user 6', '+55 21 997581237', 'email6@test.com');
INSERT INTO users (name, phone, email) VALUES ('user 7', '+55 21 997581237', 'email7@test.com');
INSERT INTO users (name, phone, email) VALUES ('user 8', '+55 21 997581237', 'email8@test.com');
INSERT INTO users (name, phone, email) VALUES ('user 9', '+55 21 997581237', 'email9@test.com');
INSERT INTO users (name, phone, email) VALUES ('user 10', '+55 21 997581237', 'email10@test.com');
INSERT INTO users (name, phone, email) VALUES ('user 11', '+55 21 997581237', 'email11@test.com');
INSERT INTO users (name, phone, email) VALUES ('user 12', '+55 21 997581237', 'email12@test.com');

INSERT INTO categories (name) VALUES ('Sports');
INSERT INTO categories (name) VALUES ('Finance');
INSERT INTO categories (name) VALUES ('Films'); 	

INSERT INTO channels (name) VALUES ('SMS'); 
INSERT INTO channels (name) VALUES ('E-mail'); 	
INSERT INTO channels (name) VALUES ('Push Notificacion'); 	


INSERT INTO users_categories (user_id, category_id) VALUES (1,1); 	
INSERT INTO users_categories (user_id, category_id) VALUES (1,2); 	
INSERT INTO users_categories (user_id, category_id) VALUES (2,2); 	
INSERT INTO users_categories (user_id, category_id) VALUES (2,3); 
INSERT INTO users_categories (user_id, category_id) VALUES (3,1); 
INSERT INTO users_categories (user_id, category_id) VALUES (3,3); 


INSERT INTO users_categories (user_id, category_id) VALUES (4,1);
INSERT INTO users_categories (user_id, category_id) VALUES (5,1);
INSERT INTO users_categories (user_id, category_id) VALUES (6,1);
INSERT INTO users_categories (user_id, category_id) VALUES (7,1);
INSERT INTO users_categories (user_id, category_id) VALUES (8,1);
INSERT INTO users_categories (user_id, category_id) VALUES (9,1);
INSERT INTO users_categories (user_id, category_id) VALUES (10,1);
INSERT INTO users_categories (user_id, category_id) VALUES (11,1);
INSERT INTO users_categories (user_id, category_id) VALUES (12,1);

INSERT INTO users_channels (user_id, channel_id) VALUES (1,1); 
INSERT INTO users_channels (user_id, channel_id) VALUES (2,1);
INSERT INTO users_channels (user_id, channel_id) VALUES (2,2);
INSERT INTO users_channels (user_id, channel_id) VALUES (3,1);
INSERT INTO users_channels (user_id, channel_id) VALUES (3,2);
INSERT INTO users_channels (user_id, channel_id) VALUES (3,3);

INSERT INTO users_channels (user_id, channel_id) VALUES (4,2);
INSERT INTO users_channels (user_id, channel_id) VALUES (5,2);
INSERT INTO users_channels (user_id, channel_id) VALUES (6,2);
INSERT INTO users_channels (user_id, channel_id) VALUES (7,2);
INSERT INTO users_channels (user_id, channel_id) VALUES (8,2);
INSERT INTO users_channels (user_id, channel_id) VALUES (9,2);
INSERT INTO users_channels (user_id, channel_id) VALUES (10,2);
INSERT INTO users_channels (user_id, channel_id) VALUES (11,2);
INSERT INTO users_channels (user_id, channel_id) VALUES (12,2);
