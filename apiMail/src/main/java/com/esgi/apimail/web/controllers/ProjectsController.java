package com.esgi.apimail.web.controllers;

import com.esgi.apimail.domain.listprojects.ListProjectService;
import com.esgi.apimail.domain.listusers.ListUsersService;
import com.esgi.apimail.domain.models.Project;
import com.esgi.apimail.domain.newproject.NewProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/projects")
public class ProjectsController {
    private final NewProjectService newProjectService;
    private final ListProjectService listProjectService;
    private final ListUsersService listUsersService;

    public ProjectsController(NewProjectService newProjectService, ListProjectService listProjectService, ListUsersService listUsersService) {
        this.newProjectService = newProjectService;
        this.listProjectService = listProjectService;
        this.listUsersService = listUsersService;
    }

    @PostMapping
    public ResponseEntity<?> post(@RequestBody @Valid Project project){
        Project res = this.newProjectService.createProject(project);
        return ResponseEntity.status(HttpStatus.CREATED).body(res);
    }

    @GetMapping
    public ResponseEntity<?> get(){
        return ResponseEntity.ok(
                this.listProjectService.get()
        );
    }

    @GetMapping("/users")
    public ResponseEntity<?> getAllUsers(){
        return ResponseEntity.ok(this.listUsersService.getAll());
    }
}
