package com.esgi.apimail.domain.sendmail;

import com.esgi.apimail.domain.models.Message;
import com.esgi.apimail.domain.models.NotifiedUser;
import com.esgi.apimail.domain.sendmail.contracts.IMailRepository;
import com.esgi.apimail.domain.sendmail.contracts.IMailSender;

import java.util.Collection;
import java.util.stream.Collectors;

public class MailService {
    private final IMailRepository repository;
    private final IMailSender sender;

    public MailService(IMailRepository repository, IMailSender sender) {
        this.repository = repository;
        this.sender = sender;
    }

    public boolean transfertMessage(Message message){
        if (message.getSubject() == null ||
            message.getContent() == null ||
            message.getProjectId() == null) {
            return false;
        }
        message = repository.save(message);
        if(message == null)
            return false;
        Collection<NotifiedUser> users = repository.getNotifiedUsersByProjectId(message.getProjectId());
        return users != null && sender.sendMail(message, users.stream().map(NotifiedUser::getEmailAddress).collect(Collectors.toList()));
    }
}

