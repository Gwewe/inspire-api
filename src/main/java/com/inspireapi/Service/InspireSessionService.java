package com.inspireapi.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.inspireapi.Model.InspireSession;

public interface InspireSessionService {


    /**
     * Get all InspireSessions.
     * @return a list of all InspireSessions
     */
    List<InspireSession> getAllSessions();

    /**
     * Get an InspireSession by its ID.
     * @param sessionId the ID of the InspireSession
     * @return the InspireSession with the specified ID, or null if not found
     */
    Optional<InspireSession> getSessionById(UUID sessionId);


    /**
     * Create a new InspireSession.
     * @param inspireSession the InspireSession to create
     * @return the created InspireSession
     */
    InspireSession createInspireSession(InspireSession inspireSession);

    /**
     * Update all modules for a single session.
     * @param sessionId the ID of the InspireSession to update
     * @param inspireSession the updated InspireSession data
     * @return the updated InspireSession, or null if not found
     */
    Optional<InspireSession> updateInspireSession(UUID sessionId, InspireSession inspireSession);


    /**
     * Delete an InspireSession by its ID.
     * @param sessionId the ID of the InspireSession to delete
     * @return true if the InspireSession was deleted, false if not found
     */
    void deleteInspireSession(UUID sessionId); 
}
