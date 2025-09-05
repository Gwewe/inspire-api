package com.inspireapi.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.inspireapi.Model.InspireSession;



@Repository
public interface InspireSessionRepository extends JpaRepository<InspireSession, UUID> {


    /**
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

    List<InspireSession> findAllSessions();


    /**
     * Search for Inspire sessions created before a specific timestamp.
     * @param createdAt the creation timestamp
     * @return a list of InspireSessions created before the specified timestamp
     */
    @Query("SELECT t FROM InspireSession t WHERE t.createdAt < :createdAt")
    List<InspireSession> findAllInspireSessionsOrderByCreatedAtAsc(String createdAt);


}
