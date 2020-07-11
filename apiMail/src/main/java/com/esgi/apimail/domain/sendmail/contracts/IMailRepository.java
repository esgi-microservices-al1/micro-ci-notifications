package com.esgi.apimail.domain.sendmail.contracts;

import com.esgi.apimail.domain.models.Message;
import com.esgi.apimail.domain.models.NotifiedUser;

import java.util.Collection;

public interface IMailRepository {
    Message save(Message message);

    Collection<NotifiedUser> getNotifiedUsersByProjectId(String projectId);
}
