package com.inspireapi.Controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.inspireapi.Model.InspireSession;
import com.inspireapi.Service.InspireSessionService;


// @Tag(name = "Inspire API", description = "An API for managing Inspire sessions with Breathe, Learn, and Quote content.")
@RestController
public class InspireSessionController {

    private final InspireSessionService inspireSessionService;

    public InspireSessionController(InspireSessionService inspireSessionService){
        this.inspireSessionService = inspireSessionService;
    }

    @GetMapping
    public ResponseEntity<List<InspireSession>> getAllSessions() {
        return ResponseEntity.ok(inspireSessionService.getAllSessions());
    }


    @GetMapping("/{id}")
    public ResponseEntity<InspireSession> getSessionById(@PathVariable UUID sessionId) {
        return ResponseEntity.ok(inspireSessionService.getSessionById(sessionId));
    }

    @PostMapping("/")
    public ResponseEntity<InspireSession> createInspireSession(@RequestBody InspireSession inspireSession) {
        InspireSession newInspireSessionCreated = inspireSessionService.createInspireSession(inspireSession);
        return ResponseEntity.status(HttpStatus.CREATED).body(newInspireSessionCreated);
    }


    // @PostMapping("/from-modules")
    // public ResponseEntity<InspireSession> createInspireSessionFromModules(@RequestBody Map<ModuleType, UUID> moduleTypeToIdMap) {
    //     InspireSession newInspireSessionFromModule = inspireSessionService.createInspireSessionFromModules(moduleTypeToIdMap);

  
    // }
    

}
