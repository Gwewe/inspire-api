package com.inspireapi.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.inspireapi.Model.InspireSession;
import com.inspireapi.Model.ModuleType;

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
     * @param moduleTypeToIdMap a map of module types to their corresponding moduleIds
     * @return the created Inspire session from template modules
     * @throws InvalidModuleTypeException if an invalid module type is provided
     */
    InspireSession createInspireSessionFromModules(Map<ModuleType, UUID> moduleTypeToIdMap);

    /**
     * Update all modules for a single session.
     * @param sessionId the UUID of the InspireSession to update
     * @param inspireSession the updated InspireSession data
     * @return the updated InspireSession, or null if not found
     * @throws InspireSessionNotFound if no Inspire session is found with the specified sessionId
     */
    InspireSession updateInspireSession(UUID sessionId, InspireSession updatedInspireSession);

    /**
     * Partial update of an existing Inspire session
     * The only allowed fields that can be updated are "breatheContent", "learnContent", and "quoteContent"
     * @param sessionId the UUID of the InspireSession to update
     * @param updates a map of module content fields to their corresponding new values
     * @return the updated InspireSession
     * @throws InvalidPatchFieldNameException if an invalid field name is provided in the updates map
     * @throws InspireSessionNotFound if no Inspire session is found with the specified sessionId
     */
    InspireSession patchInspireSession(UUID sessionId, Map<String, String> updates);

    /**
     * Delete a specific Inspire session by its sessionId
     * @param sessionId the UUID of the Inspire session to delete
     * @throws InspireSessionNotFound if no Inspire session is found with the specified sessionId
     */
    void deleteInspireSession(UUID sessionId); 

    /**
     * Find Inspire sessions containing a specific keyword in the learnContent
     * @param learnKeyword the keyword to search for in the learnContent
     * @return a list of Inspire sessions containing the specified keyword in the learnContent
     */
    List<InspireSession> findByLearnContentContainingIgnoreCase(String learnKeyword);
}
