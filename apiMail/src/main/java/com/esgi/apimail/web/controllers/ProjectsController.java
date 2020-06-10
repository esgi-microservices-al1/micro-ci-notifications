package com.esgi.apimail.web.controllers;

import com.esgi.apimail.domain.listprojects.ListProjectService;
import com.esgi.apimail.domain.models.Project;
import com.esgi.apimail.domain.newproject.NewProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/projects")
public class ProjectsController {
    private final NewProjectService newProjectService;
    private final ListProjectService listProjectService;

    public ProjectsController(NewProjectService newProjectService, ListProjectService listProjectService) {
        this.newProjectService = newProjectService;
        this.listProjectService = listProjectService;
    }

    @PostMapping
    public ResponseEntity<?> post(@RequestBody @Valid Project project){
        this.newProjectService.createProject(project);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<?> get(){
        return ResponseEntity.ok(
                this.listProjectService.get()
        );
    }
}
