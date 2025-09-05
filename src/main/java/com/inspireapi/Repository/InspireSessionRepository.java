package com.inspireapi.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inspireapi.Model.InspireSession;


@Repository
public interface InspireSessionRepository extends JpaRepository<InspireSession, UUID> {

    //Repository interface, data access layer


    /**
     * The Session level
     * Find a InspireSession by it's sessionId
     * @param sessionId the session UUID
     * @return an Optional containing the InspireSession if found, or empty if not found
     */

    Optional<InspireSession> findBySessionId(UUID sessionId);

    /**
     * The Module level
     * @param moduleType the module type
     * @return a list of InspireSessions matching the specified module type
     */

    List<Module> findByModuleType(String moduleType);

     /**
     * Find all three modules belonging to a specific session.
     * @param sessionId the UUID of the session
     * @return list of modules for that session
     */
    List<Module> findModulesBySessionId(UUID sessionId);

}
