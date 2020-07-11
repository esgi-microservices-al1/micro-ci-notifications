package com.esgi.apimail.domain.models;

import java.util.Collection;

public class Project{
    private String id;

    Collection<NotifiedUser> notifiedUsers;

    public Project() {
        this(null);
    }

    public Project(String id) {
        this(id, null);
    }

    public Project(String id, Collection<NotifiedUser> notifiedUsers) {
        this.id = id;
        this.notifiedUsers = notifiedUsers;
    }

    public Collection<NotifiedUser> getNotifiedUsers() {
        return notifiedUsers;
    }

    public void setNotifiedUsers(Collection<NotifiedUser> notifiedUsers) {
        this.notifiedUsers = notifiedUsers;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
