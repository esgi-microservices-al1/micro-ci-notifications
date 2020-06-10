package com.esgi.apimail.domain.newproject;

import com.esgi.apimail.domain.models.Project;
import com.esgi.apimail.domain.newproject.contracts.INewProjectRepository;

public class NewProjectService {
    private final INewProjectRepository repository;

    public NewProjectService(INewProjectRepository repository) {
        this.repository = repository;
    }

    public Project createProject(Project project){
        Project p = repository.save(project);
        return p;
    }
}
