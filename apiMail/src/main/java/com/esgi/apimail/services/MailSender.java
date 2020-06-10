package com.esgi.apimail.services;

import com.esgi.apimail.domain.models.Message;
import com.esgi.apimail.domain.sendmail.contracts.IMailSender;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class MailSender implements IMailSender {
    @Override
    public boolean sendMail(Message message, Collection<String> emailAddresses) {
        return false;
    }
}
