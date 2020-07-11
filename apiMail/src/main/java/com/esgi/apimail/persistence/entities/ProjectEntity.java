package com.esgi.apimail.persistence.entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name="projects")
public class ProjectEntity  {
    @Id
    private String id;

    @ManyToMany
    private Collection<UserEntity> notifiedUserEntities;

    public ProjectEntity() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Collection<UserEntity> getNotifiedUserEntities() {
        return notifiedUserEntities;
    }

    public void setNotifiedUserEntities(Collection<UserEntity> notifiedUserEntities) {
        this.notifiedUserEntities = notifiedUserEntities;
    }
}
