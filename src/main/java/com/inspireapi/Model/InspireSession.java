package com.inspireapi.Model;

import java.time.Instant;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "inspire_sessions")
public class InspireSession {

    @Id
    private final UUID sessionId;
    private String breatheModuleContent;
    private String learnModuleContent;
    private String quoteModuleContent;
    private Instant createdAt;

    public InspireSession(UUID sessionId, String breatheModuleContent, String learnModuleContent, String quoteModuleContent, Instant createdAt) {
        this.sessionId = sessionId;
        this.breatheModuleContent = breatheModuleContent;
        this.learnModuleContent = learnModuleContent;
        this.quoteModuleContent = quoteModuleContent;
        this.createdAt = createdAt;
    }

    // Getters
    public UUID getSessionId() {
        return sessionId;
    }

    public String getBreatheModuleContent() {
        return breatheModuleContent;
    }

    public String getLearnModuleContent() {
        return learnModuleContent;
    }

    public String getQuoteModuleContent() {
        return quoteModuleContent;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    //Setters

    public void setBreatheModuleContent(String breatheModuleContent) {
        this.breatheModuleContent = breatheModuleContent;
    }

    public void setLearnModuleContent(String learnModuleContent) {
        this.learnModuleContent = learnModuleContent;
    }

    public void setQuoteModuleContent(String quoteModuleContent) {
        this.quoteModuleContent = quoteModuleContent;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

}

 
