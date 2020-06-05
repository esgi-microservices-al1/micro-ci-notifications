package com.esgi.apimail.domain.models;

public class Message  extends ModelBase{
    private String content;
    private String Subject;

    public Message() {
        this(null, null);
    }

    public Message(String content, String subject) {
        this(null, content, subject);
    }

    public Message(Long id, String content, String subject) {
        super(id);
        this.content = content;
        Subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String subject) {
        Subject = subject;
    }
}
