package com.inspireapi.Model;

import java.time.Instant;
import java.util.UUID;

public class InspireSession {
    private UUID sessionId;
    private ModuleType moduleType;
    private String moduleContent;
    private Instant createdAt;

    public InspireSession(ModuleType moduleType, String moduleContent, Instant createdAt) {
        this.sessionId = UUID.randomUUID();
        this.moduleType = moduleType;
        this.moduleContent = moduleContent;
        this.createdAt = createdAt;
    }

}
