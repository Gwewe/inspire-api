package com.inspireapi.Repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inspireapi.Model.ModuleType;

public interface ModuleRepository extends JpaRepository<Module, UUID> {

    /**
     * Find all modules of a specific type
     * @param moduleType the type of the module
     * @return a list of modules matching the specified type
     */
    List<Module> findByModuleType(ModuleType moduleType);


    /**
     * Find modules containing a specific keyword in the module content
     * @param keyword the keyword to search for in the module content
     * @return a list of modules containint the keyword
     */
    List<Module> findByModuleContentContainingIgnoreCase(String keyword);

}
