package com.example.mailtracker.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

import com.example.mailtracker.converter.StringListConverter;

@Entity
@Table(name = "emails")
public class Email {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String sender;

    @Convert(converter = StringListConverter.class)
    @Column(nullable = false)
    private List<String> recipients;  

    @Column(nullable = false)
    private String subject;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    @Column(name = "sent_at", nullable = false)
    private LocalDateTime sentAt;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EmailStatus status;

    @Column(name = "last_status_update", nullable = false)
    private LocalDateTime lastStatusUpdate;

    @Column(name = "delivered_at")
    private LocalDateTime deliveredAt;

    @Column(name = "bounced_at")
    private LocalDateTime bouncedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public List<String> getRecipients() {
        return recipients;
    }

    public void setRecipients(List<String> recipients) {
        this.recipients = recipients;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getSentAt() {
        return sentAt;
    }

    public void setSentAt(LocalDateTime sentAt) {
        this.sentAt = sentAt;
    }

    public EmailStatus getStatus() {
        return status;
    }

    public void setStatus(EmailStatus status) {
        this.status = status;
    }

    public LocalDateTime getLastStatusUpdate() {
        return lastStatusUpdate;
    }

    public void setLastStatusUpdate(LocalDateTime lastStatusUpdate) {
        this.lastStatusUpdate = lastStatusUpdate;
    }

    public LocalDateTime getDeliveredAt() {
        return deliveredAt;
    }

    public void setDeliveredAt(LocalDateTime deliveredAt) {
        this.deliveredAt = deliveredAt;
    }

    public LocalDateTime getBouncedAt() {
        return bouncedAt;
    }

    public void setBouncedAt(LocalDateTime bouncedAt) {
        this.bouncedAt = bouncedAt;
    }
}
