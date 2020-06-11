package com.esgi.apimail.persistence.dals;

import com.esgi.apimail.persistence.entities.MessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageDAL extends JpaRepository<MessageEntity, Long> {
}
