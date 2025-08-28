package com.inspireapi.Model;

import java.time.Instant;
import java.util.UUID;

public class InspireSession {
    private final UUID sessionId;
    private ModuleType moduleType;
    private String moduleContent;
    private Instant createdAt;

    public InspireSession(ModuleType moduleType, String moduleContent, Instant createdAt) {
        this.sessionId = UUID.randomUUID();
        this.moduleType = moduleType;
        this.moduleContent = moduleContent;
        this.createdAt = createdAt;
    }

    // Getters
    public UUID getSessionId() {
        return sessionId;
    }

    public ModuleType getModuleType() {
        return moduleType;
    }

    public String getModuleContent() {
        return moduleContent;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    //Setters

    public void setModuleType(ModuleType moduleType) {
        this.moduleType = moduleType;
    }

    public void setModuleContent(String moduleContent) {
        this.moduleContent = moduleContent;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

}
