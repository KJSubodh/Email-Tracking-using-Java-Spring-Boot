-- Set the time zone for the current session (optional)
-- SET time_zone = 'YOUR_TIMEZONE';
USE mail_tracker;

CREATE DATABASE mail_tracker; 
SELECT * FROM emails;

SELECT * FROM email_recipients;	

DESCRIBE email_recipients;

DESCRIBE emails;

TRUNCATE TABLE emails;

TRUNCATE TABLE email_recipients;

SET FOREIGN_KEY_CHECKS = 0;
TRUNCATE TABLE emails;
SET FOREIGN_KEY_CHECKS = 1;

-- Modify the emails table to remove the is_read and read_at fields
ALTER TABLE emails
DROP COLUMN is_read,
DROP COLUMN read_at;

ALTER TABLE emails MODIFY COLUMN recipients VARCHAR(255) DEFAULT NULL;

