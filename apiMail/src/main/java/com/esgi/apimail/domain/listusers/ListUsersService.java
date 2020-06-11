package com.esgi.apimail.domain.listusers;

import com.esgi.apimail.domain.listusers.contracts.IListUsersRepository;
import com.esgi.apimail.domain.models.NotifiedUser;

import java.util.Collection;

public class ListUsersService {
    private final IListUsersRepository usersRepository;

    public ListUsersService(IListUsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public Collection<NotifiedUser> getAll(){
        return usersRepository.getAll();
    }
}
