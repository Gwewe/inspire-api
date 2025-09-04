package com.inspireapi.Model;

public enum ModuleType {

    BREATHE("This is your time to stop and just breathe."),
    LEARN("Expand your mind, one fact at a time."),
    QUOTE("This is your time to reflect on a meaningful quote."),;

    private final String moduleDescription;

    ModuleType(String moduleDescription) {
        this.moduleDescription = moduleDescription;
    }

    public String getModuleDescription() {
        return moduleDescription;
    }
}
