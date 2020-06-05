package com.esgi.apimail.domain.listprojects.contracts;

import com.esgi.apimail.domain.models.Project;

import java.util.Collection;

public interface IListProjectRepository {
    Collection<Project> get();
}
