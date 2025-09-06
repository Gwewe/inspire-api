package com.inspireapi.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.inspireapi.Exception.InspireSessionNotFound;
import com.inspireapi.Exception.InvalidModuleTypeException;
import com.inspireapi.Exception.ModuleNotFoundException;
import com.inspireapi.Model.InspireSession;
import com.inspireapi.Model.Module;
import com.inspireapi.Model.ModuleType;
import com.inspireapi.Repository.InspireSessionRepository;
import com.inspireapi.Repository.ModuleRepository;


@Service
public class InspireSessionServiceImpl implements InspireSessionService {

    private final InspireSessionRepository inspireSessionRepository;
    private final ModuleRepository moduleRepository;
    private static final Logger logErr = LoggerFactory.getLogger(InspireSessionServiceImpl.class);
    private static final Logger logInfo = LoggerFactory.getLogger(InspireSessionServiceImpl.class);


    public InspireSessionServiceImpl(InspireSessionRepository inspireSessionRepository, ModuleRepository moduleRepository) {
        this.inspireSessionRepository = inspireSessionRepository;
        this.moduleRepository = moduleRepository;
    }

    @Override
    public List<InspireSession> getAllSessions() {
        return inspireSessionRepository.findAll();
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
            logErr.error("Error occurred while creating the Inspire session {} ", inspireSession, err);
            throw err;
        }
    }

    @Override
    public InspireSession createInspireSessionFromModules(Map<ModuleType, UUID> moduleTypeToIdMap) {
        // Checking that to the map is not empty nor null
        if (moduleTypeToIdMap == null || moduleTypeToIdMap.isEmpty()){
            throw new InvalidModuleTypeException("My apologies, the module type to ID map cannot be null or empty.");
        }

        // New Inspire session
        InspireSession newSessionFromModules = new InspireSession();

        for (Map.Entry<ModuleType, UUID> entry : moduleTypeToIdMap.entrySet()) {
            ModuleType expectedType = entry.getKey();
            UUID moduleId = entry.getValue();

            // Getting the module
            Module module = moduleRepository.findById(moduleId)
            .orElseThrow(() -> new ModuleNotFoundException(String.format("Module with ID %s not found", moduleId)));

            //Validating that both type match
            if (!module.getModuleType().equals(expectedType)) {
                throw new InvalidModuleTypeException(
                    String.format("The module ID %s is of type %s, the module type entered is %s.",
                    moduleId, module.getModuleType(), expectedType)
                );
            }

            //Assign the content based on the type
            switch (expectedType) {
                case BREATHE -> newSessionFromModules.setBreatheContent(module.getModuleContent());
                case LEARN -> newSessionFromModules.setLearnContent(module.getModuleContent());
                case QUOTE -> newSessionFromModules.setQuoteContent(module.getModuleContent());
                default -> throw new InvalidModuleTypeException(String.format("Invalid module type %s", expectedType));
            }
        }
        return inspireSessionRepository.save(newSessionFromModules);
    }


    @Override
    public InspireSession updateInspireSession(UUID sessionId, InspireSession updatedInspireSession) {
        InspireSession inspireSession =  inspireSessionRepository.findById(sessionId)
        .orElseThrow(() -> new InspireSessionNotFound(String.format("Inspire session with ID %s not found", sessionId)));

        inspireSession.setBreatheContent(updatedInspireSession.getBreatheContent());
        inspireSession.setLearnContent(updatedInspireSession.getLearnContent());
        inspireSession.setQuoteContent(updatedInspireSession.getQuoteContent());

        try {
            return inspireSessionRepository.save(inspireSession);
        } catch (RuntimeException err) {
            logErr.error("Error occurred while updating the Inspire session {} ", sessionId, err);
            throw err;
        }

    }

    @Override
    public void deleteInspireSession(UUID sessionId) {
        InspireSession inspireSession = inspireSessionRepository.findById(sessionId)
        .orElseThrow(() -> new InspireSessionNotFound(String.format("Inspire session with ID %s not found", sessionId)));
        try {
            inspireSessionRepository.delete(inspireSession);
            logInfo.info("The inspire session with ID {} has been deleted", sessionId);
        } catch (RuntimeException err) {
            logErr.error("Error occurred while deleting the Inspire sessions {}", sessionId, err);
            throw err;
        }
    }

    @Override
    public List<InspireSession> findByBreatheContentContainingIgnoreCase(String breatheKeyword) {
        if (breatheKeyword == null || breatheKeyword.isBlank()){
            logInfo.info("No breathe keyword was provided so all Inspire sessions are being returned");
            return inspireSessionRepository.findAll();
        }
        logInfo.info("Finding Inspire sessions with breatheContent containing '{}", breatheKeyword);
        return inspireSessionRepository.findByBreatheContentContainingIgnoreCase(breatheKeyword);
    }


    @Override
    public List<InspireSession> findByLearnContentContainingIgnoreCase(String learnKeyword) {
        if (learnKeyword  == null || learnKeyword.isBlank()){
            logInfo.info("No learn keyword was provided so all Inspire sessions are being returned");
            return inspireSessionRepository.findAll();
        } 
        logInfo.info("Finding Inspire sessions with learnContent containing '{}", learnKeyword);
        return inspireSessionRepository.findByLearnContentContainingIgnoreCase(learnKeyword);
    }


    @Override
    public List<InspireSession> findByQuoteContentContainingIgnoreCase(String quoteKeyword){
        if (quoteKeyword == null || quoteKeyword.isBlank()){
            logInfo.info("No quote keyword was provided so all Inspire sessions are being returned");
            return inspireSessionRepository.findAll();
        }
        logInfo.info("Finding Inspire sessions with quoteContent containing '{}", quoteKeyword);
        return inspireSessionRepository.findByQuoteContentContainingIgnoreCase(quoteKeyword);
    }
}
