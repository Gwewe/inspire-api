package com.inspireapi.Service;

import java.util.List;
import java.util.UUID;

import com.inspireapi.Exception.InspireSessionNotFound;
import com.inspireapi.Model.InspireSession;

public interface InspireSessionService {


    /**
     * Get all Inspire sessions
     * @return a list of all Inspire sessions
     */
    List<InspireSession> getAllSessions();

   /**
    * Get an Inspire session by its sessionId
    * @param sessionId the UUID of the Inspire session
    * @return the Inspire session with the specific sessionId
    * @throws InspireSessionNotFound if no Inspire session is found with the specified sessionId
    */
    InspireSession getSessionById(UUID sessionId);


    /**
     * Create a new Inspire session.
     * @param inspireSession the Inspire session to create
     * @return the created Inspire session
     */
    InspireSession createInspireSession(InspireSession inspireSession);

    /**
     * Create a new Inspire session from template modules
     * @return the created Inspire session from template modules
     */
    InspireSession createInspireSessionFromModules();

    /**
     * Update all modules for a single session.
     * @param sessionId the UUID of the InspireSession to update
     * @param inspireSession the updated InspireSession data
     * @return the updated InspireSession, or null if not found
     * @throws InspireSessionNotFound if no Inspire session is found with the specified sessionId
     */
    InspireSession updateInspireSession(UUID sessionId, InspireSession updatedInspireSession);

    /**
     * Delete a specific Inspire session by its sessionId
     * @param sessionId the UUID of the Inspire session to delete
     * @throws InspireSessionNotFound if no Inspire session is found with the specified sessionId
     */
    void deleteInspireSession(UUID sessionId); 

    /**
     * Find Inspire sessions containing a specific keyword in the breatheContent
     * @param breatheKeyword the keyword to search for in breatheContent
     * @return a list of Inspire Sessions containing the keyword in breatheContent
     */
    List<InspireSession> findByBreatheContentContainingIgnoreCase(String breatheKeyword);

    /**
     * Find Inspire sessions containing a specific keyword in the learnContent
     * @param learnKeyword the keyword to search for in the learnContent
     * @return a list of Inspire sessions containing the specified keyword in the learnContent
     */
    List<InspireSession> findByLearnContentContainingIgnoreCase(String learnKeyword);

    /**
     * Find Inspire sessions containing a specific keyword in the quoteContent
     * @param quoteKeyword the keyword to search for in quoteContent
     * @return a list of InspireSessions containing the keyword in quoteContent
     */
    List<InspireSession> findByQuoteContentContainingIgnoreCase(String quoteKeyword);


}
