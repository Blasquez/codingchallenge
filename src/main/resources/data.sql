INSERT INTO users (name, phone) VALUES ('user 1', '+55 21 983482494');
INSERT INTO users (name, phone) VALUES ('user 2', '+55 21 995746845');
INSERT INTO users (name, phone) VALUES ('user 3', '+55 21 997581237');

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
 

INSERT INTO users_channels (user_id, channel_id) VALUES (1,1); 
INSERT INTO users_channels (user_id, channel_id) VALUES (2,1);
INSERT INTO users_channels (user_id, channel_id) VALUES (2,2);
INSERT INTO users_channels (user_id, channel_id) VALUES (3,1);
INSERT INTO users_channels (user_id, channel_id) VALUES (3,2);
INSERT INTO users_channels (user_id, channel_id) VALUES (3,3);
