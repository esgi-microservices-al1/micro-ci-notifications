package com.esgi.apimail.domain.models;

public class NotifiedUser extends ModelBase{
    private String emailAddress;

    public NotifiedUser() {
        this(null);
    }

    public NotifiedUser(String emailAddress) {
        this(null, emailAddress);
    }

    public NotifiedUser(Long id, String emailAddress) {
        super(id);
        this.emailAddress = emailAddress;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
