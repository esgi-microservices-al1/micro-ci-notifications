package com.esgi.apimail.domain.sendmail;

import com.esgi.apimail.domain.models.Message;
import com.esgi.apimail.domain.sendmail.contracts.IMailRepository;
import com.esgi.apimail.domain.sendmail.contracts.IMailSender;

public class MailService {
    private final IMailRepository repository;
    private final IMailSender sender;

    public MailService(IMailRepository repository, IMailSender sender) {
        this.repository = repository;
        this.sender = sender;
    }

    public void transfertMessage(Message message){
        message = repository.save(message);
        sender.sendMail(message);
    }
}

