package com.inspireapi.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.inspireapi.Model.InspireSession;
import com.inspireapi.Repository.InspireSessionRepository;


@Service
public class InspireSessionServiceImpl implements InspireSessionService {

    private final InspireSessionRepository inspireSessionRepository;

    public InspireSessionServiceImpl(InspireSessionRepository inspireSessionRepository) {
        this.inspireSessionRepository = inspireSessionRepository;
    }

    @Override
    public List<InspireSession> getAllSessions(){
        try {
            return inspireSessionRepository.findAll();
        } catch (Exception e) {
            System.err.println("Error occured while retrieving the InspireSessions list: " + e.getMessage());
            return List.of();
        }
    }

    @Override
    public Optional<InspireSession> getSessionById(UUID sessionId){
        try {
            return inspireSessionRepository.findBySessionId(sessionId);
        } catch (Exception e) {
            System.err.println("Error occured while retrieving the InspireSession by ID: " + sessionId + " - " + e.getMessage());
            return Optional.empty();
        }
        
        
    }

    @Override
    public InspireSession createInspireSession(InspireSession inspireSession) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Optional<InspireSession> updateInspireSession(UUID sessionId, InspireSession inspireSession) {
        // TODO Auto-generated method stub
        return Optional.empty();
    }

    @Override
    public void deleteInspireSession(UUID sessionId) {
        // TODO Auto-generated method stub

    }


}
