package com.esgi.apimail.persistence.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Collection;

@Entity
@Table(name="projects")
public class ProjectEntity  {
    @Id
    private Long id;

    @OneToMany
    private Collection<UserEntity> notifiedUserEntities;

    public ProjectEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Collection<UserEntity> getNotifiedUserEntities() {
        return notifiedUserEntities;
    }

    public void setNotifiedUserEntities(Collection<UserEntity> notifiedUserEntities) {
        this.notifiedUserEntities = notifiedUserEntities;
    }
}
