package com.inspireapi.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
    



}
