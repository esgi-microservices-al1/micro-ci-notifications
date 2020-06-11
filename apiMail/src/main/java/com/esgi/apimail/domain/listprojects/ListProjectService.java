package com.esgi.apimail.domain.listprojects;

import com.esgi.apimail.domain.listprojects.contracts.IListProjectRepository;
import com.esgi.apimail.domain.models.Project;

import java.util.Collection;

public class ListProjectService {
    private final IListProjectRepository repository;

    public ListProjectService(IListProjectRepository repository) {
        this.repository = repository;
    }

    public Collection<Project> get(){
        return repository.get();
    }
}
