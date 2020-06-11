package com.esgi.apimail.domain.models;

import java.util.Collection;

public class Project extends ModelBase{

    Collection<NotifiedUser> notifiedUsers;

    public Project() {
        this(null);
    }

    public Project(Long id) {
        this(id, null);
    }

    public Project(Long id, Collection<NotifiedUser> notifiedUsers) {
        super(id);
        this.notifiedUsers = notifiedUsers;
    }

    public Collection<NotifiedUser> getNotifiedUsers() {
        return notifiedUsers;
    }

    public void setNotifiedUsers(Collection<NotifiedUser> notifiedUsers) {
        this.notifiedUsers = notifiedUsers;
    }
}
