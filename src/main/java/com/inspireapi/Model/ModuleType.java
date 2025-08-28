package com.inspireapi.Model;

public enum ModuleType {
    BREATHE("This is your time to stop and just breathe."),
    LEARN("Expand your mind, one fact at a time."),
    QUOTES("We work so hard, not to change the world but to prevent the world from changing us. - Unknown author");

    private final String moduleDescription;

    ModuleType(String moduleDescription) {
        this.moduleDescription = moduleDescription;
    }

    public String getModuleDescription() {
        return moduleDescription;
    }
}
