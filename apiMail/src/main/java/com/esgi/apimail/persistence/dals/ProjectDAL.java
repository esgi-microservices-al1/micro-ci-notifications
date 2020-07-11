package com.esgi.apimail.persistence.dals;

import com.esgi.apimail.persistence.entities.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectDAL extends JpaRepository<ProjectEntity, String> {
}
