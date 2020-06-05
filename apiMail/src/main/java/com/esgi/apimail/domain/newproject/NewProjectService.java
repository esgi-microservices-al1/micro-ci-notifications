package com.esgi.apimail.domain.newproject;

import com.esgi.apimail.domain.models.Project;
import com.esgi.apimail.domain.newproject.contracts.INewProjectRepository;

public class NewProjectService {
    private final INewProjectRepository repository;

    public NewProjectService(INewProjectRepository repository) {
        this.repository = repository;
    }

    public boolean createProject(Project project){
        Project p = repository.save(project);
        return true;
    }
}
