package com.example.mailtracker.service;

import com.example.mailtracker.model.Email;
import com.example.mailtracker.model.EmailStatus;
import com.example.mailtracker.repository.EmailRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmailService {

    private static final Logger logger = LoggerFactory.getLogger(EmailService.class);

    @Autowired
    private EmailRepository emailRepository;

    @Autowired
    private JavaMailSender javaMailSender;

    @Transactional
    public void sendEmail(Email email) {
        email.setSentAt(LocalDateTime.now());
        email.setStatus(EmailStatus.SENT);
        email.setLastStatusUpdate(LocalDateTime.now());

        if (email.getRecipients() == null || email.getRecipients().isEmpty()) {
            throw new RuntimeException("Recipients list cannot be empty");
        }

        try {
            Email savedEmail = emailRepository.save(email);
            logger.info("Saved email with ID: {}", savedEmail.getId());

            for (String recipient : email.getRecipients()) {
                SimpleMailMessage mailMessage = new SimpleMailMessage();
                mailMessage.setFrom(email.getSender());
                mailMessage.setTo(recipient);
                mailMessage.setSubject(email.getSubject());
                mailMessage.setText(email.getContent());

                javaMailSender.send(mailMessage);
                logger.info("Sent email to recipient: {}", recipient);
            }

            savedEmail.setStatus(EmailStatus.DELIVERED);
            savedEmail.setDeliveredAt(LocalDateTime.now());
            savedEmail.setLastStatusUpdate(LocalDateTime.now());
            emailRepository.save(savedEmail);
            logger.info("Updated email status to DELIVERED");
        } catch (Exception e) {
            logger.error("Error in sendEmail method", e);
            email.setStatus(EmailStatus.BOUNCED);
            email.setBouncedAt(LocalDateTime.now());
            email.setLastStatusUpdate(LocalDateTime.now());
            emailRepository.save(email);
            throw new RuntimeException("Failed to send email: " + e.getMessage(), e);
        }
    }

    public List<Email> getAllEmails() {
        return emailRepository.findAll();
    }
}
