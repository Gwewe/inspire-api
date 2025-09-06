package com.inspireapi.Service;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.inspireapi.Exception.InspireSessionNotFound;
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

    private int indexForBreathe = 0;
    private int indexForLearn = 0;
    private int indexForQuote = 0;


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
    public InspireSession createInspireSessionFromModules() {

        InspireSession newSessionFromModules = new InspireSession();

        List<Module> breatheModules = moduleRepository.findByModuleType(ModuleType.BREATHE);
        if (!breatheModules.isEmpty()) {
            newSessionFromModules.setBreatheContent(breatheModules.get(indexForBreathe).getModuleContent());
            indexForBreathe = (indexForBreathe + 1) % breatheModules.size();
        }

        List<Module> learnModules = moduleRepository.findByModuleType(ModuleType.LEARN);
        if (!learnModules.isEmpty()) {
            newSessionFromModules.setLearnContent(learnModules.get(indexForLearn).getModuleContent());
            indexForLearn = (indexForLearn + 1) % learnModules.size();
        }

        List<Module> quotesModules = moduleRepository.findByModuleType(ModuleType.QUOTE);
        if (!quotesModules.isEmpty()) {
            newSessionFromModules.setQuoteContent(quotesModules.get(indexForQuote).getModuleContent());
            indexForQuote = (indexForQuote + 1) % quotesModules.size();
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
