package com.esgi.apimail.domain.newproject.contracts;

import com.esgi.apimail.domain.models.Project;

public interface INewProjectRepository {
    Project save(Project project);
}
