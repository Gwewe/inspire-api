package com.inspireapi.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.inspireapi.Service.InspireSessionService;

// @Tag(name = "Inspire API", description = "An API for managing Inspire sessions with Breathe, Learn, and Quote content.")
@RestController
public class InspireController {

    private final InspireSessionService inspireSessionService;

    public InspireController(InspireSessionService inspireSessionService){
        this.inspireSessionService = inspireSessionService;
    }



}
