INSERT INTO role(id, name) VALUES(1, 'USER_ROLE');

INSERT INTO app_user(id, password, user_name, id_role) VALUES(1, '$2a$10$EtY4VMtfEh0x7DKWwuLzkOJDkfP2apv2ZvhMUvOVHSllaTwHPxhRi', 'UserTest', 1);
INSERT INTO app_user(id, password, user_name, id_role) VALUES(2, 'test', 'test', 1);
INSERT INTO app_user(id, password, user_name, id_role) VALUES(3, 'user', 'user', 1);