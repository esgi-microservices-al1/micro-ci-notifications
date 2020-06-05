package com.esgi.apimail.persistence.parsers;

import com.esgi.apimail.domain.models.Project;
import com.esgi.apimail.persistence.entities.ProjectEntity;

import java.util.stream.Collectors;

public class ProjectParser {
    public static ProjectEntity parse(Project source){
        ProjectEntity result = new ProjectEntity();
        result.setId(source.getId());
        if(source.getNotifiedUsers() == null)
            result.setNotifiedUserEntities(null);
        else
            result.setNotifiedUserEntities(source.getNotifiedUsers().stream().map(UserParser::parse).collect(Collectors.toList()));
        return result;
    }

    public static Project parse(ProjectEntity source) {
        Project result = new Project();
        result.setId(source.getId());
        if(source.getNotifiedUserEntities() == null)
            result.setNotifiedUsers(null);
        else
            result.setNotifiedUsers(source.getNotifiedUserEntities().stream().map(UserParser::parse).collect(Collectors.toList()));
        return result;
    }
}
