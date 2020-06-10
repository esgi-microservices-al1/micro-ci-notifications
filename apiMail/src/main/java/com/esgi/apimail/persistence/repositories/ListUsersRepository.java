package com.esgi.apimail.persistence.repositories;

import com.esgi.apimail.domain.listusers.contracts.IListUsersRepository;
import com.esgi.apimail.domain.models.NotifiedUser;
import com.esgi.apimail.persistence.dals.UserDAL;
import com.esgi.apimail.persistence.entities.UserEntity;
import com.esgi.apimail.persistence.parsers.UserParser;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.Collectors;

@Component
public class ListUsersRepository implements IListUsersRepository {
    private final UserDAL userDAL;

    public ListUsersRepository(UserDAL userDAL) {
        this.userDAL = userDAL;
    }

    @Override
    public Collection<NotifiedUser> getAll() {
        Collection<UserEntity> entities = userDAL.findAll();
        return entities.stream().map(UserParser::parse).collect(Collectors.toList());
    }
}
