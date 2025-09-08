package com.inspireapi.Model;

import java.sql.Types;
import java.util.UUID;

import org.hibernate.annotations.JdbcTypeCode;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "modules")
public class Module {

    @Id
    @GeneratedValue
    @JdbcTypeCode(Types.VARCHAR)
    @Column(name = "module_id", columnDefinition = "CHAR(36)", updatable = false, nullable = false)
    private UUID moduleId;

    @Enumerated(EnumType.STRING)
    @Column(name = "module_type")
    private ModuleType moduleType;
    
    @Column(name = "module_content")
    private String moduleContent;

    // Default constructor
    public Module() {}

    public Module(UUID moduleId, ModuleType moduleType, String moduleContent) {
        this.moduleId = moduleId;
        this.moduleType = moduleType;
        this.moduleContent = moduleContent;
    }

    // The getters

    public UUID getModuleId() {
        return moduleId;
    }

    public ModuleType getModuleType() {
        return moduleType;
    }

    public String getModuleContent() {
        return moduleContent;
    }

    // the setters
    public void setModuleType(ModuleType moduleType) {
        this.moduleType = moduleType;
    }

    public void setModuleContent(String moduleContent) {
        this.moduleContent = moduleContent;
    }

}
