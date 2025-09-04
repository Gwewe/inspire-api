package com.inspireapi.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
public class Module {
    
    @Enumerated(EnumType.STRING)
    private ModuleType moduleType;
    private String moduleContent;

    public Module(ModuleType moduleType, String moduleContent) {
        this.moduleType = moduleType;
        this.moduleContent = moduleContent;
    }

    // Getters
    public ModuleType getModuleType() {
        return moduleType;
    }

    public String getModuleContent() {
        return moduleContent;
    }

    // Setters
    public void setModuleType(ModuleType moduleType) {
        this.moduleType = moduleType;
    }

    public void setModuleContent(String moduleContent) {
        this.moduleContent = moduleContent;
    }

}
