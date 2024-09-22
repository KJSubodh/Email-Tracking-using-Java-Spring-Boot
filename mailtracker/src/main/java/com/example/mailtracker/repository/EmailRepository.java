package com.example.mailtracker.repository;

import com.example.mailtracker.model.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface EmailRepository extends JpaRepository<Email, Long> {

    @Query("SELECT e FROM Email e WHERE e.sender = :sender AND :recipient LIKE CONCAT('%', :recipient, '%') AND e.sentAt BETWEEN :start AND :end")
    List<Email> findBySenderAndRecipientAndSentAtBetween(
            @Param("sender") String sender, 
            @Param("recipient") String recipient, 
            @Param("start") LocalDateTime start, 
            @Param("end") LocalDateTime end);
}
