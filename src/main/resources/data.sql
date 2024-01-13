-- Insert initial data (all fields are required which cannot be null)
-- users
INSERT IGNORE INTO Users (username,email, credit_amount, debit_amount) VALUES ('tony','tony023@test.com', 0, 0);
INSERT IGNORE INTO Users (username,email, credit_amount, debit_amount) VALUES ('garry','garry009@test.com', 0, 0);
INSERT IGNORE INTO Users (username,email, credit_amount, debit_amount) VALUES ('julie','julie001@test.com', 0, 0);

-- users_group
INSERT IGNORE INTO group_table (name) VALUES ('Trip');

-- user - group linking
INSERT IGNORE INTO group_table_users_in_group (groups_group_id, users_in_group_user_id) VALUES (1, 1);
