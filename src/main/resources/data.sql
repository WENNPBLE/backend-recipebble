INSERT INTO account (id, name, last_name, description) VALUES (1001, 'Wendy', 'Smits', 'Foodie for life');
INSERT INTO recipe (id, cooking, difficulty, meal, name,  time, account_recipe) VALUES (1001, 'baking', 'easy', 'snack', 'appleturnover', 60, 1001);
INSERT INTO recipe (id, cooking, difficulty, meal, name,  time, account_recipe ) VALUES (1002, 'baking', 'easy', 'snack', 'applepie', 120, 1001);
INSERT INTO ingredient (id, name, type, unit ) VALUES (1001, 'apple(s)', 'fruit', 'pieces');
INSERT INTO ingredient (id, name, type, unit ) VALUES (1002, 'raisin(s)', 'fruit', 'gram');
INSERT INTO recipe_ingredient (recipe_id, ingredient_id, amount ) VALUES (1001, 1001, '5');
INSERT INTO recipe_ingredient (recipe_id, ingredient_id, amount ) VALUES (1002, 1001, '8');
INSERT INTO recipe_ingredient (recipe_id, ingredient_id, amount ) VALUES (1001, 1002, '20');
INSERT INTO recipe_ingredient (recipe_id, ingredient_id, amount ) VALUES (1002, 1002, '50');

INSERT INTO users (username, password, email, enabled) VALUES ('user', '$2a$10$wPHxwfsfTnOJAdgYcerBt.utdAvC24B/DWfuXfzKBSDHO0etB1ica','user@test.nl', TRUE);
INSERT INTO users (username, password, email, enabled) VALUES ('admin', '$2a$10$wPHxwfsfTnOJAdgYcerBt.utdAvC24B/DWfuXfzKBSDHO0etB1ica', 'admin@test.nl', TRUE);

INSERT INTO authorities (username, authority) VALUES ('user', 'ROLE_USER');
INSERT INTO authorities (username, authority) VALUES ('admin', 'ROLE_USER');
INSERT INTO authorities (username, authority) VALUES ('admin', 'ROLE_ADMIN');