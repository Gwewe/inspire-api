package com.inspireapi.Model;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "inspire_sessions")
public class InspireSession {

    @Id
    @Column(name = "session_id")
    private UUID sessionId;

    @Column(name = "breathe_content")
    private String breatheContent;

    @Column(name = "learn_content")
    private String learnContent;

    @Column(name = "quote_content")
    private String quoteContent;

    @Column(name = "created_at")
    private Instant createdAt;

    //Default constructor
    public InspireSession() {}

    public InspireSession(UUID sessionId, String breatheContent, String learnContent, String quoteContent, Instant createdAt) {
        this.sessionId = sessionId;
        this.breatheContent = breatheContent;
        this.learnContent = learnContent;
        this.quoteContent = quoteContent;
        this.createdAt = createdAt.truncatedTo(ChronoUnit.MILLIS);
    }

    // Getters
    public UUID getSessionId() {
        return sessionId;
    }

    public String getBreatheContent() {
        return breatheContent;
    }

    public String getLearnContent() {
        return learnContent;
    }

    public String getQuoteContent() {
        return quoteContent;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    //Setters

    public void setBreatheContent(String breatheContent) {
        this.breatheContent = breatheContent;
    }

    public void setLearnContent(String learnContent) {
        this.learnContent = learnContent;
    }

    public void setQuoteContent(String quoteContent) {
        this.quoteContent = quoteContent;
    }

    /**
     * Truncating createdAt for a value to milliseconds precision.
     * This matches the behavior in the constructor and ensures consistency with the database column definition.
     */
    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt.truncatedTo(ChronoUnit.MILLIS);
    }

}

 
