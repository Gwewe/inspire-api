package com.inspireapi.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inspireapi.Model.InspireSession;


@Repository
public interface InspireRepository extends JpaRepository<InspireSession, UUID> {

    //Repository interface, data access layer


    /**
     * Session level
     * Find a InspireSession by it's sessionId.
     * @param sessionId the session ID
     * @return an Optional containing the InspireSession if found, or empty if not found
     */

    Optional<InspireSession> findBySessionId(UUID sessionId);
    List<InspireSession> findAllSessionList(UUID sessionId);

    /**
     * Module level
     * @param moduleType the module type
     * @return a list of InspireSessions matching the specified module type
     */

    List<InspireSession> findByModuleType(String moduleType);
    Optional<InspireSession> findModuleContentBySessionID(String moduleContent);

}
