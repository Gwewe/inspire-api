package com.inspireapi.Model;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "modules")
public class Module {

    @Id
    @Column(name = "module_id")
    private UUID moduleId;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "module_type")
    private ModuleType moduleType;
    
    @Column(name = "module_content")
    private String moduleContent;

    public Module(UUID moduleId, ModuleType moduleType, String moduleContent) {
        this.moduleId = moduleId;
        this.moduleType = moduleType;
        this.moduleContent = moduleContent;
    }

    // Getters

    public UUID getModuleId() {
        return moduleId;
    }

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
