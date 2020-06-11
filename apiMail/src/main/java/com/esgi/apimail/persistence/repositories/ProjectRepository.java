package com.esgi.apimail.persistence.repositories;

import com.esgi.apimail.domain.listprojects.contracts.IListProjectRepository;
import com.esgi.apimail.domain.models.NotifiedUser;
import com.esgi.apimail.domain.models.Project;
import com.esgi.apimail.domain.newproject.contracts.INewProjectRepository;
import com.esgi.apimail.persistence.dals.UserDAL;
import com.esgi.apimail.persistence.entities.ProjectEntity;
import com.esgi.apimail.persistence.entities.UserEntity;
import com.esgi.apimail.persistence.parsers.ProjectParser;
import com.esgi.apimail.persistence.parsers.UserParser;
import org.springframework.stereotype.Component;
import com.esgi.apimail.persistence.dals.ProjectDAL;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ProjectRepository implements INewProjectRepository, IListProjectRepository {
    private final ProjectDAL projectDAL;
    private final UserDAL userDAL;

    public ProjectRepository(ProjectDAL projectDAL, UserDAL userDAL) {
        this.projectDAL = projectDAL;
        this.userDAL = userDAL;
    }

    @Override
    public Project save(Project project) {
        Collection<UserEntity> entities = new ArrayList<>();
        for (NotifiedUser u: project.getNotifiedUsers()) {
            Optional<UserEntity> optionalUserEntity = u.getId() == null ? Optional.empty() : userDAL.findById(u.getId());
            UserEntity e = optionalUserEntity.isEmpty() ? null : optionalUserEntity.get();
            if (e == null) {
                e = UserParser.parse(u);
                e = userDAL.save(e);
            }
            entities.add(e);
        }
        ProjectEntity entity = ProjectParser.parse(project);
        entity.setNotifiedUserEntities(entities);
        ProjectEntity result = projectDAL.save(entity);
        return ProjectParser.parse(result);
    }

    @Override
    public Collection<Project> get() {
        Collection<ProjectEntity> projects = projectDAL.findAll();
        return projects.stream().map(ProjectParser::parse).collect(Collectors.toList());
    }
}
