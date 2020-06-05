package com.esgi.apimail.domain.sendmail.contracts;

import com.esgi.apimail.domain.models.Message;

public interface IMailRepository {
    Message save(Message message);
}
