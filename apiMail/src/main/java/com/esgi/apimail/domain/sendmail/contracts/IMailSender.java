package com.esgi.apimail.domain.sendmail.contracts;

import com.esgi.apimail.domain.models.Message;

import java.util.Collection;

public interface IMailSender {
    boolean sendMail(Message message, Collection<String> emailAddresses);
}
