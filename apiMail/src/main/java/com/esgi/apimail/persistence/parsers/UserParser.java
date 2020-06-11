package com.esgi.apimail.persistence.parsers;

import com.esgi.apimail.domain.models.NotifiedUser;
import com.esgi.apimail.persistence.entities.UserEntity;

public class UserParser {
    public static UserEntity parse(NotifiedUser source){
        UserEntity result = new UserEntity();
        result.setId(source.getId());
        result.setEmailAddress(source.getEmailAddress());
        return result;
    }

    public static NotifiedUser parse(UserEntity source){
        NotifiedUser result = new NotifiedUser();
        result.setId(source.getId());
        result.setEmailAddress(source.getEmailAddress());
        return result;
    }
}
