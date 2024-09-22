CREATE TABLE IF NOT EXISTS emails (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    sender VARCHAR(255) NOT NULL,
    recipients TEXT NOT NULL,  
    subject VARCHAR(255) NOT NULL,
    content TEXT NOT NULL,
    sent_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    status ENUM('SENT', 'DELIVERED', 'READ', 'BOUNCED') NOT NULL DEFAULT 'SENT',
    last_status_update DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    delivered_at DATETIME DEFAULT NULL,
    bounced_at DATETIME DEFAULT NULL,
    INDEX idx_sender (sender),
    INDEX idx_subject (subject),
    INDEX idx_sent_at (sent_at),
    INDEX idx_status (status)
);
