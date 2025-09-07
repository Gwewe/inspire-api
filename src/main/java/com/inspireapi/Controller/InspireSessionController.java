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

    @Operation(summary = "Get all the Inspire sessions", description = "Return a list of all Inspire sessions")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully retrieved all Inspire sessions"),
        @ApiResponse(responseCode = "500", description = "An error occurred: Internal Server Error")
    })
    @GetMapping
    public ResponseEntity<List<InspireSession>> getAllSessions() {
        return ResponseEntity.ok(inspireSessionService.getAllSessions());
    }


    @Operation(summary = "Get an Inspire session", description = "Return a specifc Inspire session with its ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully retrieved Inspire session with its ID"),
        @ApiResponse(responseCode = "404", description = "Inspire session not found"),
        @ApiResponse(responseCode = "500", description = "An error occurred: Internal Server Error")
    })
    @GetMapping("/{sessionId}")
    public ResponseEntity<InspireSession> getSessionById(@PathVariable UUID sessionId) {
        return ResponseEntity.ok(inspireSessionService.getSessionById(sessionId));
    }

    @Operation(summary = "Create a new Inspire session", description = "Return new Inspire session")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Successfully created new Inspire session"),
        @ApiResponse(responseCode = "400", description = "Failed to create Inspire session: Invalid or bad request"),
        @ApiResponse(responseCode = "500", description = "An error occurred: Internal Server Error")
    })
    @PostMapping
    public ResponseEntity<InspireSession> createInspireSession(@RequestBody InspireSession inspireSession) {
        InspireSession newInspireSessionCreated = inspireSessionService.createInspireSession(inspireSession);
        return ResponseEntity.status(HttpStatus.CREATED).body(newInspireSessionCreated);
    }


    @Operation(summary = "Create a new Inspire session from modules", description = "Return new Inspire session created from existing modules")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Successfully created new Inspire session from modules"),
        @ApiResponse(responseCode = "400", description = "Failed to create Inspire session from modules: Invalid module type"),
        @ApiResponse(responseCode = "404", description = "Failed to create Inspire session from modules: Module not found"),
        @ApiResponse(responseCode = "500", description = "An error occurred: Internal Server Error")
    })
    @PostMapping("/from-modules")
    public ResponseEntity<InspireSession> createInspireSessionFromModules() {
        InspireSession newInspireSessionFromModule = inspireSessionService.createInspireSessionFromModules();
        return ResponseEntity.status(HttpStatus.CREATED).body(newInspireSessionFromModule);
  
    }

    @Operation(summary = "Update a Inspire session", description = "Update an existing Inspire session with its ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully updated Inspire session"),
        @ApiResponse(responseCode = "400", description = "Failed to update Inspire session: Invalid module type"),
        @ApiResponse(responseCode = "404", description = "Inspire session not found"),
        @ApiResponse(responseCode = "500", description = "An error occurred: Internal Server Error")
    })
    @PutMapping("/{sessionId}")
    public ResponseEntity<InspireSession> updateInspireSession(@PathVariable UUID sessionId, @RequestBody InspireSession updatedInspireSession) {
        return ResponseEntity.ok(inspireSessionService.updateInspireSession(sessionId, updatedInspireSession));
    }

    @Operation(summary = "Delete a Inspire session", description = "Delete a Inspire session with its ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Successfully deleted Inspire session with its ID"),
        @ApiResponse(responseCode = "404", description = "Inspire session not found"),
        @ApiResponse(responseCode = "500", description = "An error occurred: Internal Server Error")
    })
    @DeleteMapping("/{sessionId}")
    public ResponseEntity<Void> deleteInspireSession(@PathVariable UUID sessionId){
        inspireSessionService.deleteInspireSession(sessionId);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Search for Breathe content using breatheKeyword", description = "Return a list of Inspire sessions matching breatheKeyword")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully retrieved all Inspire sessions matching breatheKeyword"),
        @ApiResponse(responseCode = "500", description = "An error occurred: Internal Server Error")
    })
    @GetMapping("/search/breathe")
    public ResponseEntity<List<InspireSession>> findByBreatheContentContainingIgnoreCase(@RequestParam String breatheKeyword) {
        return ResponseEntity.ok(inspireSessionService.findByBreatheContentContainingIgnoreCase(breatheKeyword));
    }

    @Operation(summary = "Search for Learn content using learnKeyword", description = "Return a list of all Inspire sessions matching learnKeyword")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully retrieved all Inspire sessions matching learnKeyword"),
        @ApiResponse(responseCode = "500", description = "An error occurred: Internal Server Error")
    })
    @GetMapping("/search/learn")
    public ResponseEntity<List<InspireSession>> findByLearnContentContainingIgnoreCase(@RequestParam String learnKeyword) {
        return ResponseEntity.ok(inspireSessionService.findByLearnContentContainingIgnoreCase(learnKeyword));
    }

    @Operation(summary = "Search for Quote content using quoteKeyword", description = "Return a list of all Inspire sessions matching quoteKeyword")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully retrieved all Inspire sessions matching quoteKeyword"),
        @ApiResponse(responseCode = "500", description = "An error occurred: Internal Server Error")
    })
    @GetMapping("/search/quote")
    public ResponseEntity<List<InspireSession>> findByQuoteContentContainingIgnoreCase(@RequestParam String quoteKeyword) {
        return ResponseEntity.ok(inspireSessionService.findByQuoteContentContainingIgnoreCase(quoteKeyword));
    }
}
