package com.inspireapi.Repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ModuleRepository extends JpaRepository<Module, UUID> {

    /**
     * Find all modules of a specific type.
     * @param moduleType the type of the module
     * @return a list of modules matching the specified type
     */
    List<Module> findByModuleType(String moduleType);


    /**
     * Find all modules containing a specific keyword in the module content, ignoring case.
     * @param keyword the keyword to search for
     * @return a list of modules containing the specified keyword
     */
    @Query("SELECT m FROM Module m WHERE LOWER(m.module_content) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Module> searchModuleByKeywordIgnoreCase(String keyword);

}
