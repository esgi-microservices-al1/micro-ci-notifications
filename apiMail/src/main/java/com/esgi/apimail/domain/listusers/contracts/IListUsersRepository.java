package com.esgi.apimail.domain.listusers.contracts;

import com.esgi.apimail.domain.models.NotifiedUser;

import java.util.Collection;

public interface IListUsersRepository {
    Collection<NotifiedUser> getAll();
}
