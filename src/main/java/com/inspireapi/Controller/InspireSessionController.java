package com.inspireapi.Controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inspireapi.Model.InspireSession;
import com.inspireapi.Service.InspireSessionService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;


@Tag(name = "Inspire API", description = "An API for managing Inspire sessions with Breathe, Learn, and Quote content.")
@RestController
@RequestMapping("/api/inspire-sessions")
public class InspireSessionController {

    private final InspireSessionService inspireSessionService;

    public InspireSessionController(InspireSessionService inspireSessionService){
        this.inspireSessionService = inspireSessionService;
    }

    @Operation(summary = "Retrieve all the Inspire sessions", description = "Returns a list of all Inspire sessions")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully retrived all Inspire sessions"),
        @ApiResponse(responseCode = "404", description = "No Inspire sessions found."),
        @ApiResponse(responseCode = "500", description = "An error occured: Internal Server Error")
    })
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


    @PostMapping("/from-modules")
    public ResponseEntity<InspireSession> createInspireSessionFromModules() {
        InspireSession newInspireSessionFromModule = inspireSessionService.createInspireSessionFromModules();
        return ResponseEntity.status(HttpStatus.CREATED).body(newInspireSessionFromModule);
  
    }

    @PutMapping("/{id}")
    public ResponseEntity<InspireSession> updateInspireSession(@PathVariable UUID sessionId, @RequestBody InspireSession updatedInspireSession) {
        return ResponseEntity.ok(inspireSessionService.updateInspireSession(sessionId, updatedInspireSession));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInspireSession(@PathVariable UUID sessionId){
        inspireSessionService.deleteInspireSession(sessionId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("search/breathe")
    public ResponseEntity<List<InspireSession>> findByBreatheContentContainingIgnoreCase(@RequestParam String breatheKeyword) {
        return ResponseEntity.ok(inspireSessionService.findByBreatheContentContainingIgnoreCase(breatheKeyword));
    }

    @GetMapping("search/learn")
    public ResponseEntity<List<InspireSession>> findByLearnContentContainingIgnoreCase(@RequestParam String learnKeyword) {
        return ResponseEntity.ok(inspireSessionService.findByLearnContentContainingIgnoreCase(learnKeyword));
    }

    @GetMapping("search/quote")
    public ResponseEntity<List<InspireSession>> findByQuoteContentContainingIgnoreCase(@RequestParam String quoteKeyword) {
        return ResponseEntity.ok(inspireSessionService.findByQuoteContentContainingIgnoreCase(quoteKeyword));
    }
}
