package com.example.mailtracker.controller;

import com.example.mailtracker.model.Email;
import com.example.mailtracker.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/emails")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/send")
    public ResponseEntity<String> sendEmail(@RequestBody Email email) {
        try {
            emailService.sendEmail(email);
            return ResponseEntity.ok("Email sent successfully!");
        } catch (RuntimeException e) {
            return ResponseEntity.status(500).body("Error processing email request: " + e.getMessage());
        }
    }

    @GetMapping("/list")
    public ResponseEntity<List<Email>> listEmails() {
        List<Email> emails = emailService.getAllEmails();
        return ResponseEntity.ok(emails);
    }
}
