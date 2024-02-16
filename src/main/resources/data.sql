-- Insert initial data (all fields are required which cannot be null)
-- users
INSERT IGNORE INTO Users (username,email, credit_amount, debit_amount) VALUES ('tony','tony023@test.com', 0, 0);
INSERT IGNORE INTO Users (username,email, credit_amount, debit_amount) VALUES ('garry','garry009@test.com', 0, 0);
INSERT IGNORE INTO Users (username,email, credit_amount, debit_amount) VALUES ('julie','julie001@test.com', 0, 0);

-- users_group
INSERT IGNORE INTO group_table (name) VALUES ('Trip');

-- user - group linking
INSERT IGNORE INTO users_group_map (user_id, group_id) VALUES (1, 1);
INSERT IGNORE INTO users_group_map (user_id, group_id) VALUES (2, 1);

-- transaction to group ('Trip')
INSERT IGNORE INTO transactions (amount_paid, group_id, user_id) VALUES (100, 1, 1);
SET @last_id := LAST_INSERT_ID();
INSERT IGNORE INTO expense_share_records (share, transaction_id, user_id) VALUES (1, @last_id, 1);
INSERT IGNORE INTO expense_share_records (share, transaction_id, user_id) VALUES (1, @last_id, 2);
