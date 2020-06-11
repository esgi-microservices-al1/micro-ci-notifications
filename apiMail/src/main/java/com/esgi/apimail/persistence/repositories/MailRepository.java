package com.esgi.apimail.persistence.repositories;

import com.esgi.apimail.domain.models.Message;
import com.esgi.apimail.domain.models.NotifiedUser;
import com.esgi.apimail.domain.sendmail.contracts.IMailRepository;
import com.esgi.apimail.persistence.dals.MessageDAL;
import com.esgi.apimail.persistence.dals.ProjectDAL;
import com.esgi.apimail.persistence.entities.MessageEntity;
import com.esgi.apimail.persistence.entities.ProjectEntity;
import com.esgi.apimail.persistence.parsers.MessageParser;
import com.esgi.apimail.persistence.parsers.UserParser;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class MailRepository implements IMailRepository {
    private final ProjectDAL projectDAL;
    private final MessageDAL messageDAL;

    public MailRepository(ProjectDAL projectDAL, MessageDAL messageDAL) {
        this.projectDAL = projectDAL;
        this.messageDAL = messageDAL;
    }

    @Override
    public Message save(Message message) {
        MessageEntity entity = MessageParser.parse(message);
        entity = messageDAL.save(entity);

        return MessageParser.parse(entity);
    }

    @Override
    public Collection<NotifiedUser> getNotifiedUsersByProjectId(Long projectId) {
        Optional<ProjectEntity> entity = projectDAL.findById(projectId);
        if(entity.isEmpty() || entity.get().getNotifiedUserEntities() == null)
            return null;
        return entity.get().getNotifiedUserEntities().stream().map(UserParser::parse).collect(Collectors.toList());
    }
}
