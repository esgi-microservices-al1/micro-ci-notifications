package com.esgi.apimail.persistence.parsers;

import com.esgi.apimail.domain.models.Message;
import com.esgi.apimail.persistence.entities.MessageEntity;

public class MessageParser {
    public static Message parse(MessageEntity entity){
        Message res = new Message();

        res.setContent(entity.getContent());
        res.setProjectId(entity.getProjectId());
        res.setSubject(entity.getSubject());
        res.setId(entity.getId());

        return res;
    }

    public static MessageEntity parse(Message message){
        MessageEntity res = new MessageEntity();

        res.setContent(message.getContent());
        res.setProjectId(message.getProjectId());
        res.setSubject(message.getSubject());
        res.setId(message.getId());

        return res;
    }
}
