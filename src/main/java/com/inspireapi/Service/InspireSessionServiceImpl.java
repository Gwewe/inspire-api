package com.inspireapi.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.inspireapi.Exception.InspireSessionNotFound;
import com.inspireapi.Model.InspireSession;
import com.inspireapi.Model.ModuleType;
import com.inspireapi.Repository.InspireSessionRepository;
import com.inspireapi.Repository.ModuleRepository;


@Service
public class InspireSessionServiceImpl implements InspireSessionService {

    private final InspireSessionRepository inspireSessionRepository;
    private final ModuleRepository moduleRepository;
    private static final Logger logErr = LoggerFactory.getLogger(InspireSessionServiceImpl.class);

    public InspireSessionServiceImpl(InspireSessionRepository inspireSessionRepository, ModuleRepository moduleRepository) {
        this.inspireSessionRepository = inspireSessionRepository;
        this.moduleRepository = moduleRepository;
    }

    @Override
    public List<InspireSession> getAllSessions() {
        try {
            return inspireSessionRepository.findAll();
        } catch (RuntimeException err) {
            logErr.error("Error occured while retrieving the InspireSessions list: " + err);
            return List.of();
        }
    }

    @Override
    public InspireSession getSessionById(UUID sessionId) {
        return inspireSessionRepository.findById(sessionId)
        .orElseThrow(() -> new InspireSessionNotFound(String.format("Inspire session with ID %s not found", sessionId)));
    }

    @Override
    public InspireSession createInspireSession(InspireSession inspireSession) {
        try {
            return inspireSessionRepository.save(inspireSession);
        } catch (RuntimeException err) {
            logErr.error("Error occured while creating the Inspire session: ", inspireSession, err);
            throw err;
        }
    }

    @Override
    public InspireSession createInspireSessionFromModules(Map<ModuleType, UUID> moduleTypeToIdMap) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public InspireSession updateInspireSession(UUID sessionId, InspireSession inspireSession) {
        // TODO Auto-generated method stub
        return null;

    }

    @Override
    public InspireSession patchInspireSession(UUID sessionId, Map<String, String> updates){
        // todo
        return null;
    }


    @Override
    public void deleteInspireSession(UUID sessionId) {
        //todo
        return null;
    }

    @Override
    public List<InspireSession> findByLearnContentContainingIgnoreCase(String learnKeyword) {
        // todo
        return null;
    }


}
