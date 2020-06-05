package com.esgi.apimail.persistence.dals;

import com.esgi.apimail.persistence.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAL extends JpaRepository<UserEntity, Long> {
}
