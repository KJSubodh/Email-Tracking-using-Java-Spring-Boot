USE mailtracker;

-- Set the time zone for the current session (optional)
-- SET time_zone = 'YOUR_TIMEZONE';

-- Create emails table
CREATE TABLE IF NOT EXISTS emails (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    sender VARCHAR(255) NOT NULL,
    recipient VARCHAR(255) NOT NULL,
    subject VARCHAR(255) NOT NULL,
    content TEXT NOT NULL,
    sent_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    status ENUM('SENT', 'DELIVERED', 'READ', 'BOUNCED') NOT NULL DEFAULT 'SENT',
    last_status_update DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    delivered_at DATETIME DEFAULT NULL,
    read_at DATETIME DEFAULT NULL,
    bounced_at DATETIME DEFAULT NULL,
    is_read BOOLEAN NOT NULL DEFAULT FALSE,
    INDEX idx_sender (sender),
    INDEX idx_recipient (recipient),
    INDEX idx_sent_at (sent_at),
    INDEX idx_status (status)
);

SELECT * FROM emails;

SHOW TABLES;

DESCRIBE emails;
DROP TABLE  email_status_history;
DROP TABLE email_reports;


