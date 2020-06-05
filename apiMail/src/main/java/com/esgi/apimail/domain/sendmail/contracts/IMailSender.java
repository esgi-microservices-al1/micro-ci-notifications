package com.esgi.apimail.domain.sendmail.contracts;

import com.esgi.apimail.domain.models.Message;

public interface IMailSender {
    void sendMail(Message message);
}
